
package ec.edu.espol.model;


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
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(inscripcionesfield),true))){
            for (Inscripcion ins : listainscripciones)
                pw.println(ins.id + "|"+ ins.fecha_inscripcion+ "|" + ins.valor + "|"+ ins.idMascota + "|"+ ins.idConcurso);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }       
    }
    
    //*************************************************************************************//
    
    public static ArrayList<Inscripcion> readFile(String nombre){
        ArrayList<Inscripcion> inscripciones= new ArrayList<>();
        try (Scanner sc =new Scanner(new File (nombre))){
            while(sc.hasNextLine()){
                String linea= sc.nextLine();
                String[] datos = linea.split("\\|"); 
                Inscripcion ins = new Inscripcion(Integer.parseInt(datos[0]),(datos[1]), Double.parseDouble(datos[2]),Integer.parseInt(datos[3]),Integer.parseInt(datos[4]));                
                inscripciones.add(ins);
            }
        }catch (Exception e){
            System.out.println("NO hay archivo, se ha creado uno");
        }
        return inscripciones;
    }
    
    public static Inscripcion nextInscripcion(Scanner sc){
 // CHICOS DE ESTA FORMA PODEMOS AGREGAR LOS ID A CADA CLASE, ES NECESARIO LEER EL ARCHIVO DONDE SE GUARDEN PARA QUE EL CONTEO NO REINICIE CADA VEZ QUE EJECUTAMOS EL PROGRAMA
        int id,id_mascota, id_concurso;
        Double valor;
        String fecha_inscripcion;  
        
        ArrayList<Inscripcion> lista_inscripciones = Inscripcion.readFile("inscripciones.txt");     
        id = lista_inscripciones.size()+1;       
        id_mascota = Util.next_idmascota(sc);
        id_concurso = Util.next_idconcurso(sc);
        if (id_concurso!= 0 || id_mascota != 0)
        {
            sc.useDelimiter("\n");
            sc.useLocale(Locale.US);
            System.out.println("Ingrese la fecha de inscripcion: ");
            fecha_inscripcion = sc.next();
            System.out.println("Ingrese el costo de la inscripcion: ");
            valor = sc.nextDouble();
            Inscripcion inscripcion_completa = new Inscripcion(id, fecha_inscripcion, valor,id_mascota, id_concurso);
            inscripcion_completa.saveFile("inscripciones.txt");
            System.out.println("La incripcion: "+ inscripcion_completa +" ha sido guardada");
            return inscripcion_completa;
            
        }
        System.out.println("Inscripcion inválida porque el concurso o macosta no existe");
        return null;
    }
}
