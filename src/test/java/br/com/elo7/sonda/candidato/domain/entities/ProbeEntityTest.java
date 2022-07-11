package br.com.elo7.sonda.candidato.domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.UUID;

public class ProbeEntityTest {
	
	@Test
	public void should_change_probe_direction_from_N_To_W_when_turnLeft() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'N', UUID.randomUUID());

		probe.turnLeft();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('W', probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_W_To_S_when_turnLeft() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'W', UUID.randomUUID());

		probe.turnLeft();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('S', probe.getDirection());
	}

	@Test
	public void should_change_probe_direction_from_S_To_E_when_turnLeft() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'S', UUID.randomUUID());

		probe.turnLeft();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('E', probe.getDirection());
	}

	@Test
	public void should_change_probe_direction_from_E_To_N_when_turnLeft() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'E', UUID.randomUUID());

		probe.turnLeft();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('N', probe.getDirection());
	}

	@Test
	public void should_change_probe_direction_from_N_To_E_when_turnRight() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'N', UUID.randomUUID());

		probe.turnRight();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('E', probe.getDirection());
	}

	@Test
	public void should_change_probe_direction_from_E_To_S_when_turnRight() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'E', UUID.randomUUID());

		probe.turnRight();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('S', probe.getDirection());
	}

	@Test
	public void should_change_probe_direction_from_S_To_W_when_turnRight() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'S', UUID.randomUUID());

		probe.turnRight();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('W', probe.getDirection());
	}

	@Test
	public void should_change_probe_direction_from_W_To_N_when_turnRight() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'W', UUID.randomUUID());

		probe.turnRight();

		assertEquals(1, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('N', probe.getDirection());
	}

	@Test
	public void should_change_probe_position_from_1_1_N_To_1_2_N_when_moveForward() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'N', UUID.randomUUID());

		probe.moveForward(5, 5);

		assertEquals(1, probe.getX());
		assertEquals(2, probe.getY());
		assertEquals('N', probe.getDirection());
	}

	@Test
	public void should_change_probe_position_from_1_1_S_To_1_0_S_when_moveForward() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'S', UUID.randomUUID());

		probe.moveForward(5, 5);

		assertEquals(1, probe.getX());
		assertEquals(0, probe.getY());
		assertEquals('S', probe.getDirection());
	}

	@Test
	public void should_change_probe_position_from_1_1_W_To_0_1_W_when_moveForward() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'W', UUID.randomUUID());

		probe.moveForward(5, 5);

		assertEquals(0, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('W', probe.getDirection());
	}

	@Test
	public void should_change_probe_position_from_1_1_E_To_2_1_E_when_moveForward() {
		ProbeEntity probe = new ProbeEntity(1, 1, 'E', UUID.randomUUID());

		probe.moveForward(5, 5);

		assertEquals(2, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('E', probe.getDirection());
	}
}
