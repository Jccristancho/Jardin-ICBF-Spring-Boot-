package com.example.Registro_Jardines.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.Registro_Jardines.modelo.registrosJardines;
@Repository
public interface IRegistrosJardines extends JpaRepository<registrosJardines, Integer> {

}
