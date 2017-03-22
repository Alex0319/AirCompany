package by.aircompany.tools;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by user1 on 22.03.2017.
 */
public class Operations {
    public static Scanner input = new Scanner(System.in);

    public static int inputNumber(){
        int number = -1;
        while(number <= 0){
            try {
                input = new Scanner(System.in);
                number = input.nextInt();
                if(number > 0){
                    return number;
                }
                else{
                    System.out.println("Параметр не может быть отрицательным. Повторите ввод...");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Неверный формат. Повторите ввод...");
            }
        }
        return 0;
    }
}
