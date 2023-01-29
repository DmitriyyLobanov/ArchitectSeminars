package Algorytms.Seminar_3;

public class MyLinkedListV2 {

    private NodeV2 head;
    private NodeV2 tail;


    public void revert(){
        NodeV2 currentNode = head;
        while (currentNode != null){
            NodeV2 next = currentNode.getNext();
            NodeV2 prev = currentNode.getPrev();
            currentNode.setNext(prev);
            currentNode.setPrev(next);
            if (prev == null) tail = currentNode;
            if (next == null) head = currentNode;
            currentNode = next;
        }
    }
    public void addFirst(int value){
        NodeV2 node = new NodeV2(value);
        if (head != null){
            node.setNext(head);
            head.setPrev(node);
            //head = node;
        }
        else {
            //head = node;
            tail = node;
        }

        head = node;
    }

    public void removeFirst(int value){
        if (head != null && head.getNext() != null){
            head.getNext().setPrev(null);
            head = head.getNext();
        }
        else {
            head = null;
            tail = null;
        }


    }



}
