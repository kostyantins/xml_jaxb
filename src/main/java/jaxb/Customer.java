package jaxb;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "customer")
@XmlType(propOrder = { "id", "age", "name"}) //for right position of variables below
public class Customer {

    //    @XmlElementWrapper(name = "departmentCustomer") it needs if U not using Lombok framework in set method
    //    @XmlElement it needs if U not using Lombok framework in set method
    //    @XmlAttribute it needs if U not using Lombok framework in set method
    private int id;

    //    @XmlElement it needs if U not using Lombok framework in set method
    private int age;

    //    @XmlAttribute it needs if U not using Lombok framework in set method
    private String name;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
