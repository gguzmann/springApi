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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="autos")
public class Auto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
	private Long id;
	
	private String marca;
	private String color;
	private String velocidad;
	private String patente;
	private String precio;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "autos_ventas", // nombre tabla relacional
			joinColumns = @JoinColumn(name="auto_id", nullable = false), // nombre columnda entidad local
			inverseJoinColumns = @JoinColumn(name="compraventa_id", nullable = false) // nombre columna otra entidad
			)
	private List<CompraVenta> listaCompraVentas;
	


	public void setListaCompraVentas(List<CompraVenta> listaCompraVentas) {
		this.listaCompraVentas = listaCompraVentas;
	}
	@Column(updatable = false) // INDicA QUQE NO VA A PODER SER ACTUALIZAR
	private Date createdAt; // guarda fecha cuando se inserta dato
	
	private Date updatedAt; // Guarda fecha cuando se actualiza dato

	public Auto(List<CompraVenta> listaCompraVentas) {
		super();
		this.listaCompraVentas = listaCompraVentas;
	}


	public Auto() {
		super();
	}


	public Auto(Long id, String marca, String color, String velocidad, String patente, String precio) {
		super();
		this.id = id;
		this.marca = marca;
		this.color = color;
		this.velocidad = velocidad;
		this.patente = patente;
		this.precio = precio;
	}

	public List<CompraVenta> getListaCompraVentas() {
		return listaCompraVentas;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}


	public String getPatente() {
		return patente;
	}


	public void setPatente(String patente) {
		this.patente = patente;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	
	
}
