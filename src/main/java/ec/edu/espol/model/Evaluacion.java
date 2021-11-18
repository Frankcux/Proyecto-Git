
package ec.edu.espol.model;

public class Evaluacion {
    private int id;
    private double nota;

    public Evaluacion(int id, double nota) {
        this.id = id;
        this.nota = nota;
    }

    public int getId() {
        return this.id;
    }

    public double getNota() {
        return this.nota;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNota(double nota) {
        this.nota = nota;
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
        Evaluacion other = (Evaluacion) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evaluacion{" + "id=" + id + ", nota=" + nota + '}';
    }
    
    
}






