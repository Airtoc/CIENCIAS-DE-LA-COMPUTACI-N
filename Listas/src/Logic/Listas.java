package Logic;

public class Listas {
    private Nodo inicio;
    private String lista ="";

    public Listas(){
        this.inicio = null;
    }

    public void mostrarlista(Nodo list){
        if(list != null){
            lista += "Nombre: "+list.getNombre()+"\n";
            lista += "Codigo: "+list.getCodigo()+"\n\n";
            mostrarlista(list.getSiguiente());
        }
    }

    public void addNodo(Nodo list, Nodo nodo){
        //Verificar duplicado
        if(nodo.getCodigo() == list.getCodigo()){
            System.out.println("El nodo se encuentra repetido");
        }else{
            //Ejecucion del codigo normal
            if(nodo != list){
                nodo.setSiguiente(list);
                if(inicio == list){
                    inicio = list;// pasa la cabeza a el primer nodo
                }else{
                    if(list.getSiguiente() != null){//Ultimo de la lista
                        nodo.setSiguiente(list.getSiguiente());
                        list.setSiguiente(nodo);
                    }else{
                        addNodo(nodo, list.getSiguiente());
                    }
                
                }
                }else{
                    list.setSiguiente(nodo);
                    nodo.setSiguiente(list);
            }
        }
    }

    public void buscarNodo(Nodo list,int codigo){
        if(codigo==list.getCodigo()){
            System.out.println("El nodo se encuentra en la lista");
        }else{
            if(list.getSiguiente()==null){
                System.out.println("El nodo no se encuentra en la lista");
            }else{
                buscarNodo(list.getSiguiente(),codigo); // Se reinicia la busqueda pero con el siguiente nodo
            }
            
        }
    }

    public void eliminarNodo(Nodo list, int codigo){
        if(list.getCodigo() == codigo){ //Se comprueban que los codigos sean iguales
            //PRIMERO
            if(list.getAnterior() == null){
                this.inicio = list.getSiguiente();
                list.getSiguiente().setAnterior(null);
            }
            //ULTIMO
            if(list.getSiguiente() == null){
                list.getAnterior().setSiguiente(null);
            }
            //MEDIO
            if(list.getAnterior() != null && list.getSiguiente() != null){
                list.getAnterior().setSiguiente(list.getSiguiente());
                list.getSiguiente().setAnterior(list.getAnterior());
            }
        }else{
            eliminarNodo(list.getSiguiente(), codigo);
        }
    }
    
    
    //Getters & Setters :
    public Nodo getCabeza(){
        return this.inicio;
    }
    
    public String getLista(){
        return this.lista;
    }
    
    public void setCabeza(Nodo cabeza){
        this.inicio = cabeza;
    }
    
    public void setLista(String lista){
        this.lista = lista;
    }
    
}
