public class Item implements Comparable<Item>{
    private String name;
    private Condition.ItemCondition cond;
    private double mass;
    private int amount;

    public Item(String name, double mass, int amount) {
        this.name = name;
        this.mass = mass;
        this.amount = amount;
    }

    public void print() {
        System.out.println("Nazwa towaru: " + name);
        System.out.println("Masa towaru: " + mass);
        System.out.println("Ilość towaru: " + amount);
    }

    public void increaseAmount() {
        amount++;
    }

    public void decreaseAmount() {
        amount--;
    }

    public int returnAmount() {
        return amount;
    }

    public String returnName() {
        return name;
    }

    public Condition.ItemCondition returnCondition() {
        return cond;
    }

    public int compareTo(Item i) {
        int comparisonResult = this.name.compareTo(i.name);

        return comparisonResult;
    }
}
