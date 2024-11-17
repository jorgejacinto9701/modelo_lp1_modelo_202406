package entity;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Libro {

	private int idLibro;
	private String titulo;
	private int anio;
	private String serie;
	private String tema;
	private Date fechaRegistro;
	private Date fechaActualizacion;
	private int estado;
	private Categoria categoria;

	
}
