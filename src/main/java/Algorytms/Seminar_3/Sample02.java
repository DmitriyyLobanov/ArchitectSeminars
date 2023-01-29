package Algorytms.Seminar_3;

public class Sample02 {

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);

        Node head = myLinkedList.getHead();

    }

    public static Node middleNode(Node head){
        int lenght = 1;
        Node node = head;

        while (node.getNext() != null){
            lenght++;
            node = node.getNext();
        }

        lenght = lenght / 2 + 1;

        node = head;

        for (int i = 0; i < lenght - 1; i++){
            node = node.getNext();
        }

        return node;
    }



}
