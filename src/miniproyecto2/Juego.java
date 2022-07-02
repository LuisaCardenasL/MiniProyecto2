package miniproyecto2;

import java.util.Random;

/**
 * @author Luisa Maria Cardenas Lopez - 1823494 - cardenas.luisa@correounivalle.edu.co
 * @author Alejandro Tapiero Triana - 202043737 - alejandro.tapiero@correounivalle.edu.co
 */
public class Juego {
    private int cartasEnJuego[] = new int[16];
    private int cartasPareja[] = new int[8];
    
    public Juego(){
    }
        
    private void cartasAleatorio(){
        cartasID(cartasEnJuego);
        cartasID(cartasPareja);
        
        int nuevoID;
        Random aleatorio = new Random();
        
        for (int i = 0; i < cartasEnJuego.length; i++){
            nuevoID = aleatorio.nextInt(8)+1;
            
            if(cartasPareja[nuevoID] < 2){
                cartasEnJuego[i] = nuevoID;
                cartasPareja[nuevoID]++;
            }else{
                i--;
            }
        }
    }
    
    private void cartasID(int [] cartas){
        for(int i = 0; i<cartas.length; i++){
            cartas[i]=0;
        }
    }
}

