
package ec.edu.espol.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Criterio {
    private int id;
    private String nombre;
    private String descripcion;
    private int punt_max;
    private int idConcurso;
    private Concurso concurso;
    

    
    public Criterio(int id, String nombre, String descripcion, int punt_max, int idConcurso) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.punt_max = punt_max;
        this.idConcurso = idConcurso;
    }

    public Criterio(int id, String nombre, String descripcion, int punt_max) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.punt_max = punt_max;
    }
    

    public int getId() {
        return this.id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPunt_max() {
        return this.punt_max;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPunt_max(int punt_max) {
        this.punt_max = punt_max;
    }

    
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
        Criterio other = (Criterio) obj;
        if (this.id != other.id) 
            return false;
        return true;
    }

    
    @Override
    public String toString() {
        return "Criterio{" + "id=" + this.id + ", nombre=" + this.nombre + ", descripcion=" + this.descripcion + ", punt_max=" + this.punt_max + '}';
    }
    
    
    public void saveFile (String criteriofield){
       try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(criteriofield),true))){
           pw.println(this.id + "|"+ this.nombre+ "|" + this.descripcion + "|"+ this.punt_max+ "|"+ this.idConcurso);
       }catch(Exception e){
           System.out.println(e.getMessage());
       }  
    }
    
    
    public static void saveFile(ArrayList<Criterio> listacriterios, String criteriofield){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(criteriofield),true))){
            for (Criterio crit : listacriterios)
                pw.println(crit.id + "|"+ crit.nombre+ "|" + crit.descripcion + "|"+ crit.punt_max + "|"+ crit.idConcurso);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }       
    }
    
    
    public static ArrayList<Criterio> readFromFile(String criteriofield){
        ArrayList<Criterio> criterios = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(criteriofield)))
        {
            while(sc.hasNextLine())
            {
                // linea = id|nombre|descripcion|punt_max|idConcurso
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                // int id, int punt_max,int, int idConcurso ,String nombre ,int descripcion
                Criterio crit = new Criterio(Integer.parseInt(tokens[0]),(tokens[1]),tokens[2],Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                criterios.add(crit);
            }           
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return criterios;
    }
    
    
    public static ArrayList<Criterio> nextCriterio(Scanner sc){
        int id=0,punt_max, id_concurso, cantidad, contador = 0; ;
        String nombre, descripcion;
        
        System.out.println("Ingrese la cantidad de criterios: ");
        cantidad = sc.nextInt();
        ArrayList<Criterio> lista_criterios_1 = new ArrayList<>(); 
        ArrayList<Criterio> lista_criterios_2 = new ArrayList<>();
        
        ArrayList<Criterio> lista_cri = Criterio.readFromFile("criterios.txt");
        for (Criterio c: lista_cri){
            if (id<c.getId()){
                id=c.getId();
            }
        }
        id = id+1;
        while(contador < cantidad){
            sc.useDelimiter("\n");
            sc.useLocale(Locale.US);                
            
            
            System.out.println("El tamnaño de la lista es: " + id);
            System.out.println("Ingrese el nombre del criterio: ");
            nombre = sc.next();
            System.out.println("Ingrese la descripción del criterio: ");
            descripcion = sc.next();
            System.out.println("Ingrese el puntaje maximo a obtener en ese criterio: ");
            punt_max = sc.nextInt(); 
            Criterio crit = new Criterio(id, nombre, descripcion, punt_max);  
            lista_criterios_1.add(crit);
            contador = contador + 1;
            id=id+1;
            }
            do{
            id_concurso = Util.next_idconcurso(sc);
            if (id_concurso != 0){
                for ( Criterio c1:  lista_criterios_1){
                    Criterio crit2 = new Criterio(c1.getId(),c1.getNombre(), c1.getDescripcion(), c1.getPunt_max(), id_concurso);
                    
                    crit2.saveFile("criterios.txt");
                    lista_criterios_2.add(crit2);
                }
            }
            }while(id_concurso==0);           
        return lista_criterios_1;
        }    
    }

