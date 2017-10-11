package utils;

import au.com.bytecode.opencsv.CSVReader;
import model.UserModel;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    public List<UserModel> getUsersFromCSV() throws IOException {
        List<UserModel> userModelList = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/users.csv"),',');
        String[] line = null;

        while ((line = reader.readNext()) != null){
            UserModel user = new UserModel(line[0],line[1]);
            userModelList.add(user);
        }

        return userModelList;
    }
}
