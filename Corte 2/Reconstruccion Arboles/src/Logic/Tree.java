package Logic;

//import.javax.swing.*;

public class Tree {

	private Node raizT;
	int fila;
	String[] pre, ino;
	int i = 1;

	public Tree() {
		raizT = null;
	}

	public void addIzq(Node inicio, String[] aux) {

		if (aux != null) {// Full izq
			System.out.println("\n+Raiz izq: " + pre[i]);
			Node b = new Node(pre[i]);
			subCadenaIzq(aux, pre[i], b);// null
			subCadenaDer(aux, pre[i], b);// null
			b.setRaiz(inicio);
			inicio.setIzq(b);
			inicio.setBizq(null);
			i++;
			if(i != pre.length) {
				addIzq(b, b.bizq);
			}else {
				System.out.println("se acabo todo ");
			}
			
		} else {
			
			if (inicio.getRaiz().getBder() == null && inicio.getRaiz().getBizq() == null) {
				/*System.out.println("hey " + inicio.getRaiz().getBizq());
				System.out.println("hey2 " + inicio.getRaiz().getBder());
				System.out.println("terminamos");*/
				while (inicio.getBder() == null && inicio.getBizq() == null) {
					inicio = inicio.getRaiz();
					System.out.println("\n+Raiz NEW 2: " + inicio.name);
				}
				addDer(inicio,inicio.getBder());
			}else {
			System.out.println("hey " + inicio.getRaiz().getBizq());
			System.out.println("hey2 " + inicio.getRaiz().getBder());
			System.out.println("\n+Raiz izq2: " + inicio.getRaiz().name);
			addDer(inicio.getRaiz(), inicio.getRaiz().getBder());
			}
		}
	}

	public void addDer(Node inicio, String[] aux) {
		if (aux != null) {// Full izq
			System.out.println("\n+Raiz der: " + pre[i]);
			Node b = new Node(pre[i]);
			subCadenaIzq(aux, pre[i], b);// null
			subCadenaDer(aux, pre[i], b);// null
			b.setRaiz(inicio);
			inicio.setBder(null);
			System.out.println("RA: " + b.getRaiz().name);
			inicio.setDer(b);
			i++;
			addIzq(b, b.bizq);
		} else {
			System.out.println("termine subarbol 1");
		}
	}


	public void subCadenaIzq(String[] cadena, String nodo, Node no) {
		if (cadena[0].equals(nodo) == false) {
			int division = 0;

			for (int i = 0; i < cadena.length; i++) {

				if (cadena[i].equals(nodo) == true) {
					division = i;
				}
			}
			String[] sub = new String[division];
			for (int i = 0; i < division; i++) {
				sub[i] = cadena[i];
			}

			for (int i = 0; i < sub.length; i++) {
				System.out.println("izq: " + sub[i]);
				;
			}
			no.setBizq(sub);
		} else {
			no.setBizq(null);
		}
	}

	public void subCadenaDer(String[] cadena, String nodo, Node no) {
		if (cadena[cadena.length - 1].equals(nodo) == false) {
			int division = 0;

			for (int i = 0; i < cadena.length; i++) {
				if (cadena[i].equals(nodo) == true) {
					division = i;
				}
			}
			String[] sub = new String[cadena.length - (division + 1)];
			int a = 0;
			for (int i = division + 1; i < cadena.length; i++) {
				sub[a] = cadena[i];
				a++;
			}

			for (int i = 0; i < sub.length; i++) {
				System.out.println("der: " + sub[i]);
				;
			}
			no.setBder(sub);
		} else {
			no.setBder(null);
		}
	}

	// Getters & setters
	public Node getRaizT() {
		return raizT;
	}

	public void setRaizT(Node raiz) {
		this.raizT = raiz;
	}

	public String[] getPre() {
		return pre;
	}

	public void setPre(String[] pre) {
		this.pre = pre;
	}

	public String[] getIno() {
		return ino;
	}

	public void setIno(String[] ino) {
		this.ino = ino;
	}

}
