
package ec.edu.espol.interfaz;

import ec.edu.espol.model.Concurso;
import static ec.edu.espol.model.Concurso.nextConcurso;
import static ec.edu.espol.model.Concurso.readFromFile;
import static ec.edu.espol.model.Concurso.saveFile;
import static ec.edu.espol.model.Premios.saveFile;

import ec.edu.espol.model.Premios;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    
    public static void menuOpciones(){
        System.out.println("Menú de opciones: ");
        System.out.println(" 1.	Dueño");
        System.out.println(" 2.	Mascota");
        System.out.println(" 3.	Concurso");
        System.out.println(" 4.	Premio");
        System.out.println(" 5.	Criterio");
        System.out.println(" 6.	Inscripción");
        System.out.println(" 7.	MiembroJurado");
        System.out.println(" 8.	Evaluacion"); 
        
        
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US); 
        int opcion = sc.nextInt();
        
        if ( opcion == 1 ){
            
            
            
        
        }else if ( opcion == 2){
           
            
            
            
        }else if ( opcion == 3){ //Implementacion de la opción 3
           
            Concurso concurso = nextConcurso(sc);
            concurso.saveFile("concursos.txt");
            
        }else if ( opcion == 4){ //Implementación de la opción 4
            
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
            
            
        }else if ( opcion == 5){
            
            
         
        }else if ( opcion == 6){
            
            
            
        }else if ( opcion == 7){
            
            
            
        }else if ( opcion == 8){
            
            
            
        }
    }
}
