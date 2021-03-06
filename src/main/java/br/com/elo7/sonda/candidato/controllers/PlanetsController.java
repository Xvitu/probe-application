package br.com.elo7.sonda.candidato.controllers;

import br.com.elo7.sonda.candidato.controllers.requests.CreatePlanetRequest;
import br.com.elo7.sonda.candidato.domain.entities.PlanetEntity;
import br.com.elo7.sonda.candidato.infrastructure.repositories.PlanetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/planets")
public class PlanetsController {
    @Autowired
    PlanetsRepository planetsRepository;

    @PostMapping("/")
    public ResponseEntity<PlanetEntity> register(@RequestBody CreatePlanetRequest request) {
        PlanetEntity planet = new PlanetEntity(request.getWidth(), request.getHeight());
        planetsRepository.save(planet);

        return new ResponseEntity<>(planet, HttpStatus.CREATED);
    }
}
