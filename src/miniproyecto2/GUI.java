package miniproyecto2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
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
    private int cartasEnJuego[] = new int[16];
    private int cartasPareja[] = new int[8];

    
    public GUI()
    {
        initComponents();
        //contruccion del frame
        setTitle("Juego Concentrese");
        setSize(700,400);
        //setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
    //inicializar componentes
    private void initComponents(){
        
        bAyuda = new JButton("     Ayuda     ");
        bInicio = new JButton("Iniciar");
        bSalir = new JButton("      Salir       ");
        bPareja = new BotonesPareja[16];
        
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
    
    class ManejaEventos implements ActionListener, MouseListener{
        
        Timer tiempoEspera;
        Juego juego;
        
        public ManejaEventos(){
            juego = new Juego();
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==bInicio){
                
                String seleccionOpcion = "";
                
                seleccionOpcion = cbTemas.getSelectedItem().toString();
                
                if(seleccionOpcion.equals("Seleccione una opcion")){
                    
                }else{
                    for(int i = 0; i<bPareja.length; i++){
                        bPareja[i].setIcon(new ImageIcon("src/imagenes/"+seleccionOpcion+"/"+2+".png"));
                        bInicio.setEnabled(false);
                        cbTemas.setEnabled(false);
                        bPareja[i].setEnabled(true);
                    }
                }
            }
            if (e.getSource()==bSalir) {
                JOptionPane.showMessageDialog(null, "Seguro que quieres salir");
                System.exit(0);
            }
            if (e.getSource()== bAyuda) {
                JOptionPane.showMessageDialog(null, "Concentrese:\n"+
                                                    "Es un juego de memoria donde tendras 4 segundos para observar las imagenes\n"+
                                                    "Una vez pasado este tiempo tienes 4 oportunidades para encontrar su pareja\n"+
                                                    "De equivocarte las 4 veces perderas, pero tranquilo si pierdes puedes volver a intentarlo \n"+
                                                    "Buena suerte.");
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
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
