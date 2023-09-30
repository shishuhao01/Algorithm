package dateStruct.LinkedList.Sort;

public class LinkedList {
    public Node head;
    public void addNode (Node node) {
        if (head == null) {
            this.head = node;
            return;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public Node getHead() {
        return head;
    }

    public void show () {
        if (head == null) {
            return ;
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }

        }
    }

}
