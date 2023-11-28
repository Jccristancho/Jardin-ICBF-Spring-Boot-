package com.example.Registro_Jardines.interfaceService;

import java.util.List;
import java.util.Optional;
import com.example.Registro_Jardines.modelo.*;

public interface IinventarioServiceRegistrosJardines {
	public List<registrosJardines>listar_registros();
	public Optional<registrosJardines>listar_registrosId(int id);
	public int save(registrosJardines p);
	public void delete(int id);
}
