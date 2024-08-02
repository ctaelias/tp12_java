package ar.edu.et7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BouncingBall extends JPanel implements ActionListener {
    private int ballX = 50, ballY = 50;
    private int ballDiameter = 30;
    private int ballDeltaX = 2, ballDeltaY = 2;
    private Color ballColor = Color.BLUE; 

    public BouncingBall() {
        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(ballColor);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ballX + ballDeltaX < 0 || ballX + ballDiameter + ballDeltaX > getWidth()) {
            ballDeltaX *= -1;
            changeBallColor(); // Cambia el color de la pelota al chocar con la pared
        }
        if (ballY + ballDeltaY < 0 || ballY + ballDiameter + ballDeltaY > getHeight()) {
            ballDeltaY *= -1;
            changeBallColor(); // Cambia el color de la pelota al chocar con la pared
        }

        ballX += ballDeltaX;
        ballY += ballDeltaY;

        repaint();
    }

    private void changeBallColor() {
        Random rand = new Random();
        // Genera un nuevo color aleatorio
        ballColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        BouncingBall bouncingBall = new BouncingBall();
        frame.add(bouncingBall);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
