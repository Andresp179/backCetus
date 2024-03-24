package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Models.Recepcion;
import com.example.demo.Repository.RecepcionDao;

public class RecepcionServiceImpl implements RecepcionService{

	private RecepcionDao recepcionDao;
	
	
	@Override
	public List<Recepcion> listaRecepciones() {
		// TODO Auto-generated method stub
		return (List<Recepcion>) recepcionDao.findAll();
	}

	@Override
	public void guardar(Recepcion recepcion) {
		// TODO Auto-generated method stub
		recepcionDao.save(recepcion);
	}

	@Override
	public void eliminar(Recepcion recepcion) {
		// TODO Auto-generated method stub
		recepcionDao.delete(recepcion);
	}

	@Override
	public Optional<Recepcion> encontarEncuesta(Recepcion recepcion) {
		// TODO Auto-generated method stub
		return recepcionDao.findById(recepcion.getIdrecepcion());
	}

}
