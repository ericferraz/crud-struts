/**
 * 
 */
package br.com.crud.fornecedor.dao;

import br.com.crud.abstractdao.AbstractDAO;
import br.com.crud.abstractpo.AbstractPO;
import br.com.crud.exceptions.FiltrarException;

/**
 * Classe que representa um objeto do tipo fornecedorDAO
 *
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 15/08/2014 19:36:04
 * @version 1.0
 */
public final class FornecedorDAO extends AbstractDAO{

	/**
	 * Polimorfico
	 * @see br.com.crud.interfaces.GenericInterfaceDAO#filtrar(br.com.crud.abstractpo.AbstractPO)
	 */
	@Override
	public Object filtrar( AbstractPO po ) throws FiltrarException {
		// TODO Auto-generated method stub
		return null;
	}

}
