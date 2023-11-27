package com.cursojava.obrateatro.repository;

import com.cursojava.obrateatro.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Long> {
}
