import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Gumon {
    public static void main(String[] args) {
        Random random = new Random();
        BlockingQueue<String> inputQueue = new LinkedBlockingQueue<>();

        Thread inputThread = new Thread(() -> {
            Scanner sc = new Scanner(System.in);

            while (true) {
                try {
                    String line = sc.nextLine();
                    inputQueue.offer(line);
                } catch (Exception e) {
                    break;
                }
            }
        });

        inputThread.setDaemon(true);
        inputThread.start();

        int score = 0;

        for (int i = 0; i < 10; i++) {
            inputQueue.clear();

            boolean calc = random.nextBoolean();

            int a = random.nextInt(100) + 1;
            int b = random.nextInt(100) + 1;
            int answer;

            System.out.printf("[%d번 문제] ", i + 1);

            if (calc) {
                answer = a + b;
                System.out.printf("%d + %d = ", a, b);
            } else {
                if (a < b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }

                answer = a - b;
                System.out.printf("%d - %d = ", a, b);
            }

            try {
                String input = inputQueue.poll(6, TimeUnit.SECONDS);

                if (input == null) {
                    System.out.printf("\n시간 초과입니다. 정답은 %d\n", answer);
                    System.out.print("계속하려면 Enter를 누르세요.");

                    inputQueue.take(); // 사용자가 입력 중이던 줄을 Enter로 확정하면 버림
                } else {
                    int userAnswer = Integer.parseInt(input.trim());

                    if (userAnswer == answer) {
                        System.out.println("정답입니다.");
                        score += 10;
                    } else {
                        System.out.printf("오답입니다. 정답은 %d\n", answer);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해야 합니다.");
            } catch (InterruptedException e) {
                System.out.println("프로그램이 중단되었습니다.");
                break;
            }

            System.out.println();
        }

        System.out.println("시험 종료");
        System.out.printf("최종 점수: %d점 / 100점\n", score);
    }
}