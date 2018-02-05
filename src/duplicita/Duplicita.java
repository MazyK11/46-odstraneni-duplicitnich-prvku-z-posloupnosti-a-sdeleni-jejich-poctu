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
        int k = 2;
//      p - pole pro posloupnost
        int p [] = new int [(int) Math.pow(10,k)];
//      identifikační pomocné pole 
        int[] id = new int [p.length];
        rnd(k,p,id);
//      výpis pole pro vizuální kontrolu u malé posloupnosti        
        System.out.print("Posloupnost\n");        
        for(int i = 0;i<p.length;i++){
            System.out.format("%d ",p[i]);
        }
//      volání metody selectsort
        selectsort(p,id);
//      pole pro čísla bez duplicitních čísel
        int pp [] = new int [p.length];
        int[] idid = new int [id.length];
        int count = hledaniduplicit(p,pp,idid,id);
//      pole, do kterých se nahrají zkrácené posloupnosti bez duplicitních čísel
//      tím zmizí prázdné hodnoty na konci pole
        int posloupnost[] = new int [p.length-count];
        int idcislo[] = new int [id.length-count];
        for(int i = 0;i<posloupnost.length;i++){
            posloupnost[i] = pp[i];
            idcislo[i] = idid[i];
        }
//      volání selectsort s vyměněnými proměnnými
//      ID čísla vrátí seřazenou posloupnost zpátky do původního stavu bez
//      duplicitních čísel
        selectsort(idcislo,posloupnost);
//      výpis pole pro vizuální kontrolu u malé posloupnosti  
        System.out.print("\n");
        System.out.print("Posloupnost bez duplicitních čísel\n");
        for(int i = 0;i<posloupnost.length;i++){
            System.out.format("%d ",posloupnost[i]);
        } 
        System.out.print("\n");
        System.out.format("Počet odstraněných duplicitních"
                + " čísel je %d\n",count);
    }
    /** Metoda pro generování náhodných čísel pro posloupnost
     * @param k - exponent
     * @param p - pole reprezentující posloupnost
     * @param id - identifikační pomocné pole
     */    
    public static void rnd(int k, int p[], int[] id){
        Random numbers = new Random();
        for(int i =0;i<Math.pow(10,k);i++){
//          upravitelný interval čísel pro generování 
            p[i] = numbers.nextInt(100);
        }
//      naplnění pomocného pole
        for(int i = 0;i<id.length;i++){
                id[i] = i;
        }
    }
    /** Metoda, která vyhledá duplicitní prvky
     * @param p - pole posloupnosti
     * @param id - identifikační pomocné pole
     * @param pp - pole bez duplicitních čísel
     * @param idid - identifikační pole pro pole pp
     * vyhledá duplicitní prvky a zbylé prvky zapíše do nového pole
     * @return vrací počet duplicitních prvků
     */
    public static int hledaniduplicit(int p[], int[] pp, int idid[],
            int[] id){
        int count = 0;
        int k =1;
//      první číslo je stejné
        pp[0] = p[0];
        idid[0] = id[0];
        for(int j =0;j < p.length;j++){
            for(int i = 1+j;i < p.length;i++){
                if(p[j] == p[i]){
//                  počítadlo duplicitních čísel
                    count++;
//                  podmínka pro duplicitní čísla na konci posloupnosti
                    if(i == p.length-1){
                        j=p.length;
                    }
                }
//              přepisování do nového pole
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
    /** Metoda, která seřadí posloupnost pomocí principu select sort
     * @param p - pole posloupnosti
     * @param id - identifikační pomocné pole
     * seřadí vstupní pole pomocí hledání minima, které následně vymění s 
     * prvním prvkem. Při výměně dochází k identické výměně v identifikačním
     * poli.
     */
    public static void selectsort(int p[],int[] id){
        int min;
        int h = 0;
        for(int j =0;j < p.length;j++){
            min = p[j];
            h = j;
            for(int i = 0+j;i < p.length;i++){
                if(min > p[i]){
                   min = p[i];
                   h = i;
                }
//              řazení duplicitních prvků podle menšího ID  
                else if (min == p[i]){
                    if(id[h] > id[i]){
                        min = p[i];
                        h = i;
                    }
                }
            }
//          výměna prvků v obou polích
            int m  = p[j];int n = id[j];
            p[j] = p[h];id[j] = id[h];
            p[h] = m;id[h] = n; 
        }
    }
}
