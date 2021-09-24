package GUI;

import Logic.Tree;

public class ControladorGraph {
	 private Canvas objLienzo; //VISTA
	 private Tree objArbol; //MODELO

	    public ControladorGraph(Canvas objLienzo, Tree objArbol) {
	        this.objLienzo = objLienzo;
	        this.objArbol = objArbol;
	    }
	    
	    public void iniciar() {
	    	System.out.println("paiting...");
	        objLienzo.setArbol(objArbol);
	    }
}
