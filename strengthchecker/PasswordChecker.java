package strengthchecker;

import static java.lang.Thread.sleep;
import java.util.Arrays;
import java.util.Scanner;

public class PasswordChecker extends StrengthChecker {
    public static void main(String[] args) throws InterruptedException{
        Scanner in = new Scanner(System.in);
        StrengthChecker sc = new StrengthChecker();
        String pass;
        int min,max;
        
        sc.setUpper();
        sc.setNumber();
        sc.setSymbol();
                
        do{ System.out.println("Enter minimum password length: ");
            min = in.nextInt();
            System.out.println("Enter maximum password length:");
            max = in.nextInt();
        }while((min > max || min <= 0));
        sc.setLength(min, max);
        
        do{
            System.out.println("Enter password:");
            pass = in.next();
            System.out.println(pass);
        }while(sc.checkPassword(pass) == false);
    }
}