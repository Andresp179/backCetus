package com.example.demo.Models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "recepcion")
public class Recepcion {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idProveedor;

	private Long idrecepcion;

	public Date fechaHora;

	public String idProducto;

	public String numeroFactura;

	public String cantidad;

	public String lote;

	public Recepcion(Long idrecepcion, Date fechaHora, Long idProveedor, String idProducto, String numeroFactura,
			String cantidad, String lote) {
		super();
		this.idrecepcion = idrecepcion;
		this.fechaHora = fechaHora;
		this.idProveedor = idProveedor;
		this.idProducto = idProducto;
		this.numeroFactura = numeroFactura;
		this.cantidad = cantidad;
		this.lote = lote;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public void setIdrecepcion(Long idrecepcion) {
		this.idrecepcion = idrecepcion;
	}

	public Long getIdrecepcion() {
		return idrecepcion;
	}

}
