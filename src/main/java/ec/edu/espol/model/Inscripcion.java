
package ec.edu.espol.model;

import static ec.edu.espol.model.Util.next_idconcurso;
import static ec.edu.espol.model.Util.next_idmascota;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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

    public Inscripcion(int id, String fecha_inscripcion, double valor) {
        this.id = id;
        this.fecha_inscripcion = fecha_inscripcion;
        this.valor = valor;
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
    
    
    public static void saveFile(ArrayList<Inscripcion> listainscripciones, String inscripcionesfield){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(inscripcionesfield)))){
            for (Inscripcion ins : listainscripciones)
                pw.println(ins.id + "|"+ ins.fecha_inscripcion+ "|" + ins.valor + "|"+ ins.idMascota + "|"+ ins.idConcurso);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }       
    }
    
    
    public static ArrayList<Inscripcion> readFromFile(String inscripcionesfield){
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        String filename = "src/"+inscripcionesfield;
        try (BufferedReader inputStream = new BufferedReader(new FileReader(filename)))
        {
            String line = null;
            while(((line = inputStream.readLine()) != null))
            {
                // linea = id|fecha_inscripcion|valor|idMascota|idConcurso
                String[] tokens = line.split("\\|");
                // int id, valor, idMascota, idConcurso
                // String fecha_inscripcion
                Inscripcion ins = new Inscripcion(Integer.parseInt(tokens[0]),(tokens[1]),Double.parseDouble(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                inscripciones.add(ins);
            }          
        }catch(Exception e) {
            CreateFile(inscripcionesfield);
            System.out.println("ERROR EN LECTURA DE ARCHIVO");
        }
        return inscripciones;
    }
    
    
    public static void CreateFile(String inscripcionNombre){
        String filename = "src/" +inscripcionNombre;
        try(BufferedWriter outputStream = new BufferedWriter(new FileWriter(filename))){
            
        }
        catch(Exception e){
            System.out.println("ERROR EN LA CREACION DEL ARCHIVO");
        }
    }

    
    public static Inscripcion nextInscripcion(Scanner sc){
 // CHICOS DE ESTA FORMA PODEMOS AGREGAR LOS ID A CADA CLASE, ES NECESARIO LEER EL ARCHIVO DONDE SE GUARDEN PARA QUE EL CONTEO NO REINICIE CADA VEZ QUE EJECUTAMOS EL PROGRAMA
        int id, valor,id_mascota, id_concurso;
        String fecha_inscripcion;  
        
        ArrayList<Inscripcion> lista_inscripciones = Inscripcion.readFromFile("inscripciones.txt");
        
        id = lista_inscripciones.size()+1;
        
        id_mascota = next_idmascota(sc);
        id_concurso = next_idconcurso(sc);
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);
        System.out.println("Ingrese la fecha de inscripcion: ");
        fecha_inscripcion = sc.next();
        System.out.println("Ingrese el costo de la inscripcion: ");
        valor = sc.nextInt();
        Inscripcion inscripcion_completa = new Inscripcion(id, fecha_inscripcion, valor,id_mascota, id_concurso);
        inscripcion_completa.saveFile("inscripciones.txt");
        return inscripcion_completa;
    }
}
