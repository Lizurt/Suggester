package com.lizurt.suggester;

public enum CasePreference {
    // if we have a rule [Aa], "A" will be chosen
    FIRST_MET,
    // if we have a rule [Aa], "a" will be chosen
    LAST_MET,
    // if we have a rule [Aa], "a" will be chosen after searching the lower case value in this set
    LOWER,
    // if we have a rule [Aa], "A" will be chosen after searching the upper case value in this set
    UPPER
}
