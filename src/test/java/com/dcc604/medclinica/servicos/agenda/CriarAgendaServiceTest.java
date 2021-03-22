package com.dcc604.medclinica.servicos.agenda;

import static org.mockito.Mockito.*;

import com.dcc604.medclinica.dtos.CriarAgendaDTO;
import com.dcc604.medclinica.excecoes.ExcecaoBase;
import com.dcc604.medclinica.modelos.Agenda;
import com.dcc604.medclinica.modelos.Medico;
import com.dcc604.medclinica.repositorios.AgendaRepositorio;
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
class CriarAgendaServiceTest {
    @Mock
    private AgendaRepositorio repositorio;

    @Mock
    private MedicoRepositorio medicoRepositorio;

    @InjectMocks
    private CriarAgendaService criarAgendaService;

    private static CriarAgendaDTO criarAgendaDTO;

    static {
        criarAgendaDTO = CriarAgendaDTO.builder().medicoId(1).build();
    }

    @BeforeEach
    void init() {
        this.criarAgendaService = new CriarAgendaService(repositorio, medicoRepositorio);
    }

    @Test
    void criaAgenda() {
        Medico medico = Medico.builder().crm(123).build();

        when(medicoRepositorio.findById(criarAgendaDTO.getMedicoId())).thenReturn(Optional.of(medico));

        Agenda result = this.criarAgendaService.execute(criarAgendaDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(medico, result.getMedico());
    }

    @Test
    void naoCriaAgenda_JaExistente() {
        Agenda agenda = new Agenda();

        when(repositorio.findByMedicoId(criarAgendaDTO.getMedicoId())).thenReturn(Optional.of(agenda));

        Assert.assertThrows(ExcecaoBase.class, () -> criarAgendaService.execute(criarAgendaDTO));
        verify(repositorio, never()).save(any(Agenda.class));
    }

    @Test
    void naoCriaAgenda_ComMedico_NaoExistente() {
        Assert.assertThrows(ExcecaoBase.class, () -> criarAgendaService.execute(criarAgendaDTO));
        verify(repositorio, never()).save(any(Agenda.class));
    }
}
