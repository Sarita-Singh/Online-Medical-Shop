package medicalshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Manufacturer {

    private int manufacturerId;
    private String manufacturerName;
    private List<Product> manufacturingProduct= new ArrayList<>();

    public Manufacturer(int manufacturerId, String manufacturerName) {
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public List<Product> getManufacturingProduct() {
        return manufacturingProduct;
    }

    public void setManufacturingProduct(List<Product> manufacturingProduct) {
        this.manufacturingProduct = manufacturingProduct;
    }

    public String toString() {
        return "Manufacturer ID : " + this.getManufacturerId() +
                "          Manufacturer Name: " + this.getManufacturerName();
    }
}
