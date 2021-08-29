package Logic;

public class Nodo {
    int codigo;
    String nombre;
    Nodo sig;
    Nodo ant;


    public Nodo(int co, String na){
        this.codigo = co;
        this.nombre = na;
        this.sig = null;
        this.ant = null;

    }

    //Getters & Setters:
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setSiguiente(Nodo siguiente){
        this.sig = siguiente;
    }
    public void setAnterior(Nodo anterior){
        this.ant = anterior;
    }

    public String getNombre(){
        return this.nombre;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public Nodo getSiguiente(){
        return this.sig;
    }

    public Nodo getAnterior(){
        return this.ant;
    }



}
