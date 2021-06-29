package model;

import java.io.Serializable;

/*
 * es un componente base de persistencia
 * para la id de las entidades persistentes de la aplicacion
 * (si cada objeto esta vacio me retorna null y si no me crea un primary key) 
 */

public interface AbsctractEntity extends Serializable {
	
	public Number getId();

}
