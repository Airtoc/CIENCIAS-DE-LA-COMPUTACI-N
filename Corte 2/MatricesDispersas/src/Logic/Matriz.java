package Logic;

import javax.swing.JOptionPane;

public class Matriz {
	private NodoColumna inicio;
	private String lista = "";
	private String tipo = "";

	public Matriz(String tp) {
		tipo = tp;
		this.inicio = null;
	}

	// Metodos necesarios

	public void addNodoColumna(NodoColumna nuevo, NodoColumna anterior, NodoFila fila) {
		if(anterior != null) {
			if(nuevo.getCol() == anterior.getCol()) {
				//Si se repite la columna solo se añade la fila
				addNodoFila(fila,anterior.getCabeza(),anterior);
			}else {
				if(nuevo.getCol()<anterior.getCol()) {
					if(anterior == inicio) {
						nuevo.setSiguiente(inicio);
						inicio.setAnterior(nuevo);
						inicio = nuevo;
						addNodoFila(fila,nuevo.getCabeza(),nuevo);
						
					}else {
						anterior.getAnterior()
					}
				}
			}
		}
	}

	public void addNodoFila(NodoFila nuevo,NodoFila listaFil, NodoColumna listaCol ) {
		
		if(lista != null){
            if(nuevo.getFila() == listaFil.getFila()){
                JOptionPane.showMessageDialog(null, "Ya existe un valor en esta posición");
            }else{
                if(nuevo.getFila()<listaFil.getFila()){
                    if(listaFil == listaCol.getCabeza()){
                        listaCol.getCabeza().setArriba(nuevo);
                        nuevo.setAbajo(listaCol.getCabeza());
                        listaCol.setCabeza(nuevo);
                    }else{
                        listaFil.getArriba().setAbajo(nuevo);
                        nuevo.setArriba(listaFil.getArriba());
                        nuevo.setAbajo(listaFil);
                        listaFil.setArriba(nuevo);
                    }
                }else{
                    if(listaFil.getAbajo() == null){
                        listaFil.setAbajo(nuevo);
                        nuevo.setArriba(listaFil);
                    }else{
                        addNodoFila(nuevo,listaFil.getAbajo(),listaCol);
                    }
                }
            }
        }else{
            listaCol.setCabeza(nuevo);
        }
	}

	public void mostrarlista(NodoColumna list) {
		if (list != null) {
			lista += "xd";
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
