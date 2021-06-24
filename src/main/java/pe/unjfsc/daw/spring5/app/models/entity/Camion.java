package pe.unjfsc.daw.spring5.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "camiones")
public class Camion implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String placa;
	
	@NotEmpty
	@Column(name = "clase")
	private String clase;
	
	@NotEmpty
	@Column(name = "config")
	private String config;
	
	@Column(name = "m3")
	private Integer m3;
	
	@Column(name = "tn")
	private Integer tn;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechacertificado;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaseguro;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecharevision;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public Integer getM3() {
		return m3;
	}

	public void setM3(Integer m3) {
		this.m3 = m3;
	}

	public Integer getTn() {
		return tn;
	}

	public void setTn(Integer tn) {
		this.tn = tn;
	}

	public Date getFechacertificado() {
		return fechacertificado;
	}

	public void setFechacertificado(Date fechacertificado) {
		this.fechacertificado = fechacertificado;
	}

	public Date getFechaseguro() {
		return fechaseguro;
	}

	public void setFechaseguro(Date fechaseguro) {
		this.fechaseguro = fechaseguro;
	}

	public Date getFecharevision() {
		return fecharevision;
	}

	public void setFecharevision(Date fecharevision) {
		this.fecharevision = fecharevision;
	}


 
	
	
}
