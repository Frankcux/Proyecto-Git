
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

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha_inscripcion(String fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", fecha_inscripcion=" + fecha_inscripcion + ", valor=" + valor + '}';
    }
    
    
    



}
