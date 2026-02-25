package VeevaAssignment.AutomationTest_3.part_2;

import java.util.*;

class Student {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
}

public class Prog_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                if (Double.compare(s2.getCgpa(), s1.getCgpa()) != 0) {
                    return Double.compare(s2.getCgpa(), s1.getCgpa()); 
                }
                else if (!s1.getName().equals(s2.getName())) {
                    return s1.getName().compareTo(s2.getName()); 
                }
                else {
                    return Integer.compare(s1.getId(), s2.getId()); 
                }
            }
        });

        for (int i = 0; i < n; i++) {

            String event = sc.next();

            if (event.equals("ENTER")) {

                String name = sc.next();
                double cgpa = sc.nextDouble();
                int id = sc.nextInt();

                pq.add(new Student(id, name, cgpa));
            }
            else if (event.equals("SERVED")) {

                if (!pq.isEmpty()) {
                    pq.poll();
                }
            }
        }

        if (pq.isEmpty()) {
            System.out.println("EMPTY");
        }
        else {
            while (!pq.isEmpty()) {
                System.out.print(pq.poll().getName() + " ");
            }
        }

        sc.close();
    }
}
