package com.example.demo.Models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Table(name="recepcion")
@Setter
@Getter
public class Recepcion {
	
	
    

	private Long idrecepcion;
	
	public Date fechaHora;
	
	public String idProveedor;
	
	public String idProducto;
	
	public String numeroFactura;
	
	public String cantidad;	
	
	public String lote;
	
	public Recepcion(Long idrecepcion, Date fechaHora, String idProveedor,String idProducto, String numeroFactura, String Cantidad, String Lote) {
		super();
		this.idrecepcion=idrecepcion;
		this.fechaHora=fechaHora;
		this.idProveedor=idProveedor;
		this.idProducto=idProducto;
		this.numeroFactura=numeroFactura;
		this.cantidad=cantidad;
		this.lote=lote;
	}
	
	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
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
