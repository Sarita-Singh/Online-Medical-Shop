package medicalshop;

import java.awt.*;
import java.util.*;
import java.util.List;

/*
    Name : Sarita Singh
    Roll No. : 20CS10053
*/
public class OnlineMedicalShop {

    public static ArrayList<Manufacturer> manufacturerList = new ArrayList<Manufacturer>();
    public static ArrayList<Product> productList = new ArrayList<Product>();
    public static ArrayList<Customers> customerList = new ArrayList<Customers>();
    public static ArrayList<DeliveryAgent> agentList = new ArrayList<DeliveryAgent>();
    public static ArrayList<Shop> shopList = new ArrayList<Shop>();
    public static ArrayList<Product> processOrder = new ArrayList<>();
    public static List<Product> list = new ArrayList<>();

    public static Customers customers;
    public static Product product;
    public static Shop shop;
    public static Manufacturer manufacturer;

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int op = 0;
        while (op != 9) {
            System.out.print("\nSELECT OPTION FROM LIST BELOW:\n\n" +
                    "1> Create, delete and print entities of each type.\n" +
                    "2> Add a product to manufacturer.\n" +
                    "3> Add a certain number of copies of a product to a shop.\n" +
                    "4> Add an order of a product from a customer.\n" +
                    "5> Process an order.\n" +
                    "6> List all the purchases made by a customer.\n" +
                    "7> List inventory of a shop (Products and counts).\n" +
                    "8> Products made by a manufacturer.\n" +
                    "9> Exit\n\n" +
                    "OPTION NUMBER: ");
            op = input.nextInt();
            switch (op) {
                case 1:
                    func();
                    break;
                case 2:
                    addManufacturerToProduct();
                    break;
                case 3:
                    addCopies();
                    break;
                case 4:
                    addOrderCust();
                    break;
                case 5:
                    processOrder();
                    break;
                case 6:
                    printPurchasesOfCustomer(input);
                    break;
                case 7:
                    print_product_Shops(input);
                    break;
                case 8:
                    product_of_Manufacturers(input);
                    break;
                case 9:
                    System.out.println("\n\tHave a good day. Bye!");
                    break;
                default:
                    System.out.println("\n\tEnter a valid option number.");
            }
        }
    }

    static void printCustomers() {
        for (Customers cust : customerList) {
            System.out.println(cust);
        }
    }

    static void printManufacturers() {
        for (Manufacturer manuf : manufacturerList) {
            System.out.println(manuf);
        }
    }

    static void printShops() {
        for (Shop sh : shopList) {
            System.out.println(sh);
        }
    }

    static void printProduct() {
        for (Product prod : productList) {
            System.out.println(prod);
        }
    }

    static void printDeliveryAgents() {
        for (DeliveryAgent da : agentList) {
            System.out.println(da);
        }
    }

    private static int getManufacturerIndex(Scanner sc) {

        printManufacturers();
        System.out.println("\nEnter a Manufacturer ID to select it.");

        System.out.print("ID : ");
        int ID = sc.nextInt();
        boolean isFound = false;
        int index = -1;

        for (Manufacturer temp : manufacturerList) {

            index++;
            if (temp.getManufacturerId() == ID) {
                System.out.println("Selected Manufacturer Id : " + temp.getManufacturerId() + " Manufacturer Name : "
                        + temp.getManufacturerName());
                isFound = true;
                break;
            }
        }

        if (isFound) {
            return index;
        } else
            System.out.println("Manufacturer ID not found. Please try again.");

        return -1;
    }

    private static int getShopIndex(Scanner sc) {

        printShops();
        System.out.println("\nEnter a Shop ID to select it.");
        System.out.print("ID : ");
        int ID = sc.nextInt();
        boolean isFound = false;
        int index = -1;

        for (Shop temp : shopList) {

            index++;
            if (temp.getShopId() == ID) {
                System.out.println("Selected Shop Id : " + temp.getShopId() + " Shop Name : " + temp.getShopName());
                isFound = true;
                break;
            }
        }

        if (isFound) {
            return index;
        } else
            System.out.println("Shop ID not found. Please try again.");

        return -1;
    }

    private static int getProductIndex(Scanner sc) {

        printProduct();
        System.out.println("\nEnter a Product ID to select it.");
        System.out.print("ID : ");
        int ID = sc.nextInt();
        boolean isFound = false;
        int index = -1;

        for (Product temp : productList) {

            index++;
            if (temp.getProductId() == ID) {
                System.out.println(
                        "Selected Product Id : " + temp.getProductId() + " Product Name : " + temp.getProductName());
                isFound = true;
                break;
            }
        }

        if (isFound) {
            return index;
        } else
            System.out.println("Shop ID not found. Please try again.");

        return -1;
    }

    private static int getCustomerIndex(Scanner sc) {

        printCustomers();

        System.out.println("\nEnter a Customer ID to select it.");

        System.out.print("ID : ");
        int ID = sc.nextInt();
        boolean isFound = false;
        int index = -1;

        for (Customers temp : customerList) {

            index++;
            if (temp.getCustomerID() == ID) {
                System.out.println("Selected Customer ID : " + temp.getCustomerID() + " Customer Name : "
                        + temp.getCustomerName());
                isFound = true;
                break;
            }
        }

        if (isFound) {
            return index;
        } else {
            System.out.println("Customer ID not found. Please try again.");
            return -1;
        }
    }

    private static int getDeliveryAgentIndex(Scanner sc) {

        printDeliveryAgents();
        System.out.println("\nEnter a Delivery Agent ID to delete it.");
        System.out.print("ID : ");
        int ID = sc.nextInt();
        boolean isFound = false;
        int index = -1;

        for (DeliveryAgent temp : agentList) {

            index++;
            if (temp.getDeliveryAgentId() == ID) {
                System.out.println("Selected Delivery Agent Id : " + temp.getDeliveryAgentId()
                        + " Delivery Agent Name : " + temp.getDeliveryAgentName());
                isFound = true;
                break;
            }
        }

        if (isFound) {
            return index;
        } else {
            System.out.println("Delivery Agent ID not found. Please try again.");
            return -1;
        }
    }

    static void func() {
        int op;
        System.out.print("\nChoose an option :\n" +
                "1> Create an entity.\n" +
                "2> Delete an entity.\n" +
                "3> Print an entity.\n" +
                "OPTION NUMBER [1, 3]: ");
        op = input.nextInt();
        System.out.println();

        if (op == 1) {
            int subop;
            System.out.print("SELECT TYPE:\n" +
                    "1> Manufacturer.\n" +
                    "2> Customer.\n" +
                    "3> Product.\n" +
                    "4> Shops and Warehouses.\n" +
                    "5> Delivery agent.\n" +
                    "OPTION NUMBER [1, 5]: ");
            subop = input.nextInt();
            System.out.println();

            if (subop == 1) {
                System.out.print("Enter the Manufacturer id : \n");
                int e_id = input.nextInt();
                input.nextLine();
                System.out.print("Enter the Manufacturer name : \n");
                String e_name = input.nextLine();

                Manufacturer new_m = new Manufacturer(e_id, e_name);
                manufacturerList.add(new_m);
            }
            if (subop == 2) {
                System.out.print("Enter the Customer id : \n");
                int e_id = input.nextInt();
                input.nextLine();
                System.out.print("Enter the Customer name : \n");
                String e_name = input.nextLine();

                System.out.print("Enter the zipcode : \n");
                int z_code = input.nextInt();
                Customers c = new Customers(e_id, e_name, z_code);
                customerList.add(c);
            }
            if (subop == 3) {
                System.out.print("Enter the Product id : \n");
                int e_id = input.nextInt();
                input.nextLine();
                System.out.print("Enter the Product name : \n");
                String e_name = input.nextLine();
                Product prod = new Product(e_id, e_name);
                productList.add(prod);
            }
            if (subop == 4) {
                System.out.print("Enter the Shop id : \n");
                int e_id = input.nextInt();
                input.nextLine();
                System.out.print("Enter the Shop name : \n");
                String e_name = input.nextLine();

                System.out.print("Enter the zipcode : \n");
                int z_code = input.nextInt();
                Shop sh = new Shop(e_id, e_name, z_code);
                shopList.add(sh);
            }
            if (subop == 5) {
                System.out.print("Enter the Delivery Agent id : \n");
                int e_id = input.nextInt();
                input.nextLine();
                System.out.print("Enter the Delivery agent name : \n");
                String e_name = input.nextLine();

                System.out.print("Enter the zipcode : \n");
                int z_code = input.nextInt();
                System.out.println("No Of products delivered");
                int noOfProductsDelivered = input.nextInt();
                DeliveryAgent da = new DeliveryAgent(e_id, e_name, z_code, noOfProductsDelivered);
                agentList.add(da);
            }
        } else if (op == 2) {
            int subop;
            System.out.print("SELECT TYPE:\n" +
                    "1> Manufacturer.\n" +
                    "2> Customer.\n" +
                    "3> Product.\n" +
                    "4> Shops and Warehouses.\n" +
                    "5> Delivery agent.\n" +
                    "OPTION NUMBER [1, 5]: ");
            subop = input.nextInt();
            System.out.println();

            if (subop == 1) {
                int idx = getManufacturerIndex(input);
                if (idx != -1)
                    manufacturerList.remove(idx);
            }
            if (subop == 2) {
                int idx = getCustomerIndex(input);
                if (idx != -1)
                    customerList.remove(idx);
            }
            if (subop == 3) {
                int idx = getProductIndex(input);
                if (idx != -1)
                    productList.remove(idx);
            }
            if (subop == 4) {
                int idx = getShopIndex(input);
                if (idx != -1)
                    shopList.remove(idx);
            }
            if (subop == 5) {
                int idx = getDeliveryAgentIndex(input);
                if (idx != -1)
                    agentList.remove(idx);
            }

        } else {
            int subop;
            System.out.print("SELECT TYPE:\n" +
                    "1> Manufacturer.\n" +
                    "2> Customer.\n" +
                    "3> Product.\n" +
                    "4> Shops and Warehouses.\n" +
                    "5> Delivery agent.\n" +
                    "OPTION NUMBER [1, 5]: ");
            subop = input.nextInt();
            System.out.println();

            if (subop == 1) {
                for (Manufacturer manuf : manufacturerList) {
                    System.out.println(
                            "ID: " + manuf.getManufacturerId() + " . Manufacturer name: "
                                    + manuf.getManufacturerName());
                }
            }
            if (subop == 2) {
                for (Customers cust : customerList) {
                    System.out.println("ID: " + cust.getCustomerID() + " . Customer name: " + cust.getCustomerName()
                            + " . Zip Code: " + cust.getZipcode());

                }
            }
            if (subop == 3) {
                for (Product prod : productList) {
                    System.out.println("ID: " + prod.getProductId() + " . Product name: " + prod.getProductName());

                }
            }
            if (subop == 4) {
                for (Shop sh : shopList) {
                    System.out.println("ID: " + sh.getShopId() + " . Shop name: " + sh.getShopName() + ". Zip Code: "
                            + sh.getZipcode());

                }
            }
            if (subop == 5) {
                for (DeliveryAgent da : agentList) {
                    System.out.println("ID: " + da.getDeliveryAgentId() + " . Delivery Agent name: "
                            + da.getDeliveryAgentName() + ". Zipcode: " + da.getZipCode());

                }
            }
        }
    }

    /*-----------------------------------------------------------------------
    2> Add a product to manufacturer
     */

    public static void addManufacturerToProduct() {
        Scanner in = new Scanner(System.in);
        Manufacturer manufacturer1 = null;
        System.out.println("Enter Manufucaturer id: ");
        int manId = in.nextInt();
        int flag = 0;
        for (Manufacturer man : manufacturerList) {
            if (man.getManufacturerId() == manId) {
                manufacturer1 = man;
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("No Manufacturer with id " + manId + " found");
        } else {
            System.out.println("Enter the Product id");// Add the existing product with its product id
            int productID = in.nextInt();
            in.nextLine();
            System.out.println("Enter the Product Name");
            String name = in.nextLine();
            Product p1 = new Product(productID, name);
            productList.add(p1);
            // List<Product> list = new ArrayList<>();
            // list.add(p1);
            manufacturer1.getManufacturingProduct().add(p1);
            // for (Product pr2 : manufacturer1.getManufacturingProduct()) {
            //     System.out.print(pr2.getProductName());
            // }
            System.out.println(p1.getProductName() + " is added to the manufacturer: " + manufacturer1.getManufacturerName());
        }
    }

    /*---------------------------------------------------------------
    3> Add a certain no.of product to a shop
    -----------------------------------------------------------------*/

    public static void addCopies() {
        Scanner in = new Scanner(System.in);
        Shop shop1 = null;
        System.out.println("Enter the shop id");
        int shopid = in.nextInt();
        int flag = 0;
        for (Shop sh : shopList) {
            if (sh.getShopId() == shopid) {
                shop1 = sh;
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Shop with id: " + shopid + " not found");
        } else {
            System.out.println("Enter the Product id:");// Search an existing product
            int productId = in.nextInt();
            Product product1 = null;
            flag = 0;
            for (Product pr : productList) {
                if (pr.getProductId() == productId) {
                    product1 = pr;
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("No product with id: " + productId + " found");
            } else {
                System.out.println("Enter the no. of items");
                int noOfItems = in.nextInt();
                shop1.getNoOfItems().put(product1,noOfItems);
            }
        }
    }

    /*-----------------
    4> Add an order of a product from a customer
     */

    public static void addOrderCust() {
        Scanner in = new Scanner(System.in);
        int index = getCustomerIndex(in);

        Customers customers1 = null;

        if (index == -1) {
            System.out.println("No customer with given id found.");
        } else {
            customers1 = customerList.get(index);
            int flag = 0;
            System.out.println("Enter the product id:");
            int productId = in.nextInt();
            Product product1 = null;
            for (Product pr : productList) {
                if (pr.getProductId() == productId) {
                    product1 = pr;
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("No product with id: " + productId + " found.");
            } else {
                // List<Product> list = new ArrayList<>();
                // list.add(product1);
                customers1.getPurchasedProduct().add(product1);
                List<Product> list1 = new ArrayList<>();
                list1 = customers1.getPurchasedProduct();
                for (Product pr : list1) {
                    System.out.println("Product id: " + pr.getProductId());
                    System.out.println("Product Name: " + pr.getProductName());
                }
            }
        }

    }

    /*-----------------------------------------
    5> Process an order
    */

    public static void processOrder() {
        Scanner sc = new Scanner(System.in);
        int customerIndex = getCustomerIndex(sc);

        if (customerIndex != -1) {

            // First we check for delivery agent avaibility in that area
            DeliveryAgent selectedDeliveryAgent = null;

            for (DeliveryAgent deliveryAgent : agentList) {

                if (deliveryAgent.getZipCode() == customerList.get(customerIndex).getZipcode()) {

                    // we choose the agent with least deliveries
                    if (selectedDeliveryAgent == null
                            || deliveryAgent.getNoOfProductsDelivered() < selectedDeliveryAgent
                                    .getNoOfProductsDelivered())
                        selectedDeliveryAgent = deliveryAgent;
                }
            }

            if (selectedDeliveryAgent == null) {

                System.out.println("No delivery agent is available with your zipcode.");
                return;
            }

            int productIndex = getProductIndex(sc);
            Product selectedProduct = productList.get(productIndex);

            Shop selectedShop = null;

            for (Shop shop : shopList) {

                if (shop.getNoOfItems().get(selectedProduct) == null) {
                    System.out.println("Sorry this order cannot be processed in the shop with this zipcode.");
                    return;
                }
                if (shop.getNoOfItems().get(selectedProduct) > 0) {
                    if (selectedShop == null
                            || shop.getNoOfItems().get(selectedProduct) > selectedShop.getNoOfItems()
                                    .get(selectedProduct))
                        selectedShop = shop;
                }
            }

            if (selectedShop == null) {

                System.out.println("Medicine not found in any of the shop with this zipcode.");
                return;
            }

            int quantity = 0;

            try {

                // System.out.println("Enter a positive quantity of " + selectedProduct.getProductName()
                //         + ". Enter a non-positive to cancel order. Entering anything else selects max available quantity");
                System.out.println("Enter quantity of " + selectedProduct.getProductName() + " Max["
                        + selectedShop.getNoOfItems().get(selectedProduct) + "] : ");
                quantity =sc.nextInt();
            } catch (Exception e) {

                System.out.println("Invalid response. " + selectedShop.getNoOfItems().get(selectedProduct) + " "
                        + selectedProduct.getProductName() + " will be shipped");
            }

            if (quantity <= 0)
                return;

            if (quantity > selectedShop.getNoOfItems().get(selectedProduct)) {
                quantity = selectedShop.getNoOfItems().get(selectedProduct);
            }
            Map<Product, Integer> temp = selectedShop.getNoOfItems();
            selectedShop.decreaseQuantity(temp, selectedProduct, quantity);
            selectedDeliveryAgent.addDeliveryCount(quantity);

            System.out.println(selectedProduct.getProductName() + " will be delivered by "
                    + selectedDeliveryAgent.getDeliveryAgentName()
                    + " from the Shop " + selectedShop.getShopName());

        }

    }

    /*------------------------------------
      6-> List all the purchases made by a customer.
      */

    private static void printPurchasesOfCustomer(Scanner in) {

        int index = getCustomerIndex(in);

        if (index != -1) {

            for (Product purchase : customerList.get(index).purchasedProduct) {

                System.out.println("Product ID : " +
                        purchase.getProductId() + "       Product Name :  " + purchase.getProductName()
                        + "       Quantity : " + 1);
            }
        }
    }

    /*--------------------------------------------------------------
    7.)Show the inventory of shop
     */

    public static void print_product_Shops(Scanner in) {

        int index = getShopIndex(in);
        Shop shop1 = null;
        if (index == -1) {
            System.out.println("No shop with given id found.");
        } else {
            shop1 = shopList.get(index);
            Map<Product, Integer> map = shop1.getNoOfItems();
            Iterator it = map.keySet().iterator();
            Iterator it1 = map.values().iterator();
            while (it.hasNext() && it1.hasNext()) {
                Product product = (Product) it.next();
                Integer noOfItems = (Integer) it1.next();
                System.out.println("Product Name : " + product.getProductName()
                        + "                 No. of copies available : " + noOfItems);
            }
        }
    }

    /*----------------------------------------------------------------------------------
    8.Products made by manufacturer
     */

    public static void product_of_Manufacturers(Scanner in) {

        int index = getManufacturerIndex(in);

        Manufacturer manufacturer1 = null;

        if (index == -1) {
            System.out.println("No customer with given id found.");
        } else {
            manufacturer1 = manufacturerList.get(index);
            List<Product> productList1 = manufacturer1.getManufacturingProduct();
            for (Product p : productList1) {
                System.out.println(
                        "Product Name : " + p.getProductName() + "             Product ID : " + p.getProductId());
            }
        }
    }

}
