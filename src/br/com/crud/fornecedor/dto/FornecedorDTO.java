/**
 * 
 */
package br.com.crud.fornecedor.dto;

import br.com.crud.abstractdto.AbstractDTO;
import br.com.crud.cidade.dto.CidadeDTO;
import br.com.crud.estado.dto.EstadoDTO;

/**
 * Classe que representa um objeto do tipo fornecedorDTO
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 01:28:06
 * @version 1.0
 */
public final class FornecedorDTO extends AbstractDTO{
	private String nome;
	private String cnpj;
	private String endereco;
	private EstadoDTO estado;
	private CidadeDTO cidade;

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:33:18
	 * @version 1.0
	 */
	public FornecedorDTO(){}
	
	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 *
	 * @param nome
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:33:52
	 * @version 1.0
	 */
	public FornecedorDTO( String nome ){
	    setNome( nome );
    }
	
   /**
    * 
    * Método construtor resposável por inicializar os atributos e/ou
    * executar qualquer ação no momento da criação da classe.
    *
    * @param nome
    * @param cnpj
    *
    * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
    * @since 14/08/2014 01:34:35
    * @version 1.0
    */
	public FornecedorDTO( String nome, String cnpj ){
	    setNome( nome );
	    setCnpj( cnpj );
    }

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * @param id
	 * @param nome
	 * @param cnpj
	 * @param endereco
	 * @param estado
	 * @param cidade
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:32:39
	 * @version 1.0
	 */
	public FornecedorDTO( String id, String nome, String cnpj, String endereco, EstadoDTO estado, CidadeDTO cidade ){
		setId( id );
		setNome( nome );
		setCnpj( cnpj );
		setEndereco( endereco );
		setEstado( estado );
		setCidade( cidade );
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj( String cnpj ) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco( String endereco ) {
		this.endereco = endereco;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado( EstadoDTO estado ) {
		this.estado = estado;
	}

	public CidadeDTO getCidade() {
		return cidade;
	}

	public void setCidade( CidadeDTO cidade ) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ( ( cidade == null ) ? 0 : cidade.hashCode() );
		result = prime * result + ( ( cnpj == null ) ? 0 : cnpj.hashCode() );
		result = prime * result + ( ( endereco == null ) ? 0 : endereco.hashCode() );
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
		FornecedorDTO other = (FornecedorDTO) obj;
		if ( cidade == null ) {
			if ( other.cidade != null )
				return false;
		} else if ( !cidade.equals( other.cidade ) )
			return false;
		if ( cnpj == null ) {
			if ( other.cnpj != null )
				return false;
		} else if ( !cnpj.equals( other.cnpj ) )
			return false;
		if ( endereco == null ) {
			if ( other.endereco != null )
				return false;
		} else if ( !endereco.equals( other.endereco ) )
			return false;
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
		return "FornecedorDTO [getNome()=" + getNome() + ", getCnpj()=" + getCnpj() + ", getEndereco()=" + getEndereco() + ", getEstado()=" + getEstado() + ", getCidade()=" + getCidade() + ", hashCode()=" + hashCode() + "]";
	}

}
