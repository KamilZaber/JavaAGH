import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FulfillmentCenterContainer {
    Map<String,FulfillmentCenter> warehouses = new LinkedHashMap<>();

    public void addCenter(String name, int cap) {
        warehouses.put(name,new FulfillmentCenter(name,cap));
    }

    public void removeCenter(String name) {
        warehouses.remove(name);
    }

    public List<FulfillmentCenter> findEmpty() {
        List<FulfillmentCenter> emptyOnes = new ArrayList<>();
        Set<Entry<String,FulfillmentCenter>> entrySet = warehouses.entrySet();
        FulfillmentCenter one;

        for(Entry<String,FulfillmentCenter> entry: entrySet) {
            one = entry.getValue();
            if(one.getSize()==0) {
                emptyOnes.add(one);
            }
        }

        return emptyOnes;
    }

    public void summary() {

    }
}
