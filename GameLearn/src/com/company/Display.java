package com.company;

import javax.swing.*;
import java.awt.*;

public class Display extends Canvas {

    public Display(int Width, int Height, String title, MaGame game){
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(Width,Height));
        frame.setMaximumSize(new Dimension(Width,Height));
        frame.setMinimumSize(new Dimension(Width,Height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);//centers window
        frame.add(game);
        frame.setVisible(true);

        game.start();

    }

}
