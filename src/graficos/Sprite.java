package graficos;

public final class Sprite {

    private final int lado;

    private int x;
    private int y;

    public int[] pixeles;
    private HojaSprites hoja;

    //colección de sprites del jugador
    
    public static final Sprite FRONTAL_QUIETO = new Sprite(32,0,0,HojaSprites.jugador);
    public static final Sprite FRONTAL_MOVIENDOSE1 = new Sprite(32,0,1,HojaSprites.jugador);
    public static final Sprite FRONTAL_MOVIENDOSE2 = new Sprite(32,0,2,HojaSprites.jugador);
    
    public static final Sprite POSTERIOR_QUIETO = new Sprite(32,1,0,HojaSprites.jugador);
    public static final Sprite POSTERIOR_MOVIENDOSE1 = new Sprite(32,1,1,HojaSprites.jugador);
    public static final Sprite POSTERIOR_MOVIENDOSE2 = new Sprite(32,1,2,HojaSprites.jugador);
    
    public static final Sprite DERECHA_QUIETO = new Sprite(32,2,0,HojaSprites.jugador);
    public static final Sprite DERECHA_MOVIENDOSE1 = new Sprite(32,2,1,HojaSprites.jugador);
    public static final Sprite DERECHA_MOVIENDOSE2 = new Sprite(32,2,2,HojaSprites.jugador);
    
    public static final Sprite IZQUIERDA_QUIETO = new Sprite(32,3,0,HojaSprites.jugador);
    public static final Sprite IZQUIERDA_MOVIENDOSE1 = new Sprite(32,3,1,HojaSprites.jugador);
    public static final Sprite IZQUIERDA_MOVIENDOSE2 = new Sprite(32,3,2,HojaSprites.jugador);
    //fin de la colección de sprites del jugador

//colección de sprites del mapa 
    public static final Sprite VACIO = new Sprite(32, 0);

    public static final Sprite TIERRA = new Sprite(32, 0, 0, HojaSprites.tierra);
    public static final Sprite ESQUINA_SUP_IZ_TIERRA = new Sprite(32, 1, 0, HojaSprites.tierra);
    public static final Sprite SUP_MED_TIERRA = new Sprite(32, 2, 0, HojaSprites.tierra);
    public static final Sprite ESQUINA_SUP_DER_TIERRA = new Sprite(32, 3, 0, HojaSprites.tierra);
    public static final Sprite ORILLA_POSTERIOR_RECT = new Sprite(32, 4, 0, HojaSprites.tierra);
    public static final Sprite ORILLA_ESQUINA_FRONTAL_SUP_IZ = new Sprite(32, 5, 0, HojaSprites.tierra);
    public static final Sprite POSTE_FRONTAL = new Sprite(32, 6, 0, HojaSprites.tierra);
    public static final Sprite ORILLA_ESQUINA_FRONTAL_SUP_DER = new Sprite(32, 7, 0, HojaSprites.tierra);
    public static final Sprite ORILLA_POSTERIOR_CURV = new Sprite(32, 8, 0, HojaSprites.tierra);
    public static final Sprite BANDERA_P1 = new Sprite(32, 9, 0, HojaSprites.tierra);

    public static final Sprite HUECO_CUEVA = new Sprite(32, 0, 1, HojaSprites.tierra);
    public static final Sprite ESQUINA_SUP_IZ_TIERRA_MEDIO = new Sprite(32, 1, 1, HojaSprites.tierra);
    public static final Sprite MED_MED_TIERRA = new Sprite(32, 2, 1, HojaSprites.tierra);
    public static final Sprite ESQUINA_SUP_DER_TIERRA_MED = new Sprite(32, 3, 1, HojaSprites.tierra);
    public static final Sprite ORILLA_ESQUINA_FRONTAL_INF_IZ = new Sprite(32, 5, 1, HojaSprites.tierra);
    public static final Sprite ORILLA_ESQUINA_FRONTAL_INF_MED = new Sprite(32, 6, 1, HojaSprites.tierra);
    public static final Sprite ORILLA_ESQUINA_FRONTAL_INF_DER = new Sprite(32, 7, 1, HojaSprites.tierra);
    public static final Sprite BANDERA_P2 = new Sprite(32, 9, 1, HojaSprites.tierra);

    public static final Sprite ESQUINA_SUP_IZ_TIERRA_MEDIO2 = new Sprite(32, 1, 2, HojaSprites.tierra);
    public static final Sprite INF_MED_TIERRA = new Sprite(32, 2, 2, HojaSprites.tierra);
    public static final Sprite ESQUINA_SUP_DER_TIERRA_MED2 = new Sprite(32, 3, 2, HojaSprites.tierra);
    public static final Sprite PUENTE_ORILLA_IZ = new Sprite(32, 5, 2, HojaSprites.tierra);
    public static final Sprite PUENTE_ORILLA_MED = new Sprite(32, 6, 2, HojaSprites.tierra);
    public static final Sprite PUENTE_ORILLA_DER = new Sprite(32, 7, 2, HojaSprites.tierra);
    public static final Sprite PUERTA_ARRIBA = new Sprite(32, 8, 2, HojaSprites.tierra);
    public static final Sprite ESPINO_SUP = new Sprite(32, 9, 2, HojaSprites.tierra);

