package com.cursojava.obrateatro.controler;

import com.cursojava.obrateatro.model.Actor;
import com.cursojava.obrateatro.model.Obra;
import com.cursojava.obrateatro.service.ActorService;
import com.cursojava.obrateatro.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {

    @Autowired
    private ObraService obraService;
    @Autowired
    private ActorService actorService;

    /**
     * localhost:8080/obras
     */
    // Crear obra
    @PostMapping
    public ResponseEntity<Obra> crearObra(@RequestBody Obra obra) {
        Obra nuevaObra = obraService.crearObra(obra);
        return new ResponseEntity<>(nuevaObra, HttpStatus.CREATED);
    }

    /**
     * localhost:8080/obras
     */
    // Obtener todas las obras
    @GetMapping
    public ResponseEntity<List<Obra>> obtenerTodasLasObras() {
        List<Obra> obras = obraService.obtenerTodasLasObras();
        return new ResponseEntity<>(obras, HttpStatus.OK);
    }

    /**
     * localhost:8080/obras/{id}
     */
    // Obtener una obra por ID
    @GetMapping("/{obraId}")
    public ResponseEntity<Obra> obtenerObraPorId(@PathVariable Long obraId) {
        Obra obra = obraService.obtenerObraPorId(obraId);
        if (obra != null) {
            return new ResponseEntity<>(obra, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * localhost:8080/obras/{id}
     */
    // Actualizar obra por ID
    @PutMapping("/{obraId}")
    public ResponseEntity<Obra> actualizarObra(@PathVariable Long obraId, @RequestBody Obra obra) {
        Obra obraActualizada = obraService.actualizarObra(obraId, obra);
        if (obraActualizada != null) {
            return new ResponseEntity<>(obraActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar obra por ID
    /**
     * localhost:8080/obras/{id}
     */
    @DeleteMapping("/{obraId}")
    public ResponseEntity<Void> eliminarObra(@PathVariable Long obraId) {
        obraService.eliminarObra(obraId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint para obtener un actor específico de una obra por índice

    /**
     * localhost:8080/obras/{1}/actores/{1}
     */
    @GetMapping("/{obraId}/actores/{indice}")
    public ResponseEntity<?> obtenerActorPorIndiceEnObra(@PathVariable Long obraId, @PathVariable int indice) {
        // Obtener la lista de actores por ID de obra
        List<Actor> actoresEnObra = actorService.obtenerActoresPorObraId(obraId);

        // Verificar si la lista de actores es válida y si el índice es válido
        if (actoresEnObra != null && indice >= 0 && indice < actoresEnObra.size()) {
            Actor actor = actoresEnObra.get(indice);
            return new ResponseEntity<>(actor, HttpStatus.OK);
        } else {
            String mensajeError = "No se pudo encontrar el actor en la obra con ID: " + obraId + " y el índice: " + indice;
            return new ResponseEntity<>(mensajeError, HttpStatus.NOT_FOUND);
        }
    }



}
