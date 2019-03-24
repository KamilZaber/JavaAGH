import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class FulfillmentCenter {
    private String name;
    private List<Item> products;
    private int cap;

    public FulfillmentCenter(String name, int cap) {
        products = new ArrayList<Item>();
        this.name = name;
        this.cap = cap;
    }

    public int getSize() {
        return products.size();
    }

    public void addProduct(Item i) {
        if(cap > products.size()) {
            boolean is = false;
            int which = 0;

            for(Item one: products) {
                if(one.compareTo(i) == 0) {
                    is = true;
                    break;
                }
                which++;
            }

            if(!is){
                products.add(i);
            }else {
                products.get(which).increaseAmount();
            }
        }else {
            System.err.println("Magazyn jest pełny");
        }
    }

    public void getProduct(Item i) {
        for(Item one: products) {
            if(one.compareTo(i) == 0) {
                one.decreaseAmount();
                if(one.returnAmount() > 0) {
                    products.remove(one);
                }
                break;
            }
        }
    }

    public void removeProduct(Item i) {
        products.remove(i);
    }

    public Item search(String text) {
        boolean found = false;
        Item bad;
        for(Item i: products) {
            if (i.returnName().equals(text)) {
                found = true;
                return i;
            }
        }
        System.err.println("Nie znaleziono takiego obiektu");
        bad = new Item("error", 0,0);
        return bad;
    }

    public List<Item> searchPartial(String text) {
        List<Item> matching = new ArrayList<Item>();
        for(Item i: products) {
            if(i.returnName().contains(text)) {
                matching.add(i);
            }
        }
        return matching;
    }

    public int countByCondition(Condition.ItemCondition ic) {
        int found = 0;
        for(Item i: products) {
            if(i.returnCondition() == ic) {
                found++;;
            }
        }
        return found;
    }

    public void summary() {
        int x = 0;
        System.out.println("Produkty w magazynie: ");
        for(Item i: products) {
            System.out.println(x + ":");
            i.print();
            System.out.println();
        }
    }

    public List<Item> sortByName() {
        List<Item> sorted = products;
        Collections.sort(sorted);
        return sorted;
    }

    public List<Item> sortByAmount() {
        List<Item> sorted = products;
        Collections.sort(sorted, new ByAmountComparator());
        return sorted;
    }

    public Item max() {
        Item foundMax;
        foundMax = Collections.max(products);
        return foundMax;
    }

    public double usage() {
        double usage;
        usage = ((products.size())/cap)*100;
        return usage;
    }
}
