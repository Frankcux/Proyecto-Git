
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Premios {
    private int id;
    private int lugar;
    private String descripcion;
    private int idConcurso;
    private Concurso concurso;
    
    public Premios(int id, int lugar, String des, int idConc){
        this.id = id;
        this.lugar= lugar;
        this.descripcion = des;
        this.idConcurso = idConc;
    }
 
    // Getters
    
    public int getId() {
        return id;
    }
    public int getLugar() {
        return lugar;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getIdConcurso() {
        return idConcurso;
    }
    public Concurso getConcurso() {
        return concurso;
    }
    //Setters
    
    public void setId(int id) {
        this.id = id;
    }
    public void setLugar(int lugar) {
        this.lugar = lugar;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    @Override
    
    public String toString() {
        return "Premios{" + "id=" + id + ", lugar=" + lugar + ", descripcion=" + descripcion + ", idConcurso=" + idConcurso + ", concurso=" + concurso + '}';
    }
    @Override
    
    public boolean equals(Object o) {
        if( o != null && o instanceof Premios){
            Premios p2 = (Premios)o;
            return (this.descripcion.equals(p2.descripcion)) ;
        }return false;
    }
    
    public void  saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id + "|"+ this.lugar+ "|" + this.descripcion + "|"+ this.idConcurso);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
    public static void saveFile(ArrayList<Premios> premios, String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile))))
        {
           for( Premios p: premios)
               pw.println(p.id + "|"+ p.lugar+ "|" + p.descripcion + "|"+ p.idConcurso); 
        } catch(Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    public static ArrayList<Premios> readFromFile(String nomfile){
        ArrayList<Premios> premios = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomfile)))
        {
            while(sc.hasNextLine())
            {
                // linea = id|lugar|descripcion|idConcurso
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                // int id,int lugar,String descripcion,int idconcurso
                Premios p = new Premios(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),tokens[2],Integer.parseInt(tokens[3]));
                premios.add(p);
            }
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            
        }
        return premios;
    
    }
    public static Premios nextVector(Scanner sc){
        
        int id, lugar,idConcurso ;
        String descrip;
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);
        System.out.println("Ingrese el id del premio: ");
        id = sc.nextInt();
        System.out.println("Ingrese el lugar de ese premio: ");
        lugar = sc.nextInt();
        System.out.println("Ingrese la descripción del premio: ");
        descrip = sc.next();
        System.out.println("Ingrese el id del Concurso al que pertenece ese premio");
        idConcurso = sc.nextInt();
        
        Premios premio = new Premios(id,lugar,descrip,idConcurso);
        return premio;
        
    }
    
    
    
    
    
}
