package queueinterface;
import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Custom comparator: Higher severity should come first
    public static Comparator<Patient> severityComparator = (p1, p2) -> Integer.compare(p2.severity, p1.severity);

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        // PriorityQueue with custom comparator (max heap based on severity)
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(Patient.severityComparator);

        // Add patients
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        // Treat patients in order of severity
        System.out.println("Treatment Order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}

