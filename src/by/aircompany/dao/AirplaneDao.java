package by.aircompany.dao;

import by.aircompany.dao.exception.DaoException;

/**
 * Created by user1 on 23.03.2017.
 */
public interface AirplaneDao {
    void saveAirplanesInfo() throws DaoException;
    void loadAirplanesInfo() throws DaoException;
}
