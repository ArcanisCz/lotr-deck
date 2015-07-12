package cz.arcanis.lotr.model.entity;

import cz.arcanis.lotr.model.entity.interfaces.HasBattleStats;
import cz.arcanis.lotr.model.entity.interfaces.HasThreatCost;
import cz.arcanis.lotr.model.entity.interfaces.HasTraits;

import java.util.List;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class HeroCard extends Card implements HasBattleStats, HasThreatCost, HasTraits {
    private Integer threatCost;
    private Integer defense;
    private Integer attack;
    private Integer hp;
    private List<String> traits;


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

    @Override
    public List<String> getTraits() {
        return traits;
    }

    @Override
    public void setTraits(List<String> traits) {
        this.traits = traits;
    }
}
