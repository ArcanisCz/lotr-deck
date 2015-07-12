package cz.arcanis.lotr.model.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Arcanis on 12.7.2015.
 */
public enum Sphere {
    LEADERSHIP,
    SPIRIT,
    TACTICS,
    LORE,
    NEUTRAL,
    FELLOWSHIP,
    BAGGINS;

    public static Sphere getByName(String name) {
        if (StringUtils.equalsIgnoreCase(name, "leadership")) {
            return LEADERSHIP;
        } else if (StringUtils.equalsIgnoreCase(name, "tactics")) {
            return TACTICS;
        } else if (StringUtils.equalsIgnoreCase(name, "spirit")) {
            return SPIRIT;
        } else if (StringUtils.equalsIgnoreCase(name, "lore")) {
            return LORE;
        }else if (StringUtils.equalsIgnoreCase(name, "neutral")) {
            return NEUTRAL;
        }else if (StringUtils.equalsIgnoreCase(name, "fellowship")) {
            return FELLOWSHIP;
        }else if (StringUtils.equalsIgnoreCase(name, "fellowship")) {
            return BAGGINS;
        }
        return null;
    }
}
