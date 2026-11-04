public class Main {
  public static void main(String[] args) {
    vendingMachine(2.00, -1.50);
    
  }
  
  public static void vendingMachine(double price, double insertedAmount){
      if(insertedAmount <= 0){
      System.out.println("Invalid input");
      }
      else if (price > insertedAmount){
      System.out.println("Insufficient funds");
      }
      else{
          if(insertedAmount == price){
            System.out.println("Successful purchase");
          } else{
            System.out.println("Successful purchase, your change is " + (insertedAmount - price));
          }
      }
      if(price <= 0){
        System.out.println("pricing is invalid")
      }
      
  }
}
