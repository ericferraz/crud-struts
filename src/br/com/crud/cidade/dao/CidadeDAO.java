/**
 * 
 */
package br.com.crud.cidade.dao;

import org.hibernate.Query;

import br.com.crud.abstractdao.AbstractDAO;
import br.com.crud.abstractpo.AbstractPO;
import br.com.crud.cidade.model.CidadePO;
import br.com.crud.exceptions.FiltrarException;

/**
 * Classe que representa um objeto do tipo cidadeDAO
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 02:10:35
 * @version 1.0
 */
public final class CidadeDAO extends AbstractDAO{

	/**
	 * Polimorfico
	 * 
	 * @see br.com.crud.interfaces.GenericInterfaceDAO#filtrar(br.com.crud.abstractpo.AbstractPO)
	 */
	@Override
	public Object filtrar( AbstractPO po ) throws FiltrarException {
		CidadePO poFiltrar = null;
		// Verificando se obj é um objeto do tipo CidadePO
		if ( po instanceof CidadePO ) {
			poFiltrar = (CidadePO) po;
		} else {
			throw new FiltrarException( "Objeto informado não condiz com o contexto: " + poFiltrar );
		}

		try {
			abrirSessao();

			// Criando uma HQL(Hibernate Query Language) como se estivessemos
			// criando uma NamedQuery
			/** Constante que contém a HQL a ser executada */
			final StringBuffer HQL = new StringBuffer();
			HQL.append( "SELECT c FROM " );
			HQL.append( " CidadePO c " );
			HQL.append( " WHERE 1=1 " );

			if ( poFiltrar.getId() != null ) {
				HQL.append( "AND c.id=:idParam " );
			}

			if ( poFiltrar.getNome() != null && !poFiltrar.getNome().isEmpty() ) {
				HQL.append( "AND c.nome=:nomeParam " );
			}

			if ( poFiltrar.getEstado() != null && poFiltrar.getEstado().getId() != null ) {
				HQL.append( " AND c.estado.id=:idEstadoParam " );
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

			if ( poFiltrar.getEstado() != null && poFiltrar.getEstado().getId() != null ) {
				query.setInteger( "idEstadoParam", poFiltrar.getEstado().getId());
			}

			System.out.println( HQL.toString() );

			// Executando a Query retornando o casting de seu resultado.
			return query.list();
		} catch ( Throwable e ) {
			throw new FiltrarException( "Erro ao filtrar", e );
		}
	}

}
