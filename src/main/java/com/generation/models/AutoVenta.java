package com.generation.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="autos_ventas")
public class AutoVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer cantidad;
	private Integer montoTotal;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	//MANY TO MANY a traves de 2 o + Many to One
	
	//MANY TO ONE - COMPRA VENTA
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="compraventa_id", nullable = false)
	private CompraVenta compraVenta;
	
	

	//MANY TO ONE - AUTO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="auto_id", nullable = false)
	private Auto auto;



	public AutoVenta() {
		super();
	}



	public AutoVenta(Integer cantidad, Integer montoTotal, Date fecha, CompraVenta compraVenta, Auto auto) {
		super();
		this.cantidad = cantidad;
		this.montoTotal = montoTotal;
		this.fecha = fecha;
		this.compraVenta = compraVenta;
		this.auto = auto;
	}



	public AutoVenta(Auto auto) {
		super();
		this.auto = auto;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Integer getCantidad() {
		return cantidad;
	}



	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	public Integer getMontoTotal() {
		return montoTotal;
	}



	public void setMontoTotal(Integer montoTotal) {
		this.montoTotal = montoTotal;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public CompraVenta getCompraVenta() {
		return compraVenta;
	}



	public void setCompraVenta(CompraVenta compraVenta) {
		this.compraVenta = compraVenta;
	}



	public Auto getAuto() {
		return auto;
	}



	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	
	
}
