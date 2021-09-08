package Logic;

public class NodoColumna {
	
	private int col;
	private NodoColumna siguiente;
	private NodoColumna anterior;
	private NodoFila cabeza;
	
	//Constructor
	public NodoColumna(int n){
		col = n;
		siguiente = null;
		cabeza = null;
		
	}
	
	
	//Getters & Setters 
	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public NodoColumna getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoColumna siguiente) {
		this.siguiente = siguiente;
	}

	public NodoFila getCabeza() {
		return cabeza;
	}

	public void setCabeza(NodoFila cabeza) {
		this.cabeza = cabeza;
	}


	
	public NodoColumna getAnterior() {
		return anterior;
	}
	


	public void setAnterior(NodoColumna anterior) {
		this.anterior = anterior;
	}
	
	
	

}
