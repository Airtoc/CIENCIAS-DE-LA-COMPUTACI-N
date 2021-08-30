package Logic;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Listas {
    private Nodo inicio;
    private String lista = "";
    LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

    public Listas() {
        this.inicio = null;
        map.clear();
    }

    public void mostrarlista(Nodo list) {
        if (list != null) {   
            lista += "Nombre: " + list.getNombre() + "\n";
            lista += "Codigo: " + list.getCodigo() + "\n\n";
            map.put(list.getNombre(),list.getCodigo());
            mostrarlista(list.getSiguiente());
        }
    }

    public void addNodo(Nodo nuevo, Nodo anterior){
        if(nuevo.getCodigo() == anterior.getCodigo()){
            System.out.println("El nodo está repetido");
        }else{
            if(nuevo != anterior){
                if(nuevo.getCodigo() < anterior.getCodigo()){
                    nuevo.setSiguiente(anterior);
                    anterior.setAnterior(nuevo);
                    if(inicio == anterior)
                        inicio = nuevo;
                }else{
                    if(anterior.getSiguiente() != null){
                        if(nuevo.getCodigo() < anterior.getSiguiente().getCodigo()){
                            nuevo.setSiguiente(anterior.getSiguiente());
                            nuevo.setAnterior(anterior);
                            anterior.setSiguiente(nuevo);                
                        }else{
                            addNodo(nuevo,anterior.getSiguiente());
                        }
                    }else{
                        anterior.setSiguiente(nuevo);
                        nuevo.setAnterior(anterior);
                        nuevo.setSiguiente(null);
                    }
                }
            }
        }
        
    }

    public void buscarNodo(Nodo list, int codigo) {
        if (codigo == list.getCodigo()) {
            JOptionPane.showMessageDialog(null,"El nodo se encuentra en la lista");
        } else {
            if (list.getSiguiente() == null) {
                JOptionPane.showMessageDialog(null, "El nodo no se encuentra en la lista");
            } else {
                buscarNodo(list.getSiguiente(), codigo); // Se reinicia la busqueda pero con el siguiente nodo
            }

        }
    }

    public void eliminarNodo(Nodo list, int codigo) {
        map.clear();
        if (list.getCodigo() == codigo) { // Se comprueban que los codigos sean iguales
            // PRIMERO
            if (list.getAnterior() == null) {
                this.inicio = list.getSiguiente();
                list.getSiguiente().setAnterior(null);
            }
            // ULTIMO
            if (list.getSiguiente() == null) {
                list.getAnterior().setSiguiente(null);
            }
            // MEDIO
            if (list.getAnterior() != null && list.getSiguiente() != null) {
                list.getAnterior().setSiguiente(list.getSiguiente());
                list.getSiguiente().setAnterior(list.getAnterior());
            }
        } else {
            eliminarNodo(list.getSiguiente(), codigo);
        }
    }

    // Getters & Setters :
    public Nodo getCabeza() {
        return this.inicio;
    }

    public String getLista() {
        return this.lista;
    }
    public Map<String, Integer> getMap() {
        return this.map;
    }

    public void setCabeza(Nodo cabeza) {
        this.inicio = cabeza;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

}
