import GUI.*;
import Logic.*;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(1);
        list.insert(2);
        list.writeBackwards();
        list.head();
    }
}