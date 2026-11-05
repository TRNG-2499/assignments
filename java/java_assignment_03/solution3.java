public class solution3 {
    private 
    public static void main(String[] args) {
        trafficLight("Green",5);
        trafficLight("Green", -3);
        trafficLight("Purple", 0);
    }
    public static void trafficLight(String startLight, int ticks){
        int lightNum = -1;
        if(ticks < 0){
            System.out.println("Negative ticks are invalid");
            return;
        }
        switch(startLight){
            case "Green":
                lightNum = 1;
                break;
            case "Yellow":
                lightNum = 2;
                break;
            case "Red":
                lightNum = 0;
                break;
            default:
                System.out.println("Invalid Light");
                return;
        }
        switch((lightNum + ticks) % 3){
            case 1:
                System.out.println("Green");
                break;
            case 2:
                System.out.println("Yellow");
                break;
            case 0:
                System.out.println("Red");
                break;
        }
    }
}
