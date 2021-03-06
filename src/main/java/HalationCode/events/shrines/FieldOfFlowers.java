package HalationCode.events.shrines;

import HalationCode.events.buttons.RelicDialogOptionButton;
import HalationCode.relics.madeinabyss.EternalFortune;
import HalationCode.relics.madeinabyss.StarCompass;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractImageEvent;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.relics.Circlet;

public class FieldOfFlowers extends AbstractImageEvent {
    public static final String ID = "halation:FieldOfFlowers";
    private static final EventStrings eventStrings = CardCrawlGame.languagePack.getEventString(ID);
    private static final String NAME = eventStrings.NAME;
    private static final String[] DESCRIPTIONS = eventStrings.DESCRIPTIONS;
    private static final String[] OPTIONS = eventStrings.OPTIONS;

    public FieldOfFlowers() {
        super(NAME, DESCRIPTIONS[0], "HalationImages/events/FieldOfFlowers.png");

        imageEventText.optionList.add(new RelicDialogOptionButton(0, OPTIONS[0], new StarCompass(), false));
        imageEventText.optionList.add(new RelicDialogOptionButton(1, OPTIONS[1], new EternalFortune(), false));
        imageEventText.setDialogOption(OPTIONS[2]);
    }

    @Override
    protected void buttonEffect(int i) {
        switch (screenNum) {
            case 0:
                switch (i) {
                    case 0:
                        if (AbstractDungeon.player.hasRelic(StarCompass.ID)) {
                            AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2, Settings.HEIGHT / 2,
                                    RelicLibrary.getRelic(Circlet.ID).makeCopy());
                        } else {
                            AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2, Settings.HEIGHT / 2,
                                    RelicLibrary.getRelic(StarCompass.ID).makeCopy());
                        }
                        screenNum = 1;
                        imageEventText.updateBodyText(DESCRIPTIONS[1]);
                        imageEventText.updateDialogOption(0, OPTIONS[2]);
                        imageEventText.clearRemainingOptions();
                        break;
                    case 1:
                        if (AbstractDungeon.player.hasRelic(EternalFortune.ID)) {
                            AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2, Settings.HEIGHT / 2,
                                    RelicLibrary.getRelic(Circlet.ID).makeCopy());
                        } else {
                            AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2, Settings.HEIGHT / 2,
                                    RelicLibrary.getRelic(EternalFortune.ID).makeCopy());
                        }
                        screenNum = 1;
                        imageEventText.updateBodyText(DESCRIPTIONS[2]);
                        imageEventText.updateDialogOption(0, OPTIONS[2]);
                        imageEventText.clearRemainingOptions();
                        break;
                    case 2:
                        screenNum = 1;
                        imageEventText.updateBodyText(DESCRIPTIONS[3]);
                        imageEventText.updateDialogOption(0, OPTIONS[2]);
                        imageEventText.clearRemainingOptions();
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