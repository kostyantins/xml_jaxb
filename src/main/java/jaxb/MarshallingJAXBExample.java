package jaxb;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@Setter
public class MarshallingJAXBExample {

    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<Customer>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Markus Donald");
        customer1.setAge(30);
        customerList.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Daniel Robinson");
        customer2.setAge(35);
        customerList.add(customer2);

        CustomerDepartment customerStore = new CustomerDepartment();
        customerStore.setName("Franek's Customers");
        customerStore.setLocation("Ivano-Frankivsk");
        customerStore.setDepartmentCustomer(customerList);

        try {
            File file = new File(System.getProperty("user.dir")
                    + File.separator + "customer.xml");

            JAXBContext context = JAXBContext.newInstance(CustomerDepartment.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //to generate the XML with proper indentation
            marshaller.marshal(customerStore, file);
            marshaller.marshal(customerStore, System.out);

        } catch (JAXBException ex) {
            Logger.getLogger(MarshallingJAXBExample.class.getName())
                    .log(Level.SEVERE, "Something was wrong with marshalling !!", ex);
        }
    }
}
