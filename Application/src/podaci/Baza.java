package podaci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


    
    public class Baza {
    public static Connection conn;
    public static void connect() throws SQLException{
        conn = DriverManager.getConnection("jdbc:mysql://localhost/application", "root","");
    }
    
    public static void disconnect() throws SQLException{
        conn.close();
        conn = null;
    } 
    
     public Klijent uzmiKlijenta(int id_klijent) throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("select * from klijent where id_klijent = ?");
        st.setInt(1,id_klijent);
        Klijent rezultat = null;
        
        ResultSet sr = st.executeQuery();
        if(sr.next()){
            rezultat = new Klijent();
            rezultat.id_klijent = sr.getInt("id_klijent");
            rezultat.ime_i_prezime = sr.getString("ime_i_prezime");
            rezultat.ocena = sr.getInt("ocena");
            rezultat.mesto_odlaska = sr.getString("mesto_odlaska");
            rezultat.id_kamion = sr.getInt("id_kamion");
            rezultat.naziv_kamiona = sr.getString("naziv_kamiona");
            rezultat.id_popravka = sr.getInt("id_popravka");
        }
       
        disconnect();
        
        return rezultat;
     }
    
    
    public List uzmiKlijente() throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("select * from klijent");
        
        List rezultat = new ArrayList();
        
        ResultSet sr = st.executeQuery();
        while(sr.next()){
            Klijent k = new Klijent();
            k.id_klijent = sr.getInt("id_klijent");
            k.ime_i_prezime = sr.getString("ime_i_prezime");
            k.ocena = sr.getInt("ocena");
            k.mesto_odlaska = sr.getString("mesto_odlaska");
            k.id_kamion = sr.getInt("id_kamion");
            k.naziv_kamiona = sr.getString("naziv_kamiona");
            k.id_popravka = sr.getInt("id_popravka");
            rezultat.add(k); 
        }
       
        disconnect();
        
        return rezultat;
     }
    
    public void obrisiKlijenta(int id_klijent) throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("delete from klijent where id_klijent = ?");
        st.setInt(1, id_klijent);
        st.execute();
        disconnect();
    }
    public void izmeniKlijenta(Klijent k) throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("update klijent set ime_i_prezime = ?, ocena = ?, mesto_odlaska = ?, id_kamion = ?, naziv_kamiona = ?, id_popravka = ? where id_klijent = ?");
        st.setString(1, k.ime_i_prezime);
        st.setInt(2, k.ocena);
        st.setInt(3, k.id_klijent);
        st.setString(4, k.mesto_odlaska);
        st.setInt(5, k.id_kamion);
        st.setString(6, k.naziv_kamiona);
        st.setInt(7, k.id_popravka);
        st.execute();
        disconnect();
    }
    
    public void unesiKlijenta(Klijent k) throws SQLException{
        connect();
       PreparedStatement st = conn.prepareStatement("insert into klijent values(null,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
       st.setString(1, k.ime_i_prezime);
       st.setInt(2, k.ocena);
       st.setString(3, k.mesto_odlaska);
       st.setInt(4, k.id_kamion);
       st.setString(5, k.naziv_kamiona);
       st.setInt(6, k.id_popravka);
       st.execute();
       
       ResultSet keys = st.getGeneratedKeys();
       if(keys.next()){
           k.id_klijent = keys.getInt(1);
       }
       disconnect();
    }
    // dovde je Noco za Klijenta povezivanje sa bazom a dole je za popravku
    
    public Popravka uzmiPopravku(int id_popravka) throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("select*from popravka where id_popravka = ?");
        st.setInt(1,id_popravka);
        Popravka rezultat = null;
        
        ResultSet sr = st.executeQuery();
        if(sr.next()){
            rezultat = new Popravka();
            rezultat.id_popravka = sr.getInt("id_popravka");
            rezultat.kvar = sr.getString("kvar");
            rezultat.datum = sr.getString("datum");
            rezultat.cena = sr.getString("cena");
            rezultat.id_klijent = sr.getInt("id_klijent");
            rezultat.id_kamion = sr.getInt("id_kamion");
        }
       
        disconnect();
        
        return rezultat;
     }
    
    
    public List uzmiPopravke() throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("select * from popravka");
        
        List rezultat = new ArrayList();
        
        ResultSet sr = st.executeQuery();
        while(sr.next()){
            Popravka p = new Popravka();
            p.id_popravka = sr.getInt("id_popravka");
            p.kvar = sr.getString("kvar");
            p.datum = sr.getString("datum");
            p.cena = sr.getString("cena");
            p.id_klijent = sr.getInt("id_klijent");
            p.id_kamion = sr.getInt("id_kamion");
            rezultat.add(p); 
        }
       
        disconnect();
        
        return rezultat;
     }
    
    public void obrisiPopravku(int id_popravka) throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("delete from popravka where id_popravka = ?");
        st.setInt(1, id_popravka);
        st.execute();
        disconnect();
    }
    public void izmeniPopravku(Popravka p) throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("update popravka set kvar = ?, datum = ?, cena = ?, id_klijent = ?, id_kamion = ? where id_popravka = ?");
        st.setString(1, p.kvar);
        st.setString(2, p.datum);
        st.setString(3, p.cena);
        st.setInt(4, p.id_klijent);
        st.setInt(5, p.id_kamion);
        st.setInt(6, p.id_popravka);
        st.execute();
        disconnect();
    }
    
    public void unesiPopravku(Popravka p) throws SQLException{
        connect();
       PreparedStatement st = conn.prepareStatement("insert into popravka values(null,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
       st.setString(1, p.kvar);
       st.setString(2, p.datum);
       st.setString(3, p.cena);
       st.setInt(4, p.id_klijent);
       st.setInt(5, p.id_kamion);
       st.execute();
       
       ResultSet keys = st.getGeneratedKeys();
       if(keys.next()){
           p.id_popravka = keys.getInt(1);
       }
       disconnect();
    }
    
     public Kamion uzmiKamion(int id_kamion) throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("select * from kamion where id_kamion = ?");
        st.setInt(1,id_kamion);
        Kamion rezultat = null;
        
        ResultSet sr = st.executeQuery();
        if(sr.next()){
            rezultat = new Kamion();
            rezultat.id_kamion = sr.getInt("id_kamion");
            rezultat.proizvodjac = sr.getString("proizvodjac");
            rezultat.id_klijent = sr.getInt("id_klijent");
            rezultat.id_popravka = sr.getInt("id_popravka");
        }
       
        disconnect();
        
        return rezultat;
     }
    
    
    public List uzmiSveKamione() throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("select * from kamion");
        
        List rezultat = new ArrayList();
        
        ResultSet sr = st.executeQuery();
        while(sr.next()){
            Kamion k = new Kamion();
            k.id_kamion = sr.getInt("id_kamion");
            k.proizvodjac = sr.getString("proizvodjac");
            k.id_klijent = sr.getInt("id_klijent");
            k.id_popravka = sr.getInt("id_popravka");
            rezultat.add(k); 
        }
       
        disconnect();
        
        return rezultat;
     }
    
    public void obrisiKamion(int id_kamion) throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("delete from kamion where id_kamion = ?");
        st.setInt(1, id_kamion);
        st.execute();
        disconnect();
    }
    public void izmeniKamion(Kamion k) throws SQLException{
        connect();
        
        PreparedStatement st = conn.prepareStatement("update kamion set proizvodjac = ?, id_klijent = ?, id_popravka = ? where id_kamion = ?");
        st.setString(1, k.proizvodjac);
        st.setInt(2, k.id_klijent);
        st.setInt(3, k.id_popravka);
        st.setInt(3, k.id_kamion);
        st.execute();
        disconnect();
    }
    
    public void unesiKamion(Kamion k) throws SQLException{
        connect();
       PreparedStatement st = conn.prepareStatement("insert into kamion values(null,?,?,?)",Statement.RETURN_GENERATED_KEYS);
       st.setString(1, k.proizvodjac);
       st.setInt(2, k.id_klijent);
       st.setInt(3, k.id_popravka);
       st.execute();
       
       ResultSet keys = st.getGeneratedKeys();
       if(keys.next()){
           k.id_kamion = keys.getInt(1);
       }
       disconnect();
    }
}

