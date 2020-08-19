package de.maxi.addon.module;

import de.maxi.addon.TranslatorAddon;
import de.maxi.addon.utils.Translator;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class CurrentLanguageModule extends SimpleModule {


    @Override
    public String getDisplayName() {
        return "Translate Language";
    }

    @Override
    public String getDisplayValue() {
        if (TranslatorAddon.getInstance().getCurrentEnum().toString() == null)
            return "N/A";

        return TranslatorAddon.getInstance().getCurrentEnum().toString();
    }

    @Override
    public String getDefaultValue() {
        return "N/A";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.BOOK);
    }

    @Override
    public void loadSettings() {

    }

    @Override
    public String getSettingName() {
        return "Current Translate Language";
    }

    @Override
    public String getControlName() {
        return "Current Translate Language";
    }

    @Override
    public String getDescription() {
        return "Shows the current Translate Language";
    }

    @Override
    public int getSortingId() {
        return 1;
    }

    @Override
    public ModuleCategory getCategory() {
        return TranslatorAddon.getInstance().getTranslatorCategory();
    }
}
