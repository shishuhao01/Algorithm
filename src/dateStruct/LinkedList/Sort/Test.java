package dateStruct.LinkedList.Sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = {4,6,3,5,8,5,2,5,4};
        LinkedList l1 = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            l1.addNode(new Node(arr[i]));
        }
        l1.show();
        Node rets = Sort(l1.getHead(),5);
        System.out.println(rets);
    }

    public static Node Sort(Node head, int value) {
        Node lessHead = new Node();
        Node lessTail = new Node();
        Node equalHead = new Node();
        Node equalTail = new Node();
        Node highHead = new Node();
        Node highTail = new Node();

        Node temp = head;
        while (temp != null) {
            if (temp.value < value) {
                if (lessHead.value == -999) {
                    lessHead = new Node(temp.value);
                } else {
                    if (lessTail.value == -999) {
                        lessTail = new Node(temp.value);
                        lessHead.next = lessTail;
                    }else {
                        lessTail.next = new Node(temp.value);
                        lessTail = lessTail.next;
                    }
                }
            } else if (temp.value == value) {
                if (equalHead.value == -999) {
                    equalHead = new Node(temp.value);
                } else {
                    if (equalTail.value == -999) {
                        equalTail = new Node(temp.value);
                        equalHead.next = equalTail;
                    } else {
                        equalTail.next = new Node(temp.value);
                        equalTail = equalTail.next;
                    }

                }
            } else if (temp.value > value){
                if (highHead.value == -999) {
                    highHead = new Node(temp.value);

                } else {
                    if (highTail.value == -999) {
                        highTail = new Node(temp.value);
                        highHead.next = highTail;
                    }else {
                        highTail.next = new Node(temp.value);
                        highTail = highTail.next;
                    }

                }
            }
            temp = temp.next;
        }
        lessTail.next = equalHead;
        equalTail.next = highHead;
        return lessHead;




    }
}
