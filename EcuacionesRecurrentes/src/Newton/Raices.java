package Newton;


import java.util.ArrayList;

public class Raices {
    double[]coeficientes;
    double[]raices;
    
    public Raices(double[]co){
        
        this.coeficientes = co;
        raices = new double[coeficientes.length];
        System.out.println(coeficientes.length);//5
        verificar();
    }
    
    public void verificar(){
        System.out.println("entro a el metodo verificar");
        if(coeficientes.length == 2 ){
            System.out.println("XDXDXDXD");
            raices = gradoDos(coeficientes[0],coeficientes[1],coeficientes[2]);
        }else if (coeficientes.length > 2){
            System.out.println("grado mayor");
            raices = GradoMayorA2(coeficientes);
        }
        
    }
 
    public double Grado1(double a, double b){
        return -b/a;
    }
    
    public double[]  gradoDos(double a, double b, double c) {
        double raices[] = new double[2];
        double d = ((Math.pow(b, 2) - (4 * a * c)));
        double rUnica = ((-b + (Math.sqrt(Math.pow(b, 2) - ((4 * a * c))))));
        double rDos = ((-b - (Math.sqrt(Math.pow(b, 2) - ((4 * a * c))))));
        double GT = (-((b) / (2 * a)));
        
        if (d > 0) {
            raices[0] = rUnica / (2 * a);
            System.out.println("x1 = " + rUnica / (2 * a));
            raices[1] = rDos / (2 * a);
            System.out.println("x1 = " + rDos / (2 * a));
        } else if (d == 0) {
            raices[0] = GT;
            raices[1] = GT;
            System.out.println("x1 = " + GT);
            System.out.println("x2 = " + GT);

        } else if (d < 0) {
            System.out.println("no hay raices");
        }
        return raices;
    }
    
    public double[] GradoMayorA2(double[] coeficiente){
        ArrayList<Double> divisoresNum = new ArrayList<>();
        ArrayList<Double> divisoresDen = new ArrayList<>();
        ArrayList<Double> raices = new ArrayList<>();
        
        //LLENAR DIVISORES
        for(int i=1;i<=Math.abs(coeficiente[0]);i++){
            if(coeficiente[0]%i ==0){
                divisoresDen.add((double)i);
            }   
        }
        for(int i=1;i<=Math.abs(coeficiente[coeficiente.length-1]);i++){
            if(coeficiente[coeficiente.length-1]%i == 0){
                divisoresNum.add((double)i);
                divisoresNum.add((double)-i);
            }
        }
        
        int cont =0;
        
        for(int i=0;i<divisoresNum.size();i++){
            for(int j=0;j<divisoresDen.size();j++){
                double result = coeficiente[0];
                double[] aux = new double[coeficiente.length];
                aux[0] = coeficiente[0];
                
                for(int w=1;w<coeficiente.length;w++){
                    result = coeficiente[w]+(result*divisoresNum.get(i)/divisoresDen.get(j));
                    aux[w] = result;
                }
                if(result==0){
                    raices.add(divisoresNum.get(i)/divisoresDen.get(j));
                    coeficiente = aux;
                    cont = 0;
                    for(int w=coeficiente.length-1;w>2;w--){
                        if(coeficiente[w]==0){
                            cont++;
                        }else{
                            break;
                        }
                    }
                    if(cont==coeficiente.length-3){
                        i=divisoresNum.size(); 
                    }else{
                        i=-1;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < raices.size(); i++) {
            System.out.println("las raices son: "+raices.get(i));
            
        }
        
        double[] r = new double[2];

        if(cont==coeficiente.length-3){
            r = gradoDos(coeficiente[0],coeficiente[1],coeficiente[2]);
            raices.add(r[0]);
            raices.add(r[1]);
        }
        double[] solucion = new double[raices.size()];
        for(int i = 0;i<raices.size();i++){
            solucion[i]= raices.get(i);
        }
        return solucion;
    }
    
    public double[] ordernarRaices(double[] r){
        double t;
        for(int i=0;i<(r.length-1);i++){
            for(int j=i+1;j<r.length;j++){
                if(r[i]<r[j]){
                    t=r[i];
                    r[i]=r[j];
                    r[j]=t;
                }
            }
        }
        return r;
    }

    public double[] getRaices() {
        return raices;
    }
    
    
    
}
