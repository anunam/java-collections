package queueinterface;
import java.util.*;

class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        q1.add(x);
    }

    // Removes and returns the top element
    public int pop() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty!");

        while (q1.size() > 1) {
            q2.add(q1.poll()); // Move all except last to q2
        }

        int topElement = q1.poll(); // Remove last element (top of stack)

        // Swap q1 and q2 (so q1 is always the main queue)
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Returns the top element without removing it
    public int top() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty!");

        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int topElement = q1.peek(); // Get last element
        q2.add(q1.poll()); // Move last element to q2

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Returns true if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top Element: " + stack.top()); // Output: 3
        System.out.println("Popped: " + stack.pop());      // Output: 3
        System.out.println("Popped: " + stack.pop());      // Output: 2
        System.out.println("Is Stack Empty? " + stack.isEmpty()); // Output: false
    }
}

