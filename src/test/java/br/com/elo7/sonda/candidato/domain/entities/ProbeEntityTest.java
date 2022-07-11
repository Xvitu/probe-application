package br.com.elo7.sonda.candidato.domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.elo7.sonda.candidato.usecases.MoveProbeUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.UUID;

public class ProbeEntityTest {
	
	@Autowired
	private MoveProbeUseCase subject;

	
	@Test
	@Transactional
	public void should_change_probe_direction_from_N_To_W_when_receive_the_command_L() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'N', UUID.randomUUID());

		probe.turnLeft();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('W', probe.getDirection());
	}
	
	@Test
	@Transactional
	public void should_change_probe_direction_from_W_To_S_when_receive_the_command_L() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'W', UUID.randomUUID());

		probe.turnLeft();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('S', probe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_S_To_E_when_receive_the_command_L() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'S', UUID.randomUUID());

		probe.turnLeft();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('E', probe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_E_To_N_when_receive_the_command_L() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'E', UUID.randomUUID());

		probe.turnLeft();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('N', probe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_N_To_E_when_receive_the_command_R() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'N', UUID.randomUUID());

		probe.turnRight();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('E', probe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_E_To_S_when_receive_the_command_R() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'E', UUID.randomUUID());

		probe.turnRight();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('S', probe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_S_To_W_when_receive_the_command_R() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'S', UUID.randomUUID());

		probe.turnRight();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('W', probe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_direction_from_W_To_N_when_receive_the_command_R() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'W', UUID.randomUUID());

		probe.turnRight();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('N', probe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_position_from_1_1_N_To_1_2_N_when_receive_the_command_M() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'N', UUID.randomUUID());

		probe.moveForward(5, 5);

		assertEquals(1, probe.getX());
		assertEquals(2, probe.getY());
		assertEquals('N', probe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_position_from_1_1_S_To_1_0_S_when_receive_the_command_M() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'S', UUID.randomUUID());

		probe.moveForward(5, 5);

		assertEquals(1, probe.getX());
		assertEquals(0, probe.getY());
		assertEquals('S', probe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_position_from_1_1_W_To_0_1_W_when_receive_the_command_M() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'W', UUID.randomUUID());

		probe.moveForward(5, 5);

		assertEquals(0, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('W', probe.getDirection());
	}

	@Test
	@Transactional
	public void should_change_probe_position_from_1_1_E_To_2_1_E_when_receive_the_command_M() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'E', UUID.randomUUID());

		probe.moveForward(5, 5);

		assertEquals(2, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('E', probe.getDirection());
	}
}
