package com.example.demo.Models;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.Optional;

import org.springframework.boot.context.properties.bind.ConstructorBinding;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Entity;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "idproducto", nullable = false)
	private Long idProducto;

	@Column(name = "nombre_Producto", nullable = false)
	public String nombreProducto;

	@Column(name = "descripcion", nullable = false)
	public String descripcion;

	@Column(name = "estado", nullable = false)
	public String estado;

	@Column(name = "nombre_Laboratorio", nullable = false)
	public String nombreLaboratorio;

	
	public Producto(Long idProducto,String nombre_producto,String descripcion, String estado, String nombre_Laboratorio) {
		this.idProducto=idProducto;
		this.nombreProducto=nombre_producto;
		this.descripcion=descripcion;
		this.estado=estado;
		this.nombreLaboratorio=nombre_Laboratorio;		
	}
		
	public Long getIdProducto() {
		return idProducto;
	}	

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreLaboratorio() {
		return nombreLaboratorio;
	}

	public void setNombreLaboratorio(String nombreLaboratorio) {
		this.nombreLaboratorio = nombreLaboratorio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Producto() {}
	
	
	

}
