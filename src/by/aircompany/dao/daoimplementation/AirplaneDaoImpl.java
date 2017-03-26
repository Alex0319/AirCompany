package by.aircompany.dao.daoimplementation;

import by.aircompany.airplanesfactory.AirplanesFactory;
import by.aircompany.airplanesfactory.factoriesimplementations.FactoryMapper;
import by.aircompany.beans.AbstractAirplane;
import by.aircompany.dao.AirplaneDao;
import by.aircompany.dao.exception.DaoException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.*;

/**
 * Created by user1 on 23.03.2017.
 */
public class AirplaneDaoImpl implements AirplaneDao{

    private final String filename = "AirplanesInfo.xml";

    @Override
    public void saveAirplanesInfo(List<AbstractAirplane> airplanes) throws DaoException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element rootElement = document.createElement("Airplanes");
            document.appendChild(rootElement);
            for (AbstractAirplane airplane: airplanes) {
                rootElement.appendChild(getAirplaneNode(document,airplane.toXmlString()));
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult file = new StreamResult(new File(filename));
            transformer.transform(source,file);
        } catch (ParserConfigurationException | TransformerException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    private Node getAirplaneNode(Document document, String airplaneInfo){
        String[] airplaneParams = airplaneInfo.split(", ");
        Element airplane = document.createElement("Airplane");
        for (int i = 0; i < airplaneParams.length; i++){
            airplane.setAttribute("id", Integer.toString(i+1));
            String[] airplaneParamNameAndValue = airplaneParams[i].split("=");
            airplane.appendChild(getAirplaneParamNode(document, airplaneParamNameAndValue[0],airplaneParamNameAndValue[1]));
        }
        return airplane;
    }

    private Node getAirplaneParamNode(Document document, String paramName, String paramValue) {
        Element node = document.createElement(paramName);
        node.appendChild(document.createTextNode(paramValue));
        return node;
    }

    @Override
    public List<AbstractAirplane> loadAirplanesInfo() throws DaoException {
        List<AbstractAirplane> result = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Airplane");
            for (int i = 0; i < nodeList.getLength(); i++){
                String[] airplaneParams = getAirplaneParams(nodeList.item(i));
                AirplanesFactory airplanesFactory = FactoryMapper.getFactory(airplaneParams[0].concat("_AIRPLANE_FACTORY"));
                result.add(airplanesFactory.createAirplane(Arrays.copyOfRange(airplaneParams,1,airplaneParams.length)));
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return result;
    }

    private String[] getAirplaneParams(Node item) {
        List<String> params = new ArrayList<>();
        if(item.getNodeType() == Node.ELEMENT_NODE){
            NodeList nodeElements = item.getChildNodes();
            for (int i = 0; i < nodeElements.getLength(); i++){
                params.add(nodeElements.item(i).getFirstChild().getNodeValue());
            }
        }
        return params.toArray(new String[0]);
    }
}
