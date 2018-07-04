package entes.creaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;

public class Jugador extends Creatura{
    private Teclado teclado;
    
    
    public Jugador(Teclado teclado, Sprite sprite){
        this.teclado = teclado;
        this.sprite = sprite;
    }
    /**
     * Permite que el jugador aparezca en un lugar predeterminado.
     * @param teclado
     * @param posicionX
     * @param posicionY 
     */
    public Jugador(Teclado teclado, Sprite sprite, int posicionX, int posicionY){
        this.teclado = teclado;    
        this.sprite = sprite;
        this.x = posicionX;
        this.y = posicionY;    
    }
    
    public void actualizar(){
        int desplazamientoX = 0;
        int desplazamientoY = 0;
        
        if(teclado.arriba) desplazamientoY--;
        if(teclado.abajo) desplazamientoY++;
        if(teclado.izquierda) desplazamientoX--;
        if(teclado.derecha) desplazamientoX++;
        
        /**
         * Detecta desplazamiento :v
         */
        if(desplazamientoX != 0 || desplazamientoY != 0){
            if(direccion=='n'){
                sprite = Sprite.POSTERIOR_QUIETO;
            }
            if(direccion=='s'){
                sprite = Sprite.FRONTAL_QUIETO;
            }
            if(direccion=='e'){
                sprite = Sprite.DERECHA_QUIETO;
            }
            if(direccion=='o'){
                sprite = Sprite.IZQUIERDA_QUIETO;
            }
            
            mover(desplazamientoX,desplazamientoY);
        }
    }
    
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarJugador(x, y, this);
    }
    
}
