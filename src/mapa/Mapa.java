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
    protected Cuadro[] cuadrosCatalogo;
    
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
        generarMapa();
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

        int norte = compensacionY >> 5,
                sur = (compensacionY + pantalla.getAlto() + Cuadro.LADO) >> 5,
                este = (compensacionX + pantalla.getAncho() + Cuadro.LADO) >> 5,
                oeste = compensacionX >> 5; //se hace bitshifting
        
        for(int y = norte; y < sur; y++){
            for(int x = oeste; x < este; x++){
                //getCuadro(x,y).mostrar(x,y,pantalla); //Genera los mapas aleatorios
                if(x<0 || y < 0 || x>=ancho || y>=alto){
                    Cuadro.VACIO.mostrar(x, y, pantalla);
                } else{
                    cuadrosCatalogo[x+y*ancho].mostrar(x, y, pantalla);
                }
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
    public Cuadro getCuadro(final int x, final int y){
        if(x < 0 || y < 0 || x >= ancho || y >=alto){ //permite la salida del array para que se pueda "salir" del mapa generado.
            return Cuadro.VACIO;
        }
        switch (cuadros[x + y * ancho]) {
            case 0:
                return Cuadro.TIERRA;
            case 1:
                return Cuadro.AGUA;
            case 2:
                return Cuadro.BANDERA_P1;
            case 3:
                return Cuadro.BANDERA_P2;
            case 4:
                return Cuadro.DETALLE_PARED1;
            case 5:
                return Cuadro.ESPINO_INF_CON_DETALLE;
            case 6:
                return Cuadro.ESPINO_INF_SIN_DETALLE;
            case 7:
                return Cuadro.ESPINO_SUP;
            case 8:
                return Cuadro.ESPINO_SUP_TORRE;
            case 9:
                return Cuadro.ESPINO_SUP_TORRE_DETALLE;
            case 10:
                return Cuadro.ESQUINA_INF_TORRE_DER;
            case 11:
                return Cuadro.ESQUINA_INF_TORRE_IZ;
            case 12:
                return Cuadro.ESQUINA_SUP_DER_TIERRA;
            case 13:
                return Cuadro.ESQUINA_SUP_DER_TIERRA_INF;
            case 14:
                return Cuadro.ESQUINA_SUP_DER_TIERRA_MED;
            case 15:
                return Cuadro.ESQUINA_SUP_DER_TIERRA_MED2;
            case 16:
                return Cuadro.ESQUINA_SUP_IZ_TIERRA;
            case 17:
                return Cuadro.ESQUINA_SUP_IZ_TIERRA_INF;
            case 18:
                return Cuadro.ESQUINA_SUP_IZ_TIERRA_MEDIO;
            case 19:
                return Cuadro.ESQUINA_SUP_IZ_TIERRA_MEDIO2;
            case 20:
                return Cuadro.ESQUINA_SUP_TORRE_DER;
            case 21:
                return Cuadro.ESQUINA_SUP_TORRE_DER_MEDIO;
            case 22:
                return Cuadro.ESQUINA_SUP_TORRE_DER_MEDIO2;
            case 23:
                return Cuadro.ESQUINA_SUP_TORRE_DER_MEDIO3;
            case 24:
                return Cuadro.ESQUINA_SUP_TORRE_IZ;
            case 25:
                return Cuadro.ESQUINA_SUP_TORRE_IZ_MEDIO;
            case 26:
                return Cuadro.ESQUINA_SUP_TORRE_IZ_MEDIO2;
            case 27:
                return Cuadro.ESQUINA_SUP_TORRE_IZ_MEDIO3;
            case 28:
                return Cuadro.HUECO_CUEVA;
            case 29:
                return Cuadro.INF_MED_TIERRA;
            case 30:
                return Cuadro.INF_TORRE;
            case 31:
                return Cuadro.MED_MED_TIERRA;
            case 32:
                return Cuadro.MURO_INF;
            case 33:
                return Cuadro.ORILLA_ESQUINA_FRONTAL_INF_DER;
            case 34:
                return Cuadro.ORILLA_ESQUINA_FRONTAL_INF_IZ;
            case 35:
                return Cuadro.ORILLA_ESQUINA_FRONTAL_INF_MED;
            case 36:
                return Cuadro.ORILLA_ESQUINA_FRONTAL_SUP_DER;
            case 37:
                return Cuadro.ORILLA_ESQUINA_FRONTAL_SUP_IZ;
            case 38:
                return Cuadro.ORILLA_POSTERIOR_CURV;
            case 39:
                return Cuadro.ORILLA_POSTERIOR_RECT;
            case 40:
                return Cuadro.PARED_CON_DETALLE;
            case 41:
                return Cuadro.PARED_CON_DETALLE_SIN_BORDE;
            case 42:
                return Cuadro.PARED_SIN_DETALLE;
            case 43:
                return Cuadro.POSTE_FRONTAL;
            case 44:
                return Cuadro.POSTE_POSTERIOR;
            case 45:
                return Cuadro.PUENTE_AGUA_DER;
            case 46:
                return Cuadro.PUENTE_AGUA_IZ;
            case 47:
                return Cuadro.PUENTE_AGUA_MEDIO;
            case 48:
                return Cuadro.PUENTE_ORILLA_DER;
            case 49:
                return Cuadro.PUENTE_ORILLA_IZ;
            case 50:
                return Cuadro.PUENTE_ORILLA_MED;
            case 51:
                return Cuadro.PUERTA_ABAJO;
            case 52:
                return Cuadro.PUERTA_ARRIBA;
            case 53:
                return Cuadro.SUP_MED_TIERRA;
            default:
                return Cuadro.VACIO;
        }
    }
}
