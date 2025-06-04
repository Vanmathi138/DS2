class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Stack {
    Node head;

    boolean isEmpty() {
        return head == null;
    }

    void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
        } else {
            System.out.println("Popped: " + head.data);
            head = head.next;
        }
    }

    void peek() {
        if (!isEmpty()) {
            System.out.println("Top element is: " + head.data);
        } else {
            System.out.println("Stack underflow");
        }
    }

    void peekAll() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return;
        }
        System.out.println("Stack elements:");
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node c = head;
        while (c != null) {
            sb.append(c.data);
            if (c.next != null) {
                sb.append(" -> ");
            }
            c = c.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(70);
        stack.push(30);
        stack.push(56);

        System.out.println("Initial Stack:");
        System.out.println(stack);

        System.out.println();
        stack.peek();

        System.out.println();
        stack.peekAll();

        System.out.println("\nPopping all elements:");
        while(!stack.isEmpty()) {
            stack.pop();
            System.out.println("Stack after pop: " + stack);
        }
    }
}
