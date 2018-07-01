package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

/**
 * Plantilla para crear cuadros.
 * Una clase cuadro por Sprite usado.
 */
public abstract class Cuadro {
    public int x;
    public int y;
    public Sprite sprite; //cada cuadro deberá tener un Sprite para evitar excepciones.
    public static final int LADO = 32;
    
    //colección de cuadros
    public static final Cuadro VACIO = new CuadroVacio(Sprite.VACIO);
    public static final Cuadro TIERRA  = new CuadroTierra(Sprite.TIERRA);
    //fin de la colección de cuadros.
    
    public Cuadro(Sprite sprite) {
        this.sprite = sprite;
    }
    /**
     * En las clases hijas se implementará de manera más específica para cada una.
     * @param x
     * @param y
     * @param pantalla 
     */
    public void mostrar(int x,int y, Pantalla pantalla){
        pantalla.mostrarCuadro(x << 5, y<<5, this); 
    }
    
    /**
     * Hace que se sepa que si el objeto que se está atravesando es sólido o no. Si lo es, entonces no se podrá atravesar.
     * @return false
     */
    public boolean solido(){
        return false;
    }
}
