package br.com.crud.utilidades;

import java.math.BigDecimal;

import br.com.crud.cidade.dto.CidadeDTO;
import br.com.crud.cidade.model.CidadePO;
import br.com.crud.estado.dto.EstadoDTO;
import br.com.crud.estado.model.EstadoPO;
import br.com.crud.exceptions.DadosInvalidosException;
import br.com.crud.fornecedor.dto.FornecedorDTO;
import br.com.crud.fornecedor.model.FornecedorPO;
import br.com.crud.produto.dto.ProdutoDTO;
import br.com.crud.produto.model.ProdutoPO;

/**
 * 
 * Classe responsável por transformar dto em po e vice-versa
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 27/04/2014 14:26:41
 * @version 1.0
 */
public abstract class ModelFactory{

	/**
	 * 
	 * Método responsável por transformar um estadoDTO em estadoPO
	 * ou seja o objeto que vem da camada view para a camada controller
	 * virá todos dados no tipo String, então ocorrerá a conversão dos dados
	 * do objeto de transferência de dados, para um objeto tipado que será
	 * utilizado na persistência de dados
	 * 
	 * @param dto
	 * @return
	 * @throws DadosInvalidosException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 08:58:03
	 * @version 1.0
	 */
	public static EstadoPO getPO( EstadoDTO dto ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( dto ) ) {
			throw new DadosInvalidosException( "Objeto do argumento nulo encontrado" );
		}
		EstadoPO po = new EstadoPO();
		// tudo que não for String no PO, deverá ser tratato aqui
		if ( !Utilidades.isNuloOuVazio( dto.getId() ) ) {
			Integer id = (Integer) Utilidades.parseValue( dto.getId(), Integer.class );
			po.setId( id );
		}

		if ( !Utilidades.isNuloOuVazio( dto.getNome() ) ) {
			po.setNome( dto.getNome() );
		}

		if ( !Utilidades.isNuloOuVazio( dto.getUf() ) ) {
			po.setUf( dto.getUf() );
		}

