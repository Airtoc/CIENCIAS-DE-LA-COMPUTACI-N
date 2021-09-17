package Logic;

import javax.swing.JOptionPane;
import javax.swing.*;

public class Matriz {

	private NodoColumna inicio;
	private String listaCo = "";
	private String tipo = "";
	private String listaFilas = "";
	private int maxFil=0;
	private int maxCol;
	private int val, itr,itrF,mode;

	public Matriz(String tp) {
		tipo = tp;
		this.inicio = null;
	}

	// Metodos necesarios

	public void addNodoColumna(NodoColumna nuevo, NodoColumna anterior, NodoFila fila) {
		if (anterior != null) {
			if (nuevo.getCol() == anterior.getCol()) {
				// Si se repite la columna solo se añade la fila
				addNodoFila(fila, anterior.getCabeza(), anterior);
			} else {
				if (nuevo.getCol() < anterior.getCol()) {
					if (anterior == inicio) {
						nuevo.setSiguiente(inicio);
						inicio.setAnterior(nuevo);
						inicio = nuevo;
						addNodoFila(fila, nuevo.getCabeza(), nuevo);

					} else {
						anterior.getAnterior().setSiguiente(nuevo);
						nuevo.setAnterior(anterior.getAnterior());
						nuevo.setSiguiente(anterior);
						anterior.setAnterior(nuevo);
						addNodoFila(fila, nuevo.getCabeza(), nuevo);
					}
				} else {
					if (anterior.getSiguiente() == null) {
						anterior.setSiguiente(nuevo);
						nuevo.setAnterior(anterior);
						addNodoFila(fila, anterior.getSiguiente().getCabeza(), anterior.getSiguiente());
					} else {
						addNodoColumna(nuevo, anterior.getSiguiente(), fila);
					}
				}
			}
		}
	}

	public void addNodoFila(NodoFila nuevo, NodoFila listaFil, NodoColumna listaCol) {

		if (listaFil != null) {
			if (nuevo.getFila() == listaFil.getFila()) {
				JOptionPane.showMessageDialog(null, "Ya existe un valor en esta posición");
			} else {
				if (nuevo.getFila() < listaFil.getFila()) {
					if (listaFil == listaCol.getCabeza()) {
						listaCol.getCabeza().setArriba(nuevo);
						nuevo.setAbajo(listaCol.getCabeza());
						listaCol.setCabeza(nuevo);
					} else {
						listaFil.getArriba().setAbajo(nuevo);
						nuevo.setArriba(listaFil.getArriba());
						nuevo.setAbajo(listaFil);
						listaFil.setArriba(nuevo);
					}
				} else {
					if (listaFil.getAbajo() == null) {
						listaFil.setAbajo(nuevo);
						nuevo.setArriba(listaFil);
					} else {
						addNodoFila(nuevo, listaFil.getAbajo(), listaCol);
					}
				}
			}
		} else {
			listaCol.setCabeza(nuevo);
			//System.out.println(listaCol.getCabeza().getFila());
		}
	}
	
	public void insertarColumnaR(NodoColumna nuevaColumna, NodoFila nuevaFila, NodoColumna nodoListaColumna){
        if(nodoListaColumna != null){
            if(nuevaColumna.getCol() == nodoListaColumna.getCol()){
                insertarFilaR(nuevaFila,nodoListaColumna.getCabeza(),nodoListaColumna);
            }else{
                if(nuevaColumna.getCol()<nodoListaColumna.getCol()){
                    if(nodoListaColumna == this.inicio){
                        nuevaColumna.setSiguiente(inicio);
                        this.inicio.setAnterior(nuevaColumna);
                        this.inicio = nuevaColumna;
                        insertarFilaR(nuevaFila,nuevaColumna.getCabeza(),nuevaColumna);
                    }else{
                        nodoListaColumna.getAnterior().setSiguiente(nuevaColumna);
                        nuevaColumna.setAnterior(nodoListaColumna.getAnterior());
                        nuevaColumna.setSiguiente(nodoListaColumna);
                        nodoListaColumna.setAnterior(nuevaColumna);
                        insertarFilaR(nuevaFila,nuevaColumna.getCabeza(),nuevaColumna);
                    }
                }else{
                    if(nodoListaColumna.getSiguiente() == null){
                        nodoListaColumna.setSiguiente(nuevaColumna);
                        nuevaColumna.setAnterior(nodoListaColumna);
                        insertarFilaR(nuevaFila,nuevaColumna.getCabeza(),nuevaColumna);
                    }else{
                        insertarColumnaR(nuevaColumna, nuevaFila, nodoListaColumna.getSiguiente());
                    }
                }
            }
        }
    }
	
