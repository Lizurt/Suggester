package com.lizurt.suggester;

import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.atn.PlusBlockStartState;
import org.antlr.v4.runtime.atn.StarBlockStartState;

public class ATNStateAnalyser {
    public boolean shouldStateBeBanned(ATNState atnState) {
        if (atnState instanceof StarBlockStartState) {
            return true;
        } else if (atnState instanceof PlusBlockStartState) {
            return true;
        }
        return false;
    }
}
