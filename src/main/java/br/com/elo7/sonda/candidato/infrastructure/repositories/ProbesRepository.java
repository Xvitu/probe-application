package br.com.elo7.sonda.candidato.infrastructure.repositories;

import br.com.elo7.sonda.candidato.infrastructure.entities.ProbeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProbesRepository extends JpaRepository<ProbeEntity, UUID> {
}
