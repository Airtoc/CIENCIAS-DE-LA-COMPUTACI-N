package Logic;

public class StudentNode {

    int codigo;
    String nombre;
    StudentNode sig;
    StudentNode ant;
    CourseNode cabeza;


    public StudentNode(int co, String na,CourseNode ca) {
        this.codigo = co;
        this.nombre = na;
        this.sig = null;
        this.ant = null;
        this.cabeza =ca;

    }

    // Getters & Setters:
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getCodigo() {

        return this.codigo;
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
    
    

}
