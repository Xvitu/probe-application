package br.com.elo7.sonda.candidato.domain;

public enum Command {
    LEFT("L"), RIGHT("R"), MOVE_FORWARD("M");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }
}
