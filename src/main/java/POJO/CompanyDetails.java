package POJO;

import java.util.List;

public class CompanyDetails {

    private String companyName;
    private String companyHOCity;
    private String companyCEO;
    private List<String> supportedSalaryBanks;
    private List<Integer> pinCodesOfCityOffice;

    List<JSONArrayPOJO> employee;
    List<Contractors> contractors;
    CompanyPFDetails companyPFDetails;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyHOCity() {
        return companyHOCity;
    }

    public void setCompanyHOCity(String companyHICity) {
        this.companyHOCity = companyHICity;
    }

    public String getCompanyCEO() {
        return companyCEO;
    }

    public void setCompanyCEO(String companyCEO) {
        this.companyCEO = companyCEO;
    }

    public List<String> getSupportedSalaryBanks() {
        return supportedSalaryBanks;
    }

    public void setSupportedSalaryBanks(List<String> supportedSalaryBanks) {
        this.supportedSalaryBanks = supportedSalaryBanks;
    }

    public List<Integer> getPinCodesOfCityOffice() {
        return pinCodesOfCityOffice;
    }

    public void setPinCodesOfCityOffice(List<Integer> pinCodesOfCityOffice) {
        this.pinCodesOfCityOffice = pinCodesOfCityOffice;
    }

    public List<JSONArrayPOJO> getEmployee() {
        return employee;
    }

    public void setEmployee(List<JSONArrayPOJO> employee) {
        this.employee = employee;
    }

    public List<Contractors> getContractors() {
        return contractors;
    }

    public void setContractors(List<Contractors> contractors) {
        this.contractors = contractors;
    }

    public CompanyPFDetails getCompanyPFDetails() {
        return companyPFDetails;
    }

    public void setCompanyPFDetails(CompanyPFDetails companyPFDetails) {
        this.companyPFDetails = companyPFDetails;
    }
}
