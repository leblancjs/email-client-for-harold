package com.github.leblancjs.email.client.harold;

import java.util.List;

public class EmailClient {
    private final long delayBeforeResponseInMs;

    public EmailClient(long delayBeforeResponseInMs) {
        this.delayBeforeResponseInMs = delayBeforeResponseInMs;
    }

    public List<Email> fetchEmail() {
        // Harold doesn't know it, but we won't really fetch email...
        // We'll just pretend.
        try {
            Thread.sleep(delayBeforeResponseInMs);
        } catch (InterruptedException error) {
            System.err.println("Hmm... that didn't work");
        }

        // TODO: Come up with English email equivalents...
        return List.of(
                new Email("Ricardo", "La meilleure recette de tarte", "Tu dois essayer cette recette!"),
                new Email("Ginette Renaud", "Ma nouvelle chanson", "Salut. Peux-tu écouter mon dernier single et me dire ce que t'en penses? Merci!"),
                new Email("Prince Nigérien", "Une fortune à partager", "Hey! Je dois partager mon cash. T'en veux? Donne moi ton numéro de compte, ton NAS, etc. pi je t'envois quelques millions!"));
    }
}
