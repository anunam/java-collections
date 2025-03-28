package queueinterface;
import java.util.Arrays;

class CircularBuffer {
    private int[] buffer;
    private int capacity, size, front, rear;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    // Insert element into circular buffer
    public void insert(int value) {
        rear = (rear + 1) % capacity; // Move rear to next position
        buffer[rear] = value;

        if (size < capacity) {
            size++; // Increase size if not full
        } else {
            front = (front + 1) % capacity; // Overwrite oldest element
        }
    }

    // Get buffer elements in order
    public int[] getBuffer() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(front + i) % capacity];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // Output: [1, 2, 3]

        cb.insert(4); // Overwrites 1
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // Output: [2, 3, 4]

        cb.insert(5); // Overwrites 2
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // Output: [3, 4, 5]
    }
}
