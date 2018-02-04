/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duplicita;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author MazyK
 */
public class Duplicita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//      exponent k, pro lehčí manipulaci s velikostí posloupnosti
        int k = 1;
        int p [] = new int [(int) Math.pow(10,k)];
        int[] id = new int [p.length];
        rnd(k,p,id);
//      výpis pole pro vizuální kontrolu u malé posloupnosti
        System.out.print("Posloupnost\n");        
        for(int i = 0;i<p.length;i++){
            System.out.format("%d ",p[i]);
        }
        System.out.print("\n");
        System.out.print("ID\n");
        for(int i = 0;i<id.length;i++){
            System.out.format("%d ",id[i]);
        }
//        reversesort(p,id);
//        System.out.print("\n");
//        System.out.print("ID setříděné\n");
//        for(int i = 0;i<id.length;i++){
//            System.out.format("%d ",id[i]);
//        }
//        System.out.print("\n");
//        System.out.print("Posloupnost setříděná\n");
//        for(int i = 0;i<p.length;i++){
//            System.out.format("%d ",p[i]);
//        }
        
        selectsort(p,id);
        
        System.out.print("\n");
        System.out.print("ID setříděné\n");
        for(int i = 0;i<id.length;i++){
            System.out.format("%d ",id[i]);
        }
        System.out.print("\n");
        System.out.print("Posloupnost setříděná\n");
        for(int i = 0;i<p.length;i++){
            System.out.format("%d ",p[i]);
        }
        
        int pp [] = new int [p.length];
        int[] idid = new int [id.length];
        
        int count = hledaniduplicit(p,pp,idid,id);
        
        int posloupnost[] = new int [p.length-count];
        int idcislo[] = new int [id.length-count];
        
        System.out.print("\n");
        System.out.print("Posloupnost bez double\n");
        for(int i = 0;i<posloupnost.length;i++){
            posloupnost[i] = pp[i];
            System.out.format("%d ",posloupnost[i]);
        }
        System.out.print("\n");
        System.out.print("ID duplicity\n");
        for(int i = 0;i<idcislo.length;i++){
            idcislo[i] = idid[i];
            System.out.format("%d ",idcislo[i]);
        }
        System.out.print("\n");
//        reversesort(idcislo,posloupnost);
//        
//        System.out.print("\n");
//        for(int i = 0;i<posloupnost.length;i++){
//            System.out.format("%d ",posloupnost[i]);
//        }
        selectsort(idcislo,posloupnost);
        System.out.print("\n");
        for(int i = 0;i<posloupnost.length;i++){
            System.out.format("%d ",posloupnost[i]);
        }
        System.out.print("\n");
        System.out.format("Počet odstraněných duplicitních čísel je %d\n",count);
    }
    /** Metoda pro generování náhodných čísel
     * @param k - exponent
     * @param p - pole reprezentující posloupnost
     */    
    public static void rnd(int k, int p[], int[] id){
        Random numbers = new Random();
        for(int i =0;i<Math.pow(10,k);i++){
//          upravitelný interval čísel pro generování 
            p[i] = numbers.nextInt(10);
        }
        for(int i = 0;i<id.length;i++){
                id[i] = i;
        }
    }
    /** Funkce, která provede algoritmus select sort
     * @param p - pole
     * setřídí vstupní pole pomocí hledání minima, které následně vymění s 
     * prvním prvkem
     */
    public static int hledaniduplicit(int p[], int[] pp, int idid[], int[] id){
        int count = 0;
        int k =1;
        pp[0] = p[0];
        idid[0] = id[0];
        for(int j =0;j < p.length;j++){
            for(int i = 1+j;i < p.length;i++){
                if(p[j] == p[i]){
                    count++;
                }
                else{
                    pp[k] = p[i];
                    idid[k] = id[i];
                    k++;
                    j = i-1;
                    break;
                }  
            }
        }
        return count;
    }
    /** Funkce, která provede algoritmus select sort
     * @param p - pole
     * setřídí vstupní pole pomocí hledání minima, které následně vymění s 
     * prvním prvkem
     */
    public static void selectsort(int p[],int[] id){
        int min;
        int h = 0;
        for(int j =0;j < p.length;j++){
            min = p[j];
            for(int i = 0+j;i < p.length;i++){
                if(min >= p[i]){
                   min = p[i];
                   h = i;
                }
            }
            int m  = p[j];int n = id[j];
            p[j] = p[h];id[j] = id[h];
            p[h] = m; id[h] = n; 
        }
    }
    public static void reversesort(int p[],int[] id){
        int min;
        int h = 0;
        for(int j =0;j < p.length;j++){
            min = p[p.length-1-j];
            for(int i = p.length-1-j;-1 < i;i--){
                if(min >= p[i]){
                   min = p[i];
                   h = i;
                }
            }
            int m  = p[p.length-1-j];int n = id[p.length-1-j];
            p[p.length-1-j] = p[h];id[p.length-1-j] = id[h];
            p[h] = m; id[h] = n; 
        }
    }
}
