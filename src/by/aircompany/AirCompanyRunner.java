package by.aircompany;

import by.aircompany.tools.InitializationManager;

/**
 * Created by user1 on 22.03.2017.
 */
public class AirCompanyRunner {
    public static void main(String[] args){
        try{
            InitializationManager.initialization();
            InitializationManager.getMenu();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
