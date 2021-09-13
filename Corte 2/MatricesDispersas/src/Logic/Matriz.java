package Logic;

import javax.swing.JOptionPane;

public class Matriz {
	private NodoColumna inicio;
	private String listaCo = "";
	private String tipo = "";
	private String listaFilas ="";

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
				if(nuevo.getCol() < anterior.getCol()) {
					if(anterior == inicio) {
						nuevo.setSiguiente(inicio);
						inicio.setAnterior(nuevo);
						inicio = nuevo;
						addNodoFila(fila,nuevo.getCabeza(),nuevo);
						
					}else {
						anterior.getAnterior().setSiguiente(nuevo);
						nuevo.setAnterior(anterior.getAnterior());
						nuevo.setSiguiente(anterior);
						anterior.setAnterior(nuevo);
						addNodoFila(fila,nuevo.getCabeza(),nuevo);
					}
				}else {
					if(anterior.getSiguiente() == null) {
						anterior.setSiguiente(nuevo);
						nuevo.setAnterior(anterior);
						addNodoFila(fila,anterior.getSiguiente().getCabeza(),anterior.getSiguiente());
					}else {
						addNodoColumna(nuevo,anterior.getSiguiente(),fila);
					}
				}
			}
		}
	}

	public void addNodoFila(NodoFila nuevo,NodoFila listaFil, NodoColumna listaCol ) {
		
		if(listaFil != null){
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
            System.out.println(listaCol.getCabeza().getFila());
        }
	}

	public void mostrarlista(NodoColumna list) {
		if (list != null) {
			listaCo += "Columna: "+list.getCol()+"\n";
			System.out.println("Columna: "+list.getCol()+"\n");//imprime columna
			mostrarListaFilas(list.getCabeza());
			mostrarlista(list.getSiguiente());
		}
		//System.out.println(listaCo);
		//System.out.println(listaFilas);
		
	}
	public void mostrarListaFilas(NodoFila list) {
		if(list != null) {
			listaFilas += "Fila : "+list.getFila()+" Valor: "+list.getValor()+"\n";
			System.out.println("Fila : "+list.getFila()+" Valor: "+list.getValor());
			mostrarListaFilas(list.getAbajo());
		}
		
	}

	// Getters & Setters :

	public NodoColumna getInicio() {
		return inicio;
	}

	public void setInicio(NodoColumna inicio) {
		this.inicio = inicio;
	}

	public String getListaCo() {
		return listaCo;
	}

	public void setListaCo(String listaCo) {
		this.listaCo = listaCo;
	}

	public String getListaFilas() {
		return listaFilas;
	}

	public void setListaFilas(String listaFilas) {
		this.listaFilas = listaFilas;
	}

	

}
