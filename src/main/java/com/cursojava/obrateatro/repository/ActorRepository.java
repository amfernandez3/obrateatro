package com.cursojava.obrateatro.repository;

import com.cursojava.obrateatro.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    /**
     * Este método permite la busqueda de todos los actores que participan en una pelicula
     * @param obraId
     * @return
     */
    @Query("SELECT a FROM Actor a WHERE a.obra_id = :obraId")
    List<Actor> findActorsByObraId(@Param("obraId") Long obraId);

}
