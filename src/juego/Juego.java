package juego;

import control.Teclado;
import graficos.Pantalla;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import mapa.Mapa;
import mapa.MapaGenerado;

public class Juego extends Canvas implements Runnable{ //con el implements ponemos una interfaz para poder generar procesos seguidos.

    private static JFrame ventana;
    private static Thread thread; //creamos el thread
    private static Teclado teclado; // ACCIONES DEL TECLADO
    private static Pantalla pantalla;
    
    private static Mapa mapa;
    
    private BufferedImage imagen = new BufferedImage(ANCHO,ALTO,BufferedImage.TYPE_INT_RGB);
    
    private int[]pixeles = ((DataBufferInt)imagen.getRaster().getDataBuffer()).getData(); //devuelve un array de int que representa los pixeles de la imagen
    
    private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/icono/logo.png"));
    
    private static volatile boolean enFuncionamiento = false; //Nos dice si se está iniciando (el tipo volatile sirve para que no se pueda utilizar el método de forma simultánea y evitar crasheos)
    
    private static final int ANCHO = 1000;
    private static final int ALTO = 650;
    
    private static final String NOMBRE = "Placidium";
    
    private static String contAPS = "";
    private static String contFPS = "";
    
    private static int aps = 0;
    private static int fps = 0;
    
    private static int x=0;
    private static int y=0;
    
    
    private Juego(){
        setPreferredSize(new Dimension(ANCHO,ALTO));
        
        pantalla = new Pantalla(ANCHO,ALTO); //iniciamos la pantalla
        
        mapa = new MapaGenerado(128,128);
        
        teclado = new Teclado();
        addKeyListener(teclado);
        
        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //El usuario podrá cerrar la ventana al pulsar "x"
        ventana.setResizable(false); //El usuario no podrá cambiar el tamaño de la ventana
        ventana.setIconImage(icono.getImage()); //Pone un ícono
        ventana.setLayout(new BorderLayout());  //Para dejar ordenada la ventana
        ventana.add(this, BorderLayout.CENTER); //Para que la ventana se abra justo en el centro
        ventana.setUndecorated(true); // Ventana sin bordes
        ventana.pack(); //TODO EL CONTENIDO SE AJUSTA AL TAMAÑO DESEADO
        ventana.setLocationRelativeTo(null); //Fija la ventana
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
            Juego juego = new Juego();
            juego.iniciar();
            
    }
    
//threads a ejecutarse en segundo plano y que harán que "se ejecuten varios procesos a la vez"
    private synchronized void iniciar(){ //similar a volatile synchronized evita que se utilizen los métodos a la vez
        enFuncionamiento = true;
        
        thread = new Thread(this, "Gráficos");
        thread.start();
    }
    private synchronized void detener(){
        enFuncionamiento = false;
        
        try {
            thread.join(); //no para de inmediato el thread y espera a que se terminen de ocupar los demás hilos que sí lo estén ocupando. 
        } catch (InterruptedException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Verifica todos los eventos del teclado.
     */
    private void actualizar(){
        teclado.actualizar();
        
        if(teclado.arriba){
            y--;
        }
        if(teclado.abajo){
            y++;
        }
        if(teclado.izquierda){
            x--;
        }
        if(teclado.derecha){
            x++;
        }

        if (teclado.shift && teclado.arriba) {
            y = y - 1;
        }
        if (teclado.shift && teclado.abajo) {
            y = y + 1;
        }
        if (teclado.shift && teclado.izquierda) {
            x = x - 1;
        }
        if (teclado.shift && teclado.derecha) {
            x = x + 1;
        }
        if(teclado.salir){
            System.exit(0);
        }
        
        aps++;
    }
    private void mostrar(){ //redibujar gráficos
        BufferStrategy estrategia = getBufferStrategy();
        
        if(estrategia == null){
            createBufferStrategy(3);
            return;
        }
        
        pantalla.limpiar();
        mapa.mostrar(x, y, pantalla);
        
        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length); //es un método más fácil para copiar los graficos de la pantalla al juego
        
        // for(int i=0;i<pixeles.length;i++){
        //     pixeles[i] = pantalla.pixeles[i];
        // }
        
        Graphics g= estrategia.getDrawGraphics(); //es el encargado de dibujar de la estrategia (buffer)
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        
        g.setColor(Color.WHITE); //PERSONAJE TEMPORAL :v
        g.fillRect(ANCHO/2,ALTO/2, 32, 32);
        g.drawString(contAPS, 10, 20);//dibuja un string en pantalla
        g.drawString(contFPS,10,35);
        
        g.dispose(); //destruye la memoria que g estaba usando para que no use más y más memoria
        
        estrategia.show(); //hace que se muestre todo en pantalla
        
        fps++;
    }
    /**
     * método que se utilizará porque al no depender del sistema operativo para medir el tiempo transcurrido utiliza los nanosegundos del ciclo de reloj del procesador. Lo utilizamos además para mejorar la compatibilidad con los demás sistemas operativos (para que corra fluido en todos). También sirve para limitar el tiempo de ejecución del bucle.
     */
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000; //La cantidad de nanosegundos en un segundo.
        final byte APS_OBJETIVO = 60; //ENTRE MENOR EL NÚMERO DE ACTUALIZACIONES, ES MÁS EFICIENTE EL JUEGO, PERO TAMPOCO DEBE SER MUY BAJO. La cantidad de actualizaciones por segundo
        final double NS_POR_ACTUALIZACIÓN = NS_POR_SEGUNDO / APS_OBJETIVO; //CUANTOS NANO SEGUNDOS TIENEN QUE PASAR PARA ACTUALIZAR A 60 APS. La cantidad de nanosegundos que ocurren por atualización.
        
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        
        double tiempoTranscurrido; 
        double delta = 0; //cantidad de tiempo recorrido hasta que se realiza una actualización
        
        requestFocus(); //método por defecto de java que al añadirlo, hace que automáticamente la ventana que se cree sea el foco de uso y se pueda usar inmediatamente.
        
        while(enFuncionamiento){
            final long inicioBucle = System.nanoTime();
            
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
            
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACIÓN;
            
            while(delta >= 1){
                actualizar();
                delta --;
            }
            
            mostrar();
            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){
                contAPS = "APS: " + aps;
                contFPS = "FPS: " + fps;
//                ventana.setTitle(NOMBRE + " || APS: " + aps +  " || FPS: " + fps);
                aps = 0; //se reinicializan para que vuelva a contar y no tienda al infinito, lo mismo con fps.
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }

    }
    
}
