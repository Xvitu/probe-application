package br.com.elo7.sonda.candidato.infrastructure.entities;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

public class ProbeEntity {

    private ProbeEntity () {}

    public ProbeEntity(int x, int y, char position, UUID planetId) {
        this.x = x;
        this.y = y;
        this.planetId = planetId;
        this.position = position;
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

    @Column(name = "position", nullable = false)
    private char position;

    public char getPosition() { return position; }

    public int getX() { return x; }

    public int getY() { return y; }

    public UUID getId() { return id; }

    public UUID getPlanetId() { return planetId; }
}
