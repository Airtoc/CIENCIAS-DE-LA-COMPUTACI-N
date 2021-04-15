
package Algoritmos;

public class Funciones {
    private String funcion;
    
    
    public double f(double x){
        
        return x*x*x+4*x*x-10;
    }
    
    public void algoritmo(){
        double a,b,m;
        a = -2;
        b = 5;
        if(f(a)*f(b)>0){
            System.out.println("no existe raiz en [a,b]");
        }
        m = (a+b)/2;
        while(Math.abs(f(m))>=0.000001){
            if(f(a)*f(m)<0){
                b=m;
            }else{
                a=m;
            }
            m = (a+b)/2;
        }
        System.out.println("La raiz se encuentra en "+m);
    }
    
    
}
