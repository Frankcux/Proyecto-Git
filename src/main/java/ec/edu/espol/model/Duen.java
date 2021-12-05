/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author 59399
 */
import ec.edu.espol.model.*;
import ec.edu.espol.model.Persona;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Duen extends Persona{
    private String direccion;
    private ArrayList<Mascota> mascotas;
    
    public Duen(int id, String nombre, String apellidos, String telefono, String email, String direccion){
        super(nombre,apellidos,telefono,email);
        this.id = id;
        this.direccion=direccion;
        this.mascotas=new ArrayList<>();
    }
    
    public Duen(int id, String nombre, String apellidos, String telefono, String email, String direccion, ArrayList<Mascota> mascotas){
        super(nombre,apellidos,telefono,email);
        this.id = id;
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
    
    
            @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("Dueño{ id= ");
        sb.append(this.getId());
        sb.append(", nombre= ");
        sb.append(this.getNombres());
        sb.append(", apellidos=");
        sb.append(this.getApellidos());
        sb.append(", telefono= ");
        sb.append(this.getTelefono());
        sb.append(", email= ");
        sb.append(this.getEmail());
        sb.append(", direccion= ");
        sb.append(this.getDireccion());
        sb.append(",    Mascotas= ");
        for (Mascota i: this.mascotas){
            sb.append(i.toString());
            if(this.mascotas.size()!=this.mascotas.size()-1)
                sb.append(";");               
            }
        sb.append("]");
        return sb.toString();
    }
    
    //Hice cambios aquí, espero que no te moleste
    public static Duen nextDueño(Scanner sc){
        
        sc.useDelimiter("\n");
        //Id de cada dueño
        ArrayList<Duen> lista_duenos = Duen.readFile("dueños.txt");
        int id_dueno = lista_duenos.size()+1;
        Persona persona = Persona.nextPersona(sc);
        System.out.println("Ingrese la dirreccion del Dueño: ");
        String direccion = sc.next();
        Duen persona_duen = new Duen(id_dueno, persona.nombres, persona.apellidos, persona.telefono, persona.email, direccion);    
        persona_duen.saveFile("dueños.txt");
        return persona_duen;
        
    }
    public void saveFile(String file){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(file),true)))
        {
            pw.println(this.getId() + "|"+ this.getNombres()+ "|" + this.getApellidos() + "|"+ this.getTelefono()+ "|"
                    + this.getEmail()+ "|"+ this.getDireccion());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //saveFile
    //recibe lista de pacientes
    public static void  saveFile( ArrayList<Duen> dueño , String nombre){
        //en modo append
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombre),true))){
            for (Duen v:  dueño ){
                pw.println(v.getId() + "|"+ v.getNombres()+ "|" + v.getApellidos() + "|"+ v.getTelefono()+ "|"
                    + v.getEmail()+ "|"+ v.getDireccion());
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //el comportamiento estático readFile
    
    public static ArrayList<Duen> readFile(String nombre){
        ArrayList<Duen> dueño= new ArrayList<>();
        try (Scanner sc =new Scanner(new File (nombre))){
            while(sc.hasNextLine()){
                String linea= sc.nextLine();
                String[] datos = linea.split("\\|"); 
                Duen v= new Duen(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4],datos[5]);
                dueño.add(v);
            }
        }catch (Exception e){
            System.out.println("NO hay archivo, se ha creado uno");
        }
        return dueño;
    }
    
}
