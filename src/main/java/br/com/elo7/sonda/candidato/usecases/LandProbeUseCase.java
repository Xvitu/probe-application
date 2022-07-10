package br.com.elo7.sonda.candidato.usecases;

import br.com.elo7.sonda.candidato.domain.CardinalPoints;
import br.com.elo7.sonda.candidato.domain.entities.PlanetEntity;
import br.com.elo7.sonda.candidato.domain.entities.ProbeEntity;
import br.com.elo7.sonda.candidato.infrastructure.repositories.PlanetsRepository;
import br.com.elo7.sonda.candidato.infrastructure.repositories.ProbesRepository;
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

        if (planet.isEmpty()) { throw new RuntimeException("Planet not found"); }

        LandProbeDTO.Position landPosition = landProbeDTO.getPosition();

        if (
            landPosition.getX() < 0
            || landPosition.getY() < 0
            || landPosition.getY() > planet.get().getHeight()
            || landPosition.getX() > planet.get().getWidth()
        ) {
            throw new RuntimeException("This land is out of planet bounderies");
        }

        if (CardinalPoints.valueOfLabel(landPosition.getDirection()) == null ) {
            throw new RuntimeException("This is not a valid direction");
        }

        ProbeEntity probe = new ProbeEntity(
            landPosition.getX(), landPosition.getY(), landPosition.getDirection(), landProbeDTO.getPlanetId()
        );

        probesRepository.save(probe);

        return probe;
    }

}
