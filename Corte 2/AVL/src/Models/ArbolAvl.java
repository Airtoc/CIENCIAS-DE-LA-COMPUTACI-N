package Models;

import java.util.ArrayList;

public class ArbolAvl {

    private NodoAvl raiz;
    private ArrayList<NodoAvl> in = new ArrayList<>();

    //Balancear
    public void calcularBalances(NodoAvl r) {
        if (r != null) {
            calcularBalances(r.getIzquierda());
            r.setBalance(r.CalcularAltura(r.getIzquierda()) - r.CalcularAltura(r.getDerecha()));
            calcularBalances(r.getDerecha());
        }

    }

    //Rotaciones 
    	//Simples:
    private NodoAvl rotacionSimpleIzquierda(NodoAvl q, NodoAvl p) {
        NodoAvl nuevo = null;

        nuevo = new NodoAvl(p.getEstudiante());
        nuevo.setIzquierda(q);
        nuevo.setDerecha(p.getDerecha());
        nuevo.getIzquierda().setDerecha(null);

        if (p.getIzquierda() != null) {
            q.setDerecha(p.getIzquierda());
        }

        return nuevo;
    }

    private NodoAvl rotacionSimpleDerecha(NodoAvl p, NodoAvl q) {
        NodoAvl nuevo = null;

        nuevo = new NodoAvl(p.getEstudiante());
        nuevo.setIzquierda(p.getIzquierda());
        nuevo.setDerecha(q);
        nuevo.getDerecha().setIzquierda(null);

        if (p.getDerecha() != null) {
            q.setIzquierda(p.getDerecha());
        }

        return nuevo;
    }
    	//Dobles:
    private NodoAvl rotacionDobleIzquierda(NodoAvl q, NodoAvl p) {
        NodoAvl r = p.getIzquierda(), nuevo = null;
        NodoAvl tempIzq = null, tempDer = null;

        if (r.getDerecha() != null) {
            tempDer = r.getDerecha();
        }
        if (r.getIzquierda() != null) {
            tempIzq = r.getIzquierda();
        }

        nuevo = new NodoAvl(r.getEstudiante());
        nuevo.setIzquierda(q);
        nuevo.getIzquierda().setDerecha(null);
        nuevo.setDerecha(p);
        nuevo.getDerecha().setIzquierda(null);

        if (tempDer != null) {
            p.setIzquierda(tempDer);
        }
        if (tempIzq != null) {
            q.setDerecha(tempIzq);
        }

        return nuevo;
    }

    private NodoAvl rotacionDobleDerecha(NodoAvl p, NodoAvl q) {
        NodoAvl r = p.getDerecha(), nuevo = null;
        NodoAvl tempIzq = null, tempDer = null;

        if (r.getDerecha() != null) {
            tempDer = r.getDerecha();
        }
        if (r.getIzquierda() != null) {
            tempIzq = r.getIzquierda();
        }

        nuevo = new NodoAvl(r.getEstudiante());
        nuevo.setDerecha(q);
        nuevo.getDerecha().setIzquierda(null);
        nuevo.setIzquierda(p);
        nuevo.getIzquierda().setDerecha(null);

        if (tempIzq != null) {
            p.setDerecha(tempIzq);
        }

        if (tempDer != null) {
            q.setIzquierda(tempDer);
        }

        return nuevo;
    }
    
    //Generar recorrido inorder
    public void In_orden(NodoAvl r) {
        if (r != null) {
            In_orden(r.getIzquierda());
            in.add(r);
            In_orden(r.getDerecha());
        }
    }
    
    //Obtener padre
    public NodoAvl getParent(NodoAvl nodo) {
        in = new ArrayList<>();
        In_orden(raiz);
        for (NodoAvl e : in) {
            if (e.getIzquierda() == (nodo) || e.getDerecha() == (nodo)) {
                if (nodo == raiz) {
                    return null;
                }
                return e;
            }
        }
        return null;
    }

