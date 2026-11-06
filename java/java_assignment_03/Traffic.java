public class Traffic{
  public static void main(String[] args) {
    trafficLight("Green", 2);
  }
  
  public static void trafficLight(String startColor, int ticks){
    if(ticks < 0){
        System.out.println("Invalid input: tick count cannot be negative.");
        return;
    }
      
      int position;
      
      switch (startColor)
      {
        case "Green":
            position = 0; 
        break;
        case "Yellow":
            position = 1;
        break;
        case "Red":
            position = 2;
        break;
        default:
        System.out.println("Invalid input: " + startColor + " is not a recognized light color.");
        return;
      }
    position = (position + ticks) % 3;

    String[] colors = {"Green", "Yellow", "Red"};
    System.out.println(colors[position]);
    }
}
