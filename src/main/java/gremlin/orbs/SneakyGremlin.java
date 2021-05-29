package gremlin.orbs;

import com.megacrit.cardcrawl.orbs.AbstractOrb;
import gremlin.powers.GremlinPower;
import gremlin.powers.SneakyGremlinPower;

public class SneakyGremlin extends GremlinStandby{
    public static final int DAMAGE = 3;

    public SneakyGremlin(int hp) {
        super(hp, "Gremlin:SneakyGremlin", "sneak", "animation", 25);
    }

    @Override
    public void updateDescription() {
        this.description = this.descriptions[0] + DAMAGE + this.descriptions[1];
    }

    @Override
    public AbstractOrb makeCopy() {
        return new SneakyGremlin(hp);
    }

    @Override
    public void playChannelSFX() {

    }

    @Override
    public GremlinPower getPower() {
        return new SneakyGremlinPower(DAMAGE);
    }
}
