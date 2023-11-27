package com.cursojava.obrateatro.controler;

import com.cursojava.obrateatro.model.Actor;
import com.cursojava.obrateatro.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actores")
public class ActorController {

    @Autowired
    private ActorService actorService;

    // Crear actor
    @PostMapping
    public ResponseEntity<Actor> crearActor(@RequestBody Actor actor) {
        Actor nuevoActor = actorService.crearActor(actor);
        return new ResponseEntity<>(nuevoActor, HttpStatus.CREATED);
    }

    // Crear varios actores
    @PostMapping("/varios")
    public ResponseEntity<List<Actor>> crearVariosActores(@RequestBody List<Actor> actores) {
        List<Actor> nuevosActores = actorService.crearVariosActores(actores);
        return new ResponseEntity<>(nuevosActores, HttpStatus.CREATED);
    }


    // Obtener todos los actores
    @GetMapping
    public ResponseEntity<List<Actor>> obtenerTodosLosActores() {
        List<Actor> actores = actorService.obtenerTodosLosActores();
        return new ResponseEntity<>(actores, HttpStatus.OK);
    }

    // Obtener un actor por ID
    @GetMapping("/{actorId}")
    public ResponseEntity<Actor> obtenerActorPorId(@PathVariable Long actorId) {
        Actor actor = actorService.obtenerActorPorId(actorId);
        if (actor != null) {
            return new ResponseEntity<>(actor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar actor por ID
    @PutMapping("/{actorId}")
    public ResponseEntity<Actor> actualizarActor(@PathVariable Long actorId, @RequestBody Actor actor) {
        Actor actorActualizado = actorService.actualizarActor(actorId, actor);
        if (actorActualizado != null) {
            return new ResponseEntity<>(actorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar actor por ID
    @DeleteMapping("/{actorId}")
    public ResponseEntity<Void> eliminarActor(@PathVariable Long actorId) {
        actorService.eliminarActor(actorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
