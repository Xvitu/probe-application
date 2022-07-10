package br.com.elo7.sonda.candidato.domain.entities;

import br.com.elo7.sonda.candidato.domain.Direction;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "probes")
public class ProbeEntity {

    private ProbeEntity () {}

    public ProbeEntity(int x, int y, char direction, UUID planetId) {
        this.x = x;
        this.y = y;
        this.planetId = planetId;
        this.direction = direction;
    }

    @Id
    @Column(name = "id", nullable = false)
    @Type(type="org.hibernate.type.UUIDCharType")
    private final UUID id = UUID.randomUUID();

    @Column(name = "x", nullable = false)
    private int x;

    @Column(name = "y", nullable = false)
    private int y;

    @Column(name = "planetId", nullable = false)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID planetId;

    @Column(name = "direction", nullable = false)
    private char direction;

    public char getDirection() { return direction; }

    public int getX() { return x; }

    public int getY() { return y; }

    public UUID getId() { return id; }

    public UUID getPlanetId() { return planetId; }

    public void turnLeft() {
        this.direction = switch (this.direction) {
            case Direction.NORTH -> Direction.WEST;
            case Direction.WEST -> Direction.SOUTH;
            case Direction.SOUTH -> Direction.EAST;
            case Direction.EAST -> Direction.NORTH;
            default -> throw new IllegalStateException("Unexpected value: " + this.direction);
        };
    }

    public void turnRight() {
        this.direction = switch (this.direction) {
            case Direction.NORTH -> Direction.EAST;
            case Direction.EAST -> Direction.SOUTH;
            case Direction.SOUTH -> Direction.WEST;
            case Direction.WEST -> Direction.NORTH;
            default -> throw new IllegalStateException("Unexpected value: " + this.direction);
        };
    }
    public void moveForward(int maxX, int maxY) {
        int newX = this.x;
        int newY = this.y;

        switch (this.direction) {
            case Direction.NORTH -> newY = sum(this.y, maxY);
            case Direction.WEST -> newX = sub(this.x, maxX);
            case Direction.SOUTH -> newY = sub(this.y, maxY);
            case Direction.EAST -> newX = sum(this.x, maxX);
        }

        this.x = newX;
        this.y = newY;
    }
    private int sum(int actualValue, int maxValue) {
        int newValue = actualValue + 1;
        return newValue > maxValue ? 0 : newValue;
    }

    private int sub(int actualValue, int maxValue) {
        int newValue = actualValue - 1;
        return newValue < 0 ? maxValue : newValue;
    }
}
