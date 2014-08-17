package br.com.crud.estado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.crud.abstractpo.AbstractPO;

/**
 * 
 * Classe que representa um objeto do tipo estadoPO
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 02:04:38
 * @version 1.0
 */
@Entity
@Table( name = "estados" )
public final class EstadoPO extends AbstractPO{
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String uf;

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 02:05:01
	 * @version 1.0
	 */
	public EstadoPO(){}

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * @param id
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 02:05:12
	 * @version 1.0
	 */
	public EstadoPO( Integer id ){
		setId( id );
	}

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * @param nome
	 * @param uf
	 * @param id
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 02:05:22
	 * @version 1.0
	 */
	public EstadoPO( String nome, String uf, Integer id ){
		setNome( nome );
		setUf( uf );
		setId( id );
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf( String uf ) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
		result = prime * result + ( ( uf == null ) ? 0 : uf.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj )
			return true;
		if ( !super.equals( obj ) )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		EstadoPO other = (EstadoPO) obj;
		if ( nome == null ) {
			if ( other.nome != null )
				return false;
		} else if ( !nome.equals( other.nome ) )
			return false;
		if ( uf == null ) {
			if ( other.uf != null )
				return false;
		} else if ( !uf.equals( other.uf ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstadoPO [getNome()=" + getNome() + ", getUf()=" + getUf() + ", hashCode()=" + hashCode() + "]";
	}

}
