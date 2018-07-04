package entes.creaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;

public class Jugador extends Creatura {

    private Teclado teclado;

    private int animacion;

    public Jugador(Teclado teclado, Sprite sprite) {
        this.teclado = teclado;
        this.sprite = sprite;
    }

    /**
     * Permite que el jugador aparezca en un lugar predeterminado.
     *
     * @param teclado
     * @param posicionX
     * @param posicionY
     */
    public Jugador(Teclado teclado, Sprite sprite, int posicionX, int posicionY) {
        this.teclado = teclado;
        this.sprite = sprite;
        this.x = posicionX;
        this.y = posicionY;
    }

    public void actualizar() {
        int desplazamientoX = 0;
        int desplazamientoY = 0;
        
        if(animacion< 32767){
            animacion++;
        } else{
            animacion = 0;
        }
        
        if (teclado.arriba) {
            desplazamientoY--;
        }
        if (teclado.abajo) {
            desplazamientoY++;
        }
        if (teclado.izquierda) {
            desplazamientoX--;
        }
        if (teclado.derecha) {
            desplazamientoX++;
        }

        /**
         * Detecta desplazamiento :v
         */
        if (desplazamientoX != 0 || desplazamientoY != 0) {
            mover(desplazamientoX, desplazamientoY);
            enMovimiento = true;
        } else {
            enMovimiento = false;
        }
        if (direccion == 'n') {
            sprite = Sprite.POSTERIOR_QUIETO;
            if(enMovimiento){
                if(animacion % 26 > 13){
                    sprite = Sprite.POSTERIOR_MOVIENDOSE1;
                } else{
                    sprite = Sprite.POSTERIOR_MOVIENDOSE2;
                }
            }
        }
        if (direccion == 's') {
            sprite = Sprite.FRONTAL_QUIETO;
            if(enMovimiento){
            if (animacion % 26 > 13) {
                sprite = Sprite.FRONTAL_MOVIENDOSE1;
            } else {
                sprite = Sprite.FRONTAL_MOVIENDOSE2;
            }
            }
        }
        if (direccion == 'e') {
            sprite = Sprite.DERECHA_QUIETO;
            if(enMovimiento){
            if (animacion % 28 > 14) {
                sprite = Sprite.DERECHA_MOVIENDOSE1;
            } else {
                sprite = Sprite.DERECHA_MOVIENDOSE2;
            }
            }
        }
        if (direccion == 'o') {
            sprite = Sprite.IZQUIERDA_QUIETO;
            if(enMovimiento){
                if (animacion % 28 > 14) {
                sprite = Sprite.IZQUIERDA_MOVIENDOSE1;
            } else {
                sprite = Sprite.IZQUIERDA_MOVIENDOSE2;
            }
            }
        }
    }

    public void mostrar(Pantalla pantalla) {
        pantalla.mostrarJugador(x, y, this);
    }

}
