package com.example.Registro_Jardines.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Registro_Jardines.modelo.registrosJardines;
@Repository
public interface IRegistrosJardines extends CrudRepository<registrosJardines, Integer> {

}
