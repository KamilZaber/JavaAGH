import java.util.Comparator;

public class ByAmountComparator implements Comparator<Item> {
    public int compare(Item i1, Item i2) {
        int comparisonResult = i1.returnAmount() - i2.returnAmount();

        if(comparisonResult == 0) {
            return comparisonResult;
        }else {
            return -comparisonResult;
        }
    }
}
