package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Models.Recepcion;

public interface RecepcionService {
	
	
	public List<Recepcion> listaRecepciones();

    public void guardar (Recepcion recepcion);

    public void eliminar (Recepcion recepcion);

    public Optional<Recepcion> encontarEncuesta(Recepcion recepcion);

}
