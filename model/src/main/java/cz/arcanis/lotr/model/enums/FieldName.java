package cz.arcanis.lotr.model.enums;

/**
 * Created by Arcanis on 12.7.2015.
 */
public enum FieldName {
    _ID("_id"),
    ID("id"),
    NAME("name"),
    SET("set"),
    UNIQUE("unique"),
    SPHERE("sphere"),
    ATTACK("atk"),
    DEFENSE("def"),
    HP("hp"),
    THREAT_COST("th");

    private final String name;

    FieldName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
