import java.util.Scanner;

public class Inventory {
    static Scanner scan=new Scanner(System.in);
    static Products[] product=new Products[1000];
    Inventory() {
        product[0]=new Products("A21s","25000","5" ,"M","Samsung");
        product[1]=new Products("Oppo Reno 5G","29000","5" ,"M","Oppo");
        product[2]=new Products("OMEN 16","125000","5" ,"L","HP");
        product[3]=new Products("TUF Gaming F15","60000","5" ,"L","ASUS");
        product[4]=new Products("Storm Call","1800","5" ,"W","Boat");
        product[5]=new Products("ColorFit Pro","2000","5" ,"W","Noise");
        product[6]=new Products("WF-C500 Tws","3000","5" ,"S","Sony");
        product[7]=new Products("Boat Stone 500","1000","5" ,"S","Boat");
        product[8]=new Products("810L","260000","5" ,"H","Samsung");
        product[9]=new Products("Haier clean cool","31000","5" ,"H","Haier");
        product[10]=new Products("Sony A7 III","170000","5" ,"E","Sony");
        product[11]=new Products("","25000","5" ,"E","Samsung");
        for(int i=12;i<product.length;i++) {
            product[i]=new Products();
        }
    }
    String choice;
    void menu() {
        System.out.println("***************************************************************");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 1 to Add Product");
        System.out.println("Press 2 to Upgrade Quantity Of Product");
        System.out.println("Press 3 to Display All Products");
        System.out.println("Press 4 to Display a Category Products");
        System.out.println("Press 5 to Sell Product");
        System.out.println("Press 6 to Search a product");
        System.out.println("Press 7 to Delete Product");
        System.out.println("Press 8 to Access Sales report");
        System.out.println("***************************************************************");
        choice=scan.nextLine();
        switch (choice) {
            case "0" : return;
            case "1" : addProduct();
                break;
            case "2" : upgradeQuantity();
                break;
            case "3" : displayAllProducts();
                break;
            case "4" : displayCategoryProducts();
                break;
            case "5" : sellProduct();
                break;
            case "6" : searchProduct();
                break;
            case "7" : deleteProduct();
                break;
            case "8" : salesReport();
                break;
            default : System.out.println("Please press a valid number");
        }
        menu();
    }
    String categoryID;
    void addProduct() {
        selectCategory();
        System.out.print("Enter Product Name : ");
        String productName=scan.nextLine();
        String price;
        do {
            System.out.print("Enter Product Price : ");
            price = scan.nextLine();
        } while(validityOfNumber(price,"Price"));
        String productQuantity;
        do {
            System.out.print("Enter Product Quantity : ");
            productQuantity = scan.nextLine();
        } while(validityOfNumber(productQuantity,"Product Quantity"));
        System.out.print("Enter Brand Name : ");
        String brandName=scan.nextLine();
        for (int i=0;i< product.length;i++) {
            if (product[i].productId == null) {
                product[i].add(productName, price, productQuantity, categoryID, brandName,i);
                break;
            }
        }
    }
    boolean validityOfNumber(String input,String quantityName) {
        boolean validity=true;
        if(input.charAt(0)=='0' && input.length()==1) {
            System.out.println("Enter a valid "+quantityName);
        } else {
            for (int i = 0; i < input.length(); i++) {
                if ((input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                    validity=false;
                }
                else {
                    validity=true;
                    System.out.println("Enter a valid "+quantityName);
                    break;
                }
            }
        }
        return validity;
    }
    void selectCategory() {
        System.out.println("***************************************************************");
        System.out.println("Select Product Category");
        System.out.println("Press 1 For Mobile Phones");
        System.out.println("Press 2 For Laptops/Desktops");
        System.out.println("Press 3 For Smart Watches");
        System.out.println("Press 4 For Audio Products");
        System.out.println("Press 5 For Home Appliances");
        System.out.println("Press 5 For other Products");
        System.out.println("***************************************************************");
        String categoryChoice=scan.nextLine();
        switch (categoryChoice) {
            case "1" -> categoryID = "M";
            case "2" -> categoryID = "L";
            case "3" -> categoryID = "W";
            case "4" -> categoryID = "S";
            case "5" -> categoryID = "H";
            case "6" -> categoryID = "E";
            default -> {
                System.out.println("Select a valid Product Category");
                selectCategory();
            }
        }
    }
    void upgradeQuantity() {

    }
    void displayAllProducts() {
        Products.header();
        for (Products products : product) {
            if(products.productId==null) {
                continue;
            }
            products.displayAllProducts();
        }
    }
    void displayCategoryProducts() {
        int count=0;
        selectCategory();
        String category="";
        switch (categoryID) {
            case "M" -> category = "Mobile Phone";
            case "L" -> category = "Laptop/Desktop";
            case "W" -> category = "Smart Watches";
            case "S" -> category = "Audio Product";
            case "H" -> category = "Home Appliances";
            case "E" -> category = "Others";
        }
        for (Products products : product) {
            if(products.productId==null) {
                continue;
            }
            if(products.category.equals(category)) {
                count++;
            }
        }
        if(count==0) {
            System.out.println("No Products of "+category+" category found in inventory");
        }
        else {
            Products.header();
            for (Products products : product) {
                if (products.productId == null) {
                    continue;
                }
                if (products.category.equals(category)) {
                    products.displayAllProducts();
                    count++;
                }
            }
        }
    }
    void sellProduct() {

    }
    void searchProduct() {

    }
    void deleteProduct() {

    }
    void salesReport() {

    }
}

