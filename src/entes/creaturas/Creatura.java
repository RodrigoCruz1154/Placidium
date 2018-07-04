package entes.creaturas;

import entes.Ente;
import graficos.Sprite;

public abstract class Creatura extends Ente {

    protected Sprite sprite;
    protected char direccion = 'n';
    protected boolean enMovimiento = false;

    public void actualizar() {

    }

    public void mostrar() {

    }

    public void mover(int desplazamientoX, int desplazamientoY) {
        if (desplazamientoX > 0) {
            direccion = 'e';
        }
        if (desplazamientoX < 0) {
            direccion = 'o';
        }
        if (desplazamientoY > 0) {
            direccion = 's';
        }
        if (desplazamientoY < 0) {
            direccion = 'n';
        }
        
        if(!isEliminado()){
            if (!enColision(desplazamientoX, 0)) {
                modificarPosX(desplazamientoX);
            }
            if (!enColision(0, desplazamientoY)) {
                modificarPosY(desplazamientoY);
            }
        }
    }

    public Sprite getSprite() {
        return sprite;
    }
    
    private boolean enColision(int desplazamientoX, int desplazamientoY){
        
        boolean colision = false;
        
        int posicionX = x + desplazamientoX;
        int posicionY = y + desplazamientoY;
        
        int margenIzquierdo = 18;
        int margenDerecho = 14;
        int margenSuperior = 18;
        int margenInferior = 32;

        int bordeIzquierdo = (posicionX + margenDerecho) / sprite.getLado();
        int bordeDerecho = (posicionX + margenIzquierdo) / sprite.getLado();
        int bordeSuperior = (posicionY + margenInferior) / sprite.getLado();
        int bordeInferior = (posicionY + margenSuperior) / sprite.getLado();

        if (mapa.getCuadrosCatalogo(bordeIzquierdo + bordeSuperior * mapa.getAncho()).issolido()) {
            colision = true;
        }
        if (mapa.getCuadrosCatalogo(bordeIzquierdo + bordeInferior * mapa.getAncho()).issolido()) {
            colision = true;
        }
        if (mapa.getCuadrosCatalogo(bordeDerecho + bordeSuperior * mapa.getAncho()).issolido()) {
            colision = true;
        }
        if (mapa.getCuadrosCatalogo(bordeDerecho + bordeInferior * mapa.getAncho()).issolido()) {
            colision = true;
        }

        return colision;
    }
}
