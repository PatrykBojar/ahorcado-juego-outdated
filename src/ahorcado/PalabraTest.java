package ahorcado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunListener.ThreadSafe;

public class PalabraTest {
	private Palabra palabraOculta;

	@Before
	public void setUp() throws Exception {
		palabraOculta = new Palabra();
	}

	@Test
	public void testElegirPalabra() {
		assertNotNull(palabraOculta.elegirPalabra());
	}

	@Test
	public void testComprobarLetraUsada() {
		fail("No implementado");
	}

}
