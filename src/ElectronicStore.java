import java.util.*;
public class ElectronicStore {
    static Scanner scan=new Scanner(System.in);
    static Random random=new Random();
    static int loginAttempt_count;
    static boolean access;
    static String userId="Manager";
    static String password="Manager";
    static void managerLogin() {
        // login method
        if (loginAttempt_count == 2) {
            System.out.println("Account locked for 1 hour");
            access = false;
        } else {
            System.out.print("Enter User ID  : ");
            String enteredUserId = scan.nextLine();
            System.out.print("Enter Password : ");
            String enteredPassword = scan.nextLine();
            captcha();
            if(enteredUserId.equals(userId)&&enteredPassword.equals(password)) {
                access=true;
                System.out.println("You have successfully signed in");
            } else {
                System.out.println("Incorrect User Id or Password");
                System.out.println("*****************************************************************************");
                loginAttempt_count++;
                managerLogin();
            }
        }
    }
    static void captcha() {
        // To generate Captcha
        int a=random.nextInt(1,50);//creates a random variable between 1 and 49
        int b=random.nextInt(1,50);//creates a random variable between 1 and 49
        int operator=random.nextInt(3);
        char operator_sign;
        int answer;
        if (operator == 1) {
            operator_sign = '-';
            answer = a - b;
        } else if(operator == 2) {
            operator_sign = '+';
            answer = a + b;
        } else {
            operator_sign = '*';
            answer = a * b;
        }
        System.out.print("CAPTCHA --> "+a+operator_sign+b+" = ");
        String enteredAnswer=scan.nextLine();
        if(!(enteredAnswer.equals(String.valueOf(answer)))) {
            System.out.println("Entered Captcha answer is incorrect");
            captcha();
        }
    }
    static Inventory inventory=new Inventory();
    static Employee[] employee =new Employee[25];
    static {
        employee[0]=new Employee("James","25","50000","Executive");
        employee[1]=new Employee("Harry","28","40000","logistics Manager");
        employee[2]=new Employee("Tony","26","25000","Security Guard");
        employee[3]=new Employee("Steve","30","35000","Security Head");
        for(int i=4;i<employee.length;i++) {
            employee[i]=new Employee();
        }
    }
    static String choice;
    static void menu() {
        System.out.println("*****************************************************************************");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 1 to Product Menu");
        System.out.println("Press 2 to Employee Menu");
        System.out.println("*****************************************************************************");
        choice=scan.nextLine();
        switch (choice) {
            case "0" -> {
                System.out.println("***************** Thanks for using our system *****************");
                return;
            }
            case "1" -> inventory.menu();
            case "2" -> menu_2();
            default -> System.out.println("Please press a valid number");
        }
        menu();
    }
    static void menu_2() {
        System.out.println("*****************************************************************************");
        System.out.println("Press 0 to Main Menu.");
        System.out.println("Press 1 to Add Employee");
        System.out.println("Press 2 to Update salary");
        System.out.println("Press 3 to Display All Employee");
        System.out.println("Press 4 to Search Employee");
        System.out.println("Press 5 to Remove Employee");
        System.out.println("*****************************************************************************");
        choice=scan.nextLine();
        switch (choice) {
            case "0" : return;
            case "1" :
                {
                    for(int i=0;i<employee.length;i++) {
                        if(employee[i].employee_id==null) {
                            employee[i].add(i);
                            break;
                        }
                    }
                }
                break;
            case "2" :
                {
                    int id = searchEmployee();
                    if (id == 4001) {
                        System.out.println("No such product found in the inventory");
                    } else {
                        employee[id].updateSalary();
                    }
                }
                break;
            case "3" :
                {
                    Employee.header();
                    for (Employee emp : employee) {
                        if (emp.employee_id == null) {
                            continue;
                        }
                        emp.display();
                    }
                }
                break;
            case "4" :
                    {
                        int id = searchEmployee();
                        if (id == 4001) {
                            System.out.println("No such product found in the inventory");
                        } else {
                            employee[id].displayOne();
                        }
                    }
                break;
            case "5" :
                {
                    int id = searchEmployee();
                    if (id == 4001) {
                        System.out.println("No such product found in the inventory");
                    } else {
                        employee[id].delete();
                    }
                }
                break;
            default : System.out.println("Please press a valid number");
        }
        menu();
    }
    static int searchEmployee() {
        System.out.print("Enter Employee ID : ");
        String enteredID=scan.nextLine();
        int i=0;
        for(;i<employee.length;i++) {
            if(employee[i].employee_id==null) {
                if(i==employee.length-1) {
                    return 4001;//error code
                }
            } else if(employee[i].employee_id.equals(enteredID)) {
                break;
            }
        }
        return i;
    }
    public  static  void main(String [] args) {
        System.out.println("*************************** Welcome to the Store ****************************");
        System.out.println("**************************** Login to continue ******************************");
        managerLogin();
        System.out.println("*****************************************************************************");
        if(!access) {
            return;
        }
        menu();
    }
}