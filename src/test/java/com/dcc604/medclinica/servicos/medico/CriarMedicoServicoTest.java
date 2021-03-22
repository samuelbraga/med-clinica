package com.dcc604.medclinica.servicos.medico;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

import com.dcc604.medclinica.dtos.CriarMedicoDTO;
import com.dcc604.medclinica.excecoes.ExcecaoBase;
import com.dcc604.medclinica.modelos.Medico;
import com.dcc604.medclinica.repositorios.MedicoRepositorio;
import java.util.Optional;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CriarMedicoServicoTest {
    @Mock
    private MedicoRepositorio repositorio;

    @InjectMocks
    private CriarMedicoServico criarMedicoServico;

    private static final CriarMedicoDTO medicoDto;

    private static final Medico medico;

    static {
        medicoDto = CriarMedicoDTO.builder().cpf("12345678900").carteiraDeTrabalho(123456).build();

        medico = Medico.builder().build();
    }

    @BeforeEach
    void init() {
        criarMedicoServico = new CriarMedicoServico(repositorio);
    }

    @Test
    void criaAtendente() {
        Medico medico = new Medico();
        medico.setCpf("12345678900");
        medico.setCarteiraDeTrabalho(123456);
        Medico result = criarMedicoServico.execute(medicoDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(medico.getCpf(), result.getCpf());
    }

    @Test
    void naoCriaAtendente_Atendente_JaExistente_CPF() {
        when(repositorio.findByCpf(medicoDto.getCpf())).thenReturn(Optional.of(medico));

        Assert.assertThrows(ExcecaoBase.class, () -> criarMedicoServico.execute(medicoDto));
        verify(repositorio, never()).save(any(Medico.class));
    }

    @Test
    void naoCriaAtendente_Atendente_JaExistente_CT() {
        when(repositorio.findByCarteiraDeTrabalho(medicoDto.getCarteiraDeTrabalho())).thenReturn(Optional.of(medico));

        Assert.assertThrows(ExcecaoBase.class, () -> criarMedicoServico.execute(medicoDto));
        verify(repositorio, never()).save(any(Medico.class));
    }
}
