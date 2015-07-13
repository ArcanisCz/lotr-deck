package cz.arcanis.lotr.model.interfaces;

/**
 * Created by Arcanis on 12.7.2015.
 */
public interface HasBattleStats {

    Integer getAttack();

    Integer getDefense();

    Integer getHp();

    void setAttack(Integer attack);

    void setDefense(Integer defense);

    void setHp(Integer hp);

}
