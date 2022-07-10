package br.com.elo7.sonda.candidato.infrastructure.repositories;

import br.com.elo7.sonda.candidato.domain.entities.ProbeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProbesRepository extends JpaRepository<ProbeEntity, UUID> { }
