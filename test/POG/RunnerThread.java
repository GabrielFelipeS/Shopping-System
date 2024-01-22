package POG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Assertions;

public class RunnerThread {

	public static void runThread(String[] params) {
		new Thread() {
			@Override
			public void run() {
				robot(params);
			}
		}.start();
	}

	private static void robot(String[] params) {
		try {
			Robot robot = new Robot();

			robot.delay(500);

			for (String textoParaDigitar : params) {
				clickMouse(600, 622);
				for (char caractere : textoParaDigitar.toCharArray()) {
					if (caractere == '@') {
						pressShiftAndTwo(robot);
					} else {
						pressKeyBy(caractere, robot);
					}
					/*
					int CharUni = (int) caractere;
					robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(CharUni));
					*/
				}
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('\n'));
			}
			
			robot.delay(500);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	private static void pressShiftAndTwo(Robot robot) {

		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_2);

		robot.delay(50);

		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_2);

	}

	private static void pressKeyBy(char caractere, Robot robot) {
		robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(caractere));
		robot.delay(50);
		robot.keyRelease(caractere);
	}

	private static void clickMouse(int x, int y) {
		try {
			Robot robot = new Robot();
			robot.delay(10);
			robot.mouseMove(x, y);
			robot.delay(50);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(50);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(50);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}
}
