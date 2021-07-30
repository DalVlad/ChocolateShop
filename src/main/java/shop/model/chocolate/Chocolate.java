package shop.model.chocolate;

public class Chocolate {


    private int index;
    private String chocolateColor;
    private int cocoaPercentage;
    private String name;

    public Chocolate(){}

    public Chocolate(int index, String chocolateColor, int cocoaPercentage, String name) {
        this.index = index;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
