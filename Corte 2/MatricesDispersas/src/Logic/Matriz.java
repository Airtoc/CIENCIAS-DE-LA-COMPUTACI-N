package Logic;

import javax.swing.JOptionPane;
import javax.swing.*;

public class Matriz {

	private NodoColumna inicio;
	private String listaCo = "";
	private String tipo = "";
	private String listaFilas ="";
	private int maxFil;
	private int maxCol;
	private int val;

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
			listaCo += "Columna: "+list.getCol();
			mostrarListaFilas(list.getCabeza());
			listaCo += "\n";
			mostrarlista(list.getSiguiente());
		}
	}

	
	public void mostrarListaFilas(NodoFila list) {
		if(list != null) {
		    listaCo += " -> "+list.getFila()+", "+list.getValor();
			mostrarListaFilas(list.getAbajo());
		}
	}

	public String getListaString() {
	    return listaCo;
	}

	public int nColumnas(NodoColumna col) {
		if(col!=null) {
			maxCol = col.getCol();
			nColumnas(col.getSiguiente());
		}
		return maxCol;
	}
	
	public int nFilas(NodoFila fil) {
		if(fil != null) {
			maxFil = fil.getFila();
			nFilas(fil.getAbajo());
		}
		return maxFil;
	}

	public int multiplicar(NodoColumna aCol, NodoFila bFil) {

		if(aCol != null && bFil != null) {
			this.val += aCol.getCabeza().getValor() * bFil.getValor();
			System.out.println("mult columna : "+aCol.getCabeza().getValor()+ "mult fila: "+ bFil.getValor());			
			multiplicar(aCol.getSiguiente(), bFil.getAbajo());
		}
		//System.out.println(val);
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
}