package determinante.controller;

public abstract class Controller {
    
    public Controller() {
        //me lee?
        System.out.println(this.getClass().getSimpleName()+" is loading.");
        
    }
    
    public abstract void start ();
    
}
