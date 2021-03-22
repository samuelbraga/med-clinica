package com.dcc604.medclinica.servicos.paciente;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.dcc604.medclinica.dtos.CriarPacienteDTO;
import com.dcc604.medclinica.excecoes.ExcecaoBase;
import com.dcc604.medclinica.modelos.Atendente;
import com.dcc604.medclinica.modelos.Paciente;
import com.dcc604.medclinica.repositorios.AtendenteRepositorio;
import com.dcc604.medclinica.repositorios.PacienteRepositorio;
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
class CriarPacienteServicoTest {
    @Mock
    private PacienteRepositorio repositorio;

    @Mock
    private AtendenteRepositorio atendenteRepositorio;

    @InjectMocks
    private CriarPacienteServico criarPacienteServico;

    private static final CriarPacienteDTO criaPacienteDto;

    private static final Paciente paciente;

    private static final Atendente atendente;

    static {
        criaPacienteDto = CriarPacienteDTO.builder().atendenteId(1).cpf("12345678900").build();
        atendente = Atendente.builder().build();
        paciente = Paciente.builder().build();
    }

    @BeforeEach
    void init() {
        criarPacienteServico = new CriarPacienteServico(repositorio, atendenteRepositorio);
    }

    @Test
    void criPaciente() {
        Paciente paciente = new Paciente();
        paciente.setCpf("12345678900");
        when(atendenteRepositorio.findById(criaPacienteDto.getAtendenteId())).thenReturn(Optional.of(atendente));

        Paciente result = criarPacienteServico.execute(criaPacienteDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(paciente.getCpf(), result.getCpf());
    }

    @Test
    void naoCriaPaciente_Paciente_JaExistente() {
        when(repositorio.findByCpf(criaPacienteDto.getCpf())).thenReturn(Optional.of(paciente));

        Assert.assertThrows(ExcecaoBase.class, () -> criarPacienteServico.execute(criaPacienteDto));
        verify(repositorio, never()).save(any(Paciente.class));
    }

    @Test
    void naoCriaPaciente_Atendente_NaoExistente() {
        Assert.assertThrows(ExcecaoBase.class, () -> criarPacienteServico.execute(criaPacienteDto));
        verify(repositorio, never()).save(any(Paciente.class));
    }
}
