package com.example.Registro_Jardines.interfaceService;

import com.example.Registro_Jardines.modelo.registrosNinos;

import java.util.List;
import java.util.Optional;

public interface IinventarioServiceRegistrosNinos {
    List<registrosNinos> listar_ninos();
    Optional<registrosNinos> listar_ninosId(int id);
    void editarN(registrosNinos p);
    int saveN(registrosNinos p);
    void deleteN(int id);
}

