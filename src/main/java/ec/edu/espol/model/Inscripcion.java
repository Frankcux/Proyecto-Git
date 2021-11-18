
package ec.edu.espol.model;

import java.util.ArrayList;

public class Inscripcion {
    private int id;
    private String fecha_inscripcion;
    private double valor;

    
    public Inscripcion(int id, String fecha_inscripcion, double valor) {
        this.id = id;
        this.fecha_inscripcion = fecha_inscripcion;
        this.valor = valor;
    }

    public int getId() {
        return this.id;
    }

    public String getFecha_inscripcion() {
        return this.fecha_inscripcion;
    }

    public double getValor() {
        return this.valor;
    }
    
    



}
