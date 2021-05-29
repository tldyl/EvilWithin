package gremlin.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import gremlin.powers.MakeshiftArmorPower;

import static gremlin.GremlinMod.MAD_GREMLIN;

public class MakeshiftArmor extends AbstractGremlinCard {
    public static final String ID = getID("MakeshiftArmor");
    private static final CardStrings strings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = strings.NAME;
    private static final String IMG_PATH = "cards/makeshift_armor.png";

    private static final AbstractCard.CardType TYPE = CardType.POWER;
    private static final AbstractCard.CardRarity RARITY = CardRarity.UNCOMMON;
    private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;

    private static final int COST = 1;
    private static final int MAGIC = 0;
    private static final int UPGRADE_BONUS = 1;

    public MakeshiftArmor()
    {
        super(ID, NAME, IMG_PATH, COST, strings.DESCRIPTION, TYPE, RARITY, TARGET);

        this.baseMagicNumber = MAGIC;
        this.magicNumber = baseMagicNumber;

        this.tags.add(MAD_GREMLIN);
        setBackgrounds();
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        if (upgraded) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p,
                    new ArtifactPower(p, magicNumber), magicNumber));
        }
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p,
                new MakeshiftArmorPower(p, 1), 1));
    }

    public void upgrade()
    {
        if (!this.upgraded)
        {
            upgradeName();
            upgradeMagicNumber(UPGRADE_BONUS);
            this.rawDescription = strings.UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
}

