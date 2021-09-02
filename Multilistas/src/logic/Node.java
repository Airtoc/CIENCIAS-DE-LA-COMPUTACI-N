package logic;

public class Node {
    int codigo;
    String nombre;
    Node sig;
    Node ant;
    Node up;
    Node down;

    public Node(int co, String na) {
        this.codigo = co;
        this.nombre = na;
        this.sig = null;
        this.ant = null;
        this.up = null;
        this.down = null;

    }

    // Getters & Setters:
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setSiguiente(Node siguiente) {
        this.sig = siguiente;
    }

    public void setAnterior(Node anterior) {
        this.ant = anterior;
    }

    public void setUp(Node arriba) {
        this.up = arriba;
    }

    public void setDown(Node abajo) {
        this.down = abajo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCodigo() {

        return this.codigo;
    }

    public Node getSiguiente() {
        return this.sig;
    }

    public Node getAnterior() {
        return this.ant;
    }

    public Node getUp() {
        return this.up;
    }

    public Node getDown() {
        return this.down;
    }

}