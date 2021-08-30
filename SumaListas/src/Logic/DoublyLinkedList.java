package Logic;

public class DoublyLinkedList {
    Node head;

    public DoublyLinkedList() {
        head = null;
    }

    public void insert(int x){
        Node nodeA = new Node(x);
        Node nodeB = head;
        Node nodeC = null;
        while(nodeB != null) {
            nodeC = nodeB;
            nodeB = nodeB.next;
        }
        if(nodeC == null) {
            head = nodeA;
        }else {
            nodeC.next = nodeA;
            nodeA.prev = nodeC;
        }
    }

    public void writeBackwards() {
        Node nodeA = head;
        Node nodeB = null;
        while (nodeA != null){
            nodeB = nodeA;
            nodeA = nodeA.next;
        }
        while (nodeB != null){
            System.out.print(nodeB.data+" ");
            nodeB = nodeB.prev;
        }
        System.out.println();
    }

    public void head (){
        System.out.println(head.next.prev.data);
    }
}