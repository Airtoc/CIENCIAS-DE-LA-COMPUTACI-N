
package Logic;


public class CourseNode {
    String curso;
    CourseNode sig;
    CourseNode ant;
    StudentNode cabezaStudent;

    public CourseNode(String nombre) {
        this.curso = nombre;
        this.sig = null;
        this.ant = null;
        this.cabezaStudent = null;

    }
    
    // Getters & Setters:
    public void setNombre(String nombre) {
        this.curso = nombre;
    }

    public void setSiguiente(CourseNode siguiente) {
        this.sig = siguiente;
    }

    public void setAnterior(CourseNode anterior) {
        this.ant = anterior;
    }

    public String getCurso() {
        return this.curso;
    }

    public CourseNode getSiguiente() {
        return this.sig;
    }

    public CourseNode getAnterior() {
        return this.ant;
    }

    public StudentNode getCabezaStudent() {
        return cabezaStudent;
    }

    public void setCabezaStudent(StudentNode abj) {
        this.cabezaStudent = abj;
    }
    
    
}
