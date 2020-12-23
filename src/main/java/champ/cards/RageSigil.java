package champ.cards;

import champ.ChampMod;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class RageSigil extends AbstractChampCard {

    public final static String ID = makeID("RageSigil");

    //stupid intellij stuff skill, self, common

    public RageSigil() {
        super(ID, 0, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        tags.add(ChampMod.TECHNIQUE);
       // tags.add(ChampMod.OPENER);
        this.block = this.baseBlock = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        techique();
        if (upgraded) blck();
    }

    public void upp() {
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}