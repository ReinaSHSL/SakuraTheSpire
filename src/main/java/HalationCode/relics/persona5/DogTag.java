package HalationCode.relics.persona5;

import HalationCode.tools.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

public class DogTag extends CustomRelic {
    public static final String ID = "halation:DogTag";
    private static final Texture IMG = TextureLoader.getTexture("HalationImages/relics/DogTag.png");
    private AbstractPlayer p = AbstractDungeon.player;
    private GameActionManager am = AbstractDungeon.actionManager;
    private static final int HEALING_REDUC = 1;
    private static final int ENERGY = 1;

    public DogTag() {
        super(ID, IMG, RelicTier.SHOP, LandingSound.CLINK);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + HEALING_REDUC + DESCRIPTIONS[1] + ENERGY + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new DogTag();
    }

    @Override
    public int onPlayerHeal(int healAmt) {
        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            AbstractDungeon.actionManager.addToBottom(new GainEnergyAction(ENERGY));
            return healAmt - HEALING_REDUC;
        }
        return healAmt;
    }
}
