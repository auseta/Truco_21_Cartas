package main;

import java.util.Random;
import java.util.Scanner;

public class Truco21Cartas {

    public static void main(String[] args) {
        final short MAX_TARJETAS_GRUPO= 7; // Tarjetas por grupo.
        final short MAX_GRUPOS= 3; // Cantidad de grupos.
        final short MAX_TARJETAS= MAX_TARJETAS_GRUPO*MAX_GRUPOS; //Total de tarjetas.
        final short MIN_TARJETA_VALOR='A';
        final short MAX_TARJETA_VALOR= (char)(MAX_TARJETAS+(int)('A')-1); //Tarjeta final.
        var generador= new Random();
        var entrada= new Scanner(System.in);
        String grupoSeleccionado;
        char tarjeta;
        int i,j,k,l;
        
        
        char[] grupo1= new char[MAX_TARJETAS_GRUPO], grupo2= new char[MAX_TARJETAS_GRUPO], grupo3= new char[MAX_TARJETAS_GRUPO];
        char[] deck= new char[MAX_TARJETAS];
        
        //Generar letras al azar:
        for(i=0; i<MAX_TARJETAS; i++){
            j=0;
            tarjeta= (char)(generador.nextInt(MAX_TARJETA_VALOR-(int)(MIN_TARJETA_VALOR)+1)+(int)(MIN_TARJETA_VALOR));
            while(j<i){
                if(deck[j]==tarjeta){
                    j=0;
                    tarjeta= (char)(generador.nextInt(MAX_TARJETA_VALOR-(int)(MIN_TARJETA_VALOR)+1)+(int)(MIN_TARJETA_VALOR));
                } else{
                    j++;
                }
            }
            deck[i]=tarjeta;
        }
        
        System.out.println();
        
        //Asignar cartas a las celdas de los grupos
        j=0;
        for (i=0; i<MAX_GRUPOS; i++) {
            k=0;
            while(k<MAX_TARJETAS_GRUPO){
                switch (i) {
                    case 0:
                        grupo1[k]=deck[j];
                        k++;
                        j++;
                        break;
                    case 1:
                        grupo2[k]=deck[j];
                        k++;
                        j++;
                        break;
                    case 2:
                        grupo3[k]=deck[j];
                        k++;
                        j++;
                        break;
                    default:
                        break;
                }   
            }
        }
        
        //--- MOSTRANDO DATOS ---
        System.out.print("Deck: ");
        for(char card:deck){
            System.out.print(card+" ");
        }
        System.out.println();
        
        System.out.print("Grupo 1: ");
        for(char card:grupo1){
            System.out.print(card+" ");
        }
        System.out.println();
        
        System.out.print("Grupo 2: ");
        for(char card:grupo2){
            System.out.print(card+" ");
        }
        System.out.println();
        
        System.out.print("Grupo 3: ");
        for(char card:grupo3){
            System.out.print(card+" ");
        }
        System.out.println();
        //---FIN: MOSTRANDO DATOS ---
        
        var numero="3";
        
        System.out.println("Haremos 3 secuencias. Empecemos...");               
        for(i=0; i<MAX_GRUPOS;i++){
            System.out.println("Secuencia "+(i+1)+" :");
            //--- IMPRIME LA SECUENCIA EN PANTALLA ---
            for(j=0; j<MAX_TARJETAS_GRUPO;j++){
                System.out.println("\t\t"+grupo1[j]+"   "+grupo2[j]+"   "+grupo3[j]);
                System.out.println();
            }
            // --- FIN: IMPRIME LA SECUENCIA EN PANTALLA ---
            System.out.print("En que grupo esta tu tarjeta [1,2,3]: ");
            grupoSeleccionado= entrada.nextLine();
            while(!grupoSeleccionado.equals("1") && !grupoSeleccionado.equals("2") && !grupoSeleccionado.equals("3")){
                System.out.print("ERROR - Opcion incorrecta, ingresa una opcion valida [1,2,3]: ");
                grupoSeleccionado= entrada.nextLine();
            }
        }
    }
}
