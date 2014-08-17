/**
 * 
 */
package br.com.crud.fornecedor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.crud.abstractpo.AbstractPO;
import br.com.crud.cidade.model.CidadePO;
import br.com.crud.estado.model.EstadoPO;

/**
 * Classe que representa um objeto do tipo fornecedor
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 00:50:58
 * @version 1.0
 */
@Entity
@Table( name = "fornecedores" )
public final class FornecedorPO extends AbstractPO{

	@Column( nullable = false )
	private String nome;
	
	@Column( nullable = false)
	private String cnpj;
	@Column( nullable = false )
	private String endereco;

	/**
	 * representa um relaciomento 1 para 1 no modelo relacional
	 * ou seja 1 fornecedor pode pertencer a somente um estado
	 */
	@OneToOne( fetch = FetchType.EAGER )
	/**
	 * a liga��o entre esses dois objetos ser� representado na tabela fornecedores pelo id_estado
	 */
	@JoinColumn( name = "id_estado",nullable=false )
	private EstadoPO estado;

	/**
	 * mesma situa��o acima, o relaciomento entre os dois objetos(fornecedor e cidade � 1 para 1)
	 * a liga��o entre esses dois objetos ser� o id_cidade(chave estrangeira)
	 */
	@OneToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "id_cidade",nullable=false )
	private CidadePO cidade;

	/**
	 * M�todo construtor respos�vel por inicializar os atributos e/ou
	 * executar qualquer a��o no momento da cria��o da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:03:13
	 * @version 1.0
	 */
	public FornecedorPO(){}

	/**
	 * 
	 * M�todo construtor respos�vel por inicializar os atributos e/ou
	 * executar qualquer a��o no momento da cria��o da classe.
	 * 
	 * @param nome
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:04:09
	 * @version 1.0
	 */
	public FornecedorPO( String nome ){
		setNome( nome );
	}

	/**
	 * 
	 * M�todo construtor respos�vel por inicializar os atributos e/ou
	 * executar qualquer a��o no momento da cria��o da classe.
	 * 
	 * @param id
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:04:49
	 * @version 1.0
	 */
	public FornecedorPO( Integer id ){
		setId( id );
	}

	/**
	 * 
	 * M�todo construtor respos�vel por inicializar os atributos e/ou
	 * executar qualquer a��o no momento da cria��o da classe.
	 * 
	 * @param nome
	 * @param cnpj
	 * @param endereco
	 * @param estado
	 * @param cidade
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:02:24
	 * @version 1.0
	 */
	public FornecedorPO( Integer id, String nome, String cnpj, String endereco, EstadoPO estado, CidadePO cidade ){
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

	public EstadoPO getEstado() {
		return estado;
	}

	public void setEstado( EstadoPO estado ) {
		this.estado = estado;
	}

	public CidadePO getCidade() {
		return cidade;
	}

	public void setCidade( CidadePO cidade ) {
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
		FornecedorPO other = (FornecedorPO) obj;
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
		return "FornecedorPO [getNome()=" + getNome() + ", getCnpj()=" + getCnpj() + ", getEndereco()=" + getEndereco() + ", getEstado()=" + getEstado() + ", getCidade()=" + getCidade() + ", hashCode()=" + hashCode() + "]";
	}

}
