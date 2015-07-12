package cz.arcanis.lotr.model.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Arcanis on 12.7.2015.
 */
public enum CardType {
    HERO,
    ALLY,
    ATTACHMENT,
    EVENT;

    public static CardType getByName(String name) {
        if (StringUtils.equalsIgnoreCase(name, "hero")) {
            return HERO;
        } else if (StringUtils.equalsIgnoreCase(name, "ally")) {
            return ALLY;
        } else if (StringUtils.equalsIgnoreCase(name, "attachment")) {
            return ATTACHMENT;
        } else if (StringUtils.equalsIgnoreCase(name, "event")) {
            return EVENT;
        }
        return null;
    }
}
