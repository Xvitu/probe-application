package br.com.elo7.sonda.candidato.domain;

public enum CardinalPoints {
    NORTH('N'), SOUTH('S'), WEST('W'), EAST('E');

    private final char direction;

    CardinalPoints(char command) {
        this.direction = command;
    }

    public char toChar() {
        return direction;
    }

    public static CardinalPoints valueOfLabel(char label) {
        for (CardinalPoints direction : values()) {
            if (direction.toChar() == label) {
                return direction;
            }
        }
        return null;
    }
}
