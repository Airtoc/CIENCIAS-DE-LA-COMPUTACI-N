
class ej008
{
  // algoritmos para el calculo de ceros de una funcion no lineal

  public static void main(String args[])
  {
    System.out.println("la solucion utilizando Newton es    "
                        + Newton(0, (float) 0.001));
    System.out.println("la solucion utilizando Biseccion es "
                       + Biseccion((float)0.0, (float)1.0, (float)0.001));
    System.out.println("la solucion utilizando Aproximaciones es "
                       + cruce_por_cero((float)0.0, (float)1.0, 100));
  }

  public static float f(float x)
  {
    // funcion a resolver
    float y;
    y= x-(float)Math.cos((double)x);
    return y;
  }

  public static float Df(float x)
  {
    // derivada de f
    float y;
    y=1+ (float)Math.sin((double)x);
    return y;
  }

  public static float Newton(float vi, float T)
  {
    float p1;float p0=p1=vi;
    int k=1;

    do
    {
       p0=p1;
       p1=p0- ((f(p0))/(Df(p0)));
       System.out.println("Iteracion " + k + " solucion " + p1+ " f(x)= " + f(p1));
       k++;
     }
    while (Math.abs(p0-p1)>=T);

    return(p1);
  }

  public static float Biseccion(float a, float b, float T)
  {
    // algoritmo de biseccion

    float m, fa, fm, fb;
    int k = 1;

    do
    {
      m=((b+a)/2);
      fa=f(a);
      fm=f(m);
      fb=f(b);

      if(fa*fm > 0 ) a=m;
      else           b=m;
      if(fa*fm == 0) a = b = m;
      System.out.println("Iteracion " + k + " solucion " + m + " f(x)= " + f(m));
      k++;
    }
    while(Math.abs(fm)>T);
    return(m);
  }

  public static float cruce_por_cero(float a,float b,int ndiv)
  {
    // Algoritmo de aproximaciones sucesivas.

    float inc,x,nvo,ant;
    int k = 1;
    inc=(b-a)/ndiv;
    x=a;

    do
    {
      ant=f(x);
      x=x+inc;
      nvo=f(x);

      System.out.println("Iteracion " + k + " solucion " + x + " f(x)= " + f(x));
      k++;
    } while((ant*nvo)>0);

    return(x-inc/2);
  }
}
