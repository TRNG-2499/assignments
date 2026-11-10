// extends Cat with an indoor/outdoor field, without changing Cat itself
public class DetailedCat extends Cat {

    private boolean isIndoor;

    public DetailedCat(boolean isIndoor) {
        this.isIndoor = isIndoor;
    }

    @Override
    public void describe() {
        super.describe(); // keeps the original description
        if (isIndoor) {
            System.out.println("It's an indoor cat.");
        } else {
            System.out.println("It's an outdoor cat.");
        }
    }
}