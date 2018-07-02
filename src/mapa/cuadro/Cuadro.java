package mapa.cuadro;

import graficos.HojaSprites;
import graficos.Pantalla;
import graficos.Sprite;

/**
 * Plantilla para crear cuadros.
 * Una clase cuadro por Sprite usado.
 */
public class Cuadro {
    public int x;
    public int y;
    public Sprite sprite; //cada cuadro deberá tener un Sprite para evitar excepciones.
    public static final int LADO = 32;
    
    //colección de cuadros
    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
    
    public static final Cuadro TIERRA  = new Cuadro(Sprite.TIERRA);
    public static final Cuadro ESQUINA_SUP_IZ_TIERRA = new Cuadro(Sprite.ESQUINA_SUP_IZ_TIERRA);
    public static final Cuadro SUP_MED_TIERRA = new Cuadro(Sprite.SUP_MED_TIERRA);
    public static final Cuadro ESQUINA_SUP_DER_TIERRA = new Cuadro(Sprite.ESQUINA_SUP_DER_TIERRA);
    public static final Cuadro ORILLA_POSTERIOR_RECT = new Cuadro(Sprite.ORILLA_POSTERIOR_RECT);
    public static final Cuadro ORILLA_ESQUINA_FRONTAL_SUP_IZ = new Cuadro(Sprite.ORILLA_ESQUINA_FRONTAL_SUP_IZ);
    public static final Cuadro POSTE_FRONTAL = new Cuadro(Sprite.POSTE_FRONTAL);
    public static final Cuadro ORILLA_ESQUINA_FRONTAL_SUP_DER = new Cuadro(Sprite.ORILLA_ESQUINA_FRONTAL_SUP_DER);
    public static final Cuadro ORILLA_POSTERIOR_CURV = new Cuadro(Sprite.ORILLA_POSTERIOR_CURV);
    public static final Cuadro BANDERA_P1 = new Cuadro(Sprite.BANDERA_P1);
    
    public static final Cuadro HUECO_CUEVA = new Cuadro(Sprite.HUECO_CUEVA);
    public static final Cuadro ESQUINA_SUP_IZ_TIERRA_MEDIO = new Cuadro(Sprite.ESQUINA_SUP_IZ_TIERRA_MEDIO);
    public static final Cuadro MED_MED_TIERRA = new Cuadro(Sprite.MED_MED_TIERRA);
    public static final Cuadro ESQUINA_SUP_DER_TIERRA_MED = new Cuadro(Sprite.ESQUINA_SUP_DER_TIERRA_MED);
    public static final Cuadro ORILLA_ESQUINA_FRONTAL_INF_IZ = new Cuadro(Sprite.ORILLA_ESQUINA_FRONTAL_INF_IZ);
    public static final Cuadro ORILLA_ESQUINA_FRONTAL_INF_MED = new Cuadro(Sprite.ORILLA_ESQUINA_FRONTAL_INF_MED);
    public static final Cuadro ORILLA_ESQUINA_FRONTAL_INF_DER = new Cuadro(Sprite.ORILLA_ESQUINA_FRONTAL_INF_DER);
    public static final Cuadro BANDERA_P2 = new Cuadro(Sprite.BANDERA_P2);
    
    public static final Cuadro ESQUINA_SUP_IZ_TIERRA_MEDIO2 = new Cuadro(Sprite.ESQUINA_SUP_IZ_TIERRA_MEDIO2);
    public static final Cuadro INF_MED_TIERRA = new Cuadro(Sprite.INF_MED_TIERRA);
    public static final Cuadro ESQUINA_SUP_DER_TIERRA_MED2 = new Cuadro(Sprite.ESQUINA_SUP_DER_TIERRA_MED2);
    public static final Cuadro PUENTE_ORILLA_IZ = new Cuadro(Sprite.PUENTE_ORILLA_IZ);
    public static final Cuadro PUENTE_ORILLA_MED = new Cuadro(Sprite.PUENTE_ORILLA_MED);
    public static final Cuadro PUENTE_ORILLA_DER = new Cuadro(Sprite.PUENTE_ORILLA_DER);
    public static final Cuadro PUERTA_ARRIBA = new Cuadro(Sprite.PUERTA_ARRIBA);
    public static final Cuadro ESPINO_SUP = new Cuadro(Sprite.ESPINO_SUP);
    
