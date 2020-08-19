package de.maxi.addon;

import de.maxi.addon.categorys.TranslatorCategory;
import de.maxi.addon.events.MessageSendListener;
import de.maxi.addon.module.CurrentLanguageModule;
import de.maxi.addon.enums.LanguageEnum;
import net.labymod.api.LabyModAPI;
import net.labymod.api.LabyModAddon;
import net.labymod.gui.elements.DropDownMenu;
import net.labymod.settings.elements.*;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;

import java.util.List;

public class TranslatorAddon extends LabyModAddon {

    private static TranslatorAddon instance;

    private boolean enabled = true;
    private String currentInvoke = "!";
    private LanguageEnum currenteLanguageEnum = LanguageEnum.ENGLISH;

    private TranslatorCategory translatorCategory;
    public static final String PREFIX = "§8▌ §6ChatTranslator §8» §7";

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("Enable TranslatorAddon by IBims1ckoky");
        translatorCategory = new TranslatorCategory();
        getApi().getEventManager().register(new MessageSendListener());
        getApi().registerModule(new CurrentLanguageModule());
    }

    @Override
    public void loadConfig() {
        this.enabled = !this.getConfig().has("enabled") || this.getConfig().get("enabled").getAsBoolean();

    }

    @Override
    protected void fillSettings(final List<SettingsElement> settingsList) {
        settingsList.add(new HeaderElement("§7§lChatTranslator v1.0 by IBims1ckoky"));
        settingsList.add(new HeaderElement("§6§lChatTranslator §l§8| §l§7Settings"));
        final BooleanElement enabledElement = new BooleanElement("Enabled", new ControlElement.IconData(Material.LEVER), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean status) {
                enabled = status;
                getConfig().addProperty("enabled", status);
                saveConfig();
            }
        }, this.enabled);
        settingsList.add(enabledElement);

        final StringElement messageInvoke = new StringElement("Message Invoke", new ControlElement.IconData(Material.REDSTONE_TORCH_ON), "!", new Consumer<String>() {
            @Override
            public void accept(String invoke) {
                currentInvoke = invoke;
            }
        });
        settingsList.add(messageInvoke);

        final DropDownMenu<LanguageEnum> languageDropDownMenu = new DropDownMenu<LanguageEnum>("Translate Language", 0, 0, 0, 0).fill(LanguageEnum.values());
        final DropDownElement<LanguageEnum> languageDropDownElement = new DropDownElement<LanguageEnum>("Translate Language", languageDropDownMenu);
        languageDropDownMenu.setSelected(currenteLanguageEnum);
        languageDropDownElement.setChangeListener(new Consumer<LanguageEnum>() {
           @Override
           public void accept(LanguageEnum languageEnum) {
                setCurrenteLanguageEnum(languageEnum);
               System.out.println(languageEnum);
           }
       });
        settingsList.add(languageDropDownElement);

        settingsList.add(new HeaderElement("§6§lChatTranslator §l§8| §l§7EXAMPLE"));
        settingsList.add(new HeaderElement("§7!Hello my name is Maxi"));
    }

    public static TranslatorAddon getInstance() {
        return instance;
    }

    public String getCurrentInvoke() {
        return currentInvoke;
    }

    @Override
    public LabyModAPI getApi() {
        return super.getApi();
    }


    public Boolean isEnabled() {
        return this.enabled;
    }

    public TranslatorCategory getTranslatorCategory() {
        return translatorCategory;
    }

    public LanguageEnum getCurrentEnum() {
        return this.currenteLanguageEnum;
    }

    public void setCurrenteLanguageEnum(LanguageEnum currenteLanguageEnum) {
        this.currenteLanguageEnum = currenteLanguageEnum;
    }
}
