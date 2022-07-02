package miniproyecto2;

import java.util.Random;
import java.util.random.RandomGenerator;

/**
 *
 * @author Lu
 */
public class Juego {
    int matriz [][] = new int [4][4];
    Random random;
    
    /**
     * Este metodo se ultiliza para obtener aleatorianmente las cartas y que estas aparezcan en diferentes lugares
     * Tambien se utiliza para que aparezcan dos veces la misma carta
     */
    private void cartasAleatorio(){
        int acumulador = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++){
                matriz[i][j] = 0;
        }
        
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++){
                matriz[i][j] = random.nextInt(8)+1;
                
                do{
                    acumulador = 0;
                    for (int k = 0; k < 4; k++)
                        for (int l = 0; l < 4; l++){
                                if(matriz[i][j] == matriz[k][l]){
                                    acumulador +=1;
                                }
                            }
                if(acumulador == 3){
                    matriz[i][j] = random.nextInt(8)+1;
                }
                }while (acumulador == 0);
            }
        }
}

