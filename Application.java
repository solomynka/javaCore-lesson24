package lesson24;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Cinema cinema = new Cinema(new Time(8, 10), new Time(21, 0));

		while (true) {
			menu();

			switch (sc.next()) {
			case "1": {
				cinema.addMovie();
				break;
			}
			case "2": {
				cinema.addSeance();
				
				break;
			}
			case "3": {
				cinema.removeMovie();
				break;
			}
			case "4": {
				cinema.removeSeance();
				break;
			}
			case "5": {
				cinema.allMovie();
				break;
			}
			case "6": {
				System.out.println("Програму закрито");
				System.exit(0);
				break;
			}

			}
		}

	}

	public static void menu() {
		System.out.println("Enter 1 to add movie");
		System.out.println("Enter 2 to add seance");
		System.out.println("Enter 3 to remove movie");
		System.out.println("Enter 4 to remove seance");
		System.out.println("Enter 5 to visual all movie");
		System.out.println("Enter 6 to exit");
	}
}
