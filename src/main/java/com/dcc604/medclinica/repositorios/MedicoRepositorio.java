package com.dcc604.medclinica.repositorios;

import com.dcc604.medclinica.modelos.Medico;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepositorio extends JpaRepository<Medico, Integer> {
    Optional<Medico> findByCpf(String cpf);
    Optional<Medico> findByCarteiraDeTrabalho(Integer carteiraDeTrabalho);
}
