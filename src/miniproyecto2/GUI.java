package miniproyecto2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * @author Luisa Maria Cardenas Lopez - 1823494 - cardenas.luisa@correounivalle.edu.co
 * @author Alejandro Tapiero Triana - 202043737 - alejandro.tapiero@correounivalle.edu.co
 */
public class GUI extends JFrame{
    private BotonesPareja bPareja[];
    private JButton bAyuda, bInicio, bSalir;
    private JLabel lFallas, lOportunidades, lAciertos;
    private JPanel pNorte, pJuego, pSur, pOpciones, pInicio;
    private JComboBox cbTemas;
    private JMenuBar menuBar;
    private JMenu menuOpciones;
    
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
        bAyuda = new JButton("    Ayuda    ");
        bInicio = new JButton("Iniciar");
        bSalir = new JButton("      Salir      ");
        
        bAyuda.setBorder(null);
        bSalir.setBorder(null);
        
        lFallas = new JLabel("Fallas: ");
        lAciertos = new JLabel("Aciertos: ");
        lOportunidades = new JLabel("Oportunidades: ");
        
        //Colecciones
        String[] tiposC = {"Seleccione una opcion", "Carnes","Dulces","Frutas","Verduras"};
        cbTemas = new JComboBox<>(tiposC);
        
        pNorte = new JPanel(new GridLayout(2,1));
        pJuego = new JPanel(new GridLayout(4,4,3,3));
        pSur = new JPanel(new GridLayout(1,3));
        pOpciones = new JPanel(new GridLayout(1,1));
        pInicio = new JPanel(new GridLayout(1,2));
        
        for (int i =0; i < bPareja.length; i++)
        {
            bPareja[i] = new BotonesPareja(i);
            pJuego.add(bPareja[i]);
        }
        
        menuBar = new JMenuBar();
        
        menuOpciones = new JMenu("Opciones");
        menuOpciones.add(bAyuda);
        menuOpciones.add(bSalir);
        
        menuBar.add(menuOpciones);
        
        pOpciones.add(menuBar);
        
        pInicio.add(cbTemas);
        pInicio.add(bInicio);
        
        pNorte.add(pOpciones);
        pNorte.add(pInicio);
        
        pSur.add(lOportunidades);
        pSur.add(lAciertos);
        pSur.add(lFallas);
        
        add(pNorte, BorderLayout.NORTH);
        add(pJuego, BorderLayout.CENTER);
        add(pSur, BorderLayout.SOUTH);
        
        for(int i = 0; i<bPareja.length; i++){
            bPareja[i].setEnabled(false);
        }
        
        //escuchas
        ManejaEventos evento = new ManejaEventos();
        bAyuda.addActionListener(evento);
        bSalir.addActionListener(evento);
        bInicio.addActionListener(evento);
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
