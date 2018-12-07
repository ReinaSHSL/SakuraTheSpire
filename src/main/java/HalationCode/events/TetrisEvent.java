package HalationCode.events;

import HalationCode.events.buttons.RelicDialogOptionButton;
import HalationCode.relics.generalweebreferences.OrihimeAndHikoboshiSamaAndTears;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.events.AbstractImageEvent;
import com.megacrit.cardcrawl.events.shrines.GremlinMatchGame;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.ArrayList;

public class TetrisEvent extends AbstractImageEvent {
    public static final String ID = "halation:TetrisEvent";
    private static final EventStrings eventStrings = CardCrawlGame.languagePack.getEventString(ID);
    private static final String NAME = eventStrings.NAME;
    private static final String[] DESCRIPTIONS = eventStrings.DESCRIPTIONS;
    private static final String[] OPTIONS = eventStrings.OPTIONS;
    private CUR_SCREEN screen;
    private ShapeRenderer shapeRenderer = new ShapeRenderer();

    private enum CUR_SCREEN
    {
        INTRO,
        RULE_EXPLANATION,
        PLAY,
        COMPLETE,
        CLEAN_UP;
    }

    public TetrisEvent() {
        super(NAME, DESCRIPTIONS[0], "HalationImages/events/Tetris.png");
        imageEventText.setDialogOption(OPTIONS[0]);
        imageEventText.setDialogOption(OPTIONS[1]);
        imageEventText.setDialogOption(OPTIONS[2]);
        imageEventText.setDialogOption(OPTIONS[3]);
    }

    @Override
    public void update() {
        super.update();
        if (this.screen == CUR_SCREEN.PLAY) {
            this.updateTetrisLogic();
        }
    }

    public void updateTetrisLogic() {

    }

    @Override
    protected void buttonEffect(int i) {
        switch (screenNum) {
            case 0:
                switch (i) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:
                        
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                }
                break;
            case 1:
                switch (i) {
                    default:
                        openMap();
                        break;
                }
                break;
        }
    }
}
