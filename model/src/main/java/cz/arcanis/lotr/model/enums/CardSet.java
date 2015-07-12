package cz.arcanis.lotr.model.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Arcanis on 12.7.2015.
 */
public enum CardSet {
    CORE,
    OTHER;

    public static CardSet getSetByName(String name) {
        if (StringUtils.equalsIgnoreCase(name, "core")) {
            return CORE;
        }
        return OTHER;
    }
}
