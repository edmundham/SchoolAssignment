package ca.bcit.infosys;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ConversationScoped
public class RandomNumberGenerator implements Serializable {

    private static final int MAX = 100;

    private java.util.Random random = new java.util.Random(System.currentTimeMillis());

    @Produces @Named @ca.bcit.infosys.Random int getRandomNumber() {
        return random.nextInt(MAX);
    }
}
