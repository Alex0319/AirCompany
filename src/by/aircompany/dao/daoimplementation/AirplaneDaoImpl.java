package by.aircompany.dao.daoimplementation;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.dao.AirplaneDao;
import by.aircompany.dao.exception.DaoException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by user1 on 23.03.2017.
 */
public class AirplaneDaoImpl implements AirplaneDao{

    private File getFile() throws IOException {
        final String filename = "AirplanesInfo.dat";
        File file = new File(filename);
        if(!file.exists()){
            file.createNewFile();
        }
        return file;
    }

    @Override
    public void saveAirplanesInfo(ArrayList<AbstractAirplane> airplanes) throws DaoException {
        ObjectOutputStream objectOutputStream = null;
        try {
            File file = getFile();
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(airplanes);
        } catch (IOException e) {
            throw new DaoException(e.getMessage(), e);
        }finally {
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public ArrayList<AbstractAirplane> loadAirplanesInfo() throws DaoException {
        ArrayList<AbstractAirplane> result = null;
        ObjectInputStream objectInputStream = null;
        try {
            File file = getFile();
            if(file.length() != 0) {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                result = (ArrayList<AbstractAirplane>) objectInputStream.readObject();
            }
        } catch (IOException e) {
            throw new DaoException(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            throw new DaoException(e.getMessage(), e);
        }finally {
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
