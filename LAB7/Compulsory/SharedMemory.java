package org.compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SharedMemory {
    private final List<Token> tokens;
    public SharedMemory(int numTokens) {
        tokens = new ArrayList<>();
        for (int i = 1; i <= numTokens; i++) {
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
    }
    public synchronized Token takeToken() {
        if (tokens.isEmpty()) {
            return null;
        }
        return tokens.remove(0);
    }
}
