// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ahorcado;

/************************************************************/
/**
 * La clase Frase se ocupará de almacenar diferentes frases para el juego,
 * contendrá distintos métodos que ayudarán al proceso y se ocuparán de
 * seleccionar la frase de forma aleatoria.
 * 
 */
public class Palabra {
	private static final int NUM_LETRAS_ABECEDARIO = 27;
	/**
	 * Palabra que ha sido escogida para adivinar.
	 * 
	 */
	private String palabraOculta;
	/**
	 * Son las letras que el jugador ha dicho pero no estaban en la palabra.
	 */
	private char[] letrasFallidas = new char[NUM_LETRAS_ABECEDARIO];
	/**
	 * Son las letras que ha dicho el jugador y estaban en la palabra.
	 */
	private char[] letrasDescubiertas = new char[NUM_LETRAS_ABECEDARIO];

	/**
	 * Devuelve una frase aleatoria sacada del array frases.
	 */
	public String elegirPalabra() {
		String[] palabras = { "Jirafa", "Perro", "Gato", "Gallo", "Elefante", "Rata", "Tortuga" };
		String elegida = palabras[(int) (Math.random() * (palabras.length - 1))];

		return elegida;

	}

	/**
	 * Comprueba si la letra ya ha sido usada.
	 */
	public boolean comprobarLetraUsada(char letra) {
		for (int i = 0; i < letrasDescubiertas.length; i++) {
			if (letra == letrasDescubiertas[i]) {
				return true;
			}
		}
		for (int i = 0; i < letrasFallidas.length; i++) {
			if (letra == letrasFallidas[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Comprueba si existe la letra en la palabra oculta (no comprueba si la
	 * letra ha sido usada) y almacena como acertada o fallida.
	 * 
	 * @param letra
	 *            Letra a comprobar si existe o no en la palabra a adivinar
	 * @return estaba Devuelve true si la letra está al menos una vez en la
	 *         palabra oculta y false en caso contrario
	 * 
	 */
	public boolean comprobarLetra(char letra) {
		boolean usada = comprobarLetraUsada(letra);
		if (palabraOculta.indexOf(letra) == -1) {
			insertarLetra(letra, letrasFallidas);
			return false;
		} else {
			insertarLetra(letra, letrasDescubiertas);
			return true;
		}
	}

	private void insertarLetra(char letra, char[] destino) {
		// Inserta la letra en la primera posición vacía.
		for (int i = 0; i < destino.length; i++) {
			if (destino[i] == '\u0000') {
				destino[i] = letra;
				break;
			}
		}
	}

	/**
	 * Muestra el reusltado de la palabra, con sus letras adivinadas y el
	 * diseño.
	 */
	public void mostrarResultados() {
	}

	/**
	 * 
	 * @return ganado
	 */
	public boolean comprobarSiGanador() {
		boolean estanTodas = true;
		char[] descompueta = palabraOculta.toCharArray();

		for (int i = 0; i < descompueta.length; i++) {
			boolean estaEnDescubiertas = false;
			for (int j = 0; j < letrasDescubiertas.length; j++) {
				if (descompueta[i] == letrasDescubiertas[j]) {
					estaEnDescubiertas = true;
					break;

				}
			}
			if (!estaEnDescubiertas) {
				estanTodas = false;;
				break;
			}
		}
		return estanTodas;
	}

	/**
	 * Comprueba si la palabra propuesta por el jugador coincide con la palabra
	 * oculta (quiero resolver).
	 * 
	 * @param palabra
	 * @return adivinada Adivinada es verdadero si la palabra coincide con la
	 *         que buscábamos.
	 */
	public boolean comprobarPalabra(String palabra) {
		return (palabraOculta.equals(palabra));

	}
};