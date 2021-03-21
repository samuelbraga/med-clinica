package com.dcc604.medclinica.repositorios;

import com.dcc604.medclinica.modelos.Paciente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByCpf(String cpf);
}
