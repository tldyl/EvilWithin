package gremlin.events;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractImageEvent;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.rewards.RewardItem;

public class GremlinTrenchcoat extends AbstractImageEvent {
    public static final String ID = "Gremlin:Trenchcoat";
    private static final EventStrings eventStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    public static final String[] OPTIONS;
    private int goldAmount;
    private static final String DIALOG_1;
    private GremlinTrenchcoat.CUR_SCREEN screen;

    public GremlinTrenchcoat() {
        super(NAME, DIALOG_1, "images/events/ballAndCup.jpg");
        this.screen = CUR_SCREEN.INTRO;
        this.goldAmount = 30;
        this.noCardsInRewards = true;
        if (AbstractDungeon.ascensionLevel >= 15) {
            this.goldAmount = 40;
        }

        if (AbstractDungeon.player.gold >= this.goldAmount) {
            this.imageEventText.setDialogOption(OPTIONS[0] + this.goldAmount + OPTIONS[1] + OPTIONS[2]);
        } else {
            this.imageEventText.setDialogOption(OPTIONS[6] + this.goldAmount + OPTIONS[7], true);
        }

        if (AbstractDungeon.player.gold >= this.goldAmount*2) {
            this.imageEventText.setDialogOption(OPTIONS[0] + this.goldAmount*2 + OPTIONS[1] + OPTIONS[3]);
        } else {
            this.imageEventText.setDialogOption(OPTIONS[6] + this.goldAmount*2 + OPTIONS[7], true);
        }

        if (AbstractDungeon.player.gold >= this.goldAmount*3) {
            this.imageEventText.setDialogOption(OPTIONS[0] + this.goldAmount*3 + OPTIONS[1] + OPTIONS[4]);
        } else {
            this.imageEventText.setDialogOption(OPTIONS[6] + this.goldAmount*3 + OPTIONS[7], true);
        }

        this.imageEventText.setDialogOption(OPTIONS[5]);
    }

    private void getColorlessCard(int num) {
        AbstractDungeon.getCurrRoom().rewards.clear();
        for (int i=0;i<num;i++) {
            RewardItem reward = new RewardItem(AbstractCard.CardColor.COLORLESS);
            while(reward.cards.size() > 1) {
                reward.cards.remove(0);
            }
            AbstractDungeon.getCurrRoom().addCardReward(reward);
        }
        AbstractDungeon.combatRewardScreen.open();
    }

    @Override
    protected void buttonEffect(int buttonPressed) {
        switch(this.screen) {
            case INTRO:
                this.screen = CUR_SCREEN.COMPLETE;
                switch(buttonPressed) {
                    case 0:
                        this.imageEventText.updateBodyText(DESCRIPTIONS[1]);
                        AbstractDungeon.player.loseGold(this.goldAmount);
                        this.getColorlessCard(1);
                        break;
                    case 1:
                        this.imageEventText.updateBodyText(DESCRIPTIONS[1]);
                        AbstractDungeon.player.loseGold(this.goldAmount*2);
                        this.getColorlessCard(2);
                        break;
                    case 2:
                        this.imageEventText.updateBodyText(DESCRIPTIONS[1]);
                        AbstractDungeon.player.loseGold(this.goldAmount*3);
                        this.getColorlessCard(3);
                        break;
                    case 3:
                        this.imageEventText.updateBodyText(DESCRIPTIONS[2]);
                }

                this.imageEventText.updateDialogOption(0, OPTIONS[5]);
                this.imageEventText.clearRemainingOptions();
                break;
            case COMPLETE:
                this.openMap();
        }
    }

    static {
        eventStrings = CardCrawlGame.languagePack.getEventString("Gremlin:Trenchcoat");
        NAME = eventStrings.NAME;
        DESCRIPTIONS = eventStrings.DESCRIPTIONS;
        OPTIONS = eventStrings.OPTIONS;
        DIALOG_1 = DESCRIPTIONS[0];
    }

    private enum CUR_SCREEN {
        INTRO,
        COMPLETE;

        private CUR_SCREEN() {
        }
    }
}
