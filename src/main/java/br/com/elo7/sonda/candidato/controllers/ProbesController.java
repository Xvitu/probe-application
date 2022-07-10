package br.com.elo7.sonda.candidato.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/probes")
public class ProbesController {

    /// land a probe -> pousa uma probe em um planeta, pousar pode ser entendido como "criar" uma probe?
    /// /probes/land
    /// recebe planeta, posição X, posição, Y, posição rosa dos ventos
    /// retorna o objeto probe ou probe id
    /// status 200
    /// erros:
    /// já existe uma sonda no lugar, retornar 409
    /// posição de pouso fora da area do planeta, retornar 422

    /// move a prob -> Move uma prob dentro do planeta em que ela pousou
    /// /probes/{id}/move
    /// recebe commands
    /// retorna o objeto da probe
    /// erros:
    /// já existe uma sonda no lugar, retornar 409
    /// posição de pouso fora da area do planeta, retornar 422


    /// provocações de possiveis cenários de falha
    /// o que acontece quando dois comandos para probes diferentes a mesma posição são executados ao mesmo tempo? vão colidir?
    /// o que acontece quando duas probes cruzam o caminho ao mesmo tempo?
    /// identificar comandos que não fazem sentido? Por exemplo, girar sem sair do lugar
    /// comandos muito longos podem ser um problema, Testar performance
    /// considerar cenario de dois comandos ao mesmo tempo para uma mesma sonda?

}
