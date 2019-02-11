package strengthchecker;
    import java.util.Scanner;

/**
*
* @author tyler
*/
public class StrengthChecker {
    int min,max,numC,symC,upperC,lowerC;
    boolean uNum,uSym,uUpper,uLower = true;
    char[] num = {'1','2','3','4','5','6','7','8','9','0'};
    char[] sym = {'.',',','!','@','#','$','%','^','&','*','(',')','-','_'};
    char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    void setUpper(/*String[] validSym*/){
        /*for (int i = 0; i <= upper.length; i++) {
            validSym[validSym.length] = upper[i];
        } */
        uUpper = true;
    }
    void setSymbol(/*String[] validSym*/){
        /*for (int i = 0; i <= sym.length; i++) {
            validSym[validSym.length] = sym[i];
        } */ 
        uSym = true;
    }
    void setNumber(/*String[] validSym*/){
        /*for (int i = 0; i < num.length; i++) {
            validSym[i] = num[i];
        } */  
        uNum = true;
    }
    void setLength(int minLength, int maxLength){
//        Scanner in = new Scanner(System.in);
//        System.out.println('Enter minimum password length: ');
//        min = in.nextInt();
//        System.out.println('Enter maximum password length: ');
//        max = in.nextInt();
        min = minLength;
        max = maxLength;

//        System.out.println(min + ' ' + max);
    }
    boolean checkPassword(String pass/*, String[] validSym*/){
        boolean b = false;
        if(pass.length()>max || pass.length()<min){
                System.out.println("*****************\nPassword need to be between " + min + " &  "+ max + "charcters\n*****************");
            return false;
        }
        
        for(int i = 0; i<pass.length(); i++){
            if(uLower == true){
                for(int ii = 0; ii<lower.length; ii++){
                    if(pass.charAt(i)==(lower[ii])){
                        lowerC++;
                    }
                }
            }
            else if(uUpper == true){
                for(int ii = 0; ii<upper.length; ii++){
                    if(pass.charAt(i)==(upper[ii])){
                        upperC++;
                    }
                }
            }
            else if(uNum == true){
//                if(pass.contains(num[i]) == true){
//                    numC = true;
//                }
                for(int ii = 0; ii<num.length; ii++){
                    if(pass.charAt(i)==(num[ii])){
                        numC++;
                    }
                }
            }
            else if(uSym == true){
                for(int ii = 0; ii<sym.length; ii++){
                    if(pass.charAt(i)==(sym[ii])){
                        symC++;
                    }
                }
            }
        }
        if((lowerC+upperC+numC+symC) == pass.length()){
            System.out.println("Valid Password");
            return true;
        }else{
            System.out.println("*****Invalid Password*****\nOnly use valid characters : ");
            if(uNum == true){
                System.out.println("0-9");
            }
            if(uSym == true){
                System.out.println(". , ! @ # $ % ^ & * ( ) - _");
            }
            if(uUpper == true){
                System.out.println("A-Z");
            }
            if(uLower == true){
                System.out.println("a-z");
            }
            return false;
        }
    }
}