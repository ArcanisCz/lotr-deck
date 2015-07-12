package cz.arcanis.lotr.model.enums;

import org.apache.commons.lang3.StringUtils;

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

    public static Sphere getSetByName(String name) {
        if (StringUtils.equalsIgnoreCase(name, "leadership")) {
            return LEADERSHIP;
        } else if (StringUtils.equalsIgnoreCase(name, "tactics")) {
            return TACTICS;
        } else if (StringUtils.equalsIgnoreCase(name, "spirit")) {
            return SPIRIT;
        } else if (StringUtils.equalsIgnoreCase(name, "lore")) {
            return LORE;
        }
        return NEUTRAL;
    }
}
