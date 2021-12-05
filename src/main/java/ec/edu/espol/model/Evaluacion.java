
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Evaluacion {
    private int id;
    private int nota;
    private int idInscripcion;
    private Inscripcion inscripcion;
    private int idMiembroJurado;
//    private MiembroJurado miembrojurado; ***************************************************************************************
    private int idCriterio;
    private Criterio criterio;
    

    public Evaluacion(int id, int idMiembroJurado, int idInscripcion, int idCriterio, int nota) {
        this.id = id;
        this.nota = nota;
        this.idInscripcion = idInscripcion;
        this.idMiembroJurado = idMiembroJurado;
        this.idCriterio = idCriterio;
    }

    public int getId() {
        return this.id;
    }

    public double getNota() {
        return this.nota;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public int getIdMiembroJurado() {
        return idMiembroJurado;
    }

    public int getIdCriterio() {
        return idCriterio;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public void setIdMiembroJurado(int idMiembroJurado) {
        this.idMiembroJurado = idMiembroJurado;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }
   
    @Override
    public String toString() {
        return "Evaluacion{" + "id=" + id + ", nota=" + nota + ", idInscripcion=" + idInscripcion + ", idMiembroJurado=" + idMiembroJurado + ", idCriterio=" + idCriterio + '}';
    }

   
    public void saveFile (String evaluacionefield){
       try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(evaluacionefield),true))){
           pw.println(this.id + "|"+ this.nota+ "|" + this.idInscripcion + "|"+ this.idMiembroJurado + "|"+ this.idCriterio);
       }catch(Exception e){
           System.out.println(e.getMessage());
       }  
    }
    
    
    public static void saveFile(ArrayList<Evaluacion> listaevaluaciones, String evaluacionefield){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(evaluacionefield),true))){
            for (Evaluacion eva : listaevaluaciones)
                pw.println(eva.getId() + "|"+ eva.getNota()+ "|" + eva.getIdInscripcion() + "|"+
                        eva.getIdMiembroJurado() + "|"+ eva.getIdCriterio());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }       
    }
    
    
    public static ArrayList<Evaluacion> readFile(String evaluacionefield){
        ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(evaluacionefield))){
            while(sc.hasNextLine())
            {
                
// linea = id|nota|idInscripcion|idMiembroJurado|idCriterio
                String linea = sc.nextLine();
                
                String[] tokens = linea.split("\\|");
                
                // int id, nota, idInscripcion, idMiembroJurado, idCriterio
                Evaluacion evalu = new Evaluacion(Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                evaluaciones.add(evalu);
            }            
        }catch(Exception e) {
            System.out.println("No hay archivo de evaluacion ");
        }
        return evaluaciones;
    }
    
    
    public static Evaluacion nextEvaluacion(Scanner sc){     
        int id, idInscripcion, idCriterio;
        int nota; 
        int idMiembroJurado= 0;
        String emailMiembroJurado;
        ArrayList<Evaluacion> lista_evaluaciones = Evaluacion.readFile("evaluaciones.txt");
        id=0;
        
        for (Evaluacion e: lista_evaluaciones){
            System.out.println(e.getId());
           if (id <e.getId()){
               
               id=e.getId();
           }
           id=id+1;
        }
        //id = lista_evaluaciones.size() + 1;  
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);
        System.out.println("hay " + id);
        System.out.println("Ingrese el email del miembro del jurado: ");
        emailMiembroJurado = sc.next();
        ArrayList<MiembroJurado>  miembros =  MiembroJurado.readFile("miembroJurados.txt");
        for (MiembroJurado m: miembros){
            if(emailMiembroJurado.equals(m.getEmail()))
            {
                System.out.println(idMiembroJurado);
                idMiembroJurado= m.getId();
            }
        }
        System.out.println(idMiembroJurado);
        if(idMiembroJurado==0){
            return null;
        }
        System.out.println("Ingrese el id de la inscripcion a la que pertenece: ");
        idInscripcion = sc.nextInt();
        System.out.println("Ingrese el id del criterio evaluado: ");
        idCriterio = sc.nextInt();
        ArrayList<Criterio> lista_criterios = Criterio.readFromFile("criterios.txt");
        int ptmax=0;
        for (Criterio cri : lista_criterios){
            if (cri.getId() == idCriterio){
                ptmax = cri.getPunt_max();
            }
        }
        do{
            System.out.println("Ingrese la nota: ");
            nota = sc.nextInt(); 
        }while(nota<ptmax);
        
        Evaluacion nueva_evaluacion = new Evaluacion(id, idMiembroJurado, idInscripcion,
                idCriterio, nota);
        nueva_evaluacion.saveFile("evaluaciones.txt");
        return nueva_evaluacion;
    }
}






