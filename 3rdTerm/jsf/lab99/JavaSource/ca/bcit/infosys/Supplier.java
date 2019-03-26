package ca.bcit.infosys;

import java.io.Serializable;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@Entity
@Table(name="Suppliers")
@TransactionManagement(TransactionManagementType.BEAN)
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="SupplierID")
    private int supplierId;

    @Column(name="SupplierName")
    private String supplierName;

    @Column(name="ContactName")
    private String contactName;

    @Column(name="ContactTitle")
    private String contactTitle;

    @Column(name="Address")
    private String address;

    @Column(name="City")
    private String city;

    @Column(name="PostalCode")
    private String postalCode;

    @Column(name="StateOrProvince")
    private String stateOrProvince;

    @Column(name="Country")
    private String country;

    @Column(name="PhoneNumber")
    private String phoneNumber;

    @Column(name="FaxNumber")
    private String faxNumber;

    @Column(name="PaymentTerms")
    private String paymentTerms;

    @Column(name="EmailAddress")
    private String emailAddress;

    @Column(name="Notes")
    private String notes;

    public Supplier() {

    }

//    public Supplier(Map<String, String> supplierMap) {
//        supplierId = Integer.parseInt(supplierMap.get("SupplierID"));
//        supplierName = supplierMap.get("SupplierName");
//        contactName = supplierMap.get("ContactName");
//        contactTitle = supplierMap.get("ContactTitle");
//        address = supplierMap.get("Address");
//        city = supplierMap.get("City");
//        postalCode = supplierMap.get("PostalCode");
//        stateOrProvince = supplierMap.get("StateOrProvince");
//        country = supplierMap.get("Country");
//        phoneNumber = supplierMap.get("PhoneNumber");
//        faxNumber = supplierMap.get("FaxNumber");
//        paymentTerms = supplierMap.get("PaymentTerms");
//        emailAddress = supplierMap.get("EmailAddress");
//        notes = supplierMap.get("Notes");
//    }

    @XmlAttribute
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @XmlElement(name = "supplierName")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @XmlElement(name = "contactName")
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @XmlElement(name = "contactTitle")
    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    @XmlElement
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @XmlElement(name = "stateOrProvince")
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    @XmlElement
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlElement(name = "faxNumber")
    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    @XmlElement(name = "paymentTerms")
    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    @XmlElement(name = "emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @XmlElement(name = "notes")
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
