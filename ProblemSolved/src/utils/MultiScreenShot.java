package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MultiScreenShot {
    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("폴더명을 적어주세요 (엔터만 입력 시 종료): ");
            String folderName = sc.nextLine();
            if (folderName.isEmpty()) break;

            System.out.print("페이지는 몇 장입니까? ");
            int totalPage = Integer.parseInt(sc.nextLine());

            // 준비
            for (int i = 3; i > 0; i--) {
                System.out.printf("%d초 후 시작합니다%n", i);
                Thread.sleep(1000);
            }


            // 저장 폴더 생성
            File dir = new File("src/" + folderName);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            Robot robot = new Robot();

            for (int page = 1; page <= totalPage; page++) {
                // 화면 캡처
                BufferedImage screenShot = robot.createScreenCapture(new Rectangle(
                        Toolkit.getDefaultToolkit().getScreenSize()));

                // 이미지 파일로 저장 (예: PNG)
                File out = new File(dir, String.format("%03d.png", page));
                ImageIO.write(screenShot, "png", out);

                // 우측 방향키 누르기
                robot.keyPress(KeyEvent.VK_RIGHT);
                robot.keyRelease(KeyEvent.VK_RIGHT);
                Thread.sleep(500);
            }
            System.out.println("스크린샷이 전부 저장되었습니다.");
        }
        sc.close();
    }
}