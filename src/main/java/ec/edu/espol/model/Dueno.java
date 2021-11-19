
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Scanner;


public class Dueno extends Persona{
    private String direccion;
    private ArrayList<Mascota> mascotas;
    public Dueno(int id, String nombre,String apellidos,String telefono,String email,String direccion){
        super(id,nombre,apellidos,telefono,email);
        this.direccion=direccion;
        this.mascotas=new ArrayList<>();
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    @Override
    public String toString() {
        return "Dueño{" +"id="+ this.id+", nombres="+this.nombres+", apellidos="+this.apellidos+", telefono"+this.telefono+ ", direccion=" + direccion + ", email="+this.email+" mascotas=" + mascotas + '}';
    }
    
    //
    public static Dueno nextDueño(Scanner sc){
        
        int id;
        String nombre,apellidos,telefono,email,direccion;
        sc.useDelimiter("\n");
        System.out.println("Ingrese el id del Dueño: ");
        id = sc.nextInt();
        System.out.println("Ingrese el nombre del Dueño: ");
        nombre = sc.next();
        System.out.println("Ingrese el apellido del Dueño: ");
        apellidos = sc.next();
        System.out.println("Ingrese el telefono del Dueño: ");
        telefono = sc.next();
        System.out.println("Ingrese el email del Dueño: ");
        email = sc.next();
        System.out.println("Ingrese la direccion del Dueño: ");
        direccion = sc.next();
       
        return new Dueno(id,nombre,apellidos,telefono,email,direccion);
        
    }
    
}
