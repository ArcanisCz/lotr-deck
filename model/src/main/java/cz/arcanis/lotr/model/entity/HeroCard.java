package cz.arcanis.lotr.model.entity;

import cz.arcanis.lotr.model.entity.interfaces.HasBattleStats;
import cz.arcanis.lotr.model.entity.interfaces.HasThreatCost;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class HeroCard extends Card implements HasBattleStats, HasThreatCost {
    private Integer threatCost;
    private Integer defense;
    private Integer attack;
    private Integer hp;


    @Override
    public Integer getThreatCost() {
        return threatCost;
    }

    @Override
    public void setThreatCost(Integer threatCost) {
        this.threatCost = threatCost;
    }

    @Override
    public Integer getDefense() {
        return defense;
    }

    @Override
    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    @Override
    public Integer getAttack() {
        return attack;
    }

    @Override
    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    @Override
    public Integer getHp() {
        return hp;
    }

    @Override
    public void setHp(Integer hp) {
        this.hp = hp;
    }
}
