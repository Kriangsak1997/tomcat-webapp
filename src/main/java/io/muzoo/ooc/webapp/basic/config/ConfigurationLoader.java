package io.muzoo.ooc.webapp.basic.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Properties;

public class ConfigurationLoader {
    //added static method for loading configuration from disk
    // default location is 'config.properties' in the same folder
    public static  ConfigProperties load() {
        String ConfigurationFilename = "config.properties";
        try (FileInputStream fin = new FileInputStream(ConfigurationFilename)) {
            Properties prop = new Properties();
            prop.load(fin);

            // get the property value and print it out
            String driverClassName = prop.getProperty("database.setDriverClassName");
            String connectionUrl = prop.getProperty("database.connectionUrl");
            String username = prop.getProperty("database.username");
            String password = prop.getProperty("database.password ");
            ConfigProperties cp = new ConfigProperties();
            cp.setDatabaseDriverClassName(driverClassName);
            cp.setDatabaseConnectionUrl(connectionUrl);
            cp.setDatabaseUsername(username);
            cp.setDatabasePassword(password);
            return cp;

        } catch (Exception e) {
           return null;
        }

    }
}
