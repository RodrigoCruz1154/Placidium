package graficos;

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
                if(posicionX < 0){
                    posicionX = 0;
                }
                pixeles[posicionX+posicionY*ancho] = cuadro.sprite.pixeles[x+y*cuadro.sprite.getLado()];
            }
        }
    }
    
    public void setDiferencia(final int DiferenciaX, final int DiferenciaY){
        this.diferenciaX = DiferenciaX;
        this.diferenciaY = DiferenciaY;
    }
}
