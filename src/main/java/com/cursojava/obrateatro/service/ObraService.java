package com.cursojava.obrateatro.service;
import com.cursojava.obrateatro.model.Actor;
import com.cursojava.obrateatro.model.Obra;
import com.cursojava.obrateatro.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraService {

    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    private ActorService actorService;

    // Crear obra con actores
    public Obra crearObra(Obra obra) {
        // Guardar la obra
        obraRepository.save(obra);

        // Asociar actores a la obra
        List<Actor> actores = obra.getActores();
        for (Actor actor : actores) {
            actorService.crearActor(actor);
        }

        return obra;
    }

    // Obtener todas las obras
    public List<Obra> obtenerTodasLasObras() {
        return obraRepository.findAll();
    }

    // Obtener una obra por ID
    public Obra obtenerObraPorId(Long obraId) {
        return obraRepository.findById(obraId).orElse(null);
    }

    // Actualizar obra por ID
    public Obra actualizarObra(Long obraId, Obra obra) {
        Optional<Obra> obraExistente = obraRepository.findById(obraId);
        if (obraExistente.isPresent()) {
            Obra obraEncontrada = obraExistente.get();
            obraEncontrada.setTitulo(obra.getTitulo());
            obraEncontrada.setActores(obra.getActores());
            return obraRepository.save(obraEncontrada);
        } else {
            return null;
        }
    }

    // Eliminar obra por ID
    public void eliminarObra(Long obraId) {
        obraRepository.deleteById(obraId);
    }
}
