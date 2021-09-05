
package Logic;


public class CourseNode {
    String curso;
    CourseNode sig;
    CourseNode ant;

    public CourseNode(String nombre) {
        this.curso = nombre;
        this.sig = null;
        this.ant = null;

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

}
