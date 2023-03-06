package org.example.client;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class View {
    private BufferedImage bufferedImage;

    public View() {
        try {
            bufferedImage = ImageIO.read(View.class.getResource("/talismanBoard.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void tick() {
    }

    public void render(Graphics2D g) {
        int fieldId = 1;
        int fieldWidth = ClientParams.WIDTH / 7;

        //g.drawRect(400, 450, 300, 350);
        g.drawImage(bufferedImage, 0, 0, ClientParams.WIDTH, ClientParams.HEIGHT, null);
        g.setColor(Color.ORANGE.darker());
        g.fillOval(fieldId * fieldWidth,100,100,100);
    }
}
