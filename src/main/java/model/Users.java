package model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "userModels")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
    @XmlElement(name = "userModel")
    private List<UserModel> userModels = null;

    public List<UserModel> getUserModels() {
        return userModels;
    }

}