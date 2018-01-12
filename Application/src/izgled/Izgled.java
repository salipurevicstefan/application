package izgled;

import java.util.Scanner;
import podaci.Klijent;

public class Izgled {
    
    
    public int meni(){
        System.out.println("1.Unos, 2.Izmena, 3.Brisanje, 4.Prikaz, 5.Prikaz svih");
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
    
    public int uzmiBroj(){
        System.out.println("Unesi id_klijent:");
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
    
    public void izmeniKlijenta(Klijent k){
       Scanner scanner = new Scanner(System.in);
       
       System.out.println("Unesi ime i prezime klijenta: ");
       k.ime_i_prezime = scanner.nextLine();
       
       
        System.out.println("Unesi ocenu klijenta: ");
        k.ocena = scanner.nextInt();
       
        System.out.println("Unesi mesto odlaska do klijenta: ");
        k.mesto_odlaska = scanner.nextLine();
        
        System.out.println("Unesi id_kamiona: ");
        k.id_kamion = scanner.nextInt();
        
        System.out.println("Unesi naziv kamiona: ");
        k.naziv_kamiona = scanner.nextLine();
        
        System.out.println("Unesi id_popravke: ");
        k.id_popravka = scanner.nextInt();
    }
    
    public Klijent uzmiKlijenta(){
        
        Scanner scanner = new Scanner(System.in);
        Klijent rezultat = new Klijent();
        
        
        System.out.println("Unesi ime_i_prezime klijenta: ");
        rezultat.ime_i_prezime = scanner.nextLine();
       
        System.out.println("Unesi ocenu klijenta: ");
        rezultat.ocena = scanner.nextInt();
       
        System.out.println("Unesi mesto odlaska do klijenta: ");
        rezultat.mesto_odlaska = scanner.nextLine();
        
        System.out.println("Unesi id kamiona: ");
        rezultat.id_kamion = scanner.nextInt();
        
        System.out.println("Unesi naziv kamiona: ");
        rezultat.naziv_kamiona = scanner.nextLine();
        
        System.out.println("Unesi id popravke: ");
        rezultat.id_popravka = scanner.nextInt();
       
       return rezultat;
    } 
   } 



