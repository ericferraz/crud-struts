/**
 * 
 */
package br.com.crud.testes;

import java.util.ArrayList;

import org.junit.Test;

import br.com.crud.cidade.controller.CidadeFacade;
import br.com.crud.cidade.dto.CidadeDTO;
import br.com.crud.cidade.model.CidadeService;
import br.com.crud.estado.dto.EstadoDTO;
import br.com.crud.exceptions.ApplicationException;

/**
 * Classe que representa um objeto de testes da cidade
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 02:26:52
 * @version 1.0
 */
public final class TestaCidade{
	public EstadoDTO estado;
	public CidadeDTO cidade;
	public CidadeService service;

	//@Test
	public void inserir() {
		estado = new EstadoDTO( "paraná", "pr", "1" );
		cidade = new CidadeDTO( "2", "teste", estado );
		try {
			CidadeFacade.getInstance().inserir( cidade );
			System.out.println( "Cidade cadastrada com sucesso" );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			System.out.println( "Falha ao cadastrar cidade" + e.getMessage() );
		}
	}

	//@Test
	public void excluir() {
		cidade = new CidadeDTO();
		cidade.setId( "3" );
		cidade.setNome( "teste" );
		try {
			CidadeFacade.getInstance().excluir( cidade );
			System.out.println( "Cidade excluida com sucesso" );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			System.out.println( "Falha ao excluir cidade" + e.getMessage() );
		}
	}

	//@Test
	public void alterar() {
		cidade = new CidadeDTO();
		estado = new EstadoDTO();
		estado.setId( "1" );
		cidade.setId( "2" );
		cidade.setNome( "londrina" );
		cidade.setEstado( estado );
		try {
			CidadeFacade.getInstance().alterar( cidade );
			System.out.println( "Cidade alterada com sucesso" );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			System.out.println( "Falha ao excluir cidade" + e.getMessage() );
		}
	}
	
	@Test
	public void filtrar(){
		cidade = new CidadeDTO();
		estado = new EstadoDTO();
		//estado.setId( "1" );
		//cidade.setId( "2" );
		cidade.setNome( "ci2" );
		//cidade.setEstado( estado );
		try {
			ArrayList< CidadeDTO > itens = new ArrayList< CidadeDTO >();
			itens = CidadeFacade.getInstance().filtrar( cidade );
			for ( CidadeDTO cidades : itens ) {
	           System.out.println("\n Id:"+cidades.getId());
	           System.out.println("\n Cidade:"+cidades.getNome()); 
	           System.out.println("\n Estado:"+cidades.getEstado().getId());
	           System.out.println("\n---------------------------------"); 
            }
			System.out.println( "Listagem realizada com sucesso" );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			System.out.println( "Falha ao excluir cidade" + e.getMessage() );
		}
	}
}
