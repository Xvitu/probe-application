package br.com.elo7.sonda.candidato.usecases;

import java.util.UUID;

public class LandProbeDTO {
    private LandProbeDTO.Position position;
    private UUID planetId;

    public LandProbeDTO.Position getPosition() { return position; }

    public UUID getPlanetId() { return planetId; }

    public static class Position {
        private char direction;
        private int x;
        private int y;

        public int getY() { return y; }

        public int getX() { return x; }

        public char getDirection() { return direction; }
    }
}
