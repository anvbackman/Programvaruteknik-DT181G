package com.dt181g.project;

import java.awt.event.KeyEvent;

public interface StrategyInterface {
    public void controller(Bird bird, KeyEvent keyEvent);
    public void releaseController(Bird bird, KeyEvent keyEvent);
}
