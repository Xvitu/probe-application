package br.com.elo7.sonda.candidato.controllers;

import br.com.elo7.sonda.candidato.domain.entities.ProbeEntity;
import br.com.elo7.sonda.candidato.usecases.LandProbeDTO;
import br.com.elo7.sonda.candidato.usecases.LandProbeUseCase;
import br.com.elo7.sonda.candidato.usecases.MoveProbeDTO;
import br.com.elo7.sonda.candidato.usecases.MoveProbeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/probes")
public class ProbesController {

    @Autowired
    private LandProbeUseCase landProbeUseCase;

    @Autowired
    private MoveProbeUseCase moveProbeUseCase;

    // TODO() - handle de erros para http
    @PostMapping("/land")
    public ResponseEntity<ProbeEntity> land(@RequestBody LandProbeDTO request) {
        return ResponseEntity.ok(landProbeUseCase.land(request));
    }

    @PutMapping("/move")
    public ResponseEntity<ProbeEntity> move(@RequestBody MoveProbeDTO request) {
        return new ResponseEntity<>(moveProbeUseCase.execute(request), HttpStatus.OK);
    }
}