	private void insertarFilaR(NodoFila nuevaFila, NodoFila nodoListaFila, NodoColumna columna){
        if(nodoListaFila != null){
            if(nuevaFila.getFila() == nodoListaFila.getFila()){
                nodoListaFila.setValor(nodoListaFila.getValor()+nuevaFila.getValor());
                if(nodoListaFila.getValor() == 0){
                    if(nodoListaFila == columna.getCabeza()){
                        if(columna.getCabeza().getAbajo() != null){
                            columna.setCabeza(columna.getCabeza().getAbajo());
                            columna.getCabeza().setAbajo(null);
                        }else{
                            columna.setCabeza(null);
                        }
                    }else{
                        nuevaFila.setAbajo(null);
                        nuevaFila.setArriba(null);
                    }
                }    
            }else{
                if(nuevaFila.getFila()<nodoListaFila.getFila()){
                    if(nodoListaFila == columna.getCabeza()){
                        columna.getCabeza().setArriba(nuevaFila);
                        nuevaFila.setAbajo(columna.getCabeza());
                        columna.setCabeza(nuevaFila);
                    }else{
                        nodoListaFila.getArriba().setAbajo(nuevaFila);
                        nuevaFila.setArriba(nodoListaFila.getArriba());
                        nuevaFila.setAbajo(nodoListaFila);
                        nodoListaFila.setArriba(nuevaFila);
                    }
                }else{
                    if(nodoListaFila.getAbajo() == null){
                        nodoListaFila.setAbajo(nuevaFila);
                        nuevaFila.setArriba(nodoListaFila);
                    }else{
                        insertarFilaR(nuevaFila,nodoListaFila.getAbajo(),columna);
                    }
                }
            }
        }else{
            columna.setCabeza(nuevaFila);
        }
    }
	
	public void mostrarlista(NodoColumna list) {
		if (list != null) {
			listaCo += "Columna: " + list.getCol();
			mostrarListaFilas(list.getCabeza());
			listaCo += "\n";
			mostrarlista(list.getSiguiente());
		}
	}

	public void mostrarListaFilas(NodoFila list) {
		if (list != null) {
			listaCo += " -> " + list.getFila() + ", " + list.getValor();
			mostrarListaFilas(list.getAbajo());
		}
	}

	public String getListaString() {
		return listaCo;
	}

	public int nColumnas(NodoColumna col) {
		if (col != null) {
			maxCol = col.getCol();
			nColumnas(col.getSiguiente());
		}
		return maxCol;
	}

	public int nFilas(NodoColumna col) {
		if(col != null) {
			NodoFila fil = col.getCabeza();
			int i = 0;
			while(fil!=null) {
				if (fil != null) {
					System.out.println("1.- max: "+ maxFil +" 2.- valor fila:"+fil.getFila());
					if(maxFil < fil.getFila()) {
						maxFil = fil.getFila();
						itrF = i+1;
					}
					fil = fil.getAbajo();
					i++;
				}
			};
			nFilas(col.getSiguiente());
			
		}
		return maxFil;
	}

	public NodoFila getMultFil(NodoColumna a) {

		NodoFila ab = a.getCabeza();
		if (itr > 0) {
			for (int i = 0; i < itr; i++) {
				ab = ab.getAbajo();

			}
		}
		return ab;

	}
	public int iteradorCol(NodoColumna col) {
		int itr = 0;
		while(col != null) {
			itr++;
			col = col.getSiguiente();
		}
		return itr;
		
	}
	
	public int iteradorFil(NodoFila fil) {
		int itr = 0;
		while(fil != null) {
			itr++;
			fil = fil.getAbajo();
		}
		return itr;
		
	}

	public int multiplicar(NodoColumna aCol, NodoFila bFil) {
		if (aCol != null && bFil != null) {
		NodoFila aFil = getMultFil(aCol);//forma la columna dependiendo de el numero de fila 
		System.out.println("valor columna : " + aCol.getCol() + " valor fila: " + bFil.getFila());
		if(aCol.getCol()== bFil.getFila()) {
			this.val += aFil.getValor() * bFil.getValor();
			System.out.println("mult columna : " + aFil.getValor() + " mult fila: " + bFil.getValor());
			System.out.println("Multiplicidad: "+itr+ " Valor: "+val);
		}else {
			multiplicar(aCol.getSiguiente(), bFil.getAbajo());
		}
		}
		
		/*
		if (aCol != null && bFil != null) {
			NodoFila aFil = getMultFil(aCol);
			if(aFil==null || bFil ==null) {
				System.out.println("skip");
			}else {
				this.val += aFil.getValor() * bFil.getValor();
				System.out.println("mult columna : " + aFil.getValor() + " mult fila: " + bFil.getValor());
				System.out.println("Multiplicidad: "+itr+ " Valor: "+val);
				multiplicar(aCol.getSiguiente(), bFil.getAbajo());
		}
			multiplicar(aCol.getSiguiente(), bFil.getAbajo());
		System.out.println(val);*/
		return this.val;
	}

	// Getters, Setters.
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

	public void setVal(int val) {
		this.val = val;
	}

	public int getVal() {
		return this.val;
	}

	public int getItr() {
		return itr;
	}

	public void setItr(int itr) {
		this.itr = itr;
	}

	public int getItrF() {
		return itrF;
	}

	public void setItrF(int itrF) {
		this.itrF = itrF;
	}
	
	
	
}