package POJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateNestedJSONFromPOJO {

    @Test
    public void generatePOJOData() throws JsonProcessingException {
        CompanyDetails nestedPOJO = new CompanyDetails();
        nestedPOJO.setCompanyName("Las Heras F5");
        nestedPOJO.setCompanyHOCity("Lomas del Mirador");
        nestedPOJO.setCompanyCEO("Julian Chappa");

        List<String> supportedSalaryBanks = new ArrayList<>();
        supportedSalaryBanks.add("HDFC");
        supportedSalaryBanks.add("ICICI");
        supportedSalaryBanks.add("AXIS");
        nestedPOJO.setSupportedSalaryBanks(supportedSalaryBanks);

        List<Integer> pinCcodesOfCityOffice = new ArrayList<>();
        pinCcodesOfCityOffice.add(560037);
        pinCcodesOfCityOffice.add(360034);
        pinCcodesOfCityOffice.add(456343);
        nestedPOJO.setPinCodesOfCityOffice(pinCcodesOfCityOffice);

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

        List<JSONArrayPOJO> employee = new ArrayList<>();
        employee.add(erik);
        employee.add(marcos);
        employee.add(josefina);
        nestedPOJO.setEmployee(employee);

        Contractors pepe = new Contractors();
        pepe.setFirstName("Jose");
        pepe.setLastName("Parker");
        pepe.setContractFrom("Jan-2021");
        pepe.setContractTo("Jan-2023");

        Contractors julia = new Contractors();
        julia.setFirstName("Julia");
        julia.setLastName("Roberts");
        julia.setContractFrom("May-2022");
        julia.setContractTo("Dec-2025");

        List<Contractors> contractors = new ArrayList<>();
        contractors.add(pepe);
        contractors.add(julia);
        nestedPOJO.setContractors(contractors);

        CompanyPFDetails companyPFDetails = new CompanyPFDetails();
        companyPFDetails.setPfName("XYZ");
        companyPFDetails.setPfYear(2012);
        companyPFDetails.setPfCity("Laferrere");
        companyPFDetails.setNoOfEmployee(15);
        nestedPOJO.setCompanyPFDetails(companyPFDetails);

        ObjectMapper mapper = new ObjectMapper();
        String nestedPayLoad = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(nestedPOJO);
        System.out.println(nestedPayLoad);
    }
}
