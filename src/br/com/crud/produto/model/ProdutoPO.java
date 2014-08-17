/**
 * 
 */
package br.com.crud.produto.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.crud.abstractpo.AbstractPO;
import br.com.crud.fornecedor.model.FornecedorPO;

/**
 * Classe que representa um objeto do tipo produtoPO
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 01:06:01
 * @version 1.0
 */
@Entity
@Table( name = "produtos" )
public final class ProdutoPO extends AbstractPO{

	@Column( name = "nome_produto", length = 150, nullable = false )
	private String nomeProduto;
	
	@Column( name = "preco_compra",nullable=false )
	private BigDecimal precoCompra;
	
	@Column( name = "preco_venda",nullable=false )
	private BigDecimal precoVenda;
	
	private String descricao;

	@Temporal( TemporalType.DATE )
	@Column( name = "data_cadastro", nullable = false )
	private Date dataCadastro;

	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "id_fornecedor",nullable=false )
	private FornecedorPO fornecedor;

	/**
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:18:57
	 * @version 1.0
	 */
	public ProdutoPO(){}

	/**
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:18:22
	 * @version 1.0
	 */
	public ProdutoPO( Integer id ){
		setId( id );
	}

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * @param nomeProduto
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:18:06
	 * @version 1.0
	 */

	public ProdutoPO( String nomeProduto ){
		setNomeProduto( nomeProduto );
	}

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * @param id
	 * @param nomeProduto
	 * @param precoCompra
	 * @param precoVenda
	 * @param descricao
	 * @param fornecedor
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:17:22
	 * @version 1.0
	 */
	public ProdutoPO( Integer id, String nomeProduto, BigDecimal precoCompra, BigDecimal precoVenda, String descricao, FornecedorPO fornecedor, Date dataCadastro ){
		setId( id );
		setNomeProduto( nomeProduto );
		setPrecoCompra( precoCompra );
		setPrecoVenda( precoVenda );
		setDescricao( descricao );
		setDataCadastro( dataCadastro );
		setFornecedor( fornecedor );
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto( String nomeProduto ) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra( BigDecimal precoCompra ) {
		this.precoCompra = precoCompra;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda( BigDecimal precoVenda ) {
		this.precoVenda = precoVenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao( String descricao ) {
		this.descricao = descricao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro( Date dataCadastro ) {
		this.dataCadastro = dataCadastro;
	}

	public FornecedorPO getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor( FornecedorPO fornecedor ) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ( ( dataCadastro == null ) ? 0 : dataCadastro.hashCode() );
		result = prime * result + ( ( descricao == null ) ? 0 : descricao.hashCode() );
		result = prime * result + ( ( fornecedor == null ) ? 0 : fornecedor.hashCode() );
		result = prime * result + ( ( nomeProduto == null ) ? 0 : nomeProduto.hashCode() );
		result = prime * result + ( ( precoCompra == null ) ? 0 : precoCompra.hashCode() );
		result = prime * result + ( ( precoVenda == null ) ? 0 : precoVenda.hashCode() );
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
		ProdutoPO other = (ProdutoPO) obj;
		if ( dataCadastro == null ) {
			if ( other.dataCadastro != null )
				return false;
		} else if ( !dataCadastro.equals( other.dataCadastro ) )
			return false;
		if ( descricao == null ) {
			if ( other.descricao != null )
				return false;
		} else if ( !descricao.equals( other.descricao ) )
			return false;
		if ( fornecedor == null ) {
			if ( other.fornecedor != null )
				return false;
		} else if ( !fornecedor.equals( other.fornecedor ) )
			return false;
		if ( nomeProduto == null ) {
			if ( other.nomeProduto != null )
				return false;
		} else if ( !nomeProduto.equals( other.nomeProduto ) )
			return false;
		if ( precoCompra == null ) {
			if ( other.precoCompra != null )
				return false;
		} else if ( !precoCompra.equals( other.precoCompra ) )
			return false;
		if ( precoVenda == null ) {
			if ( other.precoVenda != null )
				return false;
		} else if ( !precoVenda.equals( other.precoVenda ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProdutoPO [getNomeProduto()=" + getNomeProduto() + ", getPrecoCompra()=" + getPrecoCompra() + ", getPrecoVenda()=" + getPrecoVenda() + ", getDescricao()=" + getDescricao() + ", getDataCadastro()=" + getDataCadastro() + ", getFornecedor()=" + getFornecedor() + ", hashCode()=" + hashCode() + "]";
	}

}
