package com.dt181g.project;

import java.awt.event.KeyEvent;

public interface StrategyInterface {
    public void controller(BirdModel bird, KeyEvent keyEvent);
    public void releaseController(BirdModel bird, KeyEvent keyEvent);
}
