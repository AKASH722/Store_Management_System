public class Products {
    String productId;
    String productName;
    String price;
    String productQuantity;
    String category;
    String brandName;
    /*
    * Mobile Phones --> M
    * Laptops/Desktops --> L
    * Smart Watches --> W
    * Audio --> S
    * Home Appliances --> H
    * Others --> E
    */
    static int serial=1001;
    Products() {

    }
    Products(String productName,String price,String productQuantity,String categoryID,String brandName) {
        productId=categoryID+serial++;
        setCategory(categoryID);
        this.productName=productName;
        this.price=price;
        this.productQuantity=productQuantity;
        this.brandName =brandName;
    }
    void add(String productName,String price,String productQuantity,String categoryID,String brandName,int id) {
        productId=categoryID+(1001+id);
        setCategory(categoryID);
        this.productName=productName;
        this.price=price;
        this.productQuantity=productQuantity;
        this.brandName =brandName;
    }
    void setCategory(String id) {
        switch (id) {
            case "M" -> category = "Mobile Phone";
            case "L" -> category = "Laptop/Desktop";
            case "W" -> category = "Smart Watches";
            case "S" -> category = "Audio Product";
            case "H" -> category = "Home Appliances";
            case "E" -> category = "Others";
        }
    }
    void displayProduct() {
        System.out.println("Product ID   : "+productId);
        System.out.println("Product Name : "+productName);
        System.out.println("Price        : "+price);
        System.out.println("Brand Name   : "+brandName);
        System.out.println("Category     : "+category);
        System.out.println("Quantity     : "+productQuantity);
    }
    void displayAllProducts() {
        System.out.print(productId+"   ");
        System.out.print(productName);
        spaceProductName();
        System.out.print(price);
        spacePrice();
        System.out.print(brandName);
        spaceBrandName();
        System.out.print(category);
        spaceCategory();
        System.out.print(productQuantity+"\n");
    }
    static void header() {
        System.out.println("  ID    Product Name        Price     Brand Name       Category       Quantity");
    }
    void spaceProductName() {
        int space=20-productName.length();
        if(space<0){
            System.out.print("     ");
        } else {
            int i = 0;
            while (i < space) {
                System.out.print(" ");
                i++;
            }
        }
    }
    void spacePrice() {
        Employee.space(price);
    }
    void spaceBrandName() {
        int space=17-brandName.length();
        if(space<0){
            System.out.print("     ");
        } else {
            int i = 0;
            while (i < space) {
                System.out.print(" ");
                i++;
            }
        }
    }
    void spaceCategory() {
        int space=18-category.length();
        if(space<0) {
            System.out.print("     ");
        } else {
            int i = 0;
            while (i < space) {
                System.out.print(" ");
                i++;
            }
        }
    }
    static void billHeader() {
        System.out.println("  ID    Product Name        Price     Quantity");
    }
    void billDisplay() {
        System.out.print(productId+"   ");
        System.out.print(productName);
        spaceProductName();
        System.out.print(price);
        spacePrice();
    }
}