package org.example.client;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.example.client.ClientParams.*;

public class View {
    public static final int PAWN_Y = FIELD_HEIGHT / 2;
    private final Image boardImage;

    public View() {
        try {
            boardImage = ImageIO.read(View.class.getResource("/talismanHQ.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void tick() {
    }

    public void render(Graphics2D g) {
        //dla pola o ID zaczytujemy boxa o danych wymiarach
        int fieldId = 4;

        int spacesAmountInLine = 7;
        int lastFieldInLineIndex = spacesAmountInLine - 1;

        //g.drawRect(400, 450, 300, 350);
        g.drawImage(boardImage, 0, 0, ClientParams.WIDTH, ClientParams.HEIGHT, null);
        g.setColor(Color.ORANGE.darker());
        if (fieldId <= 6) {
            g.fillOval(fieldId * FIELD_WIDTH + centerPawnModifierX(), PAWN_Y, PAWN_WIDTH, PAWN_HEIGHT);
            return;
        }

        int steppesModificatierInLine = fieldId % lastFieldInLineIndex;
        if (fieldId <= 12) {
            g.fillOval(lastFieldInLineIndex * FIELD_WIDTH + centerPawnModifierX(),
                    PAWN_Y + steppesModificatierInLine * FIELD_HEIGHT,
                    PAWN_WIDTH, PAWN_HEIGHT);
        } else if (fieldId <= 17) {
            g.fillOval(lastFieldInLineIndex * FIELD_WIDTH + centerPawnModifierX() - steppesModificatierInLine * FIELD_WIDTH,
                    lastFieldInLineIndex * FIELD_HEIGHT + centerPawnModifierY(),
                    PAWN_WIDTH, PAWN_HEIGHT);
        } else if (fieldId <= 23) {
            g.fillOval(centerPawnModifierX(),
                    lastFieldInLineIndex * FIELD_HEIGHT + centerPawnModifierY() - steppesModificatierInLine * FIELD_HEIGHT,
                    PAWN_WIDTH, PAWN_HEIGHT);
        }
    }

    private int centerPawnModifierX() {
        return FIELD_WIDTH / 2 - PAWN_WIDTH / 2;
    }

    private int centerPawnModifierY() {
        return FIELD_HEIGHT / 2 - PAWN_HEIGHT / 2;
    }
}
