package Logic;

public class Node {

    private String value;
    private Node nodoSiguiente,nodoAnterior;

    public Node(String value){
        this.value = value;
        this.nodoSiguiente = null;
        this.nodoAnterior = null;
    }

    public Node(){}

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public void setNodoSiguiente(Node nodo){
        this.nodoSiguiente = nodo;
    }

    public Node getNodoSiguiente(){
        return nodoSiguiente;
    }

    public void setNodoAnterior(Node nodo){
        this.nodoAnterior = nodo;
    }

    public Node getNodoAnterior(){
        return nodoAnterior;
    }
}