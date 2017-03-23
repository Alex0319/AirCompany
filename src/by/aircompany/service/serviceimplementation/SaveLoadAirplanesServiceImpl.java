package by.aircompany.service.serviceimplementation;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.beans.AirCompanyManager;
import by.aircompany.dao.AirplaneDao;
import by.aircompany.dao.daoimplementation.AirplaneDaoImpl;
import by.aircompany.dao.exception.DaoException;
import by.aircompany.service.SaveLoadAirplanesService;
import by.aircompany.service.exception.ServiceException;

import java.util.ArrayList;

/**
 * Created by user1 on 23.03.2017.
 */
public class SaveLoadAirplanesServiceImpl implements SaveLoadAirplanesService{
    private AirCompanyManager airCompanyManager = AirCompanyManager.getInstance();

    @Override
    public boolean saveAirplanes() throws ServiceException {
        try {
            AirplaneDao airplaneDao = new AirplaneDaoImpl();
            airplaneDao.saveAirplanesInfo(airCompanyManager.getAirplanes());
        }catch (DaoException e){
            throw new ServiceException(e.getMessage(), e);
        }
        return true;
    }

    @Override
    public boolean loadAirplanes() throws ServiceException {
        try {
            AirplaneDao airplaneDao = new AirplaneDaoImpl();
            airCompanyManager.addRange(airplaneDao.loadAirplanesInfo());
        }catch (DaoException e){
            throw new ServiceException(e.getMessage(), e);
        }
        return true;
    }
}
