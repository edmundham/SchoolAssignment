package ca.bcit.infosys;

import java.util.Map;

public class Supplier {
    private int supplierId;
    private String supplierName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String postalCode;
    private String stateOrProvince;
    private String country;
    private String phoneNumber;
    private String faxNumber;
    private String paymentTerms;
    private String emailAddress;
    private String notes;

    public Supplier(Map<String, String> supplierMap) {
        supplierId = Integer.parseInt(supplierMap.get("SupplierID"));
        supplierName = supplierMap.get("SupplierName");
        contactName = supplierMap.get("ContactName");
        contactTitle = supplierMap.get("ContactTitle");
        address = supplierMap.get("Address");
        city = supplierMap.get("City");
        postalCode = supplierMap.get("PostalCode");
        stateOrProvince = supplierMap.get("StateOrProvince");
        country = supplierMap.get("Country");
        phoneNumber = supplierMap.get("PhoneNumber");
        faxNumber = supplierMap.get("FaxNumber");
        paymentTerms = supplierMap.get("PaymentTerms");
        emailAddress = supplierMap.get("EmailAddress");
        notes = supplierMap.get("Notes");
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return supplierId  + ", " + supplierName + ", " + contactName + ", " + contactTitle + ", " + address
                + ", " + city + ", " + postalCode + ", " + stateOrProvince + ", " + country + ", " + phoneNumber
                + ", " + faxNumber + ", " + paymentTerms + ", " + emailAddress + ", " + notes;
    }

}
