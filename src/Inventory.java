public class Inventory {
    static Products[] product=new Products[1000];
    Inventory() {
        product[0]=new Products("A21s",25000,5 ,"Mobile Phones","Samsung");
    }
    void displayAllProducts() {
        product[0].displayAllProducts();
    }
}

