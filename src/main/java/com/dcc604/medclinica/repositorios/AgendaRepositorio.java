package com.dcc604.medclinica.repositorios;

import com.dcc604.medclinica.modelos.Agenda;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepositorio extends JpaRepository<Agenda, Integer> {
    Optional<Agenda> findByMedicoId(Integer id);
}
