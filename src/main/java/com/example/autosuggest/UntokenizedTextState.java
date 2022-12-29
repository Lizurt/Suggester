package com.example.autosuggest;

// todo: i guess we can do suggesting without recursion. Might try use stacks

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Just to save results in recursions
 */
@Data
public class UntokenizedTextState {
    private final String currentTokenText;
    private final String currentUnsuggestedTextFromUntokenizedText;
}
