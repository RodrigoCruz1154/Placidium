package entes;

import mapa.Mapa;

public abstract class Ente {

    protected int x;
    protected int y;

    private boolean eliminado = false; //permite saber si un ente está o no eliminado.

    protected Mapa mapa;

    public void actualizar() {

    }

    public void mostar() {

    }

    public int getposicionX() {
        return x;
    }

    public int getposicionY() {
        return y;
    }

    public boolean isEliminado() {
        return eliminado;
    }
    
    public void modificarPosX(int desplazamientoX){
        x+=desplazamientoX;
        
    }
    
    public void modificarPosY(int desplazamientoY){
        y+=desplazamientoY;
    }

    /**
     * Elimina un ente.
     */
    public void eliminar() {
        eliminado = true;
    }

}
