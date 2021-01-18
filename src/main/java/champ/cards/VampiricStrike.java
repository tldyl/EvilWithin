package champ.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.watcher.WallopAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class VampiricStrike extends AbstractChampCard {

    public final static String ID = makeID("VampiricStrike");

    //stupid intellij stuff attack, enemy, rare

    private static final int DAMAGE = 10;

    public VampiricStrike() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = DAMAGE;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (dcombo()) {
            atb(new WallopAction(m, makeInfo()));
        } else {
            dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        }
        if (bcombo()) {
            atb(new GainEnergyAction(1));
        }
    }


    public void upp() {
        upgradeDamage(3);
    }
}