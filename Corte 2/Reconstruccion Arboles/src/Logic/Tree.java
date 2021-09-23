package Logic;

import.javax.swing.*;

public class Tree {

	private Node raiz;
	int fila;
	String[] pre,ino;
	
	public Tree(String[] arr1, String[]arr2){
		raiz = null;
		this.pre = arr1;
		this.ino = arr2;
	}
	
	public void insertar(String a) {
		Node p,q;
		
		if(this.raiz == null) {
			raiz = new Node(a);
		}
		
	}
	
	public void addIzq(Node e,String a) {
		Node nuevo = new Node(a);
		e.izq = nuevo;
		nuevo.setRaiz(e);
	}
	public void addDer(Node e,String a) {
		Node nuevo = new Node(a);
		e.der = nuevo;
		nuevo.setRaiz(e);
	}
	
	public void reconstruir1(String inOrder, String preOrder) { 
	    String[] in = inOrder.split("");
	    String[] pre = preOrder.split("");
	    
	    if(in.length == pre.length){
	    
	    
	    }else {
	        JOptionPane.showMessageDialog(null, "Error: Mismo tamaño.");
	    }
	}

	public void reconstruir2() { //Inorder & Posorder
		
	}
	
	public void subcadenaIzq(String[] cadena,String nodo,Node no) {
		int division;
		for(int i= 0;i<cadena.length;i++) {
			if(cadena[i] == nodo) {
				division = i;
			}
		}
		for (int i = 0; i<division;i++) {
			cadena[i]
		}
		no.setBizq(cadena);
	}
	
	public void subcadenaDer(String[] cadena) {
		for(int i= 0;)
	}
	
	

	/*
	 * p = q = raiz;
		
		while(q!=null & p.name != a) {
			p = q;
			if(a.indexOf(a)< p.name.indexOf(a) ) {// Modificar para verificar el orden en el arboll
				q = q.izq;
			}else {
				q = q.der;
			}
			if(a.equals(p.name)==true) {
				System.out.println("el nodo se encuentra repetido");
			}else if (a.indexOf(a)< p.name.indexOf(a)) {
				addIzq(p,a);
			}else {
				addDer(p,a);
			}
			
		}
		*/

}
