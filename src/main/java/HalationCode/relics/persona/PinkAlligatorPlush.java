package HalationCode.relics.persona;

import HalationCode.tools.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class PinkAlligatorPlush extends CustomRelic {
    public static final String ID = "halation:PinkAlligatorPlush";
    private static final Texture IMG = TextureLoader.getTexture("HalationImages/relics/PinkAlligatorPlush.png");
    private AbstractPlayer p = AbstractDungeon.player;
    private GameActionManager am = AbstractDungeon.actionManager;

    public PinkAlligatorPlush() {
        super(ID, IMG, RelicTier.BOSS, LandingSound.FLAT);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new PinkAlligatorPlush();
    }

    @Override
    public void atTurnStart() {
        if (!this.usedUp) {
            flash();
            am.addToBottom(new DamageAction(p, new DamageInfo(p, 1, DamageInfo.DamageType.HP_LOSS), AbstractGameAction.AttackEffect.FIRE));
        }
    }

    public static void onDeath() {
        if (!AbstractDungeon.player.getRelic(PinkAlligatorPlush.ID).usedUp) {
            AbstractDungeon.player.getRelic(PinkAlligatorPlush.ID).flash();
            AbstractDungeon.player.heal(AbstractDungeon.player.maxHealth);
            for (AbstractMonster m : AbstractDungeon.getCurrRoom().monsters.monsters) {
                m.die();
            }
            AbstractDungeon.player.getRelic(PinkAlligatorPlush.ID).usedUp = true;
        }
    }
}