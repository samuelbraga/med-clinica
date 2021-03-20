package com.dcc604.clinica.repositorios;

import com.dcc604.clinica.modelos.Medico;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepositorio extends JpaRepository<Medico, Integer> {
    Optional<Medico> findByCpf(String cpf);
    Optional<Medico> findByCarteiraDeTrabalho(Integer carteiraDeTrabalho);
}
