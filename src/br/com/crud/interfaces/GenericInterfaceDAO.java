/**
 * 
 */
package br.com.crud.interfaces;

import br.com.crud.abstractpo.AbstractPO;
import br.com.crud.exceptions.AlterarException;
import br.com.crud.exceptions.CommitException;
import br.com.crud.exceptions.ConexaoException;
import br.com.crud.exceptions.ExcluirException;
import br.com.crud.exceptions.FiltrarException;
import br.com.crud.exceptions.InserirException;
import br.com.crud.exceptions.RollbackException;

/**
 * Interface responsável por padronizar ações dos objetos dao
 *
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 01:22:56
 * @version 1.0
 */
public interface GenericInterfaceDAO{
AbstractPO inserir(AbstractPO po) throws InserirException;
	
	/**
	 * 
	 * Método responsável por alterar
	 *
	 * @param AbstractDTO po
	 * @throws AlterarException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 27/04/2014 10:30:24
	 * @version 1.0
	 */
	void alterar(AbstractPO po) throws AlterarException;
	
	/**
	 * 
	 * Método responsável por excluir
	 *
	 * @param po
	 * @throws ExcluirException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:24:10
	 * @version 1.0
	 */
	void excluir(AbstractPO po) throws ExcluirException;
	
	/**
	 * 
	 * Método responsável por filtrar
	 *
	 * @param po
	 * @return
	 * @throws FiltrarException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:24:32
	 * @version 1.0
	 */
	Object filtrar(AbstractPO po) throws FiltrarException;
	/**
	 * 
	 * Método responsável por abrir sessão
	 *
	 * @throws ConexaoException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:25:03
	 * @version 1.0
	 */
	void abrirSessao() throws ConexaoException;
	/**
	 * 
	 * Método responsável por iniciar uma transação
	 *
	 * @throws ConexaoException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:25:18
	 * @version 1.0
	 */
	void iniciarTransacao() throws ConexaoException;
	/**
	 * 
	 * Método responsável por efetuar o rollback
	 *
	 * @throws RollbackException
	 * @throws ConexaoException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:25:32
	 * @version 1.0
	 */
	void rollbackTransacao() throws RollbackException, ConexaoException;
	
	/**
	 * 
	 * Método responsável por commitar uma transação
	 *
	 * @throws CommitException
	 * @throws ConexaoException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:26:00
	 * @version 1.0
	 */
	void commitTransacao() throws CommitException, ConexaoException;
	
	/**
	 * 
	 * Método responsável por fechar uma sessão
	 *
	 * @throws ConexaoException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:26:18
	 * @version 1.0
	 */
	void fecharSessao() throws ConexaoException;
}
