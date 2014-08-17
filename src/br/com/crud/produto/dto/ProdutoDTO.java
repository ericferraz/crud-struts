/**
 * 
 */
package br.com.crud.produto.dto;

import br.com.crud.abstractdto.AbstractDTO;
import br.com.crud.fornecedor.dto.FornecedorDTO;

/**
 * Classe que representa um objeto do tipo produtoDTO
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 01:38:46
 * @version 1.0
 */
public final class ProdutoDTO extends AbstractDTO{
	private String nomeProduto;
	private String precoCompra;
	private String precoVenda;
	private String descricao;
	private FornecedorDTO fornecedor;

	/**
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:43:08
	 * @version 1.0
	 */
	public ProdutoDTO(){}

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 * 
	 * @param id
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:43:47
	 * @version 1.0
	 */
	public ProdutoDTO( String id ){
		setId( id );
	}

	/**
	 * 
	 * Método construtor resposável por inicializar os atributos e/ou
	 * executar qualquer ação no momento da criação da classe.
	 *
	 * @param id
	 * @param nomeProduto
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 01:46:05
	 * @version 1.0
	 */
	public ProdutoDTO( String id, String nomeProduto ){
		setId( id );
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
	 * @since 14/08/2014 01:42:49
	 * @version 1.0
	 */
	public ProdutoDTO( String id, String nomeProduto, String precoCompra, String precoVenda, String descricao, FornecedorDTO fornecedor ){
		setId( id );
		setNomeProduto( nomeProduto );
		setPrecoCompra( precoCompra );
		setPrecoVenda( precoVenda );
		setDescricao( descricao );
		setFornecedor( fornecedor );
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto( String nomeProduto ) {
		this.nomeProduto = nomeProduto;
	}

	public String getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra( String precoCompra ) {
		this.precoCompra = precoCompra;
	}

	public String getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda( String precoVenda ) {
		this.precoVenda = precoVenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao( String descricao ) {
		this.descricao = descricao;
	}

	public FornecedorDTO getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor( FornecedorDTO fornecedor ) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		ProdutoDTO other = (ProdutoDTO) obj;
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
		return "ProdutoDTO [getNomeProduto()=" + getNomeProduto() + ", getPrecoCompra()=" + getPrecoCompra() + ", getPrecoVenda()=" + getPrecoVenda() + ", getDescricao()=" + getDescricao() + ", getFornecedor()=" + getFornecedor() + ", hashCode()=" + hashCode() + "]";
	}

}
