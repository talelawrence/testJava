package com.example.demo.conotroller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
@RequestMapping("/api/master-data")
public class MasterDataController {

    @Value("${ws_url_service_employee}")
    private String employee;

    @Value("${ws_url_service_organization}")
    private String organization;

    @Value("${ws_url_service_token}")
    private String serviceToken;
    @Value("${security_code}")
    private String securityCode;


    @GetMapping("/get-data")
    public void getDatavalue (){

        Properties properties = new Properties();
        InputStream configFile = null;
        System.out.println(serviceToken);
        System.out.println(organization);
        System.out.println(employee);
        System.out.println(securityCode);

        try {
            // Specify the path to your config.properties file
            configFile = MasterDataController.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(configFile);

            // Access individual properties by their keys
            String ws_url_service_employee = properties.getProperty("ws_url_service_employee");
            String ws_url_service_organization = properties.getProperty("ws_url_service_organization");
            String ws_url_service_token = properties.getProperty("ws_url_service_token");
            String security_code = properties.getProperty("security_code");

            // Use the loaded properties in your application
            System.out.println(ws_url_service_employee);
            System.out.println(ws_url_service_organization);
            System.out.println(ws_url_service_token);
            System.out.println(security_code);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the FileInputStream
            if (configFile != null) {
                try {
                    configFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
