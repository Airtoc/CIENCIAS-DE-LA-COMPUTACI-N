package Logic;

public class NodoFila {
	
	private int fila;
	private int valor;
	private NodoFila abajo;
	private NodoFila arriba;
	
	public NodoFila(int fila, int valor) {
		this.fila = fila;
		this.valor = valor;
		abajo = null;
		arriba = null;
		
	}
	
	
	
	//Getters & Setters
	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public NodoFila getAbajo() {
		return abajo;
	}

	public void setAbajo(NodoFila abajo) {
		this.abajo = abajo;
	}

	public NodoFila getArriba() {
		return arriba;
	}

	public void setArriba(NodoFila arriba) {
		this.arriba = arriba;
	}
	
}