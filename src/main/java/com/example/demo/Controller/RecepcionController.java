package com.example.demo.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Proveedor;
import com.example.demo.Models.Recepcion;
import com.example.demo.Repository.RecepcionDao;


@RequestMapping("/")
@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class RecepcionController {
 
	private RecepcionDao recepcionDao;
	
	@RequestMapping(value = "/api/v1/recepciones", method = RequestMethod.GET)
	public List<Recepcion> listarProveedores(){		
		return recepcionDao.findAll();}	
}
