package graficos;

import entes.creaturas.Jugador;
import mapa.cuadro.Cuadro;

/**
 * Ensambla la imagen que se muestra en pantalla.
 */
public final class Pantalla {

    private final int ancho;
    private final int alto;
    private int diferenciaX;
    private int diferenciaY;
    public final int[] pixeles;

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public Pantalla(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[ancho * alto];
    }

    public void limpiar() { //método que nos servirá para limpiar lo que se ve en pantalla y cambiarlo por objetos nuevos
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = 0; //expresamos a todos los int el valor 0, que representa al negro
        }
    }

    /**
     * Imprime un cuadro en pantalla.
     *
     * @param compensacionX
     * @param compensacionY
     * @param cuadro
     */
    public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro) {
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;

        for (int y = 0; y < cuadro.sprite.getLado(); y++) {
            int posicionY = y + compensacionY;
            for (int x = 0; x < cuadro.sprite.getLado(); x++) {
                int posicionX = x + compensacionX;
                if (posicionX < -cuadro.sprite.getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto) { //valida que no se dibuje nada fuera de la pantalla para mejorar el rendimiento.
                    break;
                }
                if (posicionX < 0) {
                    posicionX = 0;
                }
                pixeles[posicionX + posicionY * ancho] = cuadro.sprite.pixeles[x + y * cuadro.sprite.getLado()];
            }
        }
    }

    public void mostrarJugador(int compensacionX, int compensacionY, Jugador jugador) {
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;

        for (int y = 0; y < jugador.getSprite().getLado(); y++) {
            int posicionY = y + compensacionY;
            for (int x = 0; x < jugador.getSprite().getLado(); x++) {
                int posicionX = x + compensacionX;
                if (posicionX < -jugador.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto) { //valida que no se dibuje nada fuera de la pantalla para mejorar el rendimiento.
                    break;
                }
                if (posicionX < 0) {
                    posicionX = 0;
                }
                //obtiene el pixel del jugador propiamente y evita que se ponga la parte trasera
                if(jugador.getSprite().pixeles[x+y*jugador.getSprite().getLado()] != 0xff00d00a){
                    pixeles[posicionX+posicionY*ancho] = jugador.getSprite().pixeles[x+y*jugador.getSprite().getLado()];
                }
//                pixeles[posicionX + posicionY * ancho] = jugador.getSprite().pixeles[x + y * jugador.getSprite().getLado()];
            }
        }
    }

    public void setDiferencia(final int DiferenciaX, final int DiferenciaY) {
        this.diferenciaX = DiferenciaX;
        this.diferenciaY = DiferenciaY;
    }
}
