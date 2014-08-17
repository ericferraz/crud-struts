/**
 * 
 */
package br.com.crud.estado.dao;

import org.hibernate.Query;

import br.com.crud.abstractdao.AbstractDAO;
import br.com.crud.abstractpo.AbstractPO;
import br.com.crud.cidade.model.CidadePO;
import br.com.crud.estado.model.EstadoPO;
import br.com.crud.exceptions.FiltrarException;

/**
 * Classe que representa o objeto estadoDAO
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 15/08/2014 17:14:41
 * @version 1.0
 */
public final class EstadoDAO extends AbstractDAO{

	/**
	 * Polimorfico
	 * 
	 * @see br.com.crud.interfaces.GenericInterfaceDAO#filtrar(br.com.crud.abstractpo.AbstractPO)
	 */
	@Override
	public Object filtrar( AbstractPO po ) throws FiltrarException {
		EstadoPO poFiltrar = null;
		// Verificando se obj é um objeto do tipo EstadoPO
		if ( po instanceof EstadoPO ) {
			poFiltrar = (EstadoPO) po;
		} else {
			throw new FiltrarException( "Objeto informado não condiz com o contexto: " + poFiltrar );
		}

		try {
			abrirSessao();

			// Criando uma HQL(Hibernate Query Language) como se estivessemos

			/** Constante que contém a HQL a ser executada */
			final StringBuffer HQL = new StringBuffer();
			HQL.append( "SELECT e FROM " );
			HQL.append( " EstadoPO e " );
			HQL.append( " WHERE 1=1 " );

			if ( poFiltrar.getId() != null ) {
				HQL.append( "AND e.id=:idParam " );
			}

			if ( poFiltrar.getNome() != null && !poFiltrar.getNome().isEmpty() ) {
				HQL.append( "AND e.nome=:nomeParam " );
			}

			if ( poFiltrar.getUf() != null && poFiltrar.getUf() != null ) {
				HQL.append( " AND e.uf=:ufParam " );
			}

			/*
			 * Criando e inicializando uma variavel responsável por criar uma
			 * Query com base na nossa HQL criada acima deixando-a preparada
			 * para o Hibernate executa-la.
			 */
			Query query = sessaoCorrente.createQuery( HQL.toString() );

			if ( poFiltrar.getId() != null ) {
				query.setInteger( "idParam", poFiltrar.getId() );
			}

			if ( poFiltrar.getNome() != null && !poFiltrar.getNome().isEmpty() ) {
				query.setString( "nomeParam", poFiltrar.getNome() );
			}

			if ( poFiltrar.getUf() != null && poFiltrar.getUf() != null ) {
				HQL.append( " AND e.uf=:ufParam " );
				query.setString( "ufParam", poFiltrar.getUf() );
			}

			// Executando a Query retornando o casting de seu resultado.
			return query.list();
		} catch ( Throwable e ) {
			throw new FiltrarException( "Erro ao filtrar", e );
		}
	}

}
