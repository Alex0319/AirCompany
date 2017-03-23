package by.aircompany.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by user1 on 22.03.2017.
 */
public class Operations {
    public static Scanner input = new Scanner(System.in);

    public static int inputNumber(String paramName){
        int number = -1;
        while(number <= 0){
            try {
                if(paramName != null){
                    System.out.print(paramName + ": ");
                }
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

    public static float inputFloatNumber(String paramName){
        float number = -1;
        while(number <= 0){
            try {
                if(paramName != null){
                    System.out.print(paramName + ": ");
                }
                input = new Scanner(System.in);
                number = input.nextFloat();
                if(number > 0){
                    return number;
                }
                else{
                    System.out.println("Параметр \"" + paramName + "\" не может быть отрицательным. Повторите ввод...");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Неверный формат. Повторите ввод...");
            }
        }
        return 0;
    }

    public static String inputString(String paramName){
        String inputString;
        if(paramName != null){
            System.out.print(paramName + ": ");
        }
        while ((inputString = input.next()).isEmpty()){
            System.out.println("Параметр " + paramName + " не может быть пустым");
        }
        return inputString;
    }

    public static String inputAirplaneParameters(int airplaneType){
        final ArrayList<String> generalAirplanesParams = new ArrayList<>(Arrays.asList(new String[] { "Название",
                "Производитель", "Длина", "Размах крыльев", "Высота", "Дальность полета", "Скорость",
                "Грузоподъемность", "Высота полета", "Вместимость", "Расход топлива"}));
        final int generalAirplanesParamsCount = generalAirplanesParams.size();
        StringBuilder inputAirplaneParams = new StringBuilder();
        if (airplaneType == 1){
            generalAirplanesParams.add("Количество пассажирских мест");
        }else{
            generalAirplanesParams.add("Максимальная загрузка самолета");
            generalAirplanesParams.add("Максимальный объем самолета");
        }
        for (int i = 0; i < generalAirplanesParams.size(); i++) {
            inputAirplaneParams.append('&');
            if (i < 2){
                inputAirplaneParams.append(inputString(generalAirplanesParams.get(i)));
            }else if(i < generalAirplanesParamsCount){
                inputAirplaneParams.append(Float.toString(inputFloatNumber(generalAirplanesParams.get(i))));
            }else {
                inputAirplaneParams.append(Integer.toString(inputNumber(generalAirplanesParams.get(i))));
            }
        }
        return inputAirplaneParams.toString();
    }
}
