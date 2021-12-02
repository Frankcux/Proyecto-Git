
package ec.edu.espol.interfaz;

import ec.edu.espol.model.Concurso;
import static ec.edu.espol.model.Concurso.nextConcurso;
import static ec.edu.espol.model.Concurso.readFromFile;
import static ec.edu.espol.model.Concurso.saveFile;
import ec.edu.espol.model.Criterio;
import ec.edu.espol.model.Duen;
import ec.edu.espol.model.Evaluacion;
import ec.edu.espol.model.Inscripcion;
import ec.edu.espol.model.Mascota;
import ec.edu.espol.model.MiembroJurado;
import static ec.edu.espol.model.Premios.saveFile;

import ec.edu.espol.model.Premios;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;




public class Menu {
    
    private Scanner sc= new Scanner(System.in);
    public ArrayList<Duen> dueños= null;
    public static void menuOpciones(){
        String opcion;
        do{
            System.out.println("Menú de opciones: ");
        
            System.out.println(" 1.	Dueño");  //Jenifer
            System.out.println(" 2.	Mascota"); //Jenifer
            System.out.println(" 3.	Concurso");
            System.out.println(" 4.	Premio");
            System.out.println(" 5.	Criterio");  //Adair YALA
            System.out.println(" 6.	Inscripción");  //Adair YALA
            System.out.println(" 7.	MiembroJurado"); //Jenifer
            System.out.println(" 8.	Evaluacion");  //Adair
            System.out.println(" 9.	Salir");
            
        
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            sc.useLocale(Locale.US); 
            opcion = sc.next();
        
            if ( Integer.parseInt(opcion)== 1 ){           
                Duen dueno = Duen.nextDueño(sc);
                System.out.println("El dueño: "+ dueno +" ha sido guardado");
                //dueños.add(dueno1);
               
                
            }else if ( Integer.parseInt(opcion) == 2){
           
                Mascota mascota1=null;
                mascota1= mascota1.nextMascota(sc);
                mascota1.saveFile("mascota.txt");
            
  
            }else if ( Integer.parseInt(opcion) == 3){ //Implementacion de la opción 3
           
                Concurso concurso = nextConcurso(sc);
                concurso.saveFile("concursos.txt");
 
                
            }else if ( Integer.parseInt(opcion) ==4){
                ArrayList<Premios> premios_completos = Premios.nextPremios(sc);
                System.out.println("Estos son los premios que acaba de registrar: \n");
                System.out.println(premios_completos);

                
            }else if ( Integer.parseInt(opcion) == 5){
                ArrayList<Criterio> criterios_completos = Criterio.nextCriterio(sc);
                System.out.println("Estos son los criterios que acaba de registrar: \n");
                System.out.println(criterios_completos);
             
                
            }else if ( Integer.parseInt(opcion) == 6){
                Inscripcion inscripcion_completa = Inscripcion.nextInscripcion(sc);
                System.out.println("La incripcion: "+ inscripcion_completa +" ha sido guardada");

                        
            }else if ( Integer.parseInt(opcion) == 7){
                MiembroJurado miembroJ=null;
                miembroJ= miembroJ.nextMiembroJurado(sc);
                miembroJ.saveFile("miembroJurado.txt");

                
           }else if ( Integer.parseInt(opcion) == 8){
               Evaluacion nueva_evaluacion = Evaluacion.nextEvaluacion(sc);
               System.out.println("La evaluacion: "+ nueva_evaluacion +" ha sido guardada");
  
               
            }
        }while(Integer.parseInt(opcion)!=9);
    }
}
