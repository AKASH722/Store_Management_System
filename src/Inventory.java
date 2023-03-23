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
        product[9]=new Products("Haier cool","31000","5" ,"H","Haier");
        product[10]=new Products("Sony A7 III","170000","5" ,"E","Sony");
        product[11]=new Products("Logitech K480","2500","5" ,"E","Logitech");
        for(int i=12;i<product.length;i++) {
            product[i]=new Products();
        }
    }
    String choice;
    void menu() {
        System.out.println("*****************************************************************************");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 1 to Add Product");
        System.out.println("Press 2 to Upgrade Quantity Of Product");
        System.out.println("Press 3 to Display All Products");
        System.out.println("Press 4 to Display a Category Products");
        System.out.println("Press 5 to Sell Product");
        System.out.println("Press 6 to Search a product");
        System.out.println("Press 7 to Delete Product");
        System.out.println("Press 8 to Access Sales report");
        System.out.println("*****************************************************************************");
        choice=scan.nextLine();
        switch (choice) {
            case "0" : return;
            case "1" : {
                    String no_Products;
                    do {
                        System.out.print("Enter no of Products to be added : ");
                        no_Products = scan.nextLine();
                    } while(validityOfNumber(no_Products,"No Of Products"));
                    int temp= Integer.parseInt(no_Products);
                    for(int i=1;i<=temp;i++) {
                        System.out.println("\nEnter Product "+i);
                        addProduct();
                    }
                }
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
        int i;
        for (i = 0; i < input.length(); i++) {
            if ((input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                validity=false;
            } else {
                validity=true;
                System.out.println("Enter a valid "+quantityName);
                break;
            }
        }
        if(!validity) {
            int temp_input = Integer.parseInt(input);
            if (temp_input == 0) {
                validity=true;
                System.out.println("Enter a valid " + quantityName);
            }
        }
        return validity;
    }
    void selectCategory() {
        System.out.println("*****************************************************************************");
        System.out.println("Select Product Category");
        System.out.println("Press 1 For Mobile Phones");
        System.out.println("Press 2 For Laptops/Desktops");
        System.out.println("Press 3 For Smart Watches");
        System.out.println("Press 4 For Audio Products");
        System.out.println("Press 5 For Home Appliances");
        System.out.println("Press 6 For other Products");
        System.out.println("*****************************************************************************");
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
    int productID;
    void upgradeQuantity() {
        System.out.println("To Upgrade Quantity");
        productID=searchID();
        if (productID == 401) {
            System.out.println("No such product found in the inventory");
        }
        else {
            String quantity;
            do {
                System.out.print("Quantity you want to Add : ");
                quantity=scan.nextLine();
            } while(validityOfNumber(quantity,"Quantity"));
            int quantity_add=Integer.parseInt(quantity)+Integer.parseInt(product[productID].productQuantity);
            product[productID].productQuantity= String.valueOf(quantity_add);
            System.out.println("Quantity has been upgraded successfully");
        }
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
        } else {
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
        int[] productID = new int[1000];
        int[] quantity = new int[1000];
        System.out.println("Press 0 after adding all products");
        for(int i=0;;i++) {
            String temp_quantity;
            for(;;) {
                System.out.println("\nEnter Product " +(i+1));
                productID[i] = searchIDSell();
                if(productID[i]==4001){
                    System.out.println("No such product found in the inventory");
                } else {
                    break;
                }
            }
            if(productID[i]==1234) {
                break;
            }
            int quantity_remove;
            for(;;) {
                do {
                    System.out.print("No of Products Purchased : ");
                    temp_quantity = scan.nextLine();
                } while (validityOfNumber(temp_quantity, "Quantity"));
                quantity[i] = Integer.parseInt(temp_quantity);
                quantity_remove = Integer.parseInt(product[productID[i]].productQuantity) - quantity[i];
                if(quantity_remove>=0) {
                    break;
                } else {
                    System.out.println("Not enough Stock in the inventory");
                }
            }
            product[productID[i]].productQuantity = String.valueOf(quantity_remove);
        }
        generateBill(productID,quantity);
    }
    void generateBill(int[] productID,int[] quantity) {
        int[] price=new int[1000];
        int totalBill=0;
        double finalAmount=0.0;
        System.out.println("********************************* BILL ************************************");
        Products.billHeader();
        for(int i=0;i<productID.length;i++) {
            if(productID[i]==4001|| productID[i]==1234) {
                break;
            }
            product[productID[i]].billDisplay();
            System.out.print(quantity[i]+"\n");
            price[i]=Integer.parseInt(product[productID[i]].price);
        }
        for(int i=0;i<price.length;i++) {
            totalBill+=price[i]*quantity[i];
        }
        finalAmount+=totalBill+(0.18*totalBill);
        System.out.println("               Total Amount : "+totalBill);
        System.out.println("Total Amount(After 18% GST) : "+finalAmount);
        totalSales(finalAmount);
        System.out.println("*****************************************************************************");
    }
    int searchIDSell() {
        System.out.print("Enter Product ID : ");
        String enteredProductID=scan.nextLine();
        int i = 0;
        if(enteredProductID.equals("0")) {
            return 1234;
        } else {
            for (; i < product.length; i++) {
                if (product[i].productId == null) {
                    if (i == product.length - 1) {
                        return 4001;//error code
                    }
                } else if (product[i].productId.equals(enteredProductID)) {
                    break;
                }
            }
        }
        return i;
    }
    void searchProduct() {
        System.out.println("*****************************************************************************");
        System.out.println("Press 1 to Search by Product ID");
        System.out.println("Press 2 to Search by Product Name");
        System.out.println("Press 3 to Search by Brand Name");
        System.out.println("*****************************************************************************");
        String searchChoice=scan.nextLine();
        switch (searchChoice) {
            case "1" -> productID=searchID();
            case "2" -> searchProductName();
            case "3" -> searchBrandName();
            default -> {
                System.out.println("Please press a valid number");
                searchProduct();
            }
        }
        if(searchChoice.equals("1")) {
            if (productID == 4001) {
                System.out.println("No such product found in the inventory");
            }
            else {
                product[productID].displayProduct();
            }
        }
    }
    int searchID() {
        System.out.print("Enter Product ID : ");
        String enteredProductID=scan.nextLine();
        int i=0;
        for(;i<product.length;i++) {
            if(product[i].productId==null) {
                if(i==product.length-1) {
                    return 4001;//error code
                }
            } else if(product[i].productId.equals(enteredProductID)) {
                break;
            }
        }
        return i;
    }
    void searchProductName() {
        System.out.print("Enter Product Name : ");
        String enteredProductName=scan.nextLine();
        int display_count=0;
        for (int i=0;i<product.length;i++) {
            if (product[i].productName == null) {
                if (display_count == 0 && i==product.length-1) {
                    System.out.println("No such product found in the inventory");
                }
            } else if (product[i].productName.equalsIgnoreCase(enteredProductName)) {
                product[i].displayProduct();
                System.out.println();
                display_count++;
            }
        }
    }
    void searchBrandName() {
        System.out.print("Enter Brand Name : ");
        String enteredBrandName=scan.nextLine();
        int display_count=0;
        for (int i=0;i<product.length;i++) {
            if (product[i].productName == null) {
                if (display_count == 0 && i==product.length-1) {
                    System.out.println("No such product found in the inventory");
                }
            } else if (product[i].brandName.equalsIgnoreCase(enteredBrandName)) {
                product[i].displayProduct();
                System.out.println();
                display_count++;
            }
        }
    }
    void deleteProduct() {
        productID = searchID();
        if (productID == 401) {
            System.out.println("No such product found in the inventory");
        } else {
            product[productID].productId=null;
            product[productID].productName=null;
            product[productID].productQuantity=null;
            product[productID].price=null;
            product[productID].category=null;
            product[productID].brandName=null;
            System.out.println("Product has been successfully deleted");
        }
    }
    double[] amount=new double[1000];
    int noOfBills=0;
    void totalSales(double amount) {
       this.amount[noOfBills++]=amount;
    }
    void salesReport() {
        System.out.println("****************************** OUT OF STOCK *********************************");
        int counter=0;
        for (Products products : product) {
            if (products.productId == null) {
                continue;
            }
            if (products.productQuantity.equals("0")) {
                counter++;
            }
        }
        if (counter==0) {
            System.out.println("               None of the Products is out of stock");
        }
        else {
            Products.header();
            for (Products products : product) {
                if (products.productId == null) {
                    continue;
                }
                if (products.productQuantity.equals("0")) {
                    products.displayAllProducts();
                }
            }
        }
        System.out.println("*****************************************************************************");
        System.out.println("******************************** NET SALES **********************************");
        double totalSales=0;
        if(noOfBills==0) {
            System.out.println("                                No sales Today");
        }
        else {
            for(int i=0;i<1000;i++) {
                if(amount[i]==0) {
                    break;
                }
                System.out.println("Customer "+(i+1)+"  "+amount[i]);
                totalSales+=amount[i];
            }
            System.out.println("Net Sales Today : "+totalSales);
        }
        System.out.println("*****************************************************************************");
    }
}