package br.com.elo7.sonda.candidato.usecases;

import br.com.elo7.sonda.candidato.domain.entities.PlanetEntity;
import br.com.elo7.sonda.candidato.domain.entities.ProbeEntity;
import br.com.elo7.sonda.candidato.infrastructure.repositories.PlanetsRepository;
import br.com.elo7.sonda.candidato.usecases.exceptions.InvalidDirectionException;
import br.com.elo7.sonda.candidato.usecases.exceptions.OutOfPlanetBounderiesException;
import br.com.elo7.sonda.candidato.usecases.exceptions.PlanetNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.UUID;

@SpringBootTest
public class LandProbeUseCaseTest {

    @Autowired
    private LandProbeUseCase landProbeUseCase;

    @Autowired
    private PlanetsRepository planetsRepository;

    @Test
    public void should_land_probe_in_3_3_N() {
        PlanetEntity planet = new PlanetEntity(5, 5);
        this.planetsRepository.save(planet);

        LandProbeDTO dto = new LandProbeDTO();
        dto.setPlanetId(planet.getId());

        LandProbeDTO.Position position = new LandProbeDTO.Position();
        position.setDirection('N');
        position.setX(3);
        position.setY(3);

        dto.setPosition(position);

        ProbeEntity landedProbe = landProbeUseCase.land(dto);

        Assertions.assertEquals(3, landedProbe.getY());
        Assertions.assertEquals(3, landedProbe.getX());
        Assertions.assertEquals('N', landedProbe.getDirection());
    }

    @Test
    public void should_throw_exception_when_try_to_land_a_probe_in_no_existing_planet() {
        LandProbeDTO dto = new LandProbeDTO();
        dto.setPlanetId(UUID.randomUUID());

        LandProbeDTO.Position position = new LandProbeDTO.Position();
        position.setDirection('N');
        position.setX(1);
        position.setY(1);

        dto.setPosition(position);

        Assertions.assertThrows(PlanetNotFoundException.class, () -> landProbeUseCase.land(dto));
    }

    @Test
    @Transactional
    public void should_throw_exception_when_try_to_land_out_of_planet_bounderies() {
        PlanetEntity planet = new PlanetEntity(1, 1);
        this.planetsRepository.save(planet);

        LandProbeDTO dto = new LandProbeDTO();
        dto.setPlanetId(planet.getId());

        LandProbeDTO.Position position = new LandProbeDTO.Position();
        position.setDirection('N');
        position.setX(100);
        position.setY(100);

        dto.setPosition(position);

        Assertions.assertThrows(OutOfPlanetBounderiesException.class, () -> landProbeUseCase.land(dto));
    }

    @Test
    public void should_throw_exception_when_try_to_land_pointing_to_invalid_direction() {
        PlanetEntity planet = new PlanetEntity(1, 1);
        this.planetsRepository.save(planet);

        LandProbeDTO dto = new LandProbeDTO();
        dto.setPlanetId(planet.getId());

        LandProbeDTO.Position position = new LandProbeDTO.Position();
        position.setDirection('X');
        position.setX(0);
        position.setY(0);

        dto.setPosition(position);

        Assertions.assertThrows(InvalidDirectionException.class, () -> landProbeUseCase.land(dto));
    }

}
