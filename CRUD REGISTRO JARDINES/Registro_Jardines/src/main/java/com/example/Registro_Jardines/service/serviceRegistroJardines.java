package com.example.Registro_Jardines.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Registro_Jardines.interfaceService.*;
import com.example.Registro_Jardines.interfaces.*;
import com.example.Registro_Jardines.modelo.*;
@Service
public class serviceRegistroJardines implements IinventarioServiceRegistrosJardines {
	
	@Autowired
	private IRegistrosJardines data;
	@Override
	public List<registrosJardines> listar_registros() {
		// TODO Auto-generated method stub
		return (List<registrosJardines>)data.findAll();
	}

	@Override
	public Optional<registrosJardines> listar_registrosId(int id) {
		return data.findById(id);
		
	}



	@Override
	public int save(registrosJardines p) {
		int res = 0;
		registrosJardines registros = data.save(p);
		if (registros != null) {
			res = 1;
		}
		return res;  // Devuelve la variable res en lugar de 0
	}



	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

	@Override
	public void editar(registrosJardines p) {
		Optional<registrosJardines> registroExistente = data.findById(p.getId());

		if (registroExistente.isPresent()) {
			// Actualizar solo si el registro existe
			registrosJardines registros = registroExistente.get();
			registros.setNombre(p.getNombre());
			registros.setDireccion(p.getDireccion());
			registros.setEstado(p.getEstado());



			data.save(registros);
		}
		// Si el registro no existe
	}

}
