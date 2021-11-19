
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Mascota {
    private int id;
    private String nombre;
    private String raza;
    private String tipo;
    private LocalDate fechaNacimiento;
    private int idDueño;
    private Dueño dueño;
    private ArrayList<Inscripcion> inscripciones;
    
    public Mascota(String nombre, String raza, String tipo, int id, int idDueño, LocalDate fechaNacimiento, Dueño dueño, ArrayList<Inscripcion> inscripciones) {
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
    //toString
    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", raza=" + raza + ", tipo=" + tipo + ", id=" + id + ", idDue\u00f1o=" + idDueño + ", fechaNacimiento=" + fechaNacimiento + ", due\u00f1o=" + dueño + ", inscripciones=" + inscripciones + '}';
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
        
        
        return new Mascota(nombre,raza, tipo, id, dueño.getId(), fecha,dueño,inscripciones);
        
    }
    
}
