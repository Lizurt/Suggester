package com.example.suggester;

public enum InputAndSuggestionCompareResult {
    // the suggestion doesn't match the input (wrong char)
    INAPPROPRIATE_SUGGESTION,
    // the suggestion tries to complete the input (doesn't exit in the input)
    APPROPRIATE_SUGGESTION,
    // the suggestion matches the input, no need to suggest then
    SUGGESTION_ALREADY_IN_INPUT
}
