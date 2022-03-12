package ALocalizationUpdate;

import basemod.BaseMod;
import basemod.ModLabel;
import basemod.ModLabeledToggleButton;
import basemod.ModPanel;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import basemod.interfaces.StartGameSubscriber;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.Loader;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.monsters.city.Champ;
import com.megacrit.cardcrawl.monsters.city.Snecko;
import com.megacrit.cardcrawl.monsters.exordium.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.Properties;


@SpireInitializer
public class ALocalizationUpdate implements
        EditStringsSubscriber,
        PostInitializeSubscriber {

    public static String MOD_ID = "ALocalizationUpdate";

    public static String makeID(String id) {
        return MOD_ID + ":" + id;
    }

    public static String assetPath(String path) {
        return MOD_ID + "/" + path;
    }

    public static final String MODNAME = "ALocalizationUpdate";
    public static final String AUTHOR = "Rita";
    public static final String DESCRIPTION = "";

//


    public static Properties ALocalizationUpdateDefaults = new Properties();
    public static final Logger logger = LogManager.getLogger(ALocalizationUpdate.class.getSimpleName());


    @SuppressWarnings("unused")
    public static void initialize() {
        new ALocalizationUpdate();
    }

    public ALocalizationUpdate() {
        BaseMod.subscribe(this);
    }


    public static String getLanguageString() {
        String language;
        switch (Settings.language) {
            case ZHS:
                language = "zhs";
                break;
            case ZHT:
                language = "zht";
                break;
            case KOR:
                language = "kor";
                break;
            case JPN:
                language = "jpn";
                break;
            default:
                language = "eng";
        }
        return language;
    }

    @Override
    public void receiveEditStrings() {
        String language;
        language = getLanguageString();
//        String powerStrings = Gdx.files.internal("ALocalizationUpdate/localization/" + language + "/PowerStrings.json").readString(String.valueOf(StandardCharsets.UTF_8));
//        BaseMod.loadCustomStrings(PowerStrings.class, powerStrings);
//        String uiStrings = Gdx.files.internal("ALocalizationUpdate/localization/" + language + "/UIStrings.json").readString(String.valueOf(StandardCharsets.UTF_8));
//        BaseMod.loadCustomStrings(UIStrings.class, uiStrings);
    }

    @Override
    public void receivePostInitialize() {
        loadSettings();
//        BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, settingsPanel);
    }

    public static void saveSettings() {
        try {
            SpireConfig config = new SpireConfig("ALocalizationUpdate", "settings", ALocalizationUpdateDefaults);

            config.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadSettings() {
        try {
            SpireConfig config = new SpireConfig("ALocalizationUpdate", "settings", ALocalizationUpdateDefaults);
            config.load();

        } catch (Exception e) {
            e.printStackTrace();
            clearSettings();
        }
    }

    public static void clearSettings() {
        saveSettings();
    }
}
