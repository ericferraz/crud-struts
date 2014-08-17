/**
 * 
 */
package br.com.crud.cidade.controller;

import java.util.ArrayList;

import br.com.crud.abstractpo.AbstractPO;
import br.com.crud.cidade.dto.CidadeDTO;
import br.com.crud.cidade.model.CidadePO;
import br.com.crud.cidade.model.CidadeService;
import br.com.crud.exceptions.ApplicationException;
import br.com.crud.exceptions.DadosInvalidosException;
import br.com.crud.interfaces.GenericInterfaceService;
import br.com.crud.utilidades.ModelFactory;
import br.com.crud.utilidades.Utilidades;

/**
 * Classe que representa um objeto do tipo cidadeFacade
 * objetos comos este, fazem a interligação do sistema com a camada de front-end
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 11:13:12
 * @version 1.0
 */
public final class CidadeFacade{
	private final GenericInterfaceService SERVICE;
	private static CidadeFacade instance;

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 11:18:28
	 * @version 1.0
	 */
	private CidadeFacade(){
		SERVICE = new CidadeService();
	}

	/**
	 * 
	 * Método responsável por retornar uma única instância do proprio objeto(singleton)
	 * 
	 * @return
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 11:20:08
	 * @version 1.0
	 */
	public static CidadeFacade getInstance() {
		if ( Utilidades.isNuloOuVazio( instance ) ) {
			instance = new CidadeFacade();
		}
		return instance;
	}

	/**
	 * 
	 * Método responsável por inserir dados
	 * 
	 * @param dto objeto preenchido vindo da camada de front-end
	 * @return
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 11:22:48
	 * @version 1.0
	 */
	public CidadeDTO inserir( CidadeDTO dto ) throws ApplicationException {
		try {
			AbstractPO poPersistido = SERVICE.inserir( ModelFactory.getPO( dto ) );
			return ModelFactory.getDTO( (CidadePO) poPersistido );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( DadosInvalidosException e ) {
			throw new ApplicationException( e.getMessage() );
		}
	}

	/**
	 * 
	 * Método responsável por alterar um objeto cidade
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 20:50:51
	 * @version 1.0
	 */
	public void alterar( CidadeDTO dto ) throws ApplicationException {
		try {
			SERVICE.alterar( ModelFactory.getPO( dto ) );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( DadosInvalidosException e ) {
			throw new ApplicationException( e.getMessage() );
		}
	}

	/**
	 * 
	 * Método responsável por excluir o objeto cidade
	 *
	 * @param dto
	 * @throws ApplicationException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 20:54:31
	 * @version 1.0
	 */
	public void excluir( CidadeDTO dto ) throws ApplicationException {
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
	 * Método responsável por filtrar
	 *
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 23:26:36
	 * @version 1.0
	 */
	public ArrayList<CidadeDTO> filtrar(CidadeDTO dto)throws ApplicationException {
		try {
			@SuppressWarnings( "unchecked" )
            ArrayList<CidadePO> encontrados = (ArrayList<CidadePO>) SERVICE.filtrar(ModelFactory.getPO(dto));

			ArrayList<CidadeDTO> listaDTO = new ArrayList<>();

			for (CidadePO cidadePO : encontrados) {
				listaDTO.add(ModelFactory.getDTO(cidadePO));
			}

			return listaDTO;
		} catch (ApplicationException e) {
			throw e;
		} catch (DadosInvalidosException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

}
