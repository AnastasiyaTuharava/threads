package by.epam.thread.storage;

import java.util.HashMap;
import java.util.Map;

public class ValueBasket {
    private static ValueBasket valueBasketInstance;
    private HashMap<Integer, Integer> valueBasket;
    private ValueBasket() {
        valueBasket = new HashMap<>();
    }
    public static ValueBasket getValueBasketInstance() {
        if (valueBasketInstance == null) {
            valueBasketInstance = new ValueBasket();
        }
        return valueBasketInstance;
    }
    public void putElement (Integer key, Integer value) {
        valueBasket.put(key,value);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n').append("Value Basket").append('\n');
        for (Map.Entry<Integer, Integer> entry : valueBasket.entrySet()) {
            sb.append("Key = ").append(entry.getKey()).append(", Value = ").append(entry.getValue()).append('\n');
        }
        return sb.toString();
    }
}

