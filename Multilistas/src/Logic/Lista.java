package Logic;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
//import java.util.Map;

public class Lista {
    private CourseNode inicio;
    private ArrayList<String> cursos = new ArrayList<String>();
    private ArrayList<String> estudiantes = new ArrayList<String>();
    
    public Lista() {
        this.inicio = null;
        limpiar();
    }
    
    public void limpiar(){
        cursos.clear();
        estudiantes.clear();
    }
    public Boolean ordenar(String uno, String dos){
        List ord = new LinkedList<>();
        ord.add(uno);
        ord.add(dos);
        
        Collections.sort(ord);
        
        if(ord.get(0) == uno){
            return false;
        }else{
            return true;
        }

    }

    public void addMateria(CourseNode nuevo, CourseNode anterior){
        cursos.clear();
        if(nuevo.getCurso() == anterior.getCurso()){
            JOptionPane.showMessageDialog(null,"El Curso ya se encuentra añadido");
        }else{
            if(nuevo != anterior){
                if(ordenar(nuevo.getCurso(),anterior.getCurso()) == false){
                    nuevo.setSiguiente(anterior);
                    anterior.setAnterior(nuevo);
                    if(inicio == anterior)
                        inicio = nuevo;
                }else{
                    if(anterior.getSiguiente() != null){
                        if(ordenar(nuevo.getCurso(),anterior.getSiguiente().getCurso()) == false){
                            nuevo.setSiguiente(anterior.getSiguiente());
                            nuevo.setAnterior(anterior);
                            anterior.setSiguiente(nuevo);                
                        }else{
                            addMateria(nuevo,anterior.getSiguiente());
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

    public void eliminarMateria(CourseNode list, String nombre) {
        cursos.clear();
        if (list.getCurso() == nombre) { // Se comprueban que los codigos sean iguales
            // asignaciones basicas 
            //Primer nodo 
            if (list.getAnterior() == null) {
                this.inicio = list.getSiguiente();
                list.getSiguiente().setAnterior(null);
            }
            //Ultimo nodo
            if (list.getSiguiente() == null) {
                list.getAnterior().setSiguiente(null);
            }
            //Nodo intermedio 
            if (list.getAnterior() != null && list.getSiguiente() != null) {
                list.getAnterior().setSiguiente(list.getSiguiente());
                list.getSiguiente().setAnterior(list.getAnterior());
            }
        } else {
            eliminarMateria(list.getSiguiente(), nombre);
        }
    }

    public void mostrarlista(CourseNode list) {
        if (list != null) {   
            cursos.add(list.getCurso());
            mostrarlista(list.getSiguiente());
        }
    }

    // Getters & Setters :
    public CourseNode getCabeza() {
        return this.inicio;
    }

    public ArrayList<String> getCursos() {
        return cursos;
    }

    public void setCabeza(CourseNode cabeza) {
        this.inicio = cabeza;
    }


}