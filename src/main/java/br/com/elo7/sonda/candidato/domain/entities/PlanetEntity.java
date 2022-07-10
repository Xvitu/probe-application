package br.com.elo7.sonda.candidato.domain.entities;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "planets")
public class PlanetEntity {

    private PlanetEntity () {}

    public PlanetEntity(int width, int height) {
        this.height = height;
        this.width = width;
    }

    @Id
    @Column(name = "id", nullable = false)
    @Type(type="org.hibernate.type.UUIDCharType")
    private final UUID id = UUID.randomUUID();

    @Column(name = "width", nullable = false)
    private int width;

    @Column(name = "height", nullable = false)
    private int height;

    public UUID getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
