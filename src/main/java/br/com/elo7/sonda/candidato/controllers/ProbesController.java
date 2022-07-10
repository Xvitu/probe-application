package br.com.elo7.sonda.candidato.controllers;

import br.com.elo7.sonda.candidato.domain.entities.ProbeEntity;
import br.com.elo7.sonda.candidato.usecases.LandProbeDTO;
import br.com.elo7.sonda.candidato.usecases.LandProbeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/probes")
public class ProbesController {

    @Autowired
    private LandProbeUseCase landProbeUseCase;

    // TODO() - handle de erros para http
    @PostMapping("/land")
    public ResponseEntity<ProbeEntity> land(@RequestBody LandProbeDTO request) {
        return ResponseEntity.ok(landProbeUseCase.land(request));
    }


    /// provocações de possiveis cenários de falha
    /// o que acontece quando dois comandos para probes diferentes a mesma posição são executados ao mesmo tempo? vão colidir?
    /// o que acontece quando duas probes cruzam o caminho ao mesmo tempo?
    /// identificar comandos que não fazem sentido? Por exemplo, girar sem sair do lugar
    /// comandos muito longos podem ser um problema, Testar performance
    /// considerar cenario de dois comandos ao mesmo tempo para uma mesma sonda?

}
