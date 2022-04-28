package medicalshop;

import java.util.ArrayList;
import java.util.List;

public class Customers {

    private  int customerID;
    private  String customerName;
    private  int zipcode;
    public List<Product> purchasedProduct = new ArrayList<>();

    public Customers(int customerID, String customerName, int zipcode) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.zipcode = zipcode;

    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public List<Product> getPurchasedProduct() {
        return purchasedProduct;
    }

    public void setPurchasedProduct(List<Product> purchasedProduct) {
        this.purchasedProduct = purchasedProduct;
    }

    public String toString() {
        return "Customer ID : " + this.getCustomerID() +
                "          Customer Name: " + this.getCustomerName() +
                "          Customer Zipcode: " + this.getZipcode() 
                ;
    }
}
