package com.generation.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="comprasVentas")
public class CompraVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Range(min=0)
	private Float monto;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	//ManyToOne
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cliente_id") // FK de tabla relacionada
	private Cliente cliente;
	
	//MANY TO MANY - AUTOS VENTAS
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="autos_ventas", // nombre tabla relacion
			joinColumns = @JoinColumn(name="compraventa_id", nullable = false), // nombre columna entidad local
			inverseJoinColumns = @JoinColumn(name="auto_id", nullable = false) // nombre columna otra entidad
			)	
	private List<Auto> listaAutos;
	
	
	
	

	public CompraVenta(Cliente cliente, List<Auto> listaAutos) {
		super();
		this.cliente = cliente;
		this.listaAutos = listaAutos;
	}

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	public CompraVenta() {
		super();
	}

	public CompraVenta(@Range(min = 0) Float monto, Date fecha, Cliente cliente) {
		super();
		this.monto = monto;
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Auto> getListaAutos() {
		return listaAutos;
	}

	public void setListaAutos(List<Auto> listaAutos) {
		this.listaAutos = listaAutos;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
