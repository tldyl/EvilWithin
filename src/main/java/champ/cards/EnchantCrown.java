package champ.cards;

import champ.ChampMod;
import champ.powers.EnergizedDurationPower;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class EnchantCrown extends AbstractChampCard {

    public final static String ID = makeID("EnchantCrown");

    //stupid intellij stuff skill, self, rare

    public EnchantCrown() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
    //    tags.add(ChampMod.FINISHER);
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new SelectCardsInHandAction(1, CardCrawlGame.languagePack.getUIString("champ:EnchantUI").TEXT[0], c -> c.cost > 0, (cards) -> {
            cards.get(0).modifyCostForCombat(-999);
        }));
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        boolean canUse = false;
        for (AbstractCard c:p.hand.group){
            if (c.cost > 0){
                canUse = true;
                break;
            }
        }
        if (!canUse) return false;
        return super.canUse(p, m);
    }

    @Override
    public void triggerOnGlowCheck() {
        glowColor = (gcombo()) ? GOLD_BORDER_GLOW_COLOR : BLUE_BORDER_GLOW_COLOR;
    }

    public void upp() {
      //  tags.add(ChampMod.TECHNIQUE);
        upgradeBaseCost(0);
    }
}