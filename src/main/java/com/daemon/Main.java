package com.daemon;

import com.daemon.app.GameWindow;
import com.daemon.var.__Int;

public class Main {
    public static void main(String[] args) {
        new GameWindow(__Int.GAME_WINDOW_WIDTH, __Int.GAME_WINDOW_HEIGHT).init();
    }
}