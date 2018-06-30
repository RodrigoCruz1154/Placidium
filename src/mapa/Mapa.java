package mapa;

import graficos.Pantalla;

/**
 * Plantilla para crear más mapas.
 */
public abstract class Mapa {
    private int ancho;
    private int alto;
    private int[] cuadros;
    
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
    
    public void cargarMapa(String ruta){
        
    }
    
    public void generarMapa(){
        
    }
    
    public void actualizar(){
        
    }
    public void mostrar(int compensacionX, int compenacionY, Pantalla pantalla){
        
    }
    
}
