package com.lizurt.suggester;

public enum CasePreference {
    // if we have a rule [1A&a!], "1", "A", "&", "a", "!" will be chosen
    NONE,
    // if we have a rule [1A&a!], "1", "&", "a", "!"  will be chosen after searching the lower case value in this set.
    LOWER,
    // if we have a rule [1A2a3], "1",  "A", "&", "!" will be chosen after searching the upper case value in this set.
    UPPER
}
