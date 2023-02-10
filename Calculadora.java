
package calculadora;

import java.util.Scanner;
import java.lang.Math;


public class Calculadora {

   
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        float num1 = getfloat();
        float num2 = getfloat();
        char operation = getOperation();
        float result = C(num1,num2,operation);
        System.out.println("El resultado de la operación: "+result);
    }
    public static float getfloat(){
        System.out.println("Introduzca un número:");
        float  num;
        if(scanner.hasNextFloat()){
            num =  (float) scanner.nextFloat();
        } else {
            System.out.println("Te has equivocado al introducir el número. Inténtalo de nuevo.");
            scanner.next();
            num = getfloat();
        }
        return num;
         }
    public static char getOperation(){
        System.out.println("Introduzca la operación:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Ha cometido un error al entrar en la operación. Inténtalo de nuevo.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }
    public static float C(float num1, float num2, char operation){
        float result;
        switch (operation){
            case '+' -> result = (float) (num1+num2);
            case '-' -> result = (float) (num1-num2);
            case '*' -> result = (float) (num1*num2);
            case '/' -> result = (float) (num1/num2);
            case '^' -> result = (float) Math. pow(num1,num2);
            case 'r' -> result = (float) Math.sqrt(num1);
            case 's' -> result = (float) Math.sin(num1);
            case 'c' -> result = (float) Math.cos(num1);
            case 't' -> result = (float) Math.tan(num1);
            case '%' -> result = (float) ((num1*num2)/100);
            default -> {
                System.out.println("La operación no se reconoce. Repite la entrada.");
                result = (float) C(num1, num2, getOperation());
            }
        }
        return result;
    }
}
    
    

