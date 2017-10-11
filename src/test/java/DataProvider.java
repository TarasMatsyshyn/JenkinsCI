import model.UserModel;
import utils.CSVParser;
import utils.XLSParser;
import utils.XMLParser;

import java.io.IOException;
import java.util.List;

public class DataProvider {

    @org.testng.annotations.DataProvider(parallel = true)
    public static Object [][] getData() throws Exception {
        List<UserModel> users = userModelsCSV();
        Object [][] data = new Object[users.size()][2];

        for(int i = 0; i < users.size(); i++){
            data[i][0] = users.get(i).getLogin();
            data[i][1] = users.get(i).getPassword();
        }
        return data;
    }

    private static List<UserModel> userModelsXML() throws Exception{
        XMLParser xmlParser = new XMLParser();
        return xmlParser.unMarshaling();
    }

    private static List<UserModel> userModelsCSV() throws IOException {
        CSVParser csvParser = new CSVParser();
        return csvParser.getUsersFromCSV();
    }

    private static  List<UserModel> userModelXLS() throws IOException{
        XLSParser xlsParser = new XLSParser();
        return xlsParser.getUsersFromXLS();
    }
}
