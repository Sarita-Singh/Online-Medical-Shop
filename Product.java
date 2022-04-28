package medicalshop;

import java.util.*;

public class Product {

    private  int productId;
    private  String productName;
    private Manufacturer manufacturer;

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String toString() {
        return "Product ID : " + this.getProductId() +
                "          Product Name: " + this.getProductName() ;
    }
}

