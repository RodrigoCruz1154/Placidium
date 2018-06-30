package graficos;
/**
 * Ensambla la imagen que se muestra en pantalla.
 */
public final class Pantalla {
    private final int ancho;
    private final int alto;
    
    public final int[] pixeles;
    
    
    //variables temporales
    private final static int LADO_SPRITE = 32;
    private final static int MASCARA_SPRITE = LADO_SPRITE-1;
    //fin
    
    public Pantalla(final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[ancho*alto];
    }
    
    public void limpiar(){ //método que nos servirá para limpiar lo que se ve en pantalla y cambiarlo por objetos nuevos
        for(int i=0; i<pixeles.length; i++){
            pixeles[i]=0; //expresamos a todos los int el valor 0, que representa al negro
        }
    }
    
    public void mostrar(final int compensacionX, final int compensacionY){ //los argumentos de éste método son los movimientos que  nosotros realizamos desde teclado, el movimiento del personaje
        for(int y=0; y<alto; y++){
            int posicionY = y+ compensacionY;
            if(posicionY < 0 || posicionY >= alto){
                continue; //al llegar a éste punto cortamos el bucle y pasamos al siguiente nivel (en éste caso el x) y evita que nos salgamos del mapa
            }
            
            for(int x=0;x<ancho;x++){
                int posicionX = x + compensacionX;
                if(posicionX < 0 || posicionX >= ancho){
                    continue;
                }
                
                //Sprite temporal
                pixeles[posicionX + posicionY * ancho] = Sprite.tierra.pixeles[(x&MASCARA_SPRITE)+(y&MASCARA_SPRITE)*LADO_SPRITE]; //CADA VEZ QIE X O Y SOBREPASEN EL TAMAÑO DESEADO, ÉSTAS VUELVEN A SER CERO
            }
        }
    }
}
