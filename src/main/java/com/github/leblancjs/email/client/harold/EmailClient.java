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

        return List.of(
                new Email("Red Green", "The Handyman's Secret Weapon", "Duct tape can fix just about anything! If women don't find you handsome, they should at least find you handy."),
                new Email("Winston Rothschild III", "Rothschild's Sewage and Septic Sucking Services", "We're number one in the number two business. We'll take that smell off your hands. We come in a truck and leave in a daze."),
                new Email("Nigerian Prince", "Let Me Share a Fortune with You", "Hey! I want to share my money. Want some? Give me your bank account number, SIN, etc. and I'll send you a few million dollars!"));
    }
}
