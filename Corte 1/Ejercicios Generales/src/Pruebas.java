public class Pruebas {
    
        /**
     * Operaciones elementales:
     * 
     * conteo y verificacion de operaciones elementales usadas en los algoritmos
     */

    public void ejemplo1(){

        int cont=0,h,i,n=20;
        int x = 0;
        h=2;
        cont++; //Asignacion de h =2
        cont++; //Asignacion de i = 3
        for(i=3;i<n;i++){
            cont=cont+6; // las cuatro operaciones de abajo, la operacion de comparacion e i++
            x = i*3; // 2oe, asignacion y multiplicacion
            h = h+x; // 2oe, asignacion y multiplicacion
        }
        cont++; //verificacion de que i<n
        x++;
        cont++; // suma de x
         
        System.out.println("por programa : "+cont);
        System.out.println("por formula : " +(6*(n-3)+4));
    }

    public void ejemplo2(){

        int i,n=20,j,a=0,cont=0;
        cont++; //Asignacion de i=0
        for(i=0;i<n;i++){
            cont++; // comparacion i<n
            cont++; //la suma de i++
            cont++; // Asignacion de j=0
            for(j=0;j<n;j++){
                cont++; // comparacion j<n
                cont++; //la suma de j++
                a=a+1;
                cont = cont+2; // la suma y la asignacion
            }
            cont++; //verificacion de que j<n false
        }
        cont++; //verificacion de que i<n false

        System.out.println("por programa : "+cont);
        System.out.println("por formula : " +((4+4*n)*n+2));
    }

    public int[][] ejemplo3(int[][] a, int[][] b){
            int cont = 0;
            int[][] c = new int[a.length][b[0].length]; //2 oe
            
            // se comprueba si las matrices se pueden multiplicar
            cont++; //If
            if (a[0].length == b.length) {
                cont++;//i=0
                for (int i = 0; i < a.length; i++) {
                    cont++;//incremento
                    cont++;//comparacion
                    cont++;//J=0
                    for (int j = 0; j < b[0].length; j++) {
                        cont++;//incremento
                        cont++;//comparacion
                        cont++;//k=0
                        for (int k = 0; k < a[0].length; k++) {
                            // aquí se multiplica la matriz
                            cont++;//incremento
                            cont++;//comparacion
                            c[i][j] = c[i][j] + a[i][k] * b[k][j];
                            cont= cont+11;//operacion arriba
                        }
                        cont++;//false
                    }
                    cont++;//false
                }
                cont++;//false
            }

            /**
             * si no se cumple la condición se retorna una matriz vacía
             */
            System.out.println("por programa : "+cont);
            System.out.println("por formula : " +(13*(a[0].length*b[0].length*a.length)+4*(b[0].length*a.length)+(4*a.length)+3));
            return c;
            
            
            
        }

        public void ejemplo4(){
            int c= 1,i,n=20,h=7,j;

            for (i=0;i<n;i++){
                c=c+5;
                for (j=i+1 ;j<n; j++){
                    c = c+4;
                    h=h+3;
                }
            }
            c++;

            double formula = 4*(n*(n)-n-(n-1)*(n)/2)+n*(n)+2;
            System.out.println(formula);
            System.out.println(c);
        }

        /*public void ejemplo5(){
            for(i=0;i<n-1;i++){
                for(j=i+1;j<n;j++){
                    if(a[i]>a[j]){
                        t = a[i];
                        a[i]=a[j];
                        a[j]=t;


                    }
                }
            }
        }*/

        public void ejemplo6(){

            int c=1,i,n=10,j,h=7;
            
            for(i=0; i<n; i++){
                
                c = c+5;
                for (j=i+1; j<n; j++){
                    c=c+4;
                    h=h+3;
                }
//            }
            c++;
            double formula = 4*(n*(n) -n- (n-1)*(n)/2)+5*(n)+2;
            System.out.println("Por contador: "+c);
            System.out.println("Por formula: "+ formula);
            
        }
        }

    public static void main(String[] args) throws Exception {

        Pruebas test = new Pruebas();
        test.ejemplo6();
        /*
        ab.ejemplo1();
        ab.ejemplo2();
        int[][] a = { { 1, 2, -3 }, { 4, 0, -2 } };
        int[][] b = { { 3, 1 }, { 2, 4 }, { -1, 5 } };
        int[][] c = ab.ejemplo3(a, b);
        System.out.println(Arrays.deepToString(c));
        */
    }
}

