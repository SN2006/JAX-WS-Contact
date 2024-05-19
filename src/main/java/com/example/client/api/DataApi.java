package com.example.client.api;

import com.example.client.utils.Constants;
import com.example.server.service.DataService;
import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.URI;
import java.net.URL;

public class DataApi {

    public String create(String[] data) throws Exception{
        URL url = URI.create(Constants.WSDL_URL).toURL();
        QName qName = new QName(Constants.SERVICE_URI, Constants.SERVICE_IMPL);
        Service service = Service.create(url, qName);
        DataService dataService = service.getPort(DataService.class);
        return dataService.create(data);
    }

    public String read() throws Exception{
        URL url = URI.create(Constants.WSDL_URL).toURL();
        QName qName = new QName(Constants.SERVICE_URI, Constants.SERVICE_IMPL);
        Service service = Service.create(url, qName);
        DataService dataService = service.getPort(DataService.class);
        return dataService.read();
    }

    public String update(String[] data) throws Exception{
        URL url = URI.create(Constants.WSDL_URL).toURL();
        QName qName = new QName(Constants.SERVICE_URI, Constants.SERVICE_IMPL);
        Service service = Service.create(url, qName);
        DataService dataService = service.getPort(DataService.class);
        return dataService.update(data);
    }

    public String delete(String[] data) throws Exception{
        URL url = URI.create(Constants.WSDL_URL).toURL();
        QName qName = new QName(Constants.SERVICE_URI, Constants.SERVICE_IMPL);
        Service service = Service.create(url, qName);
        DataService dataService = service.getPort(DataService.class);
        return dataService.delete(data);
    }

    public String readById(String[] data) throws Exception{
        URL url = URI.create(Constants.WSDL_URL).toURL();
        QName qName = new QName(Constants.SERVICE_URI, Constants.SERVICE_IMPL);
        Service service = Service.create(url, qName);
        DataService dataService = service.getPort(DataService.class);
        return dataService.readById(data);
    }

}
