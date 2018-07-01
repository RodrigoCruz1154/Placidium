package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

/**
 * Plantilla para crear más mapas.
 */
public abstract class Mapa {
    protected int ancho;
    protected int alto;
    protected int[] cuadros;
    
    /**
     * Genera un mapa aleatorio.
     * @param ancho
     * @param alto 
     */
    public Mapa(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        cuadros = new int[ancho*alto];
        generarMapa();
    }
    /**
     * Genera un mapa predeterminado desde una ruta indicada.
     * @param ruta 
     */
    public Mapa(String ruta){
        cargarMapa(ruta);
    }
    
    protected void cargarMapa(String ruta){     
    }
    
    protected void generarMapa(){        
    }
    
    public void actualizar(){    
    }
    /**
     * Traduce el tamaño de los tiles en píxeles.
     * @param compensacionX
     * @param compensacionY
     * @param pantalla 
     */
    public void mostrar(int compensacionX, int compensacionY, Pantalla pantalla) {
        
        pantalla.setDiferencia(compensacionX, compensacionY);
        
        int norte = compensacionY >> 5, sur = (compensacionY + pantalla.getAlto()) >> 5, este = (compensacionX + pantalla.getAncho()) >> 5, oeste = compensacionX >> 5; //se hace bitshifting
        
        for(int y = norte; y < sur; y++){
            for(int x = oeste; x < este; x++){
                getCuadro(x,y).mostrar(x,y,pantalla);
            }
        }
        
    }
    
    /**
     * Identifica lo que hay en un punto del Array y lo traduce en un tile.
     * Ejemplo: 0 == tierra 
     *          1 == flor 
     *          n == elemento
     * @param x
     * @param y
     * @return 
     */
    public Cuadro getCuadro(final int x, final int y) {
        switch (cuadros[x + y * ancho]) {
            case 0:
                return Cuadro.TIERRA;
            default:
                return Cuadro.VACIO;
        }
    }
}
