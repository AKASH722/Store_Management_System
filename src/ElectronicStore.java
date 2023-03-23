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
    public  static  void main(String [] args) {
        System.out.println("*************************** Welcome to the Store ****************************");
        System.out.println("**************************** Login to continue ******************************");
        managerLogin();
        System.out.println("*****************************************************************************");
        if(!access) {
            return;
        }
        Inventory inventory=new Inventory();
        inventory.menu();
        if(inventory.choice.equals("0")) {
            System.out.println("***************** Thanks for using our system *****************");
            return;
        }
    }
}