package br.com.crud.cidade.dto;

import br.com.crud.abstractdto.AbstractDTO;
import br.com.crud.estado.dto.EstadoDTO;

/**
 * 
 * Classe que representa um objeto do tipo cidadeDTO
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 00:47:13
 * @version 1.0
 */
public final class CidadeDTO extends AbstractDTO{
	private String nome;
	private EstadoDTO estado;

	/**
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 00:48:08
	 * @version 1.0
	 */
	public CidadeDTO(){}

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * @param nome
	 * @param estado
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 00:48:25
	 * @version 1.0
	 */
	public CidadeDTO( String nome, EstadoDTO estado ){
		setNome( nome );
		setEstado( estado );
	}
   
	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 *
	 * @param id
	 * @param nome
	 * @param estado
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 11:28:47
	 * @version 1.0
	 */
	public CidadeDTO( String id, String nome, EstadoDTO estado ){
		setId( id );
		setNome( nome );
		setEstado( estado );
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado( EstadoDTO estado ) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ( ( estado == null ) ? 0 : estado.hashCode() );
		result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
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
		CidadeDTO other = (CidadeDTO) obj;
		if ( estado == null ) {
			if ( other.estado != null )
				return false;
		} else if ( !estado.equals( other.estado ) )
			return false;
		if ( nome == null ) {
			if ( other.nome != null )
				return false;
		} else if ( !nome.equals( other.nome ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CidadeDTO [getNome()=" + getNome() + ", getEstado()=" + getEstado() + ", hashCode()=" + hashCode() + "]";
	}

}
