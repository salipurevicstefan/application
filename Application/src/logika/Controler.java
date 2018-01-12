package logika;

import izgled.Izgled;
import java.sql.SQLException;
import java.util.List;
import podaci.Baza;
import podaci.Klijent;

public class Controler {
    izgled.Izgled izgled;
    podaci.Baza baza;
    
    public Controler(){ 
        izgled = new Izgled();
        baza = new Baza();
        
    }
    
    public void prikaziSveKlijente() throws SQLException{
        List sve = baza.uzmiKlijente();
        for(Object o : sve){
            Klijent k = (Klijent)o;
            System.out.println("Id klijenta: "+k.id_klijent+", Ime i prezime klijenta: "+k.ime_i_prezime);
        }
    }
    
    public void unesiKlijenta() throws SQLException{
        Klijent ZaUnos = izgled.uzmiKlijenta();
        baza.unesiKlijenta(ZaUnos);
    }
    
    public void izmeniKlijenta() throws SQLException{
        int id_klijent = izgled.uzmiBroj();
        Klijent k = baza.uzmiKlijenta(id_klijent);
        izgled.izmeniKlijenta(k);
        baza.izmeniKlijenta(k);
        
    }
    
    public void obrisiKlijenta() throws SQLException{
        int id_klijent = izgled.uzmiBroj();
        baza.obrisiKlijenta(id_klijent);
   
    }
    
    public void prikaziKlijenta() throws SQLException{
        int id_klijent = izgled.uzmiBroj();
        Klijent k = baza.uzmiKlijenta(id_klijent);
        
        if(k==null){
            System.out.println("Nepostojeci klijent!");
        } else {
            System.out.println("Id klijenta: "+k.id_klijent);
            System.out.println("Ime i prezime klijenta: "+k.ime_i_prezime);
            System.out.println("Ocena klijenta: "+k.ocena);
            System.out.println("Mesto odlaska do klijenta: "+k.mesto_odlaska);
            System.out.println("Id kamiona: "+k.id_kamion);
            System.out.println("Naziv kamiona: "+k.naziv_kamiona);
            System.out.println("id popravke: "+k.id_popravka);
            
        }
    }
    
    public static void run() throws SQLException{
        Controler c = new Controler(); 
        
        
        while(true){
        int odabranaStavka = c.izgled.meni();
        switch(odabranaStavka){
            case 1:
                c.unesiKlijenta();
                break;
            case 2:
                c.izmeniKlijenta();
                break;   
            case 3:
                c.obrisiKlijenta();
                break;
            case 4:
                c.prikaziKlijenta();
                break;
            case 5:
                c.prikaziSveKlijente();
                break;
                
             }
        }
    }
}


