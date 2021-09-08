package Logic;

public class Matriz {
	private NodoColumna inicio;
	private String lista = "";

	public Matriz() {

		this.inicio = null;
	}

	public void addDato(int fila, int columna, int valor) {

	}
	// Metodos necesarios

	public void addNodoColumna(NodoColumna nuevo, NodoColumna anterior) {
		if (nuevo != anterior) {
			if (nuevo.getCol() > anterior.getCol()) {
				nuevo.setSiguiente(anterior);
				anterior.setAnterior(nuevo);
				if (inicio == anterior)
					inicio = nuevo;
			} else {
				if (anterior.getSiguiente() != null) {
					if (nuevo.getCol() < anterior.getSiguiente().getCol()) {
						nuevo.setSiguiente(anterior.getSiguiente());
						nuevo.setAnterior(anterior);
						anterior.setSiguiente(nuevo);
					} else {
						addNodoColumna(nuevo, anterior.getSiguiente());
					}
				} else {
					anterior.setSiguiente(nuevo);
					nuevo.setAnterior(anterior);
					nuevo.setSiguiente(null);
				}
			}
		}
	}

	public void addNodoFila(NodoFila nuevo, NodoColumna lista,int columna) {
		//A el metodo se le pasa la cabeza de las columnas 
		if(columna == lista.getCol()) {
			NodoFila anterior = lista.getCabeza();
			if (nuevo != anterior) {
				if (nuevo.getFila() > anterior.getFila()) {
					nuevo.setAbajo(anterior);
					anterior.setArriba(nuevo);
					if (lista.getCabeza() == anterior) {
						lista.setCabeza(nuevo);
					} else {
						if (anterior.getAbajo() != null) {
							if (nuevo.getFila() < anterior.getAbajo().getFila()) {
								nuevo.setArriba(anterior.getAbajo());
								nuevo.setArriba(anterior);
								anterior.setAbajo(nuevo);
							} else {
								addNodoFila(nuevo, lista.getSiguiente(), columna);
							}
						} else {
							anterior.setAbajo(nuevo);
							nuevo.setArriba(anterior);
							nuevo.setAbajo(null);
						}
					}
				}
			}
		}else {
			addNodoFila(nuevo, lista.getSiguiente(), columna);
		}
	}

	public void mostrarlista(NodoColumna list) {
		if (list != null) {
			mostrarlista(list.getSiguiente());
		}
	}

	// Getters & Setters :

	public NodoColumna getInicio() {
		return inicio;
	}

	public void setInicio(NodoColumna inicio) {
		this.inicio = inicio;
	}

	public String getLista() {
		return lista;
	}

	public void setLista(String lista) {
		this.lista = lista;
	}

}