    public static final Sprite ESQUINA_SUP_IZ_TIERRA_INF = new Sprite(32, 1, 3, HojaSprites.tierra);
    public static final Sprite ESQUINA_SUP_DER_TIERRA_INF = new Sprite(32, 3, 3, HojaSprites.tierra);
    public static final Sprite POSTE_POSTERIOR = new Sprite(32, 5, 3, HojaSprites.tierra);
    public static final Sprite DETALLE_PARED1 = new Sprite(32, 7, 3, HojaSprites.tierra);
    public static final Sprite PUERTA_ABAJO = new Sprite(32, 8, 3, HojaSprites.tierra);
    public static final Sprite ESPINO_INF_CON_DETALLE = new Sprite(32, 9, 3, HojaSprites.tierra);

    public static final Sprite ESQUINA_SUP_TORRE_IZ = new Sprite(32, 1, 4, HojaSprites.tierra);
    public static final Sprite ESPINO_SUP_TORRE = new Sprite(32, 2, 4, HojaSprites.tierra);
    public static final Sprite ESQUINA_SUP_TORRE_DER = new Sprite(32, 3, 4, HojaSprites.tierra);
    public static final Sprite ESPINO_INF_SIN_DETALLE = new Sprite(32, 7, 4, HojaSprites.tierra);
    public static final Sprite PARED_CON_DETALLE = new Sprite(32, 9, 4, HojaSprites.tierra);

    public static final Sprite ESQUINA_SUP_TORRE_IZ_MEDIO = new Sprite(32, 1, 5, HojaSprites.tierra);
    public static final Sprite ESPINO_SUP_TORRE_DETALLE = new Sprite(32, 2, 5, HojaSprites.tierra);
    public static final Sprite ESQUINA_SUP_TORRE_DER_MEDIO = new Sprite(32, 3, 5, HojaSprites.tierra);
    public static final Sprite MURO_INF = new Sprite(32, 9, 5, HojaSprites.tierra);

    public static final Sprite ESQUINA_SUP_TORRE_IZ_MEDIO2 = new Sprite(32, 1, 6, HojaSprites.tierra);
    public static final Sprite PARED_CON_DETALLE_SIN_BORDE = new Sprite(32, 2, 6, HojaSprites.tierra);
    public static final Sprite ESQUINA_SUP_TORRE_DER_MEDIO2 = new Sprite(32, 3, 6, HojaSprites.tierra);
    public static final Sprite PUENTE_AGUA_IZ = new Sprite(32, 5, 6, HojaSprites.tierra);
    public static final Sprite PUENTE_AGUA_MEDIO = new Sprite(32, 6, 6, HojaSprites.tierra);
    public static final Sprite PUENTE_AGUA_DER = new Sprite(32, 7, 6, HojaSprites.tierra);
    public static final Sprite AGUA = new Sprite(32, 9, 6, HojaSprites.tierra);

    public static final Sprite ESQUINA_SUP_TORRE_IZ_MEDIO3 = new Sprite(32, 1, 7, HojaSprites.tierra);
    public static final Sprite PARED_SIN_DETALLE = new Sprite(32, 2, 7, HojaSprites.tierra);
    public static final Sprite ESQUINA_SUP_TORRE_DER_MEDIO3 = new Sprite(32, 3, 7, HojaSprites.tierra);

    public static final Sprite ESQUINA_INF_TORRE_IZ = new Sprite(32, 1, 8, HojaSprites.tierra);
    public static final Sprite INF_TORRE = new Sprite(32, 2, 8, HojaSprites.tierra);
    public static final Sprite ESQUINA_INF_TORRE_DER = new Sprite(32, 3, 8, HojaSprites.tierra);
    public static final Sprite PUENTE_POSTERIOR_IZ = new Sprite(32, 5, 8, HojaSprites.tierra);
    public static final Sprite PUENTE_POSTERIOR_MED = new Sprite(32, 6, 8, HojaSprites.tierra);
    public static final Sprite PUENTE_POSTERIOR_DER = new Sprite(32, 7, 8, HojaSprites.tierra);
    //fin de la colección

    /**
     * Inicia el Sprite sin necesidad de cargar un Sprite predefinido. Basta con
     * nombrar un color y su tamaño.
     *
     * @param lado
     * @param color
     */
    public Sprite(final int lado, final int color) {
        this.lado = lado;
        pixeles = new int[lado * lado];
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = color;
        }
    }

    /**
     * Devuelve el valor de el lado.
     *
     * @return
     */
    public int getLado() {
        return lado;
    }

    /**
     * Carga un Sprite predeterminado.
     *
     * @param lado
     * @param columna
     * @param fila
     * @param hoja
     */
    public Sprite(int lado, final int columna, final int fila, final HojaSprites hoja) {
        this.lado = lado;

        pixeles = new int[lado * lado];

        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;

        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    }
}
