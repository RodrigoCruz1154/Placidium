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
        int velocidadMovimiento = 1;
        boolean estaCorriendo = false;

        if (animacion < 32767) {
            animacion++;
        } else {
            animacion = 0;
        }

        if (teclado.shift) {
            velocidadMovimiento = 2;
            estaCorriendo=true;
        }
        if (teclado.arriba) {
            desplazamientoY -= velocidadMovimiento;
        }
        if (teclado.abajo) {
            desplazamientoY += velocidadMovimiento;
        }
        if (teclado.izquierda) {
            desplazamientoX -= velocidadMovimiento;
        }
        if (teclado.derecha) {
            desplazamientoX += velocidadMovimiento;
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

        int resto = animacion % 40;
        if (direccion == 'n') {
            sprite = Sprite.POSTERIOR_QUIETO;
            if (enMovimiento) {
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.POSTERIOR_MOVIENDOSE1;
                } else if (resto > 20 && resto <= 30) {
                    sprite = Sprite.POSTERIOR_QUIETO;
                } else if (resto > 30) {
                    sprite = Sprite.POSTERIOR_MOVIENDOSE2;
                } else {
                    sprite = sprite = Sprite.POSTERIOR_QUIETO;
                }
                if (estaCorriendo) {
                    if (resto > 10 && resto <= 20) {
                        sprite = Sprite.POSTERIOR_CORRIENDO1;
                    } else if (resto > 20 && resto <= 30) {
                        sprite = Sprite.POSTERIOR_CORRIENDO2;
                    } else if (resto > 30) {
                        sprite = Sprite.POSTERIOR_CORRIENDO3;
                    } else {
                        sprite = sprite = Sprite.POSTERIOR_CORRIENDO2;
                    }
                }
            }
        }
        if (direccion == 's') {
            sprite = Sprite.FRONTAL_QUIETO;
            if (enMovimiento) {
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.FRONTAL_MOVIENDOSE1;
                } else if (resto > 20 && resto <= 30) {
                    sprite = Sprite.FRONTAL_QUIETO;
                } else if (resto > 30) {
                    sprite = Sprite.FRONTAL_MOVIENDOSE2;
                } else {
                    sprite = sprite = Sprite.FRONTAL_QUIETO;
                }
                if (estaCorriendo) {
                    if (resto > 10 && resto <= 20) {
                        sprite = Sprite.FRONTAL_CORRIENDO1;
                    } else if (resto > 20 && resto <= 30) {
                        sprite = Sprite.FRONTAL_CORRIENDO2;
                    } else if (resto > 30) {
                        sprite = Sprite.FRONTAL_CORRIENDO3;
                    } else {
                        sprite = sprite = Sprite.FRONTAL_CORRIENDO2;
                    }
                }
            }
        }
        if (direccion == 'e') {
            sprite = Sprite.DERECHA_QUIETO;
            if (enMovimiento) {
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.DERECHA_MOVIENDOSE1;
                } else if (resto > 20 && resto <= 30) {
                    sprite = Sprite.DERECHA_QUIETO;
                } else if (resto > 30) {
                    sprite = Sprite.DERECHA_MOVIENDOSE2;
                } else {
                    sprite = sprite = Sprite.DERECHA_QUIETO;
                }
                if (estaCorriendo) {
                    if (resto > 10 && resto <= 20) {
                        sprite = Sprite.DERECHA_CORRIENDO1;
                    } else if (resto > 20 && resto <= 30) {
                        sprite = Sprite.DERECHA_CORRIENDO2;
                    } else if (resto > 30) {
                        sprite = Sprite.DERECHA_CORRIENDO3;
                    } else {
                        sprite = sprite = Sprite.DERECHA_CORRIENDO2;
                    }
                }
            }
        }
        if (direccion == 'o') {
            sprite = Sprite.IZQUIERDA_QUIETO;
            if (enMovimiento) {
                if (resto > 10 && resto <= 20) {
                    sprite = Sprite.IZQUIERDA_MOVIENDOSE1;
                } else if (resto > 20 && resto <= 30) {
                    sprite = Sprite.IZQUIERDA_QUIETO;
                } else if (resto > 30) {
                    sprite = Sprite.IZQUIERDA_MOVIENDOSE2;
                } else {
                    sprite = sprite = Sprite.IZQUIERDA_QUIETO;
                }
                if (estaCorriendo) {
                    if (resto > 10 && resto <= 20) {
                        sprite = Sprite.IZQUIERDA_CORRIENDO1;
                    } else if (resto > 20 && resto <= 30) {
                        sprite = Sprite.IZQUIERDA_CORRIENDO2;
                    } else if (resto > 30) {
                        sprite = Sprite.IZQUIERDA_CORRIENDO3;
                    } else {
                        sprite = sprite = Sprite.IZQUIERDA_CORRIENDO2;
                    }
                }
            }
        }
    }

    public void mostrar(Pantalla pantalla) {
        pantalla.mostrarJugador(x, y, this);
    }

}
