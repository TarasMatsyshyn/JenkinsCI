package utils;

import model.UserModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesParser {

    public UserModel getSomeUser(){
        Properties instance = getPropertyInstance();
        return new UserModel(instance.getProperty("mail.login"),instance.getProperty("mail.password"));
    }

    public String getBaseUrl(){
        return getPropertyInstance().getProperty("base.url");
    }

    private Properties getPropertyInstance(){

        FileInputStream inputStream;
        Properties instance = new Properties();

        try {
            inputStream = new FileInputStream("src/main/resources/baseURL.properties");
            instance.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }



}
