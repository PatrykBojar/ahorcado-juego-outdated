package ahorcado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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

}
