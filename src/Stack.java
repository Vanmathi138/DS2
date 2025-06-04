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

        Queue queue = new Queue();
        queue.enqueue(56);
        queue.enqueue(30);
        queue.enqueue(70);

        System.out.println("Initial Queue:");
        System.out.println(queue);

        System.out.println("\nDequeuing elements:");
        while (!queue.isEmpty()) {
            queue.dequeue();
            System.out.println("Queue after dequeue: " + queue);
        }

    }
}

class Queue {
    Node front, rear;

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(int newData) {
        Node newNode = new Node(newData);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return;
        }
        System.out.println("Dequeued: " + front.data);
        front = front.next;
        if (front == null) {
            rear = null;  // Important to reset rear if the queue is empty
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node c = front;
        while (c != null) {
            sb.append(c.data);
            if (c.next != null) {
                sb.append(" -> ");
            }
            c = c.next;
        }
        return sb.toString();
    }
}

