package com.daemon.main;

import com.daemon.var.__Int;

import java.awt.Color;
import java.lang.reflect.Constructor;

public class SnakeObject extends TileObject {
    public SnakeObject(int __xLocation, int __yLocation, int __width, int __height, Color color) {
        super(__xLocation, __yLocation, __width, __height, color);
    }

    public static class Direction {
        public static final int UP = __Int.SNAKE_DIRECTION_KEYCODE__UP;
        public static final int DOWN = __Int.SNAKE_DIRECTION_KEYCODE__DOWN;
        public static final int LEFT = __Int.SNAKE_DIRECTION_KEYCODE__LEFT;
        public static final int RIGHT = __Int.SNAKE_DIRECTION_KEYCODE__RIGHT;
    }

    public void move(int direction) throws Exception {
        if(direction == Direction.UP) {
            this.yLocation -= __Int.TILE_STEP;
        } else if(direction == Direction.DOWN) {
            this.yLocation += __Int.TILE_STEP;
        } else if(direction == Direction.LEFT) {
            this.xLocation -= __Int.TILE_STEP;
        } else if(direction == Direction.RIGHT) {
            this.xLocation += __Int.TILE_STEP;
        } else {}

        System.out.println("xLocation: " + xLocation + ", " + "yLocation: " + yLocation);

        Class<?> thisObject = this.getClass();
        Constructor<?> thisObjectConstructor = thisObject.getDeclaredConstructor(int.class, int.class, int.class, int.class, Color.class);
        Object newThisObject = thisObjectConstructor.newInstance(this.xLocation, this.yLocation, this.width, this.height, this.color);
    }

    public void feed() {
        
    }
}
