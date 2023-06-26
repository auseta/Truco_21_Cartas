package main;

import java.util.Scanner;
import java.util.Random;

public class Truco21Cartas {

    public static void main(String[] args) {
        var entrada= new Scanner(System.in);
        var sorteador= new Random();
        int i, j;
        char[] arregloSinRepetir= new char[21];
        char carta;
        char[][] secuencia= new char[7][3];

        //Generador de caracteres aleatorios sin repetir
        for (i=0; i<21; i++) {
            carta= (char)(sorteador.nextInt(85-65+1)+65);
            j=0;
            while(j<i){
                if(arregloSinRepetir[j]==carta){
                    carta= (char)(sorteador.nextInt(85-65+1)+65);
                    j=0;
                } else {
                    j++;
                }
            }
            arregloSinRepetir[i]=carta;
        }
        
        System.out.println("Haremos 3 secuencias. Empecemos...");
    }
}
