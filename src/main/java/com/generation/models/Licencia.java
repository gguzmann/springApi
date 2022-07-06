package com.generation.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

// RElACION 1 a 1

@Entity
@Table(name="licencias")
public class Licencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numero;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaVencimiento;

	private String clase;
	private String estado;
	
	// OPCIONALES: SIRVEN PARA GESTION DE BASE DE DATOS
	// NO AGREGAR EN CONSTRUCTORES NI EN GETTER SETTER
	@Column(updatable = false) // INDicA QUQE NO VA A PODER SER ACTUALIZAR
	private Date createdAt; // guarda fecha cuando se inserta dato
		
	private Date updatedAt; // Guarda fecha cuando se actualiza dato
	// private Date deletedAt; // Fecha de eliminacion logica(cambio de estado, no borrar)
		
	
	// RELACION ONE TO ONE
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id") // FK de tabla relacionada
	private Usuario usuario;

	public Licencia() {
		super();
	}
	
	public Licencia(Long id, Integer numero, Date fechaVencimiento, String clase, String estado) {
		super();
		this.id = id;
		this.numero = numero;
		this.fechaVencimiento = fechaVencimiento;
		this.clase = clase;
		this.estado = estado;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	// INSERTAR EN BASE DE DATOS FECHA DE CREACION ANTES QUE REGISTRAR LA QUERY
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

	
	
}
