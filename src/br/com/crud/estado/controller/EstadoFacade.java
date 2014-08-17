/**
 * 
 */
package br.com.crud.estado.controller;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.crud.abstractpo.AbstractPO;
import br.com.crud.cidade.dto.CidadeDTO;
import br.com.crud.cidade.model.CidadePO;
import br.com.crud.estado.dto.EstadoDTO;
import br.com.crud.estado.model.EstadoPO;
import br.com.crud.estado.model.EstadoService;
import br.com.crud.exceptions.ApplicationException;
import br.com.crud.exceptions.DadosInvalidosException;
import br.com.crud.interfaces.GenericInterfaceService;
import br.com.crud.utilidades.ModelFactory;
import br.com.crud.utilidades.Utilidades;

/**
 * Classe que representa o objeto do tipo estadoFacade
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 15/08/2014 17:31:19
 * @version 1.0
 */
public final class EstadoFacade implements Serializable{

	private static final long serialVersionUID = -7532539359393809120L;
	private final GenericInterfaceService SERVICE;
	private static EstadoFacade instance;

	/**
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 15/08/2014 17:32:37
	 * @version 1.0
	 */
	private EstadoFacade(){
		SERVICE = new EstadoService();
	}

	/**
	 * 
	 * Método responsável por retornar uma única instância do objeto(singleton)
	 * 
	 * @return
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 15/08/2014 17:36:27
	 * @version 1.0
	 */
	public static EstadoFacade getInstance() {
		if ( Utilidades.isNuloOuVazio( instance ) ) {
			instance = new EstadoFacade();
		}
		return instance;
	}

	/**
	 * 
	 * Método responsável por inserir um objeto com base na service
	 * 
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 15/08/2014 17:45:28
	 * @version 1.0
	 */
	public EstadoDTO inserir( EstadoDTO dto ) throws ApplicationException {
		try {
			AbstractPO poPersistido = SERVICE.inserir( ModelFactory.getPO( dto ) );
			return ModelFactory.getDTO( (EstadoPO) poPersistido );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( DadosInvalidosException e ) {
			throw new ApplicationException( e.getMessage() );
		}
	}

	/**
	 * 
	 * Método responsável por alterar o estado com base na service
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 15/08/2014 17:51:08
	 * @version 1.0
	 */
	public void alterar( EstadoDTO dto ) throws ApplicationException {
		try {
			SERVICE.alterar( ModelFactory.getPO( dto ) );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( DadosInvalidosException e ) {

			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Método responsável por excluir um objeto com base na service
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 15/08/2014 17:52:17
	 * @version 1.0
	 */
	public void excluir( EstadoDTO dto ) throws ApplicationException {
		try {
			SERVICE.excluir( ModelFactory.getPO( dto ) );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( DadosInvalidosException e ) {
			throw new ApplicationException( e.getMessage() );
		}
	}
	
	/**
	 * 
	 * Método responsável por buscar e retornar estados
	 *
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 16/08/2014 21:21:08
	 * @version 1.0
	 */
	public ArrayList<EstadoDTO> filtrar(EstadoDTO dto)throws ApplicationException {
		try {
			
			/**
			 * efetua a busca dos estados com base na service
			 */
            ArrayList<EstadoPO> encontrados = (ArrayList<EstadoPO>) SERVICE.filtrar(ModelFactory.getPO(dto));
            
            /**
             *cria um array de estadosDTO, pois para a camada view, os dados serão todos do
             *tipo string e a função do pattern dto é trafegar strings
             */
			ArrayList<EstadoDTO> listaDTO = new ArrayList<>();
			
			if(encontrados.size() <1){
				System.out.println("Não há registros");
				return null;
			}
			
			for (EstadoPO estados : encontrados) {
				listaDTO.add(ModelFactory.getDTO(estados));
			}

			return listaDTO;
		} catch (ApplicationException e) {
			throw e;
		} catch (DadosInvalidosException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
}
