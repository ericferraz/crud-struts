/**
 * 
 */
package br.com.crud.testes;

import java.util.ArrayList;

import org.junit.Test;

import br.com.crud.estado.controller.EstadoFacade;
import br.com.crud.estado.dto.EstadoDTO;
import br.com.crud.exceptions.ApplicationException;

/**
 * Classe que representa
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 15/08/2014 17:53:02
 * @version 1.0
 */
public final class TestaEstado{
	private EstadoDTO estado;

	//@Test
	public void inserir() {
		try {
			estado = new EstadoDTO( "Maranhão", "ma", "4" );
			EstadoFacade.getInstance().inserir( estado );
			System.out.println( "Estado cadastrado com sucesso" );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			System.out.println( "Falha ao cadastrar estado " + e.getMessage() );
		}
	}
	
	//@Test
	public void alterar(){
		estado = new EstadoDTO( "mato grosso", "mt", "3" );
		try {
	        EstadoFacade.getInstance().alterar( estado );
	        System.out.println("Estado alterado com sucesso");
        } catch ( ApplicationException e ) {
	        e.printStackTrace();
	        System.out.println("Falha ao alterar estado"+e.getMessage());
        }
	}

	@Test
	public void excluir() {
		try {
			estado = new EstadoDTO( "es2", "uf2", "1" );
			EstadoFacade.getInstance().excluir( estado );
			System.out.println( "Estado excluido com sucesso" );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			System.out.println( "Falha ao excluir estado " + e.getMessage() );
		}
	}
	
	//@Test
	public void filtrar(){
		try {
			estado = new EstadoDTO( );
			estado.setId( "1" );
			ArrayList< EstadoDTO > itens = new ArrayList< EstadoDTO >();
			itens = EstadoFacade.getInstance().filtrar( estado );
			
			for ( EstadoDTO estados : itens ) {
				System.out.println("\n Id:"+estados.getId());
				System.out.println("\n Nome:"+estados.getNome()); 
				System.out.println("\n Uf:"+estados.getUf()); 
            }
			System.out.println( "\n Listagem realizada com sucesso!!" );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			System.out.println( "Falha ao listar" + e.getMessage() );
		}	
	}
}
