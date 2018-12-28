package it.nave;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;

public class Alarm implements Runnable {
	private boolean stop = false;
	private PointerInfo pi;
	private Point p;

	@Override
	public void run() {
		try {
			wakeUp();
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void wakeUp() throws AWTException, InterruptedException {
		boolean control = true;
		while (!stop) {
			acquireMousePosition();
			moveMouse(p.getX(), p.getY(), control);
			control = !control;
			Thread.sleep(500);
		}
	}

	private void acquireMousePosition() {
		pi = MouseInfo.getPointerInfo();
		p = pi.getLocation();
	}

	private void moveMouse(double x, double y, boolean control) throws AWTException {
		Robot r = new Robot();
		int delta = (control) ? 1 : -1;
		r.mouseMove((int) x + delta, (int) y + delta);
	}

	public void terminate() {
		stop = true;
	}

}
