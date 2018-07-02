package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import mapa.cuadro.Cuadro;

/**
 *Permite cargar un mapa desde una ruta preestablecida.
 */
public class MapaCargado extends Mapa{
    
    private int[] pixeles;
    
    public MapaCargado(String ruta) {
        super(ruta);
    }
    /**
     * Lee la imagen, inicializa las variables ancho, alto e inserta en pixeles los valores de los colores de nuestro mapa a generar.
     * @param ruta 
     */
    protected void cargarMapa(String ruta){
        try {
            BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
            
            ancho = imagen.getWidth();
            alto = imagen.getHeight();
            
            cuadrosCatalogo = new Cuadro[ancho*alto];
            pixeles = new int[ancho*alto];
            
            imagen.getRGB(0, 0, ancho,alto,pixeles,0,ancho);
            
        } catch (IOException ex) {
            Logger.getLogger(MapaCargado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Permite generar un mapa
     */
    protected void generarMapa() {
        for (int i = 0; i < pixeles.length; i++) {
            switch (pixeles[i]) { //evalua el color guardado en el array de pixeles
                case 0xff579641:
                    cuadrosCatalogo[i] = Cuadro.TIERRA;
                    continue;
                case 0xff414b96:
                    cuadrosCatalogo[i] = Cuadro.AGUA;
                    continue;
                case 0xff9f8034:
                    cuadrosCatalogo[i] = Cuadro.BANDERA_P1;
                    continue;
                case 0xff6d5314:
                    cuadrosCatalogo[i] = Cuadro.BANDERA_P2;
                    continue;
                case 0xff8d6507:
                    cuadrosCatalogo[i] = Cuadro.DETALLE_PARED1;
                    continue;
                case 0xff907d50:
                    cuadrosCatalogo[i] = Cuadro.ESPINO_INF_CON_DETALLE;
                    continue;
                case 0xffb08828:
                    cuadrosCatalogo[i] = Cuadro.ESPINO_INF_SIN_DETALLE;
                    continue;
                case 0xff615035:
                    cuadrosCatalogo[i] = Cuadro.ESPINO_SUP;
                    continue;
                case 0xff6b604f:
                    cuadrosCatalogo[i] = Cuadro.ESPINO_SUP_TORRE;
                    continue;
                case 0xff6c564d:
                    cuadrosCatalogo[i] = Cuadro.ESPINO_SUP_TORRE_DETALLE;
                    continue;
                case 0xffa12d5e:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_INF_TORRE_DER;
                    continue;
                case 0xff620e31:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_INF_TORRE_IZ;
                    continue;
                case 0xff3f2424:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_DER_TIERRA;
                    continue;
                case 0xff864040:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_DER_TIERRA_INF;
                    continue;
                case 0xff462020:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_DER_TIERRA_MED;
                    continue;
                case 0xff4f0f0f:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_DER_TIERRA_MED2;
                    continue;
                case 0xff735845:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_IZ_TIERRA;
                    continue;
                case 0xff9b7a43:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_IZ_TIERRA_INF;
                    continue;
                case 0xffa06d48:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_IZ_TIERRA_MEDIO;
                    continue;
                case 0xffb4945f:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_IZ_TIERRA_MEDIO2;
                    continue;
                case 0xff867f7f:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_DER;
                    continue;
                case 0xff807870:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_DER_MEDIO;
                    continue;
                case 0xff887a6c:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_DER_MEDIO2;
                    continue;
                case 0xff796551:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_DER_MEDIO3;
                    continue;
                case 0xff866c2e:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_IZ;
                    continue;
                case 0xff2b1f24:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_IZ_MEDIO;
                    continue;
                case 0xff28121b:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_IZ_MEDIO2;
                    continue;
                case 0xff330e1e:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_IZ_MEDIO3;
                    continue;
                case 0xff784b35:
                    cuadrosCatalogo[i] = Cuadro.HUECO_CUEVA;
                    continue;
                case 0xff6a3f2a:
                    cuadrosCatalogo[i] = Cuadro.INF_MED_TIERRA;
                    continue;
                case 0xff821442:
                    cuadrosCatalogo[i] = Cuadro.INF_TORRE;
                    continue;
                case 0xffbc8e36:
                    cuadrosCatalogo[i] = Cuadro.MED_MED_TIERRA;
                    continue;
                case 0xff836c33:
                    cuadrosCatalogo[i] = Cuadro.MURO_INF;
                    continue;
                case 0xffa04f28:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_ESQUINA_FRONTAL_INF_DER;
                    continue;
                case 0xffcc8d6e:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_ESQUINA_FRONTAL_INF_IZ;
                    continue;
                case 0xff86401e:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_ESQUINA_FRONTAL_INF_MED;
                    continue;
                case 0xffdc6b34:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_ESQUINA_FRONTAL_SUP_DER;
                    continue;
                case 0xffb0623b:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_ESQUINA_FRONTAL_SUP_IZ;
                    continue;
                case 0xff639e72:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_POSTERIOR_CURV;
                    continue;
                case 0xff419657:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_POSTERIOR_RECT;
                    continue;
                case 0xff6a5420:
                    cuadrosCatalogo[i] = Cuadro.PARED_CON_DETALLE;
                    continue;
                case 0xff3e3337:
                    cuadrosCatalogo[i] = Cuadro.PARED_CON_DETALLE_SIN_BORDE;
                    continue;
                case 0xff281a1f:
                    cuadrosCatalogo[i] = Cuadro.PARED_SIN_DETALLE;
                    continue;
                case 0xff1a5804:
                    cuadrosCatalogo[i] = Cuadro.POSTE_FRONTAL;
                    continue;
                case 0xffd5845c:
                    cuadrosCatalogo[i] = Cuadro.POSTE_POSTERIOR;
                    continue;
                case 0xffc3876a:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_AGUA_DER;
                    continue;
                case 0xff623520:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_AGUA_IZ;
                    continue;
                case 0xff925537:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_AGUA_MEDIO;
                    continue;
                case 0xffad5e38:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_ORILLA_DER;
                    continue;
                case 0xffae5c34:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_ORILLA_IZ;
                    continue;
                case 0xffd99b7c:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_ORILLA_MED;
                    continue;
                case 0xff333a01:
                    cuadrosCatalogo[i] = Cuadro.PUERTA_ABAJO;
                    continue;
                case 0xff677313:
                    cuadrosCatalogo[i] = Cuadro.PUERTA_ARRIBA;
                    continue;
                case 0xffd0ad73:
                    cuadrosCatalogo[i] = Cuadro.SUP_MED_TIERRA;
                    continue;
                case 0xff925e45:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_POSTERIOR_IZ;
                    continue;
                case 0xff815d4b:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_POSTERIOR_MED;
                    continue;
                case 0xff4f2714:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_POSTERIOR_DER;
                    continue;
                default:
                    cuadrosCatalogo[i] = Cuadro.VACIO;
            }
        }
    }

}
