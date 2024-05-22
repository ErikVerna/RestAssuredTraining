package POJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONArraySerialization {

    public String completeJSON;

    @Test
    public void createJSONArrayFromPojo() throws JsonProcessingException {
        JSONArrayPOJO erik = new JSONArrayPOJO();

        erik.setFirstName("Erik");
        erik.setLastName("Verna");
        erik.setAge(26);
        erik.setGender("Male");
        erik.setSalary(144444.0);
        erik.setMarriage(false);

        JSONArrayPOJO marcos = new JSONArrayPOJO();

        marcos.setFirstName("Marcos");
        marcos.setLastName("Aguirre");
        marcos.setAge(29);
        marcos.setGender("Male");
        marcos.setSalary(1454544.0);
        marcos.setMarriage(true);

        JSONArrayPOJO josefina = new JSONArrayPOJO();

        josefina.setFirstName("Josefina");
        josefina.setLastName("Guti");
        josefina.setAge(31);
        josefina.setGender("Female");
        josefina.setSalary(198544.0);
        josefina.setMarriage(false);


        ArrayList<JSONArrayPOJO> allemployees = new ArrayList<JSONArrayPOJO>();
        allemployees.add(erik);
        allemployees.add(marcos);
        allemployees.add(josefina);

        ObjectMapper mapper = new ObjectMapper();
        completeJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(allemployees);

        System.out.println(completeJSON);
    }

    @Test
    public void getPOJOfromObject() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<JSONArrayPOJO> allemployees = mapper.readValue(completeJSON, new TypeReference<ArrayList<JSONArrayPOJO>>() {});

        for(JSONArrayPOJO employee : allemployees){
            System.out.println("==================================");
            System.out.println("First Name of Employee: " + employee.getFirstName());
            System.out.println("Last Name of Employee: " + employee.getLastName());
            System.out.println("Age of Employee: " + employee.getAge());
            System.out.println("Salary of Employee: " + employee.getSalary());
            System.out.println("Marital status of employee: " + employee.isMarriage());
        }
    }
}
