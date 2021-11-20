

import ec.edu.espol.model.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author 59399
 */
public class Mascota {
    private String nombre,raza,tipo;
    private int id,idDueño;
    private LocalDate fechaNacimiento;
    private Dueño dueño;
    private ArrayList<Inscripcion> inscripciones;
   

    public Mascota( int id,String nombre, String raza, String tipo, int idDueño, LocalDate fechaNacimiento, Dueño dueño, ArrayList<Inscripcion> inscripciones) {
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.id = id;
        this.idDueño = idDueño;
        this.fechaNacimiento = fechaNacimiento;
        this.dueño = dueño;
        this.inscripciones = inscripciones;
    }
    
    
    //Gets and Sets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(int idDueño) {
        this.idDueño = idDueño;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
    /*
    //toString
    @Override
    public String toString() {
        return "Mascota{"+ " id=" + id + "nombre=" + nombre + ", raza="
                + raza + ", tipo=" + tipo  + ", idDue\u00f1o=" + idDueño + 
                ", fechaNacimiento=" + fechaNacimiento + ", due\u00f1o=" 
                + dueño + ", inscripciones=" + inscripciones + '}';
    }*/
    
    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("Mascota{ id= ");
        sb.append(this.id);
        sb.append(", nombre= ");
        sb.append(this.nombre);
        sb.append(", raza= ");
        sb.append(this.raza);
        sb.append(", tipo= ");
        sb.append(this.tipo);
        sb.append(", idDueño= ");
        sb.append(this.idDueño);
        sb.append(", fechaNacimiento= ");
        sb.append(this.fechaNacimiento);
        sb.append(", Inscripciones= ");
        for (Inscripcion i: inscripciones){
            sb.append(i.toString());
            if(this.inscripciones.size()!=this.inscripciones.size()-1)
                sb.append(";");
                
            }
        sb.append("]");
        return sb.toString();
    }
    //equals
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
        Mascota other = (Mascota) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idDueño != other.idDueño) {
            return false;
        }
        return true;
    }
    
    
    public void saveFile(String file){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(file),true)))
        {
            pw.println(this.id + "|"+ this.nombre+ "|" + this.raza + "|"+ this.fechaNacimiento+ "|"+ this.tipo+ "|"+ this.idDueño+ "|"+ this.dueño);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    Scanner sc= new Scanner(System.in);
       //nextMascota 
    public static Mascota nextMascota(Scanner sc){
        
        /*int id;
        String tematica, nombre;
        double costo;
        LocalDate fecha, fechaIns, fechaCierreIns;
        sc.useDelimiter("\n");*/
        String nombre,raza,tipo;
        int id,idDueño;
        LocalDate fecha;
        Dueño dueño = null;
        ArrayList<Inscripcion> inscripciones= new ArrayList<>();
        
       
        sc.useLocale(Locale.US);
        System.out.println("Ingrese el id de la mascota: ");
        id = sc.nextInt();
        System.out.println("Ingrese el nombre de la mascota: ");
        nombre = sc.next();        
        System.out.println("Ingrese la raza de la mascota: ");
        raza = sc.next();
        System.out.println("Ingrese la fecha de nacimiento: ");
        fecha = LocalDate.parse(sc.next());
        System.out.println("Ingrese el tipo de mascota: ");
        tipo= sc.next();
        dueño = dueño.nextDueño(sc);
        System.out.println("Cuantas inscripciones tiene la mascota: ");
        int numeroInst=sc.nextInt();
        int idinst;
        String fecha_inscripcion;
        double valor;
        for (int i=0; i>= numeroInst;i++){
            System.out.println("Ingrese el id de la inscripciones: ");
            idinst=sc.nextInt();
            System.out.println("Ingrese la fecha de inscripcion");
            fecha_inscripcion= sc.next();
            System.out.println("Ingrese el valor de inscripcion");
            valor= sc.nextDouble();
            inscripciones.add(new Inscripcion(idinst,fecha_inscripcion, valor));
        }
        
        
        return new Mascota( id,nombre,raza, tipo, dueño.getId(), fecha,dueño,inscripciones);
        
    }

        //saveFile
    //recibe lista de pacientes
    public static void  saveFile( ArrayList<Mascota> mascotas , String nombre){
        //en modo append
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombre)))){
            for (   Mascota v:  mascotas ){
                pw.println(v.getId() + "|"+ v.getNombre()+ "|" + v.getRaza() + "|"+ v.getIdDueño()+ "|"
                    + v.getTipo()+ "|"+ v.getFechaNacimiento());
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Mascota(int id,String nombre, String raza, int idDueño, String tipo,  LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.id = id;
        this.idDueño = idDueño;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //el comportamiento estático readFile
    public static ArrayList<Mascota> readFile(String nombre){
        ArrayList<Mascota> mascotas= new ArrayList<>();
        try (Scanner sc =new Scanner(new File (nombre))){
            while(sc.hasNextLine()){
                String linea= sc.nextLine();
                String[] datos = linea.split(";"); 
                Mascota v= new Mascota(Integer.parseInt(datos[0]),datos[1],datos[2],Integer.parseInt(datos[3]),datos[5],LocalDate.parse(datos[4]));
                mascotas.add(v);
            } 
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return mascotas;
    }
     

    
}
