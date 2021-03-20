package com.dcc604.clinica.repositorios;

import com.dcc604.clinica.modelos.Atendente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendenteRepositorio extends JpaRepository<Atendente, Integer> {
    Optional<Atendente> findByCpf(String cpf);
    Optional<Atendente> findByCarteiraDeTrabalho(Integer carteiraDeTrabalho);
}
