
package GUI;

import Logic.Nodo;

public class Controlador {
    private Lienzo objLienzo; //VISTA
    private Nodo objArbol; //MODELO

    public Controlador(Lienzo objLienzo, Nodo objArbol) {
        this.objLienzo = objLienzo;
        this.objArbol = objArbol;
    }
    
    public void iniciar() {
        objLienzo.setObjArbol(objArbol);
    }
}