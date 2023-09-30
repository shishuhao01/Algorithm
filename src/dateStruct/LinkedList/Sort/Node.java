package dateStruct.LinkedList.Sort;

public class Node {
    public Integer value;
    public Node next;

    public Node(Integer value) {
        this.value = value;
    }

    public Node() {
        this.value = -999;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
