package com.example.demo.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Excepciones.ResourceNotFoundException;
import com.example.demo.Models.Producto;
import com.example.demo.Models.Proveedor;
import com.example.demo.Repository.ProveedorDao;


@RequestMapping
@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class ProveedorController {
	
	@Autowired
	public ProveedorDao proveedorDao;
	
	@RequestMapping(value = "/api/v1/proveedores", method = RequestMethod.GET)
	public List<Proveedor> listarProveedores(){		
		return proveedorDao.findAll();
	}
	

	// este metodo sirve para buscar un proveedor
	@GetMapping("/api/v1/proveedor/{id}")
	public ResponseEntity<Proveedor> obtenerProductoPorId(@PathVariable Long id) {
		Proveedor proveedor = proveedorDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el proveedor con el ID : " + id));
		return ResponseEntity.ok(proveedor);
	}
	
	//este metodo sirve para actualizar proveedor
		@PutMapping("/api/v1/proveedor/{id}")
		public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id,@RequestBody Proveedor detallesProveedor){
			Proveedor proveedor = proveedorDao.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));
			
			proveedor.setnIdentificacion(detallesProveedor.getnIdentificacion());
			proveedor.setRazonSocial(detallesProveedor.getRazonSocial());
			proveedor.setDireccion(detallesProveedor.getDireccion());
			proveedor.setNombreContacto(detallesProveedor.getNombreContacto());
			
			Proveedor proveedorActualizado = proveedorDao.save(proveedor);
			return ResponseEntity.ok(proveedorActualizado);
	    }
		
		@DeleteMapping("/api/v1/proveedor/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarProveedor(@PathVariable Long id){
			Proveedor proveedor = proveedorDao.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el proveedor con el ID : " + id));
			
			proveedorDao.delete(proveedor);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }
	
}
