package com.dcc604.medclinica.servicos.atendente;

import com.dcc604.medclinica.dtos.CriarAtendenteDTO;
import com.dcc604.medclinica.excecoes.ExcecaoBase;
import com.dcc604.medclinica.modelos.Atendente;
import com.dcc604.medclinica.repositorios.AtendenteRepositorio;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CriarAtendenteServicoTest {
    @Mock
    private AtendenteRepositorio repositorio;

    @InjectMocks
    private CriarAtendenteServico criarAtendenteServico;

    private static final CriarAtendenteDTO atendenteDTO;

    private static final Atendente atendente;

    static {
        atendenteDTO = CriarAtendenteDTO.builder()
            .cpf("12345678900")
            .carteiraDeTrabalho(123456)
            .build();

        atendente = Atendente.builder().build();
    }

    @BeforeEach
    void init() {
        criarAtendenteServico = new CriarAtendenteServico(repositorio);
    }

    @Test
    void criaAtendente() {
        Atendente atendente = new Atendente();
        atendente.setCpf("12345678900");
        atendente.setCarteiraDeTrabalho(123456);
        Atendente result = criarAtendenteServico.execute(atendenteDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(atendente.getCpf(), result.getCpf());
    }

    @Test
    void naoCriaAtendente_Atendente_JaExistente_CPF() {
        when(repositorio.findByCpf(atendenteDTO.getCpf())).thenReturn(Optional.of(atendente));

        Assert.assertThrows(ExcecaoBase.class, () -> criarAtendenteServico.execute(atendenteDTO));
        verify(repositorio, never()).save(any(Atendente.class));
    }

    @Test
    void naoCriaAtendente_Atendente_JaExistente_CT() {
        when(repositorio.findByCarteiraDeTrabalho(atendenteDTO.getCarteiraDeTrabalho())).thenReturn(Optional.of(atendente));

        Assert.assertThrows(ExcecaoBase.class, () -> criarAtendenteServico.execute(atendenteDTO));
        verify(repositorio, never()).save(any(Atendente.class));
    }
}
