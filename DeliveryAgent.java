package medicalshop;

import java.util.List;

public class DeliveryAgent  {

    private int deliveryAgentId;
    private String deliveryAgentName;
    private  int zipCode;
    private  int noOfProductsDelivered;

    public DeliveryAgent(int deliveryAgentId, String deliveryAgentName, int zipCode, int noOfProductsDelivered) {
        this.deliveryAgentId = deliveryAgentId;
        this.deliveryAgentName = deliveryAgentName;
        this.zipCode = zipCode;
        this.noOfProductsDelivered = noOfProductsDelivered;
    }

    public int getDeliveryAgentId() {
        return deliveryAgentId;
    }

    public void setDeliveryAgentId(int deliveryAgentId) {
        this.deliveryAgentId = deliveryAgentId;
    }

    public String getDeliveryAgentName() {
        return deliveryAgentName;
    }

    public void setDeliveryAgentName(String deliveryAgentName) {
        this.deliveryAgentName = deliveryAgentName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getNoOfProductsDelivered() {
        return noOfProductsDelivered;
    }

    public void setNoOfProductsDelivered(int noOfProductsDelivered) {
        this.noOfProductsDelivered = noOfProductsDelivered;
    }

    public void addDeliveryCount(int newDeliveries) {

        this.noOfProductsDelivered += newDeliveries;
    }

    public String toString() {
        return "Delivery Agent ID : " + this.getDeliveryAgentId() +
                "          Delivery Agent Name: " + this.getDeliveryAgentName()
                +
                "          Delivery Agent Zipcode: " + this.getZipCode();
    }
}
