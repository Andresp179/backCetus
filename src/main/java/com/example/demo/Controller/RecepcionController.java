package com.example.demo.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
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
import com.example.demo.Models.Recepcion;
import com.example.demo.Repository.RecepcionDao;


@RequestMapping
@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class RecepcionController {
 
	private RecepcionDao recepcionDao;
	
	@RequestMapping(value = "/api/v1/recepciones", method = RequestMethod.GET)
	public List<Recepcion> listarProveedores(){		
		return recepcionDao.findAll();}	
	
	
	@GetMapping("/api/v1/recepcion/{id}")
	public ResponseEntity<Recepcion> obtenerRecepcionPorId(@PathVariable Long id) {
		Recepcion recepcion = recepcionDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el recepcion con el ID : " + id));
		return ResponseEntity.ok(recepcion);
	}
	
	//este metodo sirve para actualizar recepcion
		@PutMapping("/api/v1/recepcion/{id}")
		public ResponseEntity<Recepcion> actualizarRecepcion(@PathVariable Long id,@RequestBody Recepcion detallesRecepcion){
			Recepcion recepcion = recepcionDao.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el recepcion con el ID : " + id));
			
			recepcion.setFechaHora(detallesRecepcion.getFechaHora());
			recepcion.setIdProveedor(detallesRecepcion.getIdProveedor());
			recepcion.setIdProducto(detallesRecepcion.getIdProducto());
			recepcion.setNumeroFactura(detallesRecepcion.getNumeroFactura());
			recepcion.setCantidad(detallesRecepcion.getCantidad());
			recepcion.setLote(detallesRecepcion.getLote());
			
			Recepcion recepcionActualizado = recepcionDao.save(recepcion);
			return ResponseEntity.ok(recepcionActualizado);
	    }
		
		@DeleteMapping("/api/v1/recepcion/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarRecepcion(@PathVariable Long id){
			Recepcion recepcion = recepcionDao.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe la recepcion con el ID : " + id));
			
			recepcionDao.delete(recepcion);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }
}
