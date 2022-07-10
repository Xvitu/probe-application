package br.com.elo7.sonda.candidato.domain;

import java.util.ArrayList;
import java.util.Set;

public class Direction {
    public static final char NORTH = 'N';
	public static final char WEST = 'W';
	public static final char EAST = 'E';
	public static final char SOUTH = 'S';

	public static boolean isAValidDirection(char direction) {
		Set<Character> directions = Set.of(NORTH, WEST, EAST, SOUTH);
		return directions.contains(direction);
	}
}
