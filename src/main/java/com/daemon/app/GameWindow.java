package com.daemon.app;

import com.daemon.main.GameAreaObject;
import com.daemon.main.SnakeObject;
import com.daemon.main.FoodObject;
import com.daemon.main.TileObject;
import com.daemon.var.__String;
import com.daemon.var.__Int;

import java.lang.reflect.Field;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Color;

public class GameWindow extends JFrame implements KeyListener  {
    public int width, height;
    public String gameTitle;

    public GameAreaObject gameAreaObject;
    public SnakeObject snakeObject;
    public FoodObject foodObject;

    public ArrayList<TileObject> gameObjects;

    public GameWindow(int __width, int __height) {
        width = __width;
        height = __height;
        gameTitle = __String.GAME_TITLE;
        gameObjects = new ArrayList<TileObject>();
        gameAreaObject = new GameAreaObject(__Int.GAME_AREA_OBJECT_START_X_LOCATION, __Int.GAME_AREA_OBJECT_START_Y_LOCATION, __Int.GAME_AREA_OBJECT_WIDTH, __Int.GAME_AREA_OBJECT_HEIGHT, Color.RED);
        snakeObject = new SnakeObject(__Int.SNAKE_OBJECT_START_X_LOCATION, __Int.SNAKE_OBJECT_START_Y_LOCATION, __Int.SNAKE_OBJECT_WIDTH, __Int.SNAKE_OBJECT_HEIGHT, Color.PINK);
        foodObject = new FoodObject(__Int.FOOD_OBJECT_START_X_LOCATION, __Int.FOOD_OBJECT_START_Y_LOCATION, __Int.FOOD_OBJECT_WIDTH, __Int.FOOD_OBJECT_HEIGHT, Color.GREEN);
        gameObjects.add(foodObject);
        gameObjects.add(snakeObject);
        gameObjects.add(gameAreaObject);
        super.addKeyListener(this);
        super.setFocusable(true);
        super.requestFocusInWindow();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Field[] fields = SnakeObject.Direction.class.getDeclaredFields();

        try {     
            for(Field field : fields) {
                field.setAccessible(true);
            
                if(field.getType() == int.class && e.getKeyCode() == field.getInt(null)) {
                    snakeObject.move(e.getKeyCode());
                    update();
                    break;
                }

            }  
        } catch(IllegalAccessException __e1){
            __e1.printStackTrace();
        } catch(Exception __e2) {
            __e2.printStackTrace();
        }
    }

    @Override public void keyReleased(KeyEvent e) {} 
    @Override public void keyTyped(KeyEvent e) {}

    public void init() {
        setTitle(gameTitle);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        drawGameObjects();
        setVisible(true);
    }

    public void drawGameObjects() {
        int zIndex = 0;
        for(TileObject object : gameObjects) {
            getContentPane().add(object);
            getContentPane().setComponentZOrder(object, zIndex);
            zIndex++;
        }
    }

    public void removeGameObjects() {
        for(TileObject object : gameObjects) {
            getContentPane().remove(object);
        }
    }
    
    public void update() {
        removeGameObjects();
        revalidate();
        repaint();
        drawGameObjects();
    }
}