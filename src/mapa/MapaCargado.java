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
                case 0x579641:
                    cuadrosCatalogo[i] = Cuadro.TIERRA;
                    continue;
                case 0x414b96:
                    cuadrosCatalogo[i] = Cuadro.AGUA;
                    continue;
                case 0x9f8034:
                    cuadrosCatalogo[i] = Cuadro.BANDERA_P1;
                    continue;
                case 0x6d5314:
                    cuadrosCatalogo[i] = Cuadro.BANDERA_P2;
                    continue;
                case 0x8d6507:
                    cuadrosCatalogo[i] = Cuadro.DETALLE_PARED1;
                    continue;
                case 0x907d50:
                    cuadrosCatalogo[i] = Cuadro.ESPINO_INF_CON_DETALLE;
                    continue;
                case 0xb08828:
                    cuadrosCatalogo[i] = Cuadro.ESPINO_INF_SIN_DETALLE;
                    continue;
                case 0x615035:
                    cuadrosCatalogo[i] = Cuadro.ESPINO_SUP;
                    continue;
                case 0x6b604f:
                    cuadrosCatalogo[i] = Cuadro.ESPINO_SUP_TORRE;
                    continue;
                case 0x6c564d:
                    cuadrosCatalogo[i] = Cuadro.ESPINO_SUP_TORRE_DETALLE;
                    continue;
                case 0xa12d5e:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_INF_TORRE_DER;
                    continue;
                case 0x620e31:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_INF_TORRE_IZ;
                    continue;
                case 0x3f2424:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_DER_TIERRA;
                    continue;
                case 0x864040:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_DER_TIERRA_INF;
                    continue;
                case 0x462020:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_DER_TIERRA_MED;
                    continue;
                case 0x4f0f0f:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_DER_TIERRA_MED2;
                    continue;
                case 0x735845:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_IZ_TIERRA;
                    continue;
                case 0x9b7a43:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_IZ_TIERRA_INF;
                    continue;
                case 0xa06d48:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_IZ_TIERRA_MEDIO;
                    continue;
                case 0xb4945f:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_IZ_TIERRA_MEDIO2;
                    continue;
                case 0x867f7f:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_DER;
                    continue;
                case 0x807870:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_DER_MEDIO;
                    continue;
                case 0x887a6c:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_DER_MEDIO2;
                    continue;
                case 0x796551:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_DER_MEDIO3;
                    continue;
                case 0x866c2e:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_IZ;
                    continue;
                case 0x2b1f24:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_IZ_MEDIO;
                    continue;
                case 0x28121b:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_IZ_MEDIO2;
                    continue;
                case 0x330e1e:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_SUP_TORRE_IZ_MEDIO3;
                    continue;
                case 0x784b35:
                    cuadrosCatalogo[i] = Cuadro.HUECO_CUEVA;
                    continue;
                case 0x6a3f2a:
                    cuadrosCatalogo[i] = Cuadro.INF_MED_TIERRA;
                    continue;
                case 0x821442:
                    cuadrosCatalogo[i] = Cuadro.INF_TORRE;
                    continue;
                case 0xbc8e36:
                    cuadrosCatalogo[i] = Cuadro.MED_MED_TIERRA;
                    continue;
                case 0x836c33:
                    cuadrosCatalogo[i] = Cuadro.MURO_INF;
                    continue;
                case 0xa04f28:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_ESQUINA_FRONTAL_INF_DER;
                    continue;
                case 0xcc8d6e:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_ESQUINA_FRONTAL_INF_IZ;
                    continue;
                case 0x86401e:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_ESQUINA_FRONTAL_INF_MED;
                    continue;
                case 0xdc6b34:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_ESQUINA_FRONTAL_SUP_DER;
                    continue;
                case 0xb0623b:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_ESQUINA_FRONTAL_SUP_IZ;
                    continue;
                case 0x639e72:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_POSTERIOR_CURV;
                    continue;
                case 0x419657:
                    cuadrosCatalogo[i] = Cuadro.ORILLA_POSTERIOR_RECT;
                    continue;
                case 0x6a5420:
                    cuadrosCatalogo[i] = Cuadro.PARED_CON_DETALLE;
                    continue;
                case 0x3e3337:
                    cuadrosCatalogo[i] = Cuadro.PARED_CON_DETALLE_SIN_BORDE;
                    continue;
                case 0x281a1f:
                    cuadrosCatalogo[i] = Cuadro.PARED_SIN_DETALLE;
                    continue;
                case 0x1a5804:
                    cuadrosCatalogo[i] = Cuadro.POSTE_FRONTAL;
                    continue;
                case 0xd5845c:
                    cuadrosCatalogo[i] = Cuadro.POSTE_POSTERIOR;
                    continue;
                case 0xc3876a:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_AGUA_DER;
                    continue;
                case 0x623520:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_AGUA_IZ;
                    continue;
                case 0x925537:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_AGUA_MEDIO;
                    continue;
                case 0xad5e38:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_ORILLA_DER;
                    continue;
                case 0xae5c34:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_ORILLA_IZ;
                    continue;
                case 0xd99b7c:
                    cuadrosCatalogo[i] = Cuadro.PUENTE_ORILLA_MED;
                    continue;
                case 0x333a01:
                    cuadrosCatalogo[i] = Cuadro.PUERTA_ABAJO;
                    continue;
                case 0x677313:
                    cuadrosCatalogo[i] = Cuadro.PUERTA_ARRIBA;
                    continue;
                case 0xd0ad73:
                    cuadrosCatalogo[i] = Cuadro.SUP_MED_TIERRA;
                    continue;
            }
        }
    }

}
