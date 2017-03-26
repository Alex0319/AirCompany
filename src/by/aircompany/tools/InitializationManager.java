package by.aircompany.tools;

import by.aircompany.controller.Controller;

/**
 * Created by user1 on 22.03.2017.
 */
public class InitializationManager {

    private static final String[] mainMenuItems = { "Войти как пользователь", "Войти как администратор","Выход" };
    private static final String[] userMenuItems = { "Показать список самолетов компании", "Поиск самолета",
            "Отсортировать самолеты", "Выход" };
    private static final String[] adminMenuItems = { "Показать список самолетов компании", "Поиск самолета",
            "Отсортировать самолеты", "Добавить самолет", "Удалить самолет", "Сохранить изменения", "Определить общую вместимость",
            "Определить общую грузоподъемность", "Выход" } ;
    private static final String[] airplanesTypes = { "Пассажирский самолет", "Грузовой самолет" };
    private static final String[] sortParams = { "По высоте полета", "По дальности полета" };
    private static final String[] searchParams = { "По потреблению горючего", "По грузоподъемости" };

    public static void initialization(){
        System.out.println(Controller.doAction("LOAD_AIRPLANES"));
    }

    private static void printMenu(String[] menuItems){
        System.out.println("===========================================================");
        System.out.println("Выберите необходимое действие:");
        for(int i = 0; i < menuItems.length; i++){
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
        System.out.println("===========================================================");
    }

    public static void getMenu(){
        boolean isExit = false;
        while (!isExit){
            printMenu(mainMenuItems);
            switch (Operations.inputNumber(null)){
                case 1:{
                    showMenuForUser();
                }break;
                case 2:{
                    showMenuForAdmin();
                }break;
                case 3:{
                    System.out.println("Всего доброго!");
                    isExit = true;
                }break;
                default:{
                    System.out.println("Неверный выбор либо формат. Повторите...");
                }break;
            }
        }
    }

    private static void showMenuForUser(){
        boolean isExit = false;
        while (!isExit){
            printMenu(userMenuItems);
            switch (Operations.inputNumber(null)){
                case 1: {
                    System.out.print(Controller.doAction("GET_ALL_AIRPLANES"));
                }break;
                case 2: {
                    System.out.println(Controller.doAction("SEARCH_AIRPLANES&" + showMenuOfCriteriaAndGetCriteria(searchParams)
                            + "&" + Operations.inputNumber("Начало диапазона")
                            + "&" + Operations.inputNumber("Конец диапазона")));
                }break;
                case 3: {
                    System.out.println(Controller.doAction("SORT_AIRPLANES&" + showMenuOfCriteriaAndGetCriteria(sortParams)));
                }break;
                case 4:{
                    isExit = true;
                }break;
                default:{
                    System.out.println("Неверный выбор либо формат. Повторите...");
                }break;
            }
        }
    }

    private static void showMenuForAdmin(){
        boolean isExit = false;
        while (!isExit){
            printMenu(adminMenuItems);
            switch (Operations.inputNumber(null)){
                case 1: {
                    System.out.println(Controller.doAction("GET_ALL_AIRPLANES"));
                }break;
                case 2: {
                    System.out.println(Controller.doAction("SEARCH_AIRPLANES&" + showMenuOfCriteriaAndGetCriteria(searchParams)
                            + "&" + Operations.inputNumber("Начало диапазона")
                            + "&" + Operations.inputNumber("Конец диапазона")));
                }break;
                case 3: {
                    System.out.println(Controller.doAction("SORT_AIRPLANES&" + showMenuOfCriteriaAndGetCriteria(sortParams)));
                }break;
                case 4: {
                    int inputValue = showMenuOfCriteriaAndGetCriteria(airplanesTypes);
                    Controller.doAction("ADD_AIRPLANE&" + inputValue + Operations.inputAirplaneParameters(inputValue));
                }break;
                case 5: {
                    System.out.println(Controller.doAction("REMOVE_AIRPLANE&" + Operations.inputNumber("Номер самолета")));
                }break;
                case 6: {
                    System.out.println(Controller.doAction("SAVE_AIRPLANES"));
                }break;
                case 7: {
                    System.out.println(Controller.doAction("CALCULATE_TOTAL_CAPACITY"));
                }break;
                case 8: {
                    System.out.println(Controller.doAction("CALCULATE_TOTAL_CARRYING_CAPACITY"));
                }break;
                case 9:{
                    isExit = true;
                }break;
                default:{
                    System.out.println("Неверный выбор либо формат. Повторите...");
                }break;
            }
        }
    }

    private static int showMenuOfCriteriaAndGetCriteria(String[] criteriaMenuItems){
        int inputValue;
        printMenu(criteriaMenuItems);
        while ((inputValue = Operations.inputNumber(null)) > criteriaMenuItems.length){
            System.out.println("Неверный выбор либо формат. Повторите...");
            printMenu(criteriaMenuItems);
        }
        return inputValue;
    }
}