    //Obtener un nodo
    public NodoAvl ReturnNodo(long telefono) {
        NodoAvl q, p = raiz;

        if (raiz == null) {
            return null;
        }
        q = null;
        while (p != null) {
            if (telefono < p.getEstudiante().getTelefono()) {
                p = p.getIzquierda();
            } else if (telefono > p.getEstudiante().getTelefono()) {
                p = p.getDerecha();
            } else {
                return p;
            }
        }
        return null;
    }

    //Insertar Estudiante
    public int Insertar(Estudiante estudiante) {
        NodoAvl q, nuevo, p = raiz;

        if (raiz == null) {
            raiz = new NodoAvl(estudiante);
            In_orden(raiz);
            return 1;
        }

        q = null;
        while (p != null) {
            if (estudiante.getTelefono() < p.getEstudiante().getTelefono()) {
                q = p;
                p = p.getIzquierda();
            } else if (estudiante.getTelefono() > p.getEstudiante().getTelefono()) {
                q = p;
                p = p.getDerecha();
            } else {
                return -1;
            }
        }
        nuevo = new NodoAvl(estudiante);
        if (estudiante.getTelefono() < q.getEstudiante().getTelefono()) {
            q.setIzquierda(nuevo);
        } else {
            q.setDerecha(nuevo);
        }

        calcularBalances(raiz);

        NodoAvl desbalance = retornarNodoDesbalanceado();
        NodoAvl parent = null;
        if (desbalance != null) {
            parent = getParent(desbalance);
            if (parent != null) {
                if (parent.getIzquierda() == desbalance) {
                    desbalance = balancear(desbalance);
                    parent.setIzquierda(desbalance);
                } else {
                    desbalance = balancear(desbalance);
                    parent.setDerecha(desbalance);
                }
            } else {
                desbalance = balancear(desbalance);
                raiz = desbalance;
            }
        }
        calcularBalances(raiz);

        return 1;

    }

    //Eliminar estudiante
    public boolean RetirarNodo(long telefono, boolean casoEsp) {
        NodoAvl p = ReturnNodo(telefono);
        NodoAvl q = getParent(ReturnNodo(telefono));

        NodoAvl r, t, s;

        if (p == null) {
            return false;
        }

        if (telefono == raiz.getEstudiante().getTelefono()) {
            int asd = in.indexOf(ReturnNodo(telefono));
            int asd2 = asd + 1;
            if(asd2 == in.size()){
                raiz = raiz.getIzquierda();
                verifBalanceo();
                return true;
            }
            NodoAvl retiro = in.get(asd2);
            RetirarNodo(retiro.getEstudiante().getTelefono(), true);
            raiz.setEstudiante(retiro.getEstudiante());
            verifBalanceo();
            return true;
        }

        if (p.getIzquierda() == null) {
            r = p.getDerecha();
        } else if (p.getDerecha() == null) {
            r = p.getIzquierda();
        } else {
            s = p;
            r = p.getDerecha();
            t = r.getIzquierda();
            while (t != null) {
                s = r;
                r = t;
                t = t.getIzquierda();
            }
            if (p != s) {
                s.setIzquierda(r.getDerecha());
                r.setIzquierda(p.getDerecha());
            }
            r.setIzquierda((p.getIzquierda()));
        }
        if (q == null) {
            raiz = r;
        } else if (p == q.getIzquierda()) {
            q.setIzquierda(r);
        } else {
            q.setDerecha(r);
        }
        if(!casoEsp){
            verifBalanceo();
        }
        return true;
    }

    //Verificar Balanceo
    public void verifBalanceo() {
        calcularBalances(raiz);

        NodoAvl desbalance = retornarNodoDesbalanceado();
        NodoAvl parent = null;
        if (desbalance != null) {
            parent = getParent(desbalance);
            if (parent != null) {
                if (parent.getIzquierda() == desbalance) {
                    desbalance = balancear(desbalance);
                    parent.setIzquierda(desbalance);
                } else {
                    desbalance = balancear(desbalance);
                    parent.setDerecha(desbalance);

                }
            } else {
                desbalance = balancear(desbalance);
                raiz = desbalance;
            }

        }

        calcularBalances(raiz);

    }

