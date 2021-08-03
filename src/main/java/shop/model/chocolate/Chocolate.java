package shop.model.chocolate;

public class Chocolate {


    private int id;
    private String chocolateColor;
    private int cocoaPercentage;
    private String name;

    public Chocolate(){}

    public Chocolate(int id, String chocolateColor, int cocoaPercentage, String name) {
        this.id = id;
        this.chocolateColor = chocolateColor;
        this.cocoaPercentage = cocoaPercentage;
        this.name = name;
    }

    public String getChocolateColor() {
        return chocolateColor;
    }

    public void setChocolateColor(String chocolateColor) {
        this.chocolateColor = chocolateColor;
    }

    public int getCocoaPercentage() {
        return cocoaPercentage;
    }

    public void setCocoaPercentage(int cocoaPercentage) {
        this.cocoaPercentage = cocoaPercentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Шоколад: " + getName() +
                ", тип: " + chocolateColor +
                ", процент: " + cocoaPercentage;
    }
}
