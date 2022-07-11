package br.com.elo7.sonda.candidato.usecases;

import java.util.UUID;

public class LandProbeDTO {
    private LandProbeDTO.Position position;
    private UUID planetId;

    public LandProbeDTO.Position getPosition() { return position; }

    public UUID getPlanetId() { return planetId; }

    public void setPlanetId(UUID planetId) { this.planetId = planetId; }

    public void setPosition(Position position) { this.position = position; }

    public static class Position {
        private char direction;
        private int x;
        private int y;

        public int getY() { return y; }

        public int getX() { return x; }

        public char getDirection() { return direction; }

        public void setDirection(char direction) { this.direction = direction; }

        public void setX(int x) { this.x = x; }

        public void setY(int y) { this.y = y; }
    }
}
