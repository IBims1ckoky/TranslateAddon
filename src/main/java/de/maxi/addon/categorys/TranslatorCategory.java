package de.maxi.addon.categorys;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class TranslatorCategory extends ModuleCategory {

    public TranslatorCategory() {
        super("Translator", true, new ControlElement.IconData(Material.BOOK));
        ModuleCategoryRegistry.loadCategory(this);
    }

}
