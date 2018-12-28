package it.nave;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.out.println("PROGRAM STARTED");
		System.out.println("Press enter to wake up Snorlax...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		Alarm alarm = new Alarm();
		Thread thread = new Thread(alarm);
		thread.start();
		System.out.println("Press enter to exit program...");
		scanner.nextLine();
		scanner.close();
		alarm.terminate();
		thread.join();
		System.out.println("PROGRAM TERMINATED");
	}

}
