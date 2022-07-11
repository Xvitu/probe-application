package br.com.elo7.sonda.candidato.usecases;

import br.com.elo7.sonda.candidato.domain.entities.PlanetEntity;
import br.com.elo7.sonda.candidato.domain.entities.ProbeEntity;
import br.com.elo7.sonda.candidato.infrastructure.repositories.PlanetsRepository;
import br.com.elo7.sonda.candidato.infrastructure.repositories.ProbesRepository;
import br.com.elo7.sonda.candidato.usecases.exceptions.ProbeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.UUID;

@SpringBootTest
public class MoveProbeUseCaseTest {
    @Autowired
    private MoveProbeUseCase moveProbeUseCase;

    @Autowired
    private PlanetsRepository planetsRepository;

    @Autowired
    private ProbesRepository probesRepository;

    @Test
    @Transactional
    public void shoudld_move_the_probe_when_receive_commands() {
        PlanetEntity planet = new PlanetEntity(1, 1);
        planetsRepository.save(planet);

        ProbeEntity probe = new ProbeEntity(1, 0, 'N', planet.getId());
        probesRepository.save(probe);

        MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), "LMRM".toCharArray());

        ProbeEntity movedProbe = moveProbeUseCase.execute(moveProbeDTO);

        Assertions.assertEquals(0, movedProbe.getX());
        Assertions.assertEquals(1, movedProbe.getY());
        Assertions.assertEquals('N', movedProbe.getDirection());
    }

    @Test
    public void should_throw_exception_when_not_found_the_probe() {
        MoveProbeDTO moveProbeDTO = new MoveProbeDTO(UUID.randomUUID(), "LLL".toCharArray());

        Assertions.assertThrows(ProbeNotFoundException.class, () -> moveProbeUseCase.execute(moveProbeDTO));
    }
}
