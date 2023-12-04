package com.example.Registro_Jardines.service;
import com.example.Registro_Jardines.interfaceService.EvaluacionService;
import com.example.Registro_Jardines.interfaces.EvaluacionRepository;

import com.example.Registro_Jardines.modelo.Evaluacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    private final EvaluacionRepository evaluacionRepository;

    @Autowired
    public EvaluacionServiceImpl(EvaluacionRepository evaluacionRepository) {
        this.evaluacionRepository = evaluacionRepository;
    }

    @Override
    public Evaluacion guardarEvaluacion(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }


}

