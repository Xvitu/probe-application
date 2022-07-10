package br.com.elo7.sonda.candidato.usecases;

import br.com.elo7.sonda.candidato.domain.Command;
import br.com.elo7.sonda.candidato.domain.entities.PlanetEntity;
import br.com.elo7.sonda.candidato.domain.entities.ProbeEntity;
import br.com.elo7.sonda.candidato.infrastructure.repositories.PlanetsRepository;
import br.com.elo7.sonda.candidato.infrastructure.repositories.ProbesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MoveProbeUseCase {

    @Autowired
    private ProbesRepository probesRepository;
    
    @Autowired
    private PlanetsRepository planetsRepository;
    
    public ProbeEntity execute(MoveProbeDTO moveProbeDTO) {

        Optional<ProbeEntity> probe = this.probesRepository.findById(moveProbeDTO.getProbeId()); 
        
        if (probe.isEmpty()) {
            throw new RuntimeException("Probe not found");
        }

        PlanetEntity planet = this.planetsRepository.getById(probe.get().getPlanetId());

        for (char command: moveProbeDTO.getCommands()) {
            switch (command) {
                case Command.LEFT -> probe.get().turnLeft();
                case Command.MOVE_FORWARD -> probe.get().moveForward(planet.getWidth(), planet.getHeight());
                case Command.RIGHT -> probe.get().turnRight();
            }
        }

        probesRepository.save(probe.get());

        return probe.get();
    }
}
