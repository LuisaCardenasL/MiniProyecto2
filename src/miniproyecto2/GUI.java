package miniproyecto2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * @author Luisa Maria Cardenas Lopez - 1823494 - cardenas.luisa@correounivalle.edu.co
 * @author Alejandro Tapiero Triana - 202043737 - alejandro.tapiero@correounivalle.edu.co
 */
public class GUI extends JFrame{
    private BotonesPareja bPareja[];
    private JButton bAyuda, bInicio, bSalir, bOpcion1, bOpcion2, bOpcion3, bOpcion4;
    private JLabel lFallas, lOportunidades, lAciertos;
    private JPanel pNorte, pCentro, pMenu, pOpciones, pParejas, pAyudaJuego, pMenuNorte, pMenuSur;
    
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
        bPareja = new BotonesPareja[16];
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
        
        bOpcion1.setEnabled(false);
        bOpcion2.setEnabled(false);
        bOpcion3.setEnabled(false);
        bOpcion4.setEnabled(false);
        for(int i = 0; i<bPareja.length; i++){
            bPareja[i].setEnabled(false);
        }
        
        //escuchas
        ManejaEventos evento = new ManejaEventos();
        bAyuda.addActionListener(evento);
        bSalir.addActionListener(evento);
        bInicio.addActionListener(evento);
        bOpcion1.addActionListener(evento);
        bOpcion2.addActionListener(evento);
        bOpcion3.addActionListener(evento);
        bOpcion4.addActionListener(evento);
        for(int i = 0; i<bPareja.length; i++){
            bPareja[i].addActionListener(evento);
        }
    }

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
        lAciertos.setText("");
        lFallas.setText("");
        lOportunidades.setText("");
        bOpcion1.setEnabled(false);
        bOpcion2.setEnabled(false);
        bOpcion3.setEnabled(false);
        bOpcion4.setEnabled(false);
        for(int i = 0; i<bPareja.length; i++){
            bPareja[i].setEnabled(false);
        }
    }
    
    class ManejaEventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
    }
    
}
