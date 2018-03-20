package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnMmarshallingJAXBExample {

    public static void main(String[] args) {

        try {
            File file = new File(System.getProperty("user.dir")
                    + File.separator + "customer.xml");

            JAXBContext context = JAXBContext.newInstance(CustomerDepartment.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CustomerDepartment customerDepartment = (CustomerDepartment) unmarshaller.unmarshal(file);
            System.out.println(customerDepartment);

            List<Customer> customerDepartmentList = customerDepartment.getDepartmentCustomer();
            customerDepartmentList.forEach(s -> System.out.println("Customer name: " + s.getName() + " " + "Customer age: " + s.getAge()));

        } catch (JAXBException ex) {
            Logger.getLogger(UnMmarshallingJAXBExample.class.getName())
                    .log(Level.SEVERE, "Something was wrong with unmarshalling !!", ex);
        }
    }
}
