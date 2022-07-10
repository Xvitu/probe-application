package br.com.elo7.sonda.candidato.usecases;

import java.util.UUID;

public class MoveProbeDTO {

    private final UUID probeId;

    private final char[] commands;

    public MoveProbeDTO (UUID probeId, char[] commands) {
        this.commands = commands;
        this.probeId = probeId;
    }

    public char[] getCommands() {
        return commands;
    }

    public UUID getProbeId() {
        return probeId;
    }
}
