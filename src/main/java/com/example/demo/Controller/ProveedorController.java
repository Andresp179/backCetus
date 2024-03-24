package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Proveedor;
import com.example.demo.Repository.ProveedorDao;


@RequestMapping("/")
@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class ProveedorController {
	
	@Autowired
	public ProveedorDao proveedorDao;
	
	@RequestMapping(value = "/api/v1/proveedores", method = RequestMethod.GET)
	public List<Proveedor> listarProveedores(){		
		return proveedorDao.findAll();
	}
	
}
