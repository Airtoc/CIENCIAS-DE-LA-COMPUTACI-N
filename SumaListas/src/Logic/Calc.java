package Logic;

public class Calc {

    private List listaUno, listaDos;
    private String result = "";

    public String getResult() {
        return result;
    }

    public List initList(String data, List lista) {
        if (data.length() == 1) {
            String s = "000" + data;
            lista.add(s);
        } else {
            for (int i = data.length(); i > 0; i = i - 4) {
                try {
                    lista.add(data.substring(i - 4, i));
                } catch (IndexOutOfBoundsException e) {
                    String s = data.substring(0, i);
                    int rango = (4 - s.length());
                    for (int z = 0; z < rango; z++) {
                        s = "0" + s;
                    }
                    lista.add(s);
                }
            }
        }
        if (lista.getlargo() != 1) {
            return lista.reverseList(lista.getlargo());
        }
        return lista;
    }

    public Calc(String num1, String num2) {
        listaUno = new List();
        listaDos = new List();
        listaUno = initList(num1, listaUno);
        listaDos = initList(num2, listaDos);
    }

    public void start() throws NumberFormatException {
        Node iteradorUno = listaUno.getCabeza(), iteradorDos = listaDos.getCabeza();
        List listaPrincipal = (listaUno.getlargo() > listaDos.getlargo()) ? listaUno : listaDos;
        boolean suma = false;
        while (listaPrincipal.getCabeza() != null) {
            while (iteradorUno != null && iteradorUno.getNodoSiguiente() != null) {
                iteradorUno = iteradorUno.getNodoSiguiente();
            }
            while (iteradorDos != null && iteradorDos.getNodoSiguiente() != null) {
                iteradorDos = iteradorDos.getNodoSiguiente();
            }
            for (int i = 4; i > 0; i--) {
                int valor = (iteradorUno == (null)) ? 0 : Integer.parseInt(iteradorUno.getValue().substring(i - 1, i));
                int valorDos = (iteradorDos == (null)) ? 0
                        : Integer.parseInt(iteradorDos.getValue().substring(i - 1, i));

                if (suma) {
                    if ((valor + valorDos) + 1 >= 10) {
                        result = String.valueOf(((valor + valorDos) + 1 - 10) + result);
                    } else {
                        result = String.valueOf(((valor + valorDos) + 1) + result);
                    }
                    int valorSuma = (valor + valorDos + 1);
                    if (valorSuma >= 10) {
                        suma = true;
                    } else {
                        suma = false;
                    }
                } else {
                    if ((valor + valorDos) >= 10) {
                        result = String.valueOf(((valor + valorDos) - 10) + result);
                    } else {
                        result = String.valueOf((valor + valorDos) + result);
                    }
                    int valorSuma = (valor + valorDos);
                    if (valorSuma >= 10) {
                        suma = true;
                    } else {
                        suma = false;
                    }
                }
            }
            if (iteradorUno != null)
                listaUno.remove(iteradorUno.getValue());

            if (iteradorDos != null)
                listaDos.remove(iteradorDos.getValue());
            iteradorUno = listaUno.getCabeza();
            iteradorDos = listaDos.getCabeza();
        }
    }

}
