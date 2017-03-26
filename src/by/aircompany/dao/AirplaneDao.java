package by.aircompany.dao;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.dao.exception.DaoException;

import java.util.List;

/**
 * Created by user1 on 23.03.2017.
 */
public interface AirplaneDao {
    void saveAirplanesInfo(List<AbstractAirplane> airplanes) throws DaoException;
    List<AbstractAirplane> loadAirplanesInfo() throws DaoException;
}
