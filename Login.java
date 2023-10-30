import java.util.Scanner;
public class Login {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scan.nextLine();
        System.out.println("Enter password: ");
        String password = scan.nextLine();
        scan.close();
        System.out.println(username);
        System.out.println(password);
        System.out.println("Hello World");
    }
}
