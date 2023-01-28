package com.example.suggester;

// todo: i guess we can do suggesting without recursion. Might try use stacks

import lombok.Data;

/**
 * Just to save results in recursions
 */
@Data
public class UntokenizedTextState {
    private final String currentTokenText;
    private final String currentUnsuggestedTextFromUntokenizedText;
}
