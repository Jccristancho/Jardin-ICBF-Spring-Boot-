package com.example.Registro_Jardines.service;

import com.example.Registro_Jardines.interfaceService.IinventarioServiceRegistrosNinos;
import com.example.Registro_Jardines.interfaces.IRegistrosNinosRepository;
import com.example.Registro_Jardines.modelo.registrosNinos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class registrosNinosService implements IinventarioServiceRegistrosNinos {

    @Autowired
    private IRegistrosNinosRepository registrosNinosRepository;



    @Override
    public List<registrosNinos> listar_ninos() {
        return registrosNinosRepository.findAll();
    }

    @Override
    public Optional<registrosNinos> listar_ninosId(int id) {
        return registrosNinosRepository.findById(id);
    }

    @Override
    public int saveN(registrosNinos p) {

        registrosNinosRepository.save(p);

        return p.getRegistro();
    }

    @Override
    public void deleteN(int id) {
        registrosNinosRepository.deleteById(id);
    }

    @Override
    public void editarN(registrosNinos p) {
        Optional<registrosNinos> registroExistente = registrosNinosRepository.findById(p.getRegistro());

        if (registroExistente.isPresent()) {
            // Actualizar solo si el registro existe
            registrosNinos registro = registroExistente.get();
            registro.setNombre(p.getNombre());
            registro.setFechaNacimiento(p.getFechaNacimiento());
            registro.setTipoSangre(p.getTipoSangre());
            registro.setCiudadNacimiento(p.getCiudadNacimiento());
            registro.setDireccion(p.getDireccion());
            registro.setEps(p.getEps());
            registro.setIdentificacionAcudiente(p.getIdentificacionAcudiente());
            registro.setTelefono(p.getTelefono());
            registro.setJardin(p.getJardin());


            registrosNinosRepository.save(registro);
        }
        // Si el registro no existe
    }
}

