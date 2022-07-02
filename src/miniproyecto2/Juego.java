package miniproyecto2;

import java.util.Random;

/**
 *
 * @author Lu
 */
public class Juego {
    int mat [][] = new int [4][4];
    Random random;

    private void cartasAleatorio(){
        int acumulador = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++){
                mat[i][j] = 0;
        }

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++){
                mat[i][j] = random.nextInt(8)+1;

                do{
                    acumulador = 0;
                    for (int k = 0; k < 4; k++)
                        for (int l = 0; l < 4; l++){
                                if(mat[i][j] == mat[k][l]){
                                    acumulador +=1;
                                }
                            }
                if(acumulador == 3){
                    mat[i][j] = random.nextInt(8)+1;
                }
                }while (acumulador == 0);
            }
        }
}