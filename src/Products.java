public class Products {
    String productId;
    String productName;
    double price;
    int productQuantity;
    String category;
    String manufacturer;
    /*
    * Electronics
        * Mobile Phones --> M
        * Laptops --> L
        * Others --> O
    */
    static int serial=1001;
    Products() {

    }
    Products(String productName,double price,int productQuantity,String category,String manufacturer) {
        productId="E"+serial++;
        this.productName=productName;
        this.price=price;
        this.productQuantity=productQuantity;
        this.category=category;
        this.manufacturer=manufacturer;
    }
    void displayAllProducts() {
        System.out.println(productName);
        System.out.println(productId);
        System.out.println(productQuantity);
        System.out.println(category);
        System.out.println(manufacturer);
        System.out.println(price);
    }
}
