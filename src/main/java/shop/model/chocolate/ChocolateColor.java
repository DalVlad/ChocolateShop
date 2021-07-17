package shop.model.chocolate;

public enum ChocolateColor {
    WHITE("Белый"), BLACK("Черный");

    private String translation;

    ChocolateColor(String translation){
        this.translation = translation;
    }

    public String getTranslation(){
        return translation;
    }
}
