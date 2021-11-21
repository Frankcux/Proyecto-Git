
package ec.edu.espol.model;


public class Criterio {
    private int id;
    private String nombre;
    private String descripcion;
    private int punt_max;

    public Criterio(int id, String descripcion, String nombre, int punt_max) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
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

    public double getPunt_max() {
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Criterio{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", punt_max=" + punt_max + '}';
    }


    
    
    
    
}
