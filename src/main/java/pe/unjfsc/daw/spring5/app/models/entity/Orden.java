package pe.unjfsc.daw.spring5.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "ordenes")
public class Orden implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String manifiesto;

//	@OneToMany(mappedBy = "odrden",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Cliente> clientes;
//	
//	@OneToMany(mappedBy = "orden",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Camion> camiones;
//
//	@OneToMany(mappedBy = "orden",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Conductor> conductores;
//
//	@OneToMany(mappedBy = "orden",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Ruta> rutas;

	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="id_camion")
	private Camion camion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Conductor conductor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Ruta ruta;

	@NotEmpty
	private String estado;

	private Double abono;

	@NotEmpty
	private String liquidar;

	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date createAt;


//	public Orden() {
//		clientes = new ArrayList<Cliente>();
//		conductores = new ArrayList<Conductor>();
//		camiones = new ArrayList<Camion>();
//		rutas = new ArrayList<Ruta>();
//	}

	private static final long serialVersionUID = 1L;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	public Double calcularImporte() {
		
		return ruta.getCombustible()* ruta.getKms();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManifiesto() {
		return manifiesto;
	}

	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}

	public Camion getCamion() {
		return camion;
	}

	public void setCamion(Camion camion) {
		this.camion = camion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}


	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getAbono() {
		return abono;
	}

	public void setAbono(Double abono) {
		this.abono = abono;
	}

	public String getLiquidar() {
		return liquidar;
	}

	public void setLiquidar(String liquidar) {
		this.liquidar = liquidar;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	private void addCliente(Cliente cliente) {
//		clientes.add(cliente);
//	}
//
//	private void addCamion(Camion camion) {
//		camiones.add(camion);
//	}
//
//	private void addConductor(Conductor conductor) {
//		conductores.add(conductor);
//	}
//
//	private void addRuta(Ruta ruta) {
//		rutas.add(ruta);
//	}



	
	
}
