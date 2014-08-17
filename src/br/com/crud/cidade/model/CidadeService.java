/**
 * 
 */
package br.com.crud.cidade.model;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.crud.abstractpo.AbstractPO;
import br.com.crud.cidade.dao.CidadeDAO;
import br.com.crud.exceptions.AlterarException;
import br.com.crud.exceptions.ApplicationException;
import br.com.crud.exceptions.ConexaoException;
import br.com.crud.exceptions.ExcluirException;
import br.com.crud.exceptions.FiltrarException;
import br.com.crud.exceptions.InserirException;
import br.com.crud.exceptions.RollbackException;
import br.com.crud.interfaces.GenericInterfaceDAO;
import br.com.crud.interfaces.GenericInterfaceService;

/**
 * Classe que representa um objeto do tipo cidadeService
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 02:13:56
 * @version 1.0
 */
public final class CidadeService implements GenericInterfaceService,Serializable{

    private static final long serialVersionUID = 8790890487465645716L;
	private final GenericInterfaceDAO DAO;

	/**
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 02:16:21
	 * @version 1.0
	 */
	public CidadeService(){
		DAO = new CidadeDAO();
	}

	/**
	 * Polimorfico
	 * 
	 * @see br.com.crud.interfaces.GenericInterfaceService#inserir(br.com.crud.abstractpo.AbstractPO)
	 */
	@Override
	public AbstractPO inserir( AbstractPO po ) throws ApplicationException {
		CidadePO poPersistir = null;

		/**
		 * se os objetos forem do mesmo contexto
		 */
		if ( po instanceof CidadePO ) {
			poPersistir = (CidadePO) po;
		} else {
			throw new ApplicationException( "Objeto informado não condiz com o contexto: " + poPersistir );
		}

		try {

			/**
			 * Aplicando aqui a validação de preenchimento dos campos
			 * obrigatórios
			 */

			/** Criando um Bloco de Transação */
			DAO.iniciarTransacao();

			poPersistir = (CidadePO) DAO.inserir( poPersistir );

			/* Comita a sessão* */
			DAO.commitTransacao();

			return poPersistir;
		} catch ( InserirException e ) {

			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( e.getMessage(), e );
		} finally {
			try {
				DAO.fecharSessao();
			} catch ( ConexaoException e ) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * Polimorfico
	 * 
	 * @see br.com.crud.interfaces.GenericInterfaceService#alterar(br.com.crud.abstractpo.AbstractPO)
	 */
	@Override
	public void alterar( AbstractPO po ) throws ApplicationException {
		CidadePO poPersistir = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if ( po instanceof CidadePO ) {
			poPersistir = (CidadePO) po;
		} else {
			throw new ApplicationException( "Objeto informado não condiz com o contexto: " + poPersistir );
		}

		try {

			/**
			 * Aplicando aqui a validação de preenchimento dos campos
			 * obrigatórios
			 */

			/** Criando um Bloco de Transação */
			DAO.iniciarTransacao();

			DAO.alterar( poPersistir );

			/* Comita a sessão* */
			DAO.commitTransacao();

		} catch ( AlterarException e ) {

			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( e.getMessage(), e );
		} finally {
			try {
				DAO.fecharSessao();
			} catch ( ConexaoException e ) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * Polimorfico
	 * 
	 * @see br.com.crud.interfaces.GenericInterfaceService#excluir(br.com.crud.abstractpo.AbstractPO)
	 */
	@Override
	public void excluir( AbstractPO po ) throws ApplicationException {

		CidadePO poPersistir = null;
		// Verificando se obj é um objeto do tipo CidadePO
		if ( po instanceof CidadePO ) {
			poPersistir = (CidadePO) po;
		} else {
			throw new ApplicationException( "Objeto informado não condiz com o contexto: " + poPersistir );
		}

		try {

			/**
			 * Aplicando aqui a validação de preenchimento dos campos
			 * obrigatórios
			 */

			/** Criando um Bloco de Transação */
			DAO.iniciarTransacao();
			System.out.println( "id para excluir" + poPersistir.getId() );
			DAO.excluir( poPersistir );

			/* Comita a sessão* */
			DAO.commitTransacao();
		} catch ( ExcluirException e ) {

			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
			} catch ( ConexaoException e1 ) {
				throw new ApplicationException( e1.getMessage(), e1 );
			}
			throw new ApplicationException( e.getMessage(), e );
		} finally {
			try {
				DAO.fecharSessao();
			} catch ( ConexaoException e ) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * Polimorfico
	 * 
	 * @see br.com.crud.interfaces.GenericInterfaceService#filtrar(br.com.crud.abstractpo.AbstractPO)
	 */
	@Override
	public Object filtrar( AbstractPO po ) throws ApplicationException {
		CidadePO poFiltrar = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if (po instanceof CidadePO) {
			poFiltrar = (CidadePO) po;
		} else {
			throw new ApplicationException(
					"Objeto informado não condiz com o contexto: " + poFiltrar);
		}

		try {
			DAO.abrirSessao();
			return (ArrayList<CidadePO>) DAO.filtrar(poFiltrar);
		} catch (FiltrarException e) {
			throw new ApplicationException(e.getMessage(), e);
		} catch (Exception e) {
			throw new ApplicationException("Erro desconhecido ao inserir", e);
		} finally {
			try {
				DAO.fecharSessao();
			} catch (ConexaoException e) {
				throw new ApplicationException(e.getMessage(), e);
			}
		}
	}

}
