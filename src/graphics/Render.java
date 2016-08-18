package graphics;

import entities.lighting.Light;
import graphics.sprites.Sprite;
import graphics.tiles.Tile;
import math.Tinting;

import java.util.Arrays;

public class Render {
    public static final int TRANSPARENT_COLOR = -65281;
    //private int Width;
    //private int Height;
    //public int[] pixels;

    public Screen screen;

    public int xOffset = 0, yOffset = 0;

    public Render(int width, int height) {
        //this.Width = width;
        //this.Height = height;
        //pixels = new int[width * height];

        screen = new Screen(width, height);
    }

    public void clear() {
        Arrays.fill(screen.pixels, 0);
    }

    public void renderTile(Tile tile, int xp, int yp) {
        xp -= xOffset;
        yp -= yOffset;

        renderSpriteInternal(tile.sprite, xp, yp, false);
    }

    public void renderSprite(Sprite sprite, int xp, int yp, boolean setOffset) {
        if (setOffset) {
            xp -= xOffset;
            yp -= yOffset;
        }
        renderSpriteInternal(sprite, xp, yp, true);
    }

    private void renderSpriteInternal(Sprite sprite, int xp, int yp, boolean checkForTransparency) {
        // Quickly check if the sprite is visible at all
        if (isBetween(xp, -sprite.SIZE + 1, screen.Width - 1)
                && isBetween(yp, -sprite.SIZE + 1, screen.Height - 1)) {
            for (int y = Math.max(0, -yp); y < Math.min(sprite.SIZE, screen.Height - yp); y++) {
                int ya = yp + y;
                if (checkForTransparency) {
                    for (int x = Math.max(0, -xp); x < Math.min(sprite.SIZE, screen.Width - xp); x++) {
                        int xa = xp + x;
                        if (xa < 0) xa = 0;
                        if (sprite.pixels[x + y * sprite.SIZE] != TRANSPARENT_COLOR) {
                            screen.pixels[xa + ya * screen.Width] = sprite.pixels[x + y * sprite.SIZE];
                        }
                    }
                } else {
                    // Copy the entire visible row from source (sprite) to destination using System.arraycopy
                    int sourceStartX = Math.max(0, -xp);
                    int sourceEndX = Math.min(sprite.SIZE, screen.Width - xp);
                    System.arraycopy(
                            sprite.pixels, sourceStartX + y * sprite.SIZE,
                            screen.pixels, xp + sourceStartX + ya * screen.Width, sourceEndX - sourceStartX);
                }
            }
        }
    }

    public void renderParticle(int xp, int yp, int colour) {
        xp -= xOffset;
        yp -= yOffset;
        if (isBetween(yp, 1, screen.Height) && isBetween(xp, 1, screen.Width)) {
            screen.pixels[xp + yp * screen.Width] = Tinting.changeBrightness(screen.pixels[xp + yp * screen.Width], colour);
            screen.pixels[xp + (yp - 1) * screen.Width] = Tinting.changeBrightness(screen.pixels[xp + (yp - 1) * screen.Width], colour);
            screen.pixels[(xp - 1) + yp * screen.Width] = Tinting.changeBrightness(screen.pixels[(xp - 1) + yp * screen.Width], colour);
            screen.pixels[(xp - 1) + (yp - 1) * screen.Width] = Tinting.changeBrightness(screen.pixels[(xp - 1) + (yp - 1) * screen.Width], colour);
        }
    }

    public void renderPixelArray(int[] pixels, int size, int xp, int yp) {
        for (int y = 0; y < size; y++) {
            int ya = yp + y;
            if (isBetween(ya, 0, screen.Height)) {
                for (int x = 0; x < size; x++) {
                    int xa = xp + x;
                    if (isBetween(xa, 0, screen.Width)) {
                        screen.pixels[xa + ya * screen.Width] = pixels[x + y * size];
                    }
                }
            }
        }
    }

    public void renderLight(Light light) {
        int xx = light.getX() - xOffset;
        int yy = light.getY() - yOffset;
        int intensity = light.intensity;
        if (xx > 0 && yy > 0 && xx < screen.Width && yy < screen.Height) {
            double x = 0;
            double y = 0;
            for (int dist = 0; dist < light.radius; dist++) {
                for (int currad = 0; currad < 360; currad++) {
                    x = Math.sin(Math.toRadians(currad)) * dist + xx;
                    y = Math.cos(Math.toRadians(currad)) * dist + yy;
                    if (isBetween(y, 0, screen.Height) && isBetween(x, 0, screen.Width)) {
                        int position = (int) x + (int) y * screen.Width;
                        int incol = screen.pixels[(position)];
                        screen.pixels[(position)] = Tinting.changeBrightness(incol, intensity);
                    }
                }
                intensity--;
            }
        }
    }

    public void setOffsets(int x, int y) {
        xOffset = x;
        yOffset = y; // 20 16
    }

    private boolean isBetween(double value, int min, int max) {
        return value >= min && value < max;
    }

    private boolean isBetween(int value, int min, int max) {
        return value >= min && value < max;
    }
}
