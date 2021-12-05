package ec.edu.espol.model;

import ec.edu.espol.model.*;
import ec.edu.espol.model.Persona;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MiembroJurado extends Persona {
    private int idMiembroJurado;
    private String perfil;
    private ArrayList<Evaluacion> evaluaciones;

    public MiembroJurado( int id,String perfil, String nombres, 
            String apellidos, String telefono, String email) {
        super(id, nombres, apellidos, telefono, email);
        this.perfil = perfil;
        this.evaluaciones=evaluaciones;
    }

    public String getNombres() {
        return nombres;
    }

    public int getIdMiembroJurado() {
        return idMiembroJurado;
    }

    public void setIdMiembroJurado(int idMiembroJurado) {
        this.idMiembroJurado = idMiembroJurado;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("MiembroJurado{ id= ");
        sb.append(this.getId());
        sb.append(", nombre= ");
        sb.append(this.getNombres());
        sb.append(", apellidos=");
        sb.append(this.getApellidos());
        sb.append(", telefono= ");
        sb.append(this.getTelefono());
        sb.append(", email= ");
        sb.append(this.getEmail());
        sb.append(", perfil= ");
        sb.append(this.getPerfil());
        sb.append(",    Evaluaciones= ");
        for (Evaluacion i: evaluaciones){
            sb.append(i.toString());
            if(this.evaluaciones.size()!=this.evaluaciones.size()-1)
                sb.append(";");
                
            }
        sb.append("]");
        return sb.toString();
    }
    
    public static ArrayList<MiembroJurado> readFile(String nombre){
        ArrayList<MiembroJurado> miembroJurado= new ArrayList<>();
        try (Scanner sc =new Scanner(new File (nombre))){
            while(sc.hasNextLine()){
                String linea= sc.nextLine();
                String[] datos = linea.split("\\|"); 
                MiembroJurado v= new MiembroJurado(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4],datos[5]);
                miembroJurado.add(v);
            } 
        }catch (Exception e){
            System.out.println("Se ha creado el archivo: "+ nombre);
        }
        return miembroJurado;
    }
    
    
    public static MiembroJurado nextMiembroJurado(Scanner sc){
        String perfil;
        sc.useDelimiter("\n");
        Persona p=  Persona.nextPersona(sc);
        System.out.println("Ingrese una descripción: ");
        perfil= sc.next();
        ArrayList<MiembroJurado> j= MiembroJurado.readFile("miembroJurados.txt");

        return new MiembroJurado(j.size()+1,perfil,p.getNombres(),p.getApellidos(),p.getTelefono(),p.getEmail());
        
    }
    
    
    public void saveFile(String file){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(file),true)))
        {
            pw.println(this.getId()+ "|"+ this.getPerfil() + "|"+ this.getNombres()+ "|" + this.getApellidos() + "|"+ this.getTelefono()+ "|"
                    + this.getEmail());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void  saveFile( ArrayList<MiembroJurado> miembroJurado , String nombre){
        //en modo append
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombre)))){
            for (   MiembroJurado v:  miembroJurado ){
                pw.println(v.getId()+"|"+ v.getPerfil() + "|"+ v.getNombres()+ "|" + v.getApellidos() + "|"+ v.getTelefono()+ "|"
                    + v.getEmail() );
            }           
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }   
}
