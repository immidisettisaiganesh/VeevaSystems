import java.util.*;

class Employee {
    String name;
    String job;
    double salary;
    String joiningDate; 

    Employee(String name, String job , double salary, String joiningDate) {
        this.name = name;
        this.job = job;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Job: " + job +
               ", Salary: " + salary +
               ", Joining Date: " + joiningDate;
    }
}

class PartA_Prg2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        HashMap<String, Employee> employeeMap = new HashMap<>();

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1) Add a new Entry");
            System.out.println("2) Display entries in Ascending Salary order");
            System.out.println("3) Display entries in Descending Salary order");
            System.out.println("4) Display entries in Ascending Joining Date order");
            System.out.println("5) Display entries in Descending Joining Date order");
            System.out.println("0) Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEntry(employeeMap);
                    break;
                case 2:
                    ascendingOrderOfSalaries(employeeMap);
                    break;
                case 3:
                    descendingOrderOfSalaries(employeeMap);
                    break;
                case 4:
                    ascendingOrderOfJoiningDate(employeeMap);
                    break;
                case 5:
                    descendingOrderOfJoiningDate(employeeMap);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void addEntry(HashMap<String, Employee> map) {

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Job of Employee :");
        String job = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Joining Date ");
        String joiningDate = scanner.nextLine();

        map.put(name, new Employee(name,job , salary, joiningDate));
        System.out.println("Employee added successfully.");
    }

    public static void ascendingOrderOfSalaries(HashMap<String, Employee> map) {
        List<Employee> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingDouble(emp -> emp.salary));

        System.out.println("Ascending order of Salaries:");
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    public static void descendingOrderOfSalaries(HashMap<String, Employee> map) {
        List<Employee> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingDouble((Employee emp) -> emp.salary).reversed());

        System.out.println("Descending order of Salaries:");
        for (Employee emp : list) {
            System.out.println(emp.toString());
        }
    }

    public static void ascendingOrderOfJoiningDate(HashMap<String, Employee> map) {
        List<Employee> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparing(emp -> emp.joiningDate));

        System.out.println("Ascending order of Joining Dates:");
        for (Employee emp : list) {
            System.out.println(emp.toString());
    }
    }

    public static void descendingOrderOfJoiningDate(HashMap<String, Employee> map) {
        List<Employee> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparing((Employee emp) -> emp.joiningDate).reversed());

        System.out.println("Descending order of Joining Dates:");
        for (Employee emp : list) {
            System.out.println(emp.toString());
        }
    }
}
