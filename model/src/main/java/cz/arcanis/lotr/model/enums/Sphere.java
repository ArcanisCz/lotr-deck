package cz.arcanis.lotr.model.enums;

/**
 * Created by Arcanis on 12.7.2015.
 */
public enum Sphere {
    LEADERSHIP("#9D489D"),
    SPIRIT("#00B7E3"),
    TACTICS("#B81E26"),
    LORE("#00A652"),
    NEUTRAL("#555555");

    private final String color;

    Sphere(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
