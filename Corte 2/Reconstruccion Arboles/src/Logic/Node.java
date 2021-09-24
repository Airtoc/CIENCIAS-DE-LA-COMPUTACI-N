package Logic;

public class Node {

	String name;
	Node izq;
	Node der;
	Node raiz;
	String[] bizq, bder;

	public Node(String n) {
		this.name = n;
		izq = der = raiz = null;
	}

	// Getters & Setters
	public Node getIzq() {
		return izq;
	}

	public void setIzq(Node izq) {
		this.izq = izq;
	}

	public Node getDer() {
		return der;
	}

	public void setDer(Node der) {
		this.der = der;
	}

	public Node getRaiz() {
		return raiz;
	}

	public void setRaiz(Node raiz) {
		this.raiz = raiz;
	}

	public String[] getBizq() {
		return bizq;
	}

	public void setBizq(String[] bizq) {
		this.bizq = bizq;
	}

	public String[] getBder() {
		return bder;
	}

	public void setBder(String[] bder) {
		this.bder = bder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int nodosCompletos(Node n) {
        if (n == null)
            return 0;
        else {
            if (n.izq != null && n.der != null)
                return nodosCompletos(n.izq) + nodosCompletos(n.der) + 1;
            return nodosCompletos(n.izq) + nodosCompletos(n.der);
        }
	}
	
}
