package com.cursojava.obrateatro.service;

import com.cursojava.obrateatro.model.Actor;
import com.cursojava.obrateatro.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    // Crear actor
    public Actor crearActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> crearVariosActores(List<Actor> actores) {
        return actorRepository.saveAll(actores);
    }

    // Obtener todos los actores
    public List<Actor> obtenerTodosLosActores() {
        return actorRepository.findAll();
    }

    // Obtener un actor por ID
    public Actor obtenerActorPorId(Long actorId) {
        return actorRepository.findById(actorId).orElse(null);
    }

    // Actualizar actor por ID
    public Actor actualizarActor(Long actorId, Actor actor) {
        Optional<Actor> actorExistente = actorRepository.findById(actorId);
        if (actorExistente.isPresent()) {
            Actor actorEncontrado = actorExistente.get();
            actorEncontrado.setNombre(actor.getNombre());
            actorEncontrado.setPapel(actor.getPapel());
            actorEncontrado.setSalario(actor.getSalario());
            return actorRepository.save(actorEncontrado);
        } else {
            return null;
        }
    }

    // Eliminar actor por ID
    public void eliminarActor(Long actorId) {
        actorRepository.deleteById(actorId);
    }

    // Obtener lista de actores por ID de obra
    public List<Actor> obtenerActoresPorObraId(Long obraId) {
        return actorRepository.findActorsByObraId(obraId);
    }
}
