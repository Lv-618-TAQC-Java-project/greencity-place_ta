package com.ita.edu.greencity.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
    FileInputStream fis;
    Properties prop;

    public PropertiesProvider() {
        try {
            this.fis = new FileInputStream("src/main/resources/data.properties");
            this.prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public String getAdminEmail() {
        return prop.getProperty("adminEmail");
    }

    public String getAdminPassword() {
        return prop.getProperty("adminPassword");
    }

    public String getFirstCertificateNumber(){
        return prop.getProperty("firstCertificateNumber");
    }

    public String getSecondCertificateNumber(){
        return prop.getProperty("secondCertificateNumber");
    }


}
