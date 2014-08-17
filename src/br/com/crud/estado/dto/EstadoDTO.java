package br.com.crud.estado.dto;

import br.com.crud.abstractdto.AbstractDTO;

/**
 * 
 * Classe que representa um objeto do tipo objeto do tipo data transfer object do sistema
 * objetos desse tipo são responsáveis em trafegar dados entre a view e o controller
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 00:33:08
 * @version 1.0
 */
public final class EstadoDTO extends AbstractDTO{
	private String nome;
	private String uf;

	public EstadoDTO(){}

	public EstadoDTO( String nome ){
		setNome( nome );
	}

	public EstadoDTO( String nome, String uf, String id ){
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
		EstadoDTO other = (EstadoDTO) obj;
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
		return "EstadoDTO [getNome()=" + getNome() + ", getUf()=" + getUf() + ", hashCode()=" + hashCode() + "]";
	}

}
