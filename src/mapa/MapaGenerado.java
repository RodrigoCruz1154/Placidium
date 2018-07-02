package mapa;

import java.util.Random;

/**
 * Genera un mapa aleatorio.
 */
public class MapaGenerado extends Mapa {

    private static final Random aleatorio = new Random();
    /**
     * Se debe especificar cuántos tiles se quieren en el mapa en el parámetro.
     * @param ancho
     * @param alto 
     */
    public MapaGenerado(int ancho, int alto) {
        super(ancho, alto);
    }
    /**
     * Genera un tile aleatorio dependiendo del número que se genere gracias a la clase Random.
     */
    protected void generarMapa() {
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                cuadros[x+y*ancho] = aleatorio.nextInt(54);
            }
        }
    }
}
