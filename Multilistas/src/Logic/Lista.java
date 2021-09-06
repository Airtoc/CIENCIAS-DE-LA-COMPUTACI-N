package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import javax.swing.*;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
//import java.util.Map;

public class Lista {
    //Cabeza lista materias
    private CourseNode inicio;
    //materia seleccionada
    private CourseNode courseSelect;
    //cabeza estudiantes
    private StudentNode inicioEstudiante;
    //Cosas para el map
    private ArrayList<String> cursos = new ArrayList<String>();
    LinkedHashMap<String, Integer> estudiantes = new LinkedHashMap<String, Integer>();

    public Lista() {
        this.inicio = null;
        limpiar();
    }

    //Basics
    public void limpiar() {
        cursos.clear();
        estudiantes.clear();
    }

    public Boolean ordenar(String uno, String dos) {
        List ord = new LinkedList<>();
        ord.add(uno);
        ord.add(dos);

        Collections.sort(ord);

        if (ord.get(0) == uno) {
            return false;
        } else {
            return true;
        }

    }

    public void mostrarlista(CourseNode list) {
        if (list != null) {
            cursos.add(list.getCurso());
            mostrarlista(list.getSiguiente());
        }
    }
     public void mostrarEstudiantes(StudentNode list) {
        if (list != null) {   
            estudiantes.put(list.getNombre(),list.getCodigo());
            mostrarEstudiantes(list.getSiguiente());
        }
    }


    //Materias
    public void addMateria(CourseNode nuevo, CourseNode anterior) {
        cursos.clear();
        if (nuevo.getCurso() == anterior.getCurso()) {
            JOptionPane.showMessageDialog(null, "El Curso ya se encuentra añadido");
        } else {
            if (nuevo != anterior) {
                if (ordenar(nuevo.getCurso(), anterior.getCurso()) == false) {
                    nuevo.setSiguiente(anterior);
                    anterior.setAnterior(nuevo);
                    if (inicio == anterior) {
                        inicio = nuevo;
                    }
                } else {
                    if (anterior.getSiguiente() != null) {
                        if (ordenar(nuevo.getCurso(), anterior.getSiguiente().getCurso()) == false) {
                            nuevo.setSiguiente(anterior.getSiguiente());
                            nuevo.setAnterior(anterior);
                            anterior.setSiguiente(nuevo);
                        } else {
                            addMateria(nuevo, anterior.getSiguiente());
                        }
                    } else {
                        anterior.setSiguiente(nuevo);
                        nuevo.setAnterior(anterior);
                        nuevo.setSiguiente(null);
                    }
                }
            }
        }

    }

    public void eliminarMateria(CourseNode lista, String nombre) {
        cursos.clear();
        asignarMateria(lista,nombre);
        if (courseSelect.getCabezaStudent()!= null) {
            JOptionPane.showMessageDialog(null, "Elimine primero todos los estudiantes de la materia seleccionada");
        } else {
            if (lista.getCurso().equals(nombre) == true) { // Se comprueban que los codigos sean iguales
                // asignaciones basicas 
                //Primer nodo 
                if (lista.getAnterior() == null) {
                    this.inicio = lista.getSiguiente();
                    lista.getSiguiente().setAnterior(null);
                }
                //Ultimo nodo
                if (lista.getSiguiente() == null) {
                    lista.getAnterior().setSiguiente(null);
                }
                //Nodo intermedio 
                if (lista.getAnterior() != null && lista.getSiguiente() != null) {
                    lista.getAnterior().setSiguiente(lista.getSiguiente());
                    lista.getSiguiente().setAnterior(lista.getAnterior());
                }
            } else {
                eliminarMateria(lista.getSiguiente(), nombre);
            }
        }
    }

    public void asignarMateria(CourseNode lista, String nombre) {
        if (lista != null) {
            if (lista.getCurso().equals(nombre)) {
                courseSelect = lista;
            } else {
                mostrarlista(lista.getSiguiente());
            }
        }
    }
    
    //Estudiantes
    public void addStudent(StudentNode nuevo, StudentNode anterior) {
        //Limpia el mapa
        estudiantes.clear();
        //verifica que los nombres no se repitan
        if (nuevo.getNombre() == anterior.getNombre()) {
            JOptionPane.showMessageDialog(null, "El estudiante ya se encuentra registrado");
        } else {
            //verifican que sean diferentes
            if (nuevo != anterior) {
                //
                if (ordenar(nuevo.getNombre(), anterior.getNombre()) == false) {
                    nuevo.setSiguiente(anterior);
                    anterior.setAnterior(nuevo);
                    if (inicioEstudiante == anterior) {
                        inicioEstudiante = nuevo;
                    }
                } else {
                    if (anterior.getSiguiente() != null) {
                        if (ordenar(nuevo.getNombre(), anterior.getSiguiente().getNombre()) == false) {
                            nuevo.setSiguiente(anterior.getSiguiente());
                            nuevo.setAnterior(anterior);
                            anterior.setSiguiente(nuevo);
                        } else {
                            addStudent(nuevo, anterior.getSiguiente());
                        }
                    } else {
                        anterior.setSiguiente(nuevo);
                        nuevo.setAnterior(anterior);
                        nuevo.setSiguiente(null);
                    }
                }
            }
        }

    }

    public void eliminarStudent(StudentNode list, String nombre) {
        estudiantes.clear();
        if (list.getNombre() == nombre) { // Se comprueban que los codigos sean iguales
            // asignaciones basicas 
            //Primer nodo 
            if (list.getAnterior() == null) {
                this.inicioEstudiante = list.getSiguiente();
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
            eliminarStudent(list.getSiguiente(), nombre);
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

    public CourseNode getCourseSelec() {
        return courseSelect;
    }

    public void setCourseSelec(CourseNode selec) {
        this.courseSelect = selec;
    }

    public LinkedHashMap<String, Integer> getEstudiantes() {
        return estudiantes;
    }
    

}
