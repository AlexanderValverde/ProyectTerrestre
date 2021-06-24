package pe.unjfsc.daw.spring5.app.models.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rutas")
public class Ruta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String origen;
	
	@NotEmpty
	private String destino;
	
	@NotNull
	private Integer kms;
	
	@NotNull
	private Integer npeaje;	
	
	@NotNull
	private Double peaje;
	
	@NotNull
	private Double combustible;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getKms() {
		return kms;
	}

	public void setKms(Integer kms) {
		this.kms = kms;
	}

	public Integer getNpeaje() {
		return npeaje;
	}

	public void setNpeaje(Integer npeaje) {
		this.npeaje = npeaje;
	}

	public Double getPeaje() {
		return peaje;
	}

	public void setPeaje(Double peaje) {
		this.peaje = peaje;
	}

	public Double getCombustible() {
		return combustible;
	}

	public void setCombustible(Double combustible) {
		this.combustible = combustible;
	}

	
	
}
