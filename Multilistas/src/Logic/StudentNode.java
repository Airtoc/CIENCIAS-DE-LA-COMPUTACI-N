package Logic;

public class StudentNode {
    String nombre;
    StudentNode sig;
    StudentNode ant;
    StudentNode cabezaStu;
    CourseNode cabeza;


    public StudentNode(String na) {
        this.nombre = na;
        this.sig = null;
        this.ant = null;
        this.cabeza = null;

    }

    // Getters & Setters:
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSiguiente(StudentNode siguiente) {
        this.sig = siguiente;
    }

    public void setAnterior(StudentNode anterior) {
        this.ant = anterior;
    }

    public String getNombre() {
        return this.nombre;
    }

    public StudentNode getSiguiente() {
        return this.sig;
    }

    public StudentNode getAnterior() {
        return this.ant;
    }

    public CourseNode getCabeza() {
        return cabeza;
    }

    public void setCabeza(CourseNode cabeza) {
        this.cabeza = cabeza;
    }

    public StudentNode getCabezaStu() {
        return cabezaStu;
    }

    public void setCabezaStu(StudentNode cabezaStu) {
        this.cabezaStu = cabezaStu;
    }
    
    

}
