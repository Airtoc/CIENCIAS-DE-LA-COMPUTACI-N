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

    //Mostrar por niveles
    public String[][] showNiv() {
        
        String[][] retorne = new String[arbol.getIn().size()][3];//Columnas 
        //aumenta el general
        int niv = 0;
        //Obtiene el nivel max
        for (int i = 0; i < retorne.length; i++) {
            if (arbol.GetNivelXNodo(arbol.getIn().get(i).getEstudiante().getTelefono()) > niv) {
                niv = arbol.GetNivelXNodo(arbol.getIn().get(i).getEstudiante().getTelefono());
            }
        }
        //Itera por niveles
        int index = 0;
        for (int a = 0; a < niv+1; a++) {
            //itera por nodos
            for (int i = 0; i < retorne.length; i++) {
                if(arbol.GetNivelXNodo(arbol.getIn().get(i).getEstudiante().getTelefono()) == a){
                    for (int j = 0; j < retorne[i].length; j++) {
                    if (j == 1) {
                        retorne[index][j] = arbol.getIn().get(i).getEstudiante().getNombre();
                    } else if (j == 2) {
                        retorne[index][j] = "" + arbol.getIn().get(i).getEstudiante().getTelefono();
                        
                    } else {
                        retorne[index][j] = "" + arbol.getIn().get(i).getBalance();
                    }
                }
                    index = index +1;
                }
                
            }

        }

        return retorne;
    }

    //Mostrar en pos
    public String[][] showPos() {
        String[][] retorno = new String[arbol.getPos().size()][3];
        for (int i = 0; i < retorno.length; i++) {
            for (int j = 0; j < retorno[i].length; j++) {
                if (j == 1) {
                    retorno[i][j] = arbol.getPos().get(i).getEstudiante().getNombre();
                } else if (j == 2) {
                    retorno[i][j] = "" + arbol.getPos().get(i).getEstudiante().getTelefono();
                } else {
                    retorno[i][j] = "" + arbol.getPos().get(i).getBalance();
                }
            }
        }

        return retorno;
    }

}
