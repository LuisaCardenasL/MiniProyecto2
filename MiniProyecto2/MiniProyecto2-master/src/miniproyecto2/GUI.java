package miniproyecto2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Lu
 * @author Ale
 */
public class GUI extends JFrame{
    private BotonesPareja bPareja[];
    private JButton bAyuda, bInicio, bSalir, bOpcion1, bOpcion2, bOpcion3, bOpcion4;
    private JLabel lFallas, lOportunidades, lAciertos;
    private JPanel pNorte, pCentro, pMenu, pOpciones, pParejas, pAyudaJuego, pMenuNorte, pMenuSur;
    /*private ArrayList baraja1, baraja2, baraja3, baraja4;//Baraja con todas las cartas*/
    private int caraCarta, numeroCartas, numeroParejas;
    
    
    /**
     * Constructor de la clase
     */
    public GUI()
    {
        initComponents();
        //contruccion del frame
        setTitle("Juego Concentrese");
        setSize(700,400);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
    //inicializar componentes
    private void initComponents(){
        numeroCartas = 16;
        bPareja = new BotonesPareja[numeroCartas];
        bAyuda = new JButton("Ayuda");
        bInicio = new JButton("Iniciar");
        bSalir = new JButton("Salir");
        bOpcion1 = new JButton("Opcion 1");
        bOpcion2 = new JButton("Opcion 2");
        bOpcion3 = new JButton("Opcion 3");
        bOpcion4 = new JButton("Opcion 4");
        
        lFallas = new JLabel("Fallas: ");
        lAciertos = new JLabel("Aciertos: ");
        lOportunidades = new JLabel("Oportunidades: ");
        
        pNorte = new JPanel(new GridLayout(1,2));
        pCentro = new JPanel(new GridLayout(1,2));
        pMenu = new JPanel(new BorderLayout());
        pOpciones = new JPanel(new GridLayout(4,1));
        pParejas = new JPanel(new GridLayout(4,4,3,3));
        pAyudaJuego = new JPanel(new GridLayout(3,1));
        pMenuNorte = new JPanel(new GridLayout(1,2));
        pMenuSur = new JPanel(new BorderLayout());
        
        pMenuNorte.add(bAyuda);
        pMenuNorte.add(bSalir);
        
        pMenuSur.add(bInicio);
        
        pMenu.add(pMenuNorte, BorderLayout.NORTH);
        pMenu.add(pMenuSur, BorderLayout.CENTER);
        
        pOpciones.add(bOpcion1);
        pOpciones.add(bOpcion2);
        pOpciones.add(bOpcion3);
        pOpciones.add(bOpcion4);
        
        for (int i =0; i < bPareja.length; i++)
        {
            bPareja[i] = new BotonesPareja(i);
            pParejas.add(bPareja[i]);
        }
        
        pAyudaJuego.add(lFallas);
        pAyudaJuego.add(lOportunidades);
        pAyudaJuego.add(lAciertos);
        
        pNorte.add(pMenu);
        pNorte.add(pOpciones);
        
        pCentro.add(pParejas);
        pCentro.add(pAyudaJuego);
        
        add(pNorte, BorderLayout.NORTH);
        add(pCentro, BorderLayout.CENTER);
        
    }
    
    /*private void agregarPareja() { //Nota de Ale: Realmente esto se puede quitar porque es un ejemplo con arraylists, pero sé que se puede manejar con botones, como ya hiciste arriba
        int aleatorio;//Para seleccionar la posición en el array de parejas
        String nuevaCarta;
        for (int i = 0; i < NUM_CARTAS / 2; i++) {//HAY QUE HACER NUM_CARTAS/2 PARES
            //Se genera la nueva carta
            nuevaCarta = generarCartaNoUsada();
            //Se busca una posición libre en parejas y se agrega la carta (2 veces)
            for (int j = 0; j < 2; j++) {
                do {
                    aleatorio = (int) (Math.random() * NUM_CARTAS);
                    if (parejas.get(aleatorio) == null) {
                        parejas.set(aleatorio, nuevaCarta);
                        break;
                    }
                } while (parejas.get(aleatorio) != null);
            }
        }
    }
    */


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI obj = new GUI();
    }
    
    class manejadoraEventos implements ActionListener, MouseListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            /*int posicion = ((Carta) e.getComponent()).getPos();
                    if (estado[posicion] == REVERSO) {
                        estado[posicion] = ANVERSO; //Voltear la carta. Nota de Ale: Me imagino que en vez del estado[posición], será con un cambio de imagen, y creo que un boolean o un flag a cada carta individual de si está "volteada" o no.
                        ((JLabel) e.getComponent()).setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/" + parejas.get(posicion))));
                        if (primeraJLabel == null) { 
                            //Ha levantado la primera carta
                            primeraJLabel = (JLabel) e.getComponent();
                            primeraNombre = parejas.get(posicion);
                            primeraIndice = posicion;
                        } else {
                            //Ha levantado la segunda carta
                            if (!parejas.get(posicion).equals(primeraNombre)) {
                                //No hay pareja, esperamos y damos la vuelta
                                new Thread() {
                                    public void run() {
                                        try {
                                            Thread.sleep(4000); //Los 4 segundos que permanece la carta expuesta
                                            ((JLabel) e.getComponent()).setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/back.gif")));
                                            primeraJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/back.gif")));
                                            primeraJLabel = null;
                                            primeraNombre = null;
                                            primeraIndice = -1;
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }.start();
                                //Las dejo en estado REVERSO (Nota de Ale: Por esto decía lo de poner booleano o flag)
                                estado[posicion] = REVERSO;
                                estado[primeraIndice] = REVERSO;
                            } else {
                                //Hay pareja. Hacemos reset y contamos +1
                                primeraJLabel = null;
                                primeraNombre = null;
                                primeraIndice = -1;
                                numeroParejas++;
                                if (numeroParejas==numeroCartas/2){
                                    /*JOptionPane.showMessageDialog(PantallaJuego.this,"¡ENHORABUENA!", 
                                    "EmparejadosJ23", JOptionPane.INFORMATION_MESSAGE);*/ //Nota de Ale: Declaración de victoria.
                                /*}
                            }
                            
                        }
                    }*/
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    
    }
    
}