    public static final Cuadro ESQUINA_SUP_IZ_TIERRA_INF = new Cuadro(Sprite.ESQUINA_SUP_IZ_TIERRA_INF);
    public static final Cuadro ESQUINA_SUP_DER_TIERRA_INF = new Cuadro(Sprite.ESQUINA_SUP_DER_TIERRA_INF);
    public static final Cuadro POSTE_POSTERIOR = new Cuadro(Sprite.POSTE_POSTERIOR);
    public static final Cuadro DETALLE_PARED1 = new Cuadro(Sprite.DETALLE_PARED1);
    public static final Cuadro PUERTA_ABAJO = new Cuadro(Sprite.PUERTA_ABAJO);
    public static final Cuadro ESPINO_INF_CON_DETALLE = new Cuadro(Sprite.ESPINO_INF_CON_DETALLE);
    
    public static final Cuadro ESQUINA_SUP_TORRE_IZ = new Cuadro(Sprite.ESQUINA_SUP_TORRE_IZ);
    public static final Cuadro ESPINO_SUP_TORRE = new Cuadro(Sprite.ESPINO_SUP_TORRE);
    public static final Cuadro ESQUINA_SUP_TORRE_DER = new Cuadro(Sprite.ESQUINA_SUP_TORRE_DER);
    public static final Cuadro ESPINO_INF_SIN_DETALLE = new Cuadro(Sprite.ESPINO_INF_SIN_DETALLE);
    public static final Cuadro PARED_CON_DETALLE = new Cuadro(Sprite.PARED_CON_DETALLE);
    
    public static final Cuadro ESQUINA_SUP_TORRE_IZ_MEDIO = new Cuadro(Sprite.ESQUINA_SUP_TORRE_IZ_MEDIO);
    public static final Cuadro ESPINO_SUP_TORRE_DETALLE = new Cuadro(Sprite.ESPINO_SUP_TORRE_DETALLE);
    public static final Cuadro ESQUINA_SUP_TORRE_DER_MEDIO = new Cuadro(Sprite.ESQUINA_SUP_TORRE_DER_MEDIO);
    public static final Cuadro MURO_INF = new Cuadro(Sprite.MURO_INF);
    
    public static final Cuadro ESQUINA_SUP_TORRE_IZ_MEDIO2 = new Cuadro(Sprite.ESQUINA_SUP_TORRE_IZ_MEDIO2);
    public static final Cuadro PARED_CON_DETALLE_SIN_BORDE = new Cuadro(Sprite.PARED_CON_DETALLE_SIN_BORDE);
    public static final Cuadro ESQUINA_SUP_TORRE_DER_MEDIO2 = new Cuadro(Sprite.ESQUINA_SUP_TORRE_DER_MEDIO2);
    public static final Cuadro PUENTE_AGUA_IZ = new Cuadro(Sprite.PUENTE_AGUA_IZ);
    public static final Cuadro PUENTE_AGUA_MEDIO = new Cuadro(Sprite.PUENTE_AGUA_MEDIO);
    public static final Cuadro PUENTE_AGUA_DER = new Cuadro(Sprite.PUENTE_AGUA_DER);
    public static final Cuadro AGUA = new Cuadro(Sprite.AGUA);
    
    public static final Cuadro ESQUINA_SUP_TORRE_IZ_MEDIO3 = new Cuadro(Sprite.ESQUINA_SUP_TORRE_IZ_MEDIO3);
    public static final Cuadro PARED_SIN_DETALLE = new Cuadro(Sprite.PARED_SIN_DETALLE);
    public static final Cuadro ESQUINA_SUP_TORRE_DER_MEDIO3 = new Cuadro(Sprite.ESQUINA_SUP_TORRE_DER_MEDIO3);
    
    public static final Cuadro ESQUINA_INF_TORRE_IZ = new Cuadro(Sprite.ESQUINA_INF_TORRE_IZ);
    public static final Cuadro INF_TORRE = new Cuadro(Sprite.INF_TORRE);
    public static final Cuadro ESQUINA_INF_TORRE_DER = new Cuadro(Sprite.ESQUINA_INF_TORRE_DER);
    public static final Cuadro PUENTE_POSTERIOR_IZ = new Cuadro(Sprite.PUENTE_POSTERIOR_IZ);
    public static final Cuadro PUENTE_POSTERIOR_MED = new Cuadro(Sprite.PUENTE_POSTERIOR_MED);
    public static final Cuadro PUENTE_POSTERIOR_DER = new Cuadro(Sprite.PUENTE_POSTERIOR_DER);
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
