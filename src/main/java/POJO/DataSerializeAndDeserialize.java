package POJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class DataSerializeAndDeserialize {
    @Test
    public void createDatafromPOJO() throws JsonProcessingException {

        SamplePOJO employee = new SamplePOJO();

        employee.setFirstName("Erik");
        employee.setLastName("Verna");
        employee.setAge(26);
        employee.setGender("Male");
        employee.setSalary(144444);
        employee.setMarriage(false);

        ObjectMapper mapper = new ObjectMapper();

        String employeeJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);

        System.out.println(employeeJSON);
    }
    @Test
    public void getPOJOfromObject() throws JsonProcessingException {
        //creating an object of POJO class
        SamplePOJO employee = new SamplePOJO();

            //setting every key
        employee.setFirstName("Joaquin");
        employee.setLastName("Madison");
        employee.setAge(32);
        employee.setGender("Male");
        employee.setSalary(1456784);
        employee.setMarriage(true);

        //Converting a java class object to a JSON payload as String
        ObjectMapper mapper = new ObjectMapper();

        String employeeJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);

        SamplePOJO employeeObj = mapper.readValue(employeeJSON, SamplePOJO.class);

        System.out.println("First name: " + employeeObj.getFirstName());
        System.out.println("Last name: " + employeeObj.getLastName());
        System.out.println("Age: " + employeeObj.getAge());
        System.out.println("Gender: " + employeeObj.getGender());
        System.out.println("Marriage : " + employeeObj.getMarriage());

    }
}