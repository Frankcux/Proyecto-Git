
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Concurso {
    //DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
    //LocalDate fecha = LocalDate.parse("02/10/2020", formato); 
    private int id;
    private String nombre;
    private LocalDate fecha;
    private LocalDate fechaInscripcion;
    private LocalDate fechaCierreInscripcion;
    private String tematica;
    private double costo;
    private ArrayList<Inscripcion> inscripciones;
    private ArrayList<Premios> premios;
    private ArrayList<Criterio> criterio;
    
    
    public Concurso(int id, String nombre, LocalDate fecha, LocalDate fechaInscripcion, LocalDate fechaCierreInscripcion, String tematica, double costo){
        this.id = id;
        this.nombre = nombre; 
        this.fecha = fecha;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.tematica = tematica;
        this.costo = costo;
        
    
    }
    // GETTERS
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
    public LocalDate getFechaCierreInscripcion() {
        return fechaCierreInscripcion;
    }
     public String getTematica() {
        return tematica;
    }
      public double getCosto() {
        return costo;
    }
      public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }
      public ArrayList<Premios> getPremios() {
        return premios;
    }
      public ArrayList<Criterio> getCriterio() {
        return criterio;
    }

    //SETTERS

    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    public void setFechaCierreInscripcion(LocalDate fechaCierreInscripcion) {
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }
    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
    public void setPremios(ArrayList<Premios> premios) {
        this.premios = premios;
    }
    public void setCriterio(ArrayList<Criterio> criterio) {
        this.criterio = criterio;
    }
    
    @Override
    
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Concurso[ id= ");
        sb.append(this.id);
        sb.append(", nombre= ");
        sb.append(this.nombre);
        sb.append(", fecha= ");
        sb.append(this.fecha);
        sb.append(", fecha de inscripcion= ");
        sb.append(this.fechaInscripcion);
        sb.append(", fecha de cierre de inscripcion= ");
        sb.append(this.fechaCierreInscripcion);
        sb.append(", temática= ");
        sb.append(this.tematica);
        sb.append(", costo de inscripción= ");
        sb.append(this.costo);
        sb.append(", Premios= ");
        for(Premios p: this.premios){
            sb.append(p.toString());
            if(this.premios.size() != this.premios.size()-1)
                sb.append(";");
        }
        sb.append("]");
        return sb.toString();
        /*
        return "Concurso{ Id: "+ id + ",nombre: "+ nombre+", fecha: "+ fecha+", fecha de inscripcion: "+ fechaInscripcion+ ", fecha de cierre de inscripcion: "+ fechaCierreInscripcion+ ", temática: "+ tematica+", costo de inscripcion: "+ costo+" }";
        */
    }
    @Override
    
    public boolean equals(Object o) {
        if( o != null && o instanceof Concurso){
            Concurso c2 = (Concurso)o;
            return (this.id == c2.id) ;
        }return false;
    }
     public void  saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id + "|"+ this.nombre+ "|" + this.fecha + "|"+ this.fechaInscripcion+ "|"+ this.fechaCierreInscripcion+ "|"+ this.tematica+ "|"+ this.costo);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
    public static void saveFile(ArrayList<Concurso> concursos, String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile))))
        {
           for( Concurso c: concursos)
               pw.println(c.id + "|"+ c.nombre+ "|" + c.fecha + "|"+ c.fechaInscripcion + "|"+ c.fechaCierreInscripcion+ "|"+ c.tematica+ "|"+ c.costo); 
        } catch(Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    public static ArrayList<Concurso> readFromFile(String nomfile){
        ArrayList<Concurso> concursos = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomfile)))
        {
            while(sc.hasNextLine())
            {
                // linea = id|nombre|fecha|fechaInscripcion|fechaCierreInscripcion|tematica|costo
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                // int id,String nombre,LocalDate fecha,LocalDate fechaInscripcion,LocalDate fechaCierreInscripcion,String tematica, double costo
                Concurso c = new Concurso(Integer.parseInt(tokens[0]),tokens[1],LocalDate.parse(tokens[2]),LocalDate.parse(tokens[3]),LocalDate.parse(tokens[4]), tokens[5], Double.parseDouble(tokens[6])  ) ;
                concursos.add(c);
            }
            
        }catch(Exception e) {
            System.out.println("error");
            
        }
        return concursos;
    
    }
    public static Concurso nextConcurso(Scanner sc){
        
        int id;
        String tematica, nombre;
        double costo;
        LocalDate fecha, fechaIns, fechaCierreIns;
        sc.useDelimiter("\n");
       
        sc.useLocale(Locale.US);
        ArrayList<Concurso> c = Concurso.readFromFile("concursos.txt");
        id = c.size()+1;
        System.out.println("Ingrese el nombre de ese concurso: ");
        nombre = sc.next();
        System.out.println("Ingrese la fecha del concurso: ");
        fecha = LocalDate.parse(sc.next());
        // Valida que las fechas tengan sentido
        do{
        System.out.println("Ingrese la fecha de inscripcion: ");
        fechaIns = LocalDate.parse(sc.next());
        }while(fechaIns.isAfter(fecha));
        
        // Valida que las fechas tengan sentido
        do{
        System.out.println("Ingrese la fecha de cierre de inscripciones: ");
        fechaCierreIns = LocalDate.parse(sc.next());
        }while(fechaCierreIns.isBefore(fechaIns)||fechaCierreIns.isAfter(fecha));
        System.out.println("Ingrese la temática del concurso: ");
        tematica = sc.next();
        System.out.println("Ingrese el costo de la inscripcion: ");
        costo = sc.nextDouble();
        Concurso concurso = new Concurso(id,nombre,fecha,fechaIns,fechaCierreIns,tematica,costo);
        
        return concurso;
        
    }
    
    
    
    
           
}
