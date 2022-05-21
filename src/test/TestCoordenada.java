package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;

class TestCoordenada {

	@Test
	void testCoor() {
		Coordenada coor = new Coordenada();
		assertEquals(coor, true);
	}

}
