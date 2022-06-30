package miniproyecto2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
    private int caraCarta, numeroCartas, numeroParejas, numeroJugadas, cartaRevelada, pareja, bandera, juego, aciertos, fallas;
    private ArrayList<Integer> jugadaUsuario, almacenParejas;
    
    
    /**
     * Constructor de la clase
     */
    public GUI()
    {
        initComponents();
        jugadaUsuario = new ArrayList<>();
        almacenParejas = new ArrayList<>();
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
        numeroJugadas = 0;
        bPareja = new BotonesPareja[numeroCartas];
        bAyuda = new JButton("Ayuda");
        bInicio = new JButton("Iniciar");
        bSalir = new JButton("Salir");
        bOpcion1 = new JButton("Opcion 1");
        bOpcion2 = new JButton("Opcion 2");
        bOpcion3 = new JButton("Opcion 3");
        bOpcion4 = new JButton("Opcion 4");
        
        lFallas = new JLabel("Fallas: " + fallas);
        lAciertos = new JLabel("Aciertos: " + aciertos);
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

    /*private void juego(){
        
    }*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI obj = new GUI();
    }
    
    /**
     * Metodo para limpiar la GUI y dejarla como se encontraba inicialmente antes de jugar
     */
    public void limpiarGUI (){
        jugadaUsuario.clear();
        lFallas.setText("");
        lOportunidades.setText("");
        lAciertos.setText("");
    }
    
    class manejadoraEventos implements ActionListener, MouseListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == bInicio){
                
                //desactivar boton iniciar
                bInicio.setEnabled(false);
                
                //iniciar juego
                //juego(2);
                
                for (int i = 0; i < bPareja.length; i++){
                if (e.getSource() == bPareja[i] && cartaRevelada != 1) {
                    numeroJugadas++;//si se presiona 2 veces seguidas un label, se incrementa la posicion del arreglo
                    //bPareja[i] = 1;   //Voltear las cartas
                        if (numeroJugadas == 2){
                            if (bPareja[i] == bPareja[i]){
                                aciertos++;
                            }
                            else
                            {
                                //bPareja[i] = 0;   //Voltear las cartas
                                fallas++;
                            }
                        }
                    }
                } 
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
                
    }

    
}
