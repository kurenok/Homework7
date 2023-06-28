import java.util.ArrayList;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Apple", "iPhone 12", 799.99));
        phones.add(new Phone("Samsung", "Galaxy S21", 699.99));
        phones.add(new Phone("OnePlus", "8T", 599.99));
        phones.add(new Phone("Apple", "iPhone SE", 399.99));
        phones.add(new Phone("Google", "Pixel 5", 699.99));
        ArrayList<String> appleModels = phones.stream()
                .filter(p -> p.getManufacturer().equals("Apple"))
                .map(Phone::getModel)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Apple models: " + appleModels);
        phones.stream()
                .sorted()
                .forEach(p -> System.out.println(p.getModel() + " - $" + p.getPrice()));
    }
}
class Phone implements Comparable<Phone> {
    private String manufacturer;
    private String model;
    private double price;
    public Phone(String manufacturer, String model, double price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getModel() {
        return model;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public int compareTo(Phone other) {
        return Double.compare(price, other.price);
    }
}
