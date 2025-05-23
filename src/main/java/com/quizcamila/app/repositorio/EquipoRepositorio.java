package com.quizcamila.app.repositorio;

import com.quizcamila.app.entidades.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepositorio extends JpaRepository<Equipo, Long> {
}