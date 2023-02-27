public class Products {
    String productId;
    String productName;
    double price;
    int productQuantity;
    String category;
    /*
    * Mobile Phones --> M
    * Laptops/Desktops --> L
    * Smart Watches --> W
    * Audio --> S
    * Gaming --> G
    * Home Appliances --> H
    * Accessor -->
    * Others --> E
    */
    String brandName;
    static int serial=1001;
    Products() {

    }
    Products(String productName,double price,int productQuantity,String category,String brandName) {
        productId="E"+serial++;
        this.productName=productName;
        this.price=price;
        this.productQuantity=productQuantity;
        this.category=category;
        this.brandName =brandName;
    }
    void displayAllProducts() {
        System.out.println(productId);
        System.out.println(productName);
        System.out.println(price);
        System.out.println(brandName);
        System.out.println(category);
        System.out.println(productQuantity);
    }
}
