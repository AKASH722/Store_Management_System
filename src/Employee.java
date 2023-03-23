import java.util.Scanner;

public class Employee {
    String name;
    String age;
    String salary;
    String designation;
    String employee_id;
    static int serial=1001;
    Scanner scan=new Scanner(System.in);
    Employee() {

    }
    Employee(String name,String age,String salary,String designation) {
        employee_id=""+serial++;
        this.name=name;
        this.age=age;
        this.salary=salary;
        this.designation= designation;
    }
    void add(int id) {
        employee_id=""+(1001+id);
        System.out.print("Enter Name : ");
        name=scan.nextLine();
        do {
            System.out.print("Enter Age : ");
            age = scan.nextLine();
        } while(Inventory.validityOfNumber(age,"age"));
        do {
            System.out.print("Enter Salary : ");
            salary= scan.nextLine();
        } while(Inventory.validityOfNumber(salary,"salary"));
        System.out.print("Enter designation : ");
        designation=scan.nextLine();
    }
    static void header() {
        System.out.println("  ID   Name        Age  Salary   Designation");
    }
    void displayOne() {
        System.out.println("ID          : "+employee_id);
        System.out.println("Name        : "+name);
        System.out.println("Age         : "+age);
        System.out.println("Salary      : "+salary);
        System.out.println("Designation : "+designation);
    }
    void display() {
        System.out.print(employee_id+"   ");
        System.out.print(name);
        spaceName();
        System.out.print(age);
        spaceAge();
        System.out.print(salary);
        spaceSalary();
        System.out.print(designation+"\n");
    }
    void spaceName() {
        int space=12-name.length();
        if(space<0){
            System.out.print("     ");
        } else {
            int i = 0;
            while (i < space) {
                System.out.print(" ");
                i++;
            }
        }
    }
    void spaceAge() {
        int space=8-name.length();
        int i = 0;
        while (i < space) {
            System.out.print(" ");
            i++;
        }
    }
    void spaceSalary() {
        int space=10-salary.length();
        if(space<0){
            System.out.print("     ");
        } else {
            int i = 0;
            while (i < space) {
                System.out.print(" ");
                i++;
            }
        }
    }
    void updateSalary() {
        do {
            System.out.print("Enter New Salary : ");
            salary= scan.nextLine();
        } while(Inventory.validityOfNumber(salary,"salary"));
        System.out.println("Salary Updated Successfully");
    }
    void delete() {
        employee_id=null;
        name=null;
        age =null;
        salary=null;
        designation=null;
        System.out.println("Employee deleted Successfully");
    }
}
