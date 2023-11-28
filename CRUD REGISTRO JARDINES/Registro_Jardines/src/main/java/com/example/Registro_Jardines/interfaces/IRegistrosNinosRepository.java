package com.example.Registro_Jardines.interfaces;
import com.example.Registro_Jardines.modelo.registrosNinos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistrosNinosRepository extends JpaRepository<registrosNinos, Integer> {

}

