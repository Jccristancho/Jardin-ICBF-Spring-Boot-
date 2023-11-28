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
		int res=0;
		registrosJardines registros=data.save(p);
		if(!registros.equals(null)) {
			res=1;
		}
		return 0;
	}



	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
