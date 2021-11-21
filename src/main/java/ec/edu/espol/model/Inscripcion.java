
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Inscripcion {
    private int id;
    private String fecha_inscripcion;
    private double valor;
    private int idMascota;
//    private Mascota mascota; ****************
    private int idConcurso;
    private Concurso concurso;

    
    public Inscripcion(int id, String fecha_inscripcion, double valor, int idMascota,int idConcurso ) {
        this.id = id;
        this.fecha_inscripcion = fecha_inscripcion;
        this.valor = valor;
        this.idMascota = idMascota;
        this.idConcurso = idConcurso;
    }

    public int getId() {
        return this.id;
    }

    public String getFecha_inscripcion() {
        return this.fecha_inscripcion;
    }

    public double getValor() {
        return this.valor;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public int getIdConcurso() {
        return idConcurso;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setFecha_inscripcion(String fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", fecha_inscripcion=" + fecha_inscripcion + ", valor=" + valor + ", idMascota=" + idMascota + ", idConcurso=" + idConcurso + '}';
    }
    
    public void saveFile (String inscripcionesfield){
       try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(inscripcionesfield),true))){
           pw.println(this.id + "|"+ this.fecha_inscripcion+ "|" + this.valor + "|"+ this.idMascota + "|"+ this.idConcurso);
       }catch(Exception e){
           System.out.println(e.getMessage());
       }  
    }
    
    
    public static void saveFile(ArrayList<Inscripcion> listainscripciones, String evaluacionefield){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(evaluacionefield)))){
            for (Inscripcion ins : listainscripciones)
                pw.println(ins.id + "|"+ ins.fecha_inscripcion+ "|" + ins.valor + "|"+ ins.idMascota + "|"+ ins.idConcurso);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }       
    }
    
    
    public static ArrayList<Inscripcion> readFromFile(String evaluacionefield){
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(evaluacionefield)))
        {
            while(sc.hasNextLine())
            {
                // linea = id|fecha_inscripcion|valor|idMascota|idConcurso
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                // int id, valor, idMascota, idConcurso
                // String fecha_inscripcion
                Inscripcion ins = new Inscripcion(Integer.parseInt(tokens[0]),(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                inscripciones.add(ins);
            }          
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return inscripciones;
    }
    
    
    public static Inscripcion nextInscripcion(Scanner sc){
        
        int id, valor, idMascota, idConcurso;
        String fecha_inscripcion;
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);
        System.out.println("Ingrese el id de la inscripcion: ");
        id = sc.nextInt();
        System.out.println("Ingrese la fecha de inscripcion: ");
        fecha_inscripcion = sc.next();
        System.out.println("Ingrese el costo de la inscripcion: ");
        valor = sc.nextInt();
        System.out.println("Ingrese el id de su mascota: ");
        idMascota = sc.nextInt();
        System.out.println("Ingrese el id del concurso a participar: ");
        idConcurso = sc.nextInt();
        
        Inscripcion ins = new Inscripcion(id, fecha_inscripcion, valor, idMascota, idConcurso);
        return ins;
    }
    
    

    
    
    
    



}
