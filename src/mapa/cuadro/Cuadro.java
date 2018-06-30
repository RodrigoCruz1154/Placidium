package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

/**
 * Plantilla para crear cuadros.
 */
public abstract class Cuadro {
    public int x;
    public int y;
    public Sprite sprite; //cada cuadro deberá tener un Sprite para evitar excepciones.

    public Cuadro(Sprite sprite) {
        this.sprite = sprite;
    }
    
    public void mostrar(int x, Pantalla pantalla){
        
    }
    
    /**
     * Hace que se sepa que si el objeto que se está atravesando es sólido o no. Si lo es, entonces no se podrá atravesar.
     * @return false
     */
    public boolean solido(){
        return false;
    }
}
