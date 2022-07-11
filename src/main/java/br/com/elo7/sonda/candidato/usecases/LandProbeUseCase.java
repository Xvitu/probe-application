package br.com.elo7.sonda.candidato.usecases;

import br.com.elo7.sonda.candidato.domain.Direction;
import br.com.elo7.sonda.candidato.domain.entities.PlanetEntity;
import br.com.elo7.sonda.candidato.domain.entities.ProbeEntity;
import br.com.elo7.sonda.candidato.infrastructure.repositories.PlanetsRepository;
import br.com.elo7.sonda.candidato.infrastructure.repositories.ProbesRepository;
import br.com.elo7.sonda.candidato.usecases.exceptions.InvalidDirectionException;
import br.com.elo7.sonda.candidato.usecases.exceptions.OutOfPlanetBounderiesException;
import br.com.elo7.sonda.candidato.usecases.exceptions.PlanetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LandProbeUseCase {
    @Autowired
    private ProbesRepository probesRepository;

    @Autowired
    private PlanetsRepository planetsRepository;

    public ProbeEntity land(LandProbeDTO landProbeDTO) {

        Optional<PlanetEntity> planet = this.planetsRepository.findById(landProbeDTO.getPlanetId());

        if (planet.isEmpty()) { throw new PlanetNotFoundException("Planet not found"); }

        LandProbeDTO.Position landPosition = landProbeDTO.getPosition();

        if (
            landPosition.getX() < 0
            || landPosition.getY() < 0
            || landPosition.getY() > planet.get().getHeight()
            || landPosition.getX() > planet.get().getWidth()
        ) {
            throw new OutOfPlanetBounderiesException("This position is out of planet bounderies");
        }

        if (!Direction.isAValidDirection(landPosition.getDirection())) {
            throw new InvalidDirectionException("This is not a valid direction");
        }

        ProbeEntity probe = new ProbeEntity(
            landPosition.getX(), landPosition.getY(), landPosition.getDirection(), landProbeDTO.getPlanetId()
        );

        probesRepository.save(probe);

        return probe;
    }

}
