package br.com.crud.cidade.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.engine.spi.CascadingAction;

import br.com.crud.abstractpo.AbstractPO;
import br.com.crud.estado.model.EstadoPO;

/**
 * 
 * Classe que representa um objeto do tipo cidadePO
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 00:48:49
 * @version 1.0
 */
@Entity
@Table( name = "cidades" )
public final class CidadePO extends AbstractPO{

	@Column( nullable = false, length = 150 )
	private String nome;

	/**
	 * FetchType.EAGER:Traz todas as entidades que est�o relacionadas,
	 * ou seja, se a Entidade A possui um relacionamento com a Entidade B, ent�o quando consultar a Entidade A,
	 * tamb�m ser� consultado suas referencias na Entidade B.
	 * 
	 * CascadeType: com o CascadeType podemos definir a forma como ser�o propagadas as opera��es em cascata de uma Entity para suas referencias.
	 * 
	 * PERSIST
	 * Quando salvar a Entidade A, tamb�m ser� salvo todas as Entidades B associadas.
	 * 
	 * MERGE
	 * Quando atualizar as informa��es da Entidade A, tamb�m ser� atualizado no banco de dados todas as informa��es das Entidades B associadas.
	 * 
	 * REMOVE
	 * Quando remober a Entidade A, tamb�m ser� removida todas as entidades B associadas.
	 * 
	 * REFRESH
	 * Quando houver atualiza��o no banco de dados na Entidade A, todas as entidades B associadas ser�o atualizadas.
	 * 
	 * ALL
	 * Corresponde a todas as opera��es acima (MERGE, PERSIST, REFRESH e REMOVE).
	 */
	@ManyToOne( cascade=CascadeType.REMOVE,fetch = FetchType.EAGER )
	@JoinColumn( name = "id_estado")
	private EstadoPO estado;

	/**
	 * 
	 * M�todo construtor respos�vel por inicializar os atributos e/ou
	 * executar qualquer a��o no momento da cria��o da classe.
	 * 
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 00:49:13
	 * @version 1.0
	 */
	public CidadePO(){}

	/**
	 * 
	 * M�todo construtor respos�vel por inicializar os atributos e/ou
	 * executar qualquer a��o no momento da cria��o da classe.
	 * 
	 * @param nome
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 00:49:23
	 * @version 1.0
	 */
	public CidadePO( String nome ){
		setNome( nome );
	}

	public CidadePO( Integer id ){
		setId( id );
	}

	public CidadePO( String nome, EstadoPO estado, Integer id ){
		setNome( nome );
		setEstado( estado );
		setId( id );
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public EstadoPO getEstado() {
		return estado;
	}

	public void setEstado( EstadoPO estado ) {
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
		CidadePO other = (CidadePO) obj;
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
		return "CidadePO [getNome()=" + getNome() + ", getEstado()=" + getEstado() + ", hashCode()=" + hashCode() + "]";
	}

}
