package ahorcado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HorcaTest {
	private Horca horca;

	@Before
	public void setUp() throws Exception {
		horca = new Horca();
	}

	@Test
	public void testIncrementarFallo() {
		horca.incrementarFallo();
		assertEquals(horca.getFallos(), 1);

	}

	@Test
	public void testComprobarSiPerdido() {
		for (int i = 0; i < horca.MAX_FALLOS - 1; i++) {
			horca.incrementarFallo();
			assertFalse(horca.comprobarSiPerdido());

		}
		horca.incrementarFallo();
		assertTrue(horca.comprobarSiPerdido());
	}

}
