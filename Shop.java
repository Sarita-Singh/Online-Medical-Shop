package medicalshop;

import java.util.HashMap;
import java.util.Map;

public class Shop {
    private  int shopId;
    private  String shopName;
    private int zipcode;
    private Map<Product,Integer> noOfItems = new HashMap<>();

    public Shop(int shopId, String shopName,int zipcode) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.zipcode=zipcode;
    }
    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Map<Product, Integer> getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(Map<Product, Integer> noOfItems) {
        this.noOfItems = noOfItems;
    }

    public void decreaseQuantity(Map<Product, Integer> noOfItems,Product selectedProduct, Integer decrease) {

        Integer count = noOfItems.get(selectedProduct);
        noOfItems.put((selectedProduct), count -decrease);

    }
    public String toString() {
        return "Shop ID : " + this.getShopId() +
                "          Shop Name: " + this.getShopName()
                +
                "          Shop Zipcode: " + this.getZipcode();
    }
}
