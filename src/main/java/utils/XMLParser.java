package utils;

import model.UserModel;
import model.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XMLParser {
    public List<UserModel> unMarshaling() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Users users = (Users) unmarshaller.unmarshal(new File("src/test/resources/com/epam/dataProvider/users.xml"));
        return users.getUserModels();
    }
}
