package by.aircompany.dao;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.dao.exception.DaoException;

import java.util.ArrayList;

/**
 * Created by user1 on 23.03.2017.
 */
public interface AirplaneDao {
    void saveAirplanesInfo(ArrayList<AbstractAirplane> airplanes) throws DaoException;
    ArrayList<AbstractAirplane> loadAirplanesInfo() throws DaoException;
}
