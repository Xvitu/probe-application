
CREATE TABLE planets (
    id VARCHAR(100) PRIMARY KEY,
    width INTEGER,
    height INTEGER
);

CREATE TABLE probes (
    id VARCHAR(100) PRIMARY KEY,
    x INTEGER,
    y INTEGER,
    planet_id VARCHAR(100),
    direction CHAR(1),
    CONSTRAINT fk_probes_planet
        FOREIGN KEY(planet_id)
        REFERENCES planets(id)
);
