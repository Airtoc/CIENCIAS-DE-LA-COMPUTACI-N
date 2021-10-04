package Controllers;

import Models.ArbolAvl;
import Models.Estudiante;

public class ArbolAvlController {

    private ArbolAvl arbol;
    private static ArbolAvlController instance;

    private ArbolAvlController() {
        arbol = new ArbolAvl();
    }

    public static ArbolAvlController getInstance() {
        if (instance == null) {
            instance = new ArbolAvlController();
        }
        return instance;
    }

    public ArbolAvl getArbol() {
        return arbol;
    }

    public void setArbol(ArbolAvl arbol) {
        this.arbol = arbol;
    }

    //Insertar estudiante
    public void add(String nombre, long telefono) throws Exception {
        int res = arbol.Insertar(new Estudiante(nombre, telefono));
        if (res == -1) {
            throw new Exception("El telefono se encuentra repetido");
        }
    }

    //Eliminar estudiante
    public void remove(long telefono) throws Exception {
        boolean eliminado = arbol.RetirarNodo(telefono, false);
        if (!eliminado) {
            throw new Exception("El estudiante no se encuentra registrado");
        }

    }

    //Obtener estudiante
    public Estudiante getEstudiante(long codigo) {
        Estudiante estudiante = arbol.ReturnNodo(codigo).getEstudiante();
        return estudiante;
    }

    //Mostrar en inorder
    public String[][] showIn() {
        String[][] retorno = new String[arbol.getIn().size()][3];//Columnas 
        for (int i = 0; i < retorno.length; i++) {
            for (int j = 0; j < retorno[i].length; j++) {
                if (j == 1) {
                    retorno[i][j] = arbol.getIn().get(i).getEstudiante().getNombre();
                } else if (j == 2) {
                    retorno[i][j] = "" + arbol.getIn().get(i).getEstudiante().getTelefono();
                } else {
                    retorno[i][j] = "" + arbol.getIn().get(i).getBalance();
                }
            }
        }
        return retorno;
    }

}
