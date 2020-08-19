package de.maxi.addon.events;

import de.maxi.addon.TranslatorAddon;
import de.maxi.addon.utils.Language;
import de.maxi.addon.utils.Translator;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;

public class MessageSendListener implements MessageSendEvent {


    @Override
    public boolean onSend(final String message) {
        if(!TranslatorAddon.getInstance().isEnabled())
            return false;

        if (message.startsWith(TranslatorAddon.getInstance().getCurrentInvoke())) {
            try {
                System.out.println(TranslatorAddon.getInstance().getCurrentEnum().toString());
                final String englishMessage = Translator.translate(message.replace(TranslatorAddon.getInstance().getCurrentInvoke(), ""), Language.AUTO_DETECT, TranslatorAddon.getInstance().getCurrentEnum().getShortCut());
                Minecraft.getMinecraft().thePlayer.sendChatMessage(englishMessage);
            } catch (Exception e) {
                e.printStackTrace();
                LabyMod.getInstance().displayMessageInChat(TranslatorAddon.PREFIX + "Error while sending Message!");
            }
            return true;
        }
        return false;
    }
}
