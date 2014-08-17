package br.com.crud.abstractdto;

/**
 * 
 * Classe que representa todos dtos do sistema, pois todos dtos ir�o herdar desse objeto
 * ou seja todos dtos ser�o filhos de AbstractDTO
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 14/08/2014 00:36:36
 * @version 1.0
 */
public abstract class AbstractDTO{
	private String id;
    
	/**
	 * 
	 * M�todo construtor respos�vel por inicializar os atributos e/ou
	 * executar qualquer a��o no momento da cria��o da classe.
	 *
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 00:37:49
	 * @version 1.0
	 */
	public AbstractDTO(){

	}

	/**
	 * 
	 * M�todo construtor respos�vel por inicializar os atributos e/ou
	 * executar qualquer a��o no momento da cria��o da classe.
	 *
	 * @param  id
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 14/08/2014 00:38:00
	 * @version 1.0
	 */
	public AbstractDTO( String id ){
		setId( id );
	}

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		AbstractDTO other = (AbstractDTO) obj;
		if ( id == null ) {
			if ( other.id != null )
				return false;
		} else if ( !id.equals( other.id ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractDTO [getId()=" + getId() + ", hashCode()=" + hashCode() + "]";
	}

}
