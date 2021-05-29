package reskinContent.skinCharacter.skins.Guardian;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import guardian.GuardianMod;
import guardian.characters.GuardianCharacter;
import reskinContent.reskinContent;
import reskinContent.skinCharacter.AbstractSkin;

public class BetaGuardian extends AbstractSkin {

    public BetaGuardian() {
        this.NAME = CardCrawlGame.languagePack.getUIString("reskinContent:ReSkinGuardian").TEXT[1];
        this.DESCRIPTION = CardCrawlGame.languagePack.getUIString("reskinContent:ReSkinGuardian").EXTRA_TEXT[1];
        this.portraitStatic_IMG = ImageMaster.loadImage(getAssetPath("portrait_beta_guardian.png"));

        this.SHOULDER1 = "guardianResources/GuardianImages/char/shoulder.png";
        this.SHOULDER2 = "guardianResources/GuardianImages/char/shoulderR.png";
        this.CORPSE = "guardianResources/GuardianImages/char/corpse.png";
        this.atlasURL = "reskinContent/img/GuardianMod/BetaGuardian/animation/BetaGuardian.atlas";
        this.jsonURL = "reskinContent/img/GuardianMod/BetaGuardian/animation/BetaGuardian.json";
        this.renderscale = 2.5F;
    }

    public String getAssetPath(String filename) {
        return reskinContent.assetPath("img/GuardianMod/" + this.getClass().getSimpleName() + "/" + filename);
    }
}


