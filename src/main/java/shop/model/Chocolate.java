package shop.model;

public class Chocolate {


    private int index;
    private ChocolateColor chocolateColor;
    private int cocoaPercentage;

    public Chocolate(int index, ChocolateColor chocolateColor, int cocoaPercentage) {
        this.index = index;
        this.chocolateColor = chocolateColor;
        this.cocoaPercentage = cocoaPercentage;
    }

    public ChocolateColor getChocolateColor() {
        return chocolateColor;
    }

    public void setChocolateColor(ChocolateColor chocolateColor) {
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

    @Override
    public String toString() {
        return "Шоколад:" +
                " цвет: " + chocolateColor.getTranslation() +
                ", процент: " + cocoaPercentage;
    }
}
