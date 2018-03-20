package jaxb;

import lombok.Data;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Data
@XmlRootElement
@XmlType(propOrder = { "name", "location", "departmentCustomer"}) //for right position of variables below in xml structure
public class CustomerDepartment {

    private List<Customer> departmentCustomer;
    private String name;
    private String location;

    public List<Customer> getDepartmentCustomer() {
        return departmentCustomer;
    }

    @XmlElementWrapper(name = "department") // generates a wrapper element around XML representation
    public void setDepartmentCustomer(List<Customer> departmentCustomer) {
        this.departmentCustomer = departmentCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
