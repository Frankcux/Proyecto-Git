/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import static ec.edu.espol.model.Concurso.readFromFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eduardo
 */
public class Util {
    
    // el constructor se lo ha declarado privado
    // ya que esta clase solo va a contener comportamientos estáticos
    // por lo tanto, no se van a permitir crear instancia de la clase Util
    private Util(){}
    
    public static int nextID(String nomfile)
    {
        int id = 0;
        try(Scanner sc = new Scanner(new File(nomfile)))
        {
           while(sc.hasNextLine())
           {
               String linea = sc.nextLine();
               String[] tokens = linea.split("\\|");
               id = Integer.parseInt(tokens[0]);
           }
        }
        catch(Exception e)
        {
        }
        return id+1;
    }
    
    
    public static int next_idconcurso(Scanner sc){
    System.out.println("Ingrese el nombre del concurso: ");
    String concurso = sc.next();
    ArrayList<Concurso> concursos = readFromFile("concursos.txt");
    for (Concurso i: concursos){
        if (concurso.equals(i.getNombre())){
            return i.getId();
            }  
        }
    return 0;
    }
     
     
    public static int next_idmascota(Scanner sc){
    System.out.println("Ingrese el nombre de su mascota: ");
    String nombre_mascota = sc.next();
    ArrayList<Mascota> mascotas = Mascota.readFile("concursos.txt");
    for (Mascota m: mascotas){
        if (nombre_mascota.equals(m.getNombre())){
            return m.getId();
            }  
        }
    return 0;
    }
    
}