		return po;
	}

	/**
	 * 
	 * Método responsável por pegar um objeto po e tranformar em outro do tipo dto
	 * 
	 * @param po
	 * @return
	 * @throws DadosInvalidosException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 09:04:40
	 * @version 1.0
	 */
	public static EstadoDTO getDTO( EstadoPO po ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( po ) ) {
			throw new DadosInvalidosException( "Objeto do argumento nulo encontrado" );
		}
		EstadoDTO dto = new EstadoDTO();

		if ( !Utilidades.isNuloOuVazio( po.getId() ) ) {
			String id = (String) Utilidades.parseValue( po.getId(), String.class );
			dto.setId( id );
		}

		if ( !Utilidades.isNuloOuVazio( po.getNome() ) ) {
			dto.setNome( po.getNome() );
		}

		if ( !Utilidades.isNuloOuVazio( po.getUf() ) ) {
			dto.setUf( po.getUf() );
		}

		return dto;
	}

	/**
	 * 
	 * Método responsável por tranformar um dto em po
	 * 
	 * @param dto
	 * @return
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 09:09:25
	 * @version 1.0
	 * @throws DadosInvalidosException
	 */
	public static CidadePO getPO( CidadeDTO dto ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( dto ) ) {
			throw new DadosInvalidosException( "Objeto do argumento nulo encontrado" );
		}

		CidadePO po = new CidadePO();
		if ( !Utilidades.isNuloOuVazio( dto.getEstado() ) ) {
			Integer idEstado = (Integer) Utilidades.parseValue( dto.getEstado().getId(), Integer.class );
			EstadoPO estado = new EstadoPO( idEstado );
			po.setEstado( estado );
		}

		if ( !Utilidades.isNuloOuVazio( dto.getId() ) ) {
			Integer idCidade = (Integer) Utilidades.parseValue( dto.getId(), Integer.class );
			po.setId( idCidade );
		}

		if ( !Utilidades.isNuloOuVazio( dto.getNome() ) ) {
			po.setNome( dto.getNome() );
		}

		return po;
	}

	/**
	 * 
	 * Método responsável por tranformar um objeto po em dto
	 * 
	 * @param po
	 * @return
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 09:20:01
	 * @version 1.0
	 * @throws DadosInvalidosException
	 */
	public static CidadeDTO getDTO( CidadePO po ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( po ) ) {
			throw new DadosInvalidosException( "Objeto do argumento nulo encontrado" );
		}

		CidadeDTO dto = new CidadeDTO();

		if ( !Utilidades.isNuloOuVazio( po.getId() ) ) {
			String idcidade = (String) Utilidades.parseValue( po.getId(), String.class );
			dto.setId( idcidade );
		} else {
			throw new DadosInvalidosException( "O id da cidade está nulo " );
		}

		if ( !Utilidades.isNuloOuVazio( po.getNome() ) ) {
			dto.setNome( po.getNome() );
		}
		if ( !Utilidades.isNuloOuVazio( po.getEstado().getId() ) ) {
			String idEstado = (String) Utilidades.parseValue( po.getEstado().getId(), String.class );
			EstadoDTO estado = new EstadoDTO();
			estado.setId( idEstado );
			dto.setEstado( estado );
		}
		if ( !Utilidades.isNuloOuVazio( po.getNome() ) ) {
			dto.setNome( po.getNome() );
		}

		return dto;
	}

	/**
	 * 
	 * Método responsável por tranformar um dto em po
	 * 
	 * @param dto
	 * @return
	 * @throws DadosInvalidosException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 09:55:06
	 * @version 1.0
	 */
	public static FornecedorPO getPO( FornecedorDTO dto ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( dto ) ) {
			throw new DadosInvalidosException( "Objeto do argumento encontra-se nulo" );
		}
		FornecedorPO po = new FornecedorPO();
		if ( !Utilidades.isNuloOuVazio( dto.getId() ) ) {
			Integer idFornecedor = (Integer) Utilidades.parseValue( dto.getId(), Integer.class );
			po.setId( idFornecedor );
		}
		if ( !Utilidades.isNuloOuVazio( dto.getNome() ) ) {
			po.setNome( dto.getNome() );
		}
		if ( !Utilidades.isNuloOuVazio( dto.getCnpj() ) ) {
			po.setCnpj( dto.getCnpj() );
		}
		if ( !Utilidades.isNuloOuVazio( dto.getEndereco() ) ) {
			po.setEndereco( dto.getEndereco() );
		}
		if ( !Utilidades.isNuloOuVazio( dto.getCidade() ) ) {
			Integer idCidade = (Integer) Utilidades.parseValue( dto.getCidade().getId(), Integer.class );
			CidadePO cidade = new CidadePO( idCidade );
			po.setCidade( cidade );
		}

		if ( !Utilidades.isNuloOuVazio( dto.getEstado() ) ) {
			Integer idEstado = (Integer) Utilidades.parseValue( dto.getEstado().getId(), Integer.class );
			EstadoPO estado = new EstadoPO( idEstado );
			po.setEstado( estado );
		}

		return po;
	}

	/**
	 * 
	 * Método responsável por transformar um po em dto
	 * 
	 * @param po
	 * @return
	 * @throws DadosInvalidosException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 09:58:11
	 * @version 1.0
	 */
	public static FornecedorDTO getDTO( FornecedorPO po ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( po ) ) {
			throw new DadosInvalidosException( "Objeto do argumento encontra-se nulo" );
		}

		FornecedorDTO dto = new FornecedorDTO();
		if ( !Utilidades.isNuloOuVazio( po.getId() ) ) {
			String id = (String) Utilidades.parseValue( po.getId(), String.class );
			dto.setId( id );
		}

		if ( !Utilidades.isNuloOuVazio( po.getNome() ) ) {
			dto.setNome( po.getNome() );
		}

		if ( !Utilidades.isNuloOuVazio( po.getCnpj() ) ) {
			dto.setCnpj( po.getCnpj() );
		}

		if ( !Utilidades.isNuloOuVazio( po.getEndereco() ) ) {
			dto.setEndereco( po.getEndereco() );
		}

		if ( !Utilidades.isNuloOuVazio( po.getEstado() ) ) {
			String idEstado = (String) Utilidades.parseValue( po.getEstado().getId(), String.class );
			EstadoDTO estado = new EstadoDTO();
			estado.setId( idEstado );
			dto.setEstado( estado );
		}

		if ( !Utilidades.isNuloOuVazio( po.getCidade() ) ) {
			String idCidade = (String) Utilidades.parseValue( po.getCidade().getId(), String.class );
			CidadeDTO cidade = new CidadeDTO();
			cidade.setId( idCidade );
			dto.setCidade( cidade );
		}
		return dto;
	}

	/**
	 * 
	 * Método responsável por tranformar um objeto dto em po
	 * 
	 * @param dto
	 * @return
	 * @throws DadosInvalidosException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 10:54:17
	 * @version 1.0
	 */
	public static ProdutoPO getPO( ProdutoDTO dto ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( dto ) ) {
			throw new DadosInvalidosException( "Objeto do argumento encontra-se nulo" );
		}

		ProdutoPO po = new ProdutoPO();
		if ( !Utilidades.isNuloOuVazio( dto.getId() ) ) {
			Integer id = (Integer) Utilidades.parseValue( dto.getId(), Integer.class );
			po.setId( id );
		}

		if ( !Utilidades.isNuloOuVazio( dto.getDescricao() ) ) {
			po.setDescricao( dto.getDescricao() );
		}

		if ( !Utilidades.isNuloOuVazio( dto.getFornecedor().getId() ) ) {
			Integer idFornecedor = (Integer) Utilidades.parseValue( dto.getFornecedor().getId(), Integer.class );
			FornecedorPO fornecedor = new FornecedorPO( idFornecedor );
			po.setFornecedor( fornecedor );
		}

		if ( !Utilidades.isNuloOuVazio( dto.getNomeProduto() ) ) {
			po.setNomeProduto( dto.getNomeProduto() );
		}

		if ( !Utilidades.isNuloOuVazio( dto.getPrecoCompra() ) ) {
			BigDecimal precoCompra = (BigDecimal) Utilidades.parseValue( dto.getPrecoCompra(), BigDecimal.class );
			po.setPrecoCompra( precoCompra );
		}

		if ( !Utilidades.isNuloOuVazio( dto.getPrecoVenda() ) ) {
			BigDecimal precoVenda = (BigDecimal) Utilidades.parseValue( dto.getPrecoVenda(), BigDecimal.class );
			po.setPrecoVenda( precoVenda );
		}

		return po;
	}

	/**
	 * 
	 * Método responsável por transformar um po em dto
	 * 
	 * @param po
	 * @return
	 * @throws DadosInvalidosException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 11:06:19
	 * @version 1.0
	 */
	public static ProdutoDTO getDTO( ProdutoPO po ) throws DadosInvalidosException {
		if ( Utilidades.isNuloOuVazio( po ) ) {
			throw new DadosInvalidosException( "Objeto do argumento encontra-se nulo" );
		}

		ProdutoDTO dto = new ProdutoDTO();
		if ( !Utilidades.isNuloOuVazio( po.getId() ) ) {
			String id = (String) Utilidades.parseValue( po.getId(), String.class );
			dto.setId( id );
		}

		if ( !Utilidades.isNuloOuVazio( po.getDescricao() ) ) {
			dto.setDescricao( po.getDescricao() );
		}

		if ( !Utilidades.isNuloOuVazio( po.getFornecedor().getId() ) ) {
			String idFornecedor = (String) Utilidades.parseValue( po.getFornecedor().getId(), String.class );
			FornecedorDTO fornecedor = new FornecedorDTO();
			fornecedor.setId( idFornecedor );
			dto.setFornecedor( fornecedor );
		}

		if ( !Utilidades.isNuloOuVazio( po.getNomeProduto() ) ) {
			dto.setNomeProduto( po.getNomeProduto() );
		}

		if ( !Utilidades.isNuloOuVazio( po.getPrecoCompra() ) ) {
			String precoCompra = (String) Utilidades.parseValue( po.getPrecoCompra(), String.class );
			dto.setPrecoCompra( precoCompra );
		}

		if ( !Utilidades.isNuloOuVazio( po.getPrecoVenda() ) ) {
			String precoVenda = (String) Utilidades.parseValue( dto.getPrecoVenda(), String.class );
			dto.setPrecoVenda( precoVenda );
		}

		return dto;
	}

}
