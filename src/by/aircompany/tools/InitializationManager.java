package by.aircompany.tools;

import by.aircompany.controller.Controller;

/**
 * Created by user1 on 22.03.2017.
 */
public class InitializationManager {

    private static final String[] mainMenuItems = { "Войти как пользователь",
            "Войти как администратор","Зарегистрироваться","Выход" };
    private static final String[] userMenuItems = { "Показать список самолетов компании", "Поиск самолета",
            "Отсортировать самолеты", "Выход" };
    private static final String[] adminMenuItems = { "Показать список самолетов компании", "Поиск самолета",
            "Отсортировать самолеты", "Добавить самолет", "Удалить самолет", "Определить общую вместимость",
            "Определить общую грузоподъемность", "Выход" } ;
    private static final String[] sortParams = { "По дальности полета" };
    private static final String[] searchParams = { "По потреблению горючего" };

    public static void initialization(){

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
            switch (Operations.inputNumber()){
                case 1:{
                    showMenuForUser();
                }break;
                case 2:{
                    showMenuForAdmin();
                }break;
                case 3:{

                }break;
                case 4:{
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
            switch (Operations.inputNumber()){
                case 1: {
                }break;
                case 2: {
                    Controller.doAction("SEARCH&"+showMenuOfCriteriaAndGetCriteria(searchParams));
                }break;
                case 3: {
                    Controller.doAction("SORT&"+showMenuOfCriteriaAndGetCriteria(sortParams));
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
            switch (Operations.inputNumber()){
                case 1: {

                }break;
                case 2: {
                    Controller.doAction("SEARCH&"+showMenuOfCriteriaAndGetCriteria(searchParams));
                }break;
                case 3: {
                    Controller.doAction("SORT&"+showMenuOfCriteriaAndGetCriteria(sortParams));
                }break;
                case 4: {

                }break;
                case 5: {

                }break;
                case 6: {

                }break;
                case 7: {

                }break;
                case 8:{
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
        while ((inputValue = Operations.inputNumber()) > criteriaMenuItems.length + 1){
            printMenu(criteriaMenuItems);
            System.out.println("Неверный выбор либо формат. Повторите...");
        }
        return inputValue;
    }
}
