package br.com.crud.interfaces;

import br.com.crud.abstractpo.AbstractPO;
import br.com.crud.exceptions.ApplicationException;

/**
 * 
 * Interface para padronizar ações dos objetos services
 *
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 01:50:10
 * @version 1.0
 */
public interface GenericInterfaceService {
	AbstractPO inserir(AbstractPO po) throws ApplicationException;

	void alterar(AbstractPO po) throws ApplicationException;

	void excluir(AbstractPO po) throws ApplicationException;

	Object filtrar(AbstractPO po) throws ApplicationException;
}
