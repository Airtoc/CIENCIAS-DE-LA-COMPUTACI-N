package test01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Window app = new Window("Matrices Dispersas");
        app.loadComponents();
        String prueba = "(1,2,3);";
        String numbers[] = prueba.split(";");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        Validation validate = new Validation();
        System.out.println(validate.isValidFormat(numbers[0]));
    }
}
