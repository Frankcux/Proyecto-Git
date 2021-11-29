
package ec.edu.espol.interfaz;

import ec.edu.espol.model.Concurso;
import static ec.edu.espol.model.Concurso.nextConcurso;
import static ec.edu.espol.model.Concurso.readFromFile;
import static ec.edu.espol.model.Concurso.saveFile;
import ec.edu.espol.model.Criterio;
import ec.edu.espol.model.Duen;
import static ec.edu.espol.model.Premios.saveFile;

import ec.edu.espol.model.Premios;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;




public class Menu {
    
    public static int next_idconcurso(Scanner sc){
    System.out.println("Ingrese el nombre del concurso al que pertenecen los premios: ");
    String concurso = sc.next();
    ArrayList<Concurso> concursos = readFromFile("concursos.txt");
    for (Concurso i: concursos){
        if (concurso.equals(i.getNombre())){
            return i.getId();
            }  
        }
    return 0;
    }                

    private static Criterio Criterio(int id, String nombre, String descripcion, int punt_max, int id0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Scanner sc= new Scanner(System.in);
    public ArrayList<Duen> dueños= null;
    public static void menuOpciones(){
        String opcion;
        do{
            System.out.println("Menú de opciones: ");
        
            System.out.println(" 1.	Dueño");
            System.out.println(" 2.	Mascota");
            System.out.println(" 3.	Concurso");
            System.out.println(" 4.	Premio");
            System.out.println(" 5.	Criterio");  //Criterio
            System.out.println(" 6.	Inscripción");  //Adair
            System.out.println(" 7.	MiembroJurado");
            System.out.println(" 8.	Evaluacion");  //Adair
            System.out.println(" 9.	Salir");
            
        
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            sc.useLocale(Locale.US); 
            opcion = sc.next();
        
            if ( Integer.parseInt(opcion)== 1 ){
            
                Duen dueno1=null;
                dueno1= dueno1.nextDueño(sc);
                dueno1.saveFile("dueño");
                //dueños.add(dueno1);
               
            }else if ( Integer.parseInt(opcion) == 2){
           
                
            
                
            }else if ( Integer.parseInt(opcion) == 3){ //Implementacion de la opción 3
           
                Concurso concurso = nextConcurso(sc);
                concurso.saveFile("concursos.txt");
 
                
            }else if ( Integer.parseInt(opcion) ==4){ //Implementación de la opción 4
            
               System.out.println("Ingrese la cantidad de premios: ");
               int cantidad, contador;
                contador= 0;
                cantidad = sc.nextInt();
                ArrayList<Premios> lista_premios = new ArrayList<>();
                ArrayList<Premios> lista_premios2 = new ArrayList<>();
            
                while ( contador < cantidad){
                    Premios premio = Premios.nextPremios(sc);
                    lista_premios.add(premio);
                    contador ++;
                }
                System.out.println("Ingrese el nombre del concurso al que pertenecen los premios: ");
                String concurso = sc.next();
                int id;
                ArrayList<Concurso> concursos = readFromFile("concursos.txt");
                for (Concurso i: concursos){
                    if (concurso.equals(i.getNombre())){
                        id = i.getId();
                        for (Premios j: lista_premios){
                        Premios premio1 = new Premios(j.getId(),j.getLugar(),j.getDescripcion(),id);
                        lista_premios2.add(premio1);
                        }
                    } 
                }
                Premios.saveFile(lista_premios, "premios.txt");  
            
            
            }else if ( Integer.parseInt(opcion) == 5){
                System.out.println("Ingrese la cantidad de criterios: ");
                int cantidad, contador = 0;
                cantidad = sc.nextInt();
                ArrayList<Criterio> lista_criterios = new ArrayList<>();
                ArrayList<Criterio> lista_criterios2 = new ArrayList<>();
                
                while(contador < cantidad){
                    Criterio criterio = Criterio.nextCriterio(sc);
                    lista_criterios.add(criterio);
                    contador = contador + 1;
                }
                int id;
                id = next_idconcurso(sc);               
                for (Criterio crit : lista_criterios){
                    Criterio datos_criterio = Criterio(crit.getId(), crit.getNombre(), crit.getDescripcion(), crit.getPunt_max(), id);
                        lista_criterios2.add(datos_criterio);                  
                        }  
                Criterio.saveFile(lista_criterios2, "criterios.txt");

                
            }else if ( Integer.parseInt(opcion) == 6){
            
            
            
            }else if ( Integer.parseInt(opcion) == 7){
            
            
            
           }else if ( Integer.parseInt(opcion) == 8){
            
            
            
            }
        }while(Integer.parseInt(opcion)!=9);
    }
}
