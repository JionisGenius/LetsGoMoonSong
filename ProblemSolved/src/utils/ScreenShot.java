package utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScreenShot {
    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        Thread.sleep(1000);
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(
                java.awt.Toolkit.getDefaultToolkit().getScreenSize()));

        // 이미지 파일로 저장 (예: PNG)
        javax.imageio.ImageIO.write(screenShot, "png", new java.io.File("src/results/screenshot.png"));
        System.out.println("스크린샷이 'screenshot.png'로 저장되었습니다.");
    }
}