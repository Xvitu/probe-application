package br.com.elo7.sonda.candidato.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.elo7.sonda.candidato.domain.entities.PlanetEntity;
import br.com.elo7.sonda.candidato.domain.entities.ProbeEntity;
import br.com.elo7.sonda.candidato.infrastructure.repositories.PlanetsRepository;
import br.com.elo7.sonda.candidato.infrastructure.repositories.ProbesRepository;
import br.com.elo7.sonda.candidato.usecases.MoveProbeDTO;
import br.com.elo7.sonda.candidato.usecases.MoveProbeUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class ProbeServiceTest {
	
	@Autowired
	private MoveProbeUseCase subject;

	@Autowired
	private PlanetsRepository planetsRepository;

	@Autowired
	private ProbesRepository probesRepository;
	
	@Test
	@Transactional
	public void should_change_probe_direction_from_N_To_W_when_receive_the_command_L() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'N', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "L".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(1, returnedProbe.getX());
		assertEquals(1, returnedProbe.getY());
		assertEquals('W', returnedProbe.getDirection());
	}
	
	@Test
	@Transactional
	public void should_change_probe_direction_from_W_To_S_when_receive_the_command_L() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'W', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "L".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(1, returnedProbe.getX());
		assertEquals(1, returnedProbe.getY());
		assertEquals('S', returnedProbe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_S_To_E_when_receive_the_command_L() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'S', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "L".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(1, returnedProbe.getX());
		assertEquals(1, returnedProbe.getY());
		assertEquals('E', returnedProbe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_E_To_N_when_receive_the_command_L() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'E', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "L".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(1, returnedProbe.getX());
		assertEquals(1, returnedProbe.getY());
		assertEquals('N', returnedProbe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_N_To_E_when_receive_the_command_R() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'N', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "R".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(1, returnedProbe.getX());
		assertEquals(1, returnedProbe.getY());
		assertEquals('E', returnedProbe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_E_To_S_when_receive_the_command_R() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'E', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "R".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(1, returnedProbe.getX());
		assertEquals(1, returnedProbe.getY());
		assertEquals('S', returnedProbe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_S_To_W_when_receive_the_command_R() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'S', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "R".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(1, returnedProbe.getX());
		assertEquals(1, returnedProbe.getY());
		assertEquals('W', returnedProbe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_W_To_N_when_receive_the_command_R() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'W', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "R".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(1, returnedProbe.getX());
		assertEquals(1, returnedProbe.getY());
		assertEquals('N', returnedProbe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_position_from_1_1_N_To_1_2_N_when_receive_the_command_M() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'N', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "M".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(1, returnedProbe.getX());
		assertEquals(2, returnedProbe.getY());
		assertEquals('N', returnedProbe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_position_from_1_1_S_To_1_0_S_when_receive_the_command_M() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'S', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "M".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(1, returnedProbe.getX());
		assertEquals(0, returnedProbe.getY());
		assertEquals('S', returnedProbe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_position_from_1_1_W_To_0_1_W_when_receive_the_command_M() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'W', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "M".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(0, returnedProbe.getX());
		assertEquals(1, returnedProbe.getY());
		assertEquals('W', returnedProbe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_position_from_1_1_E_To_2_1_E_when_receive_the_command_M() {
		PlanetEntity planet = new PlanetEntity(5, 5);
		this.planetsRepository.save(planet);

		ProbeEntity probe = new ProbeEntity(1, 1, 'E', planet.getId());
		this.probesRepository.save(probe);

		char[] commands = "M".toCharArray();

		MoveProbeDTO moveProbeDTO = new MoveProbeDTO(probe.getId(), commands);
		ProbeEntity returnedProbe = subject.execute(moveProbeDTO);

		assertEquals(2, returnedProbe.getX());
		assertEquals(1, returnedProbe.getY());
		assertEquals('E', returnedProbe.getDirection());
	}
}