    //Balanceo Basico
    public NodoAvl balancear(NodoAvl r) {
        switch (r.getBalance()) {
            case -2 -> {
                if (r.getDerecha() != null && r.getDerecha().getBalance() == -1) {
                    return rotacionSimpleIzquierda(r, r.getDerecha());
                } else if (r.getDerecha() != null && r.getDerecha().getBalance() == 1) {
                    return rotacionDobleIzquierda(r, r.getDerecha());
                } else if (r.getDerecha() != null && r.getDerecha().getBalance() == 0) {
                    NodoAvl nuevo = new NodoAvl(r.getDerecha().getEstudiante());
                    nuevo.setDerecha(r.getDerecha().getDerecha());
                    r.setDerecha(r.getDerecha().getIzquierda());
                    nuevo.setIzquierda(r);
                    return nuevo;
                }
                break;
            }

            case 2 -> {
                if (r.getIzquierda() != null && r.getIzquierda().getBalance() == 1) {
                    return rotacionSimpleDerecha(r.getIzquierda(), r);
                } else if (r.getIzquierda() != null && r.getIzquierda().getBalance() == -1) {
                    return rotacionDobleDerecha(r.getIzquierda(), r);
                } else if (r.getIzquierda() != null && r.getIzquierda().getBalance() == 0) {
                    NodoAvl nuevo = new NodoAvl(r.getIzquierda().getEstudiante());
                    nuevo.setIzquierda(r.getIzquierda().getIzquierda());
                    r.setIzquierda(r.getIzquierda().getDerecha());
                    nuevo.setDerecha(r);
                    return nuevo;
                }
                break;
            }

        }
        return null;

    }

    //?
    public NodoAvl retornarNodoDesbalanceado() {
        in = new ArrayList<>();
        In_orden(raiz);
        ArrayList<NodoAvl> results = new ArrayList<>();
        for (NodoAvl e : in) {
            if (e.getBalance() == -2 || e.getBalance() == 2) {
                if (e.getIzquierda() != null) {
                    if (e.getIzquierda().getBalance() == -1 || e.getIzquierda().getBalance() == 1 || e.getIzquierda().getBalance() == 0) {
                        results.add(e);
                    }
                }
                if (e.getDerecha() != null) {
                    if (e.getDerecha().getBalance() == -1 || e.getDerecha().getBalance() == 1 || e.getDerecha().getBalance() == 0) {
                        results.add(e);
                    }
                }
            }
        }
        NodoAvl iterador = null;
        for (NodoAvl t : results) {
            if (iterador == null) {
                iterador = t;
            } else {
                if (GetNivelXNodo(t.getEstudiante().getTelefono()) > GetNivelXNodo(iterador.getEstudiante().getTelefono())) {
                    iterador = t;
                }
            }
        }
        return iterador;
    }

    //Obtener niveles
    public int GetNivelXNodo(long x) {
        int alturaNodo = 0;
        NodoAvl q, p = raiz;

        if (raiz == null) {
            return 0;
        }
        q = null;
        while (p != null) {
            if (x < p.getEstudiante().getTelefono()) {
                q = p;
                p = p.getIzquierda();
                alturaNodo++;
            } else if (x > p.getEstudiante().getTelefono()) {
                q = p;
                p = p.getDerecha();
                alturaNodo++;
            } else {
                return alturaNodo;
            }
        }
        return 0;
    }

    
    //Getters & Setters
    public NodoAvl getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAvl raiz) {
        this.raiz = raiz;
    }

    public ArrayList<NodoAvl> getIn() {
        return in;
    }

    public void setIn(ArrayList<NodoAvl> in) {
        this.in = in;
    }

}
