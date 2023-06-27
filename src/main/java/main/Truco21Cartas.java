package main;

import java.util.Random;

public class Truco21Cartas {

    public static void main(String[] args) {
        final short MAX_TARJETAS_GRUPO= 7; // Tarjetas por grupo.
        final short MAX_GRUPOS= 3; // Cantidad de grupos.
        final short MAX_TARJETAS= MAX_TARJETAS_GRUPO*MAX_GRUPOS; //Total de tarjetas.
        final short MIN_TARJETA_VALOR='A';
        final short MAX_TARJETA_VALOR= (char)(MAX_TARJETAS+(int)('A')-1); //Tarjeta final.
        var generadorCarta= new Random();
        char carta;
        int i,j,indice;
        
        
        char[] grupo1= new char[MAX_TARJETAS_GRUPO],
               grupo2= new char[MAX_TARJETAS_GRUPO],
               grupo3= new char[MAX_TARJETAS_GRUPO];
        char[] deck= new char[MAX_TARJETAS];
        
        //Generar letras al azar:
        for(i=0; i<MAX_TARJETAS; i++){
            carta= (char)(generadorCarta.nextInt(MAX_TARJETA_VALOR-(int)(MIN_TARJETA_VALOR)+1)+(int)(MIN_TARJETA_VALOR));
            j=0;
            while(j<i){
                if(deck[j]==carta){
                    j=0;
                    carta= (char)(generadorCarta.nextInt(MAX_TARJETA_VALOR-(int)(MIN_TARJETA_VALOR)+1)+(int)(MIN_TARJETA_VALOR));
                } else{
                    j++;
                }
            }
            deck[i]=carta;
        }
        
        //Asignar cartas a las celdas de los grupos
        j=0;
        for (i=0; i<MAX_GRUPOS; i++) {
            indice=0;
            while(indice<7){
                switch (i) {
                    case 0:
                        grupo1[indice]=deck[j];
                        indice++;
                        j++;
                        break;
                    case 1:
                        grupo2[indice]=deck[j];
                        indice++;
                        j++;
                        break;
                    case 2:
                        grupo3[indice]=deck[j];
                        indice++;
                        j++;
                        break;
                    default:
                        break;
                }   
            }
        }
        
        // >>>Mostrar cartas
        for( char card : deck){
            System.out.print(card+" ");
        };
        
        System.out.println();
        
        for(char card1 : grupo1){
            System.out.print(card1+" ");
        }
        
        System.out.println();
        
        for(char card2 : grupo2){
            System.out.print(card2+" ");
        }
        
        System.out.println();
        
        for(char card3 : grupo3){
            System.out.print(card3+" ");
        }
        
    }
        
}
