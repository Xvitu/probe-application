package br.com.elo7.sonda.candidato.domain;

public enum CardinalPoints {
    NORTH("N"), SOUTH("S"), WEST("W"), EAST("E");

    private final String command;

    CardinalPoints(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }
}
