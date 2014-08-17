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
 * Interface respons�vel por padronizar a��es dos objetos dao
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
	 * M�todo respons�vel por alterar
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
	 * M�todo respons�vel por excluir
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
	 * M�todo respons�vel por filtrar
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
	 * M�todo respons�vel por abrir sess�o
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
	 * M�todo respons�vel por iniciar uma transa��o
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
	 * M�todo respons�vel por efetuar o rollback
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
	 * M�todo respons�vel por commitar uma transa��o
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
	 * M�todo respons�vel por fechar uma sess�o
	 *
	 * @throws ConexaoException
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:26:18
	 * @version 1.0
	 */
	void fecharSessao() throws ConexaoException;
}
