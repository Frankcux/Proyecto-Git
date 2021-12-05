package ec.edu.espol.model;




import ec.edu.espol.model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author 59399
 */
public class Mascota {
    private String nombre,raza,tipo,emailDueño;
    private int id,idDueño;
    private LocalDate fechaNacimiento;
    private Duen dueño;
    private ArrayList<Inscripcion> inscripciones;

    public Mascota( int id,String nombre, String raza, String tipo, LocalDate fechaNacimiento, int idDueño) {
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.idDueño = idDueño;
    }
    
    //Gets and Sets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(int idDueño) {
        this.idDueño = idDueño;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Duen getDueño() {
        return dueño;
    }

    public void setDueño(Duen dueño) {
        this.dueño = dueño;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("Mascota[ id= ");
        sb.append(this.id);
        sb.append(", nombre= ");
        sb.append(this.nombre);
        sb.append(", raza= ");
        sb.append(this.raza);
        sb.append(", tipo= ");
        sb.append(this.tipo);
        sb.append(", idDueño= ");
        sb.append(this.idDueño);
        sb.append(", fechaNacimiento= ");
        sb.append(this.fechaNacimiento);
        sb.append(", Inscripciones= ");
        for (Inscripcion i: inscripciones){
            sb.append(i.toString());
            if(this.inscripciones.size()!=this.inscripciones.size()-1)
                sb.append(";");
                
            }
        sb.append("]");
        return sb.toString();
    }
   
    
    public void saveFile(String file){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(file),true)))
        {
            pw.println(this.getId() + "|"+ this.getNombre()+ "|" + this.getRaza() + "|"+ this.getTipo()+ "|"+ this.getFechaNacimiento()+ "|"+ this.getIdDueño()
                    );
            /*for (Inscripcion i: this.getInscripciones()){
                pw.print("|"+i.getId());
            
            }*/
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    Scanner sc= new Scanner(System.in);

    public static Mascota nextMascota(Scanner sc){

        String nombre,raza,tipo, emailDueño;
        int id,idDueño;
        LocalDate fecha;
        sc.useLocale(Locale.US);
        ArrayList <Mascota> lista_mascotas = Mascota.readFile("mascotas.txt");
        id = lista_mascotas.size()+1;
        System.out.println("Ingrese el nombre de la mascota: ");
        nombre = sc.next();        
        System.out.println("Ingrese la raza de la mascota: ");
        raza = sc.next();
        System.out.println("Ingrese la fecha de nacimiento: ");
        fecha = LocalDate.parse(sc.next());
        System.out.println("Ingrese el tipo de mascota: ");
        tipo = sc.next();
        
        Duen dueño = Util.next_Duendueño(sc);
        /*ArrayList<Inscripcion> inscripciones= new ArrayList<>(); 
        System.out.println("Cuantas inscripciones tiene la mascota: ");
        int numeroInst=sc.nextInt();
        for (int i=0; i<= numeroInst;i++){
            inscripciones.add(Util.next_InsInscripcion(sc));
        }*/
        Mascota m = new Mascota( id,nombre,raza, tipo, fecha,dueño.getId());
        ArrayList<Duen> lista_duenos = Duen.readFile("dueños.txt");
        /*for (Duen d : lista_duenos){
            if (d.getId()==dueño.getId()){
                d.getMascotas().add(m);
                d.saveFile("dueños_final");
            }           
        }*/
        m.saveFile("mascotas.txt");
        return m;
        
    }

        //saveFile
    
    public static void  saveFile( ArrayList<Mascota> mascotas , String nombre){
        //en modo append
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombre),true))){
            for (   Mascota v:  mascotas ){
                pw.println(v.getId() + "|"+ v.getNombre()+ "|" + v.getRaza() + "|"+ v.getTipo()+
                        "|"+ v.getFechaNacimiento()+ "|"+ v.getIdDueño()
                    );
                /*
                for (Inscripcion i: v.getInscripciones()){
                    pw.print("|"+i.getId());
                }*/
            }    
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /*
    //el comportamiento estático readFile
    public static ArrayList<Mascota>  readFile(String nombre) {
        ArrayList<Mascota> mascotas= new ArrayList<>();
        try (Scanner sc =new Scanner(new File (nombre))){
            while(sc.hasNextLine()){
                ArrayList<Inscripcion> inscrip = null;
                String linea= sc.nextLine();
                String[] datos = linea.split("\\|"); 
                Duen duen1;
                /*
                Inscripcion inst= null;
                ArrayList<Inscripcion> inscripcion22= inst.readFile("inscripcion.txt");
                if (datos.length>7){
                    String[] da2 = linea.split("\\|"); 
                    for (Inscripcion m: inscripcion22){
                        for (int i =7; i<=datos.length;i++){
                            if(m.getId()== Integer.parseInt(datos[i-1])){
                                inscrip.add(m);
                            }
                        }
                    }
                    
                    ArrayList<Duen> dueñosTodos= Duen.readFile("dueño.txt");
                    Duen dueño2= null;
                    for (Duen m: dueñosTodos){
                        if(m.getEmail()== datos[5]){
                            dueño2= m;
                        }
                    }
                    Mascota v= new Mascota(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],LocalDate.parse(datos[4]),dueño2,inscrip);
                }
                Mascota v= new Mascota(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],LocalDate.parse(datos[4]),dueño2.getEmail());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return mascotas;
        
    }*/

    public static ArrayList<Mascota> readFile(String nombre){
        ArrayList<Mascota> mascotas= new ArrayList<>();
        try (Scanner sc =new Scanner(new File (nombre))){
            while(sc.hasNextLine()){
                String linea= sc.nextLine();
                String[] datos = linea.split("\\|"); 
                Mascota v= new Mascota(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],LocalDate.parse(datos[4]),Integer.parseInt(datos[5]));
                mascotas.add(v);
            } 
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return mascotas;
    }
    
}
