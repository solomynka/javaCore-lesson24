package lesson24;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import java.util.Map.Entry;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cinema {

	private Time open;
	private Time close;

	TreeMap<Days, Schedule> schedules = new TreeMap<>();
	ArrayList<Movie> moviesLibrary = new ArrayList<>();

	Set<Seance> seances = new TreeSet<>();
	Days[] day = Days.values();

	public Cinema(Time open, Time close) {
		super();
		this.open = open;
		this.close = close;
	}

	public Time getOpen() {
		return open;
	}

	public void setOpen(Time open) {
		this.open = open;
	}

	public Time getClose() {
		return close;
	}

	public void setClose(Time close) {
		this.close = close;
	}

	public TreeMap<Days, Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(TreeMap<Days, Schedule> schedules) {
		this.schedules = schedules;
	}

	public ArrayList<Movie> getMoviesLibrary() {
		return moviesLibrary;
	}

	public void setMoviesLibrary(ArrayList<Movie> moviesLibrary) {
		this.moviesLibrary = moviesLibrary;
	}

	public void allMovie() {
		System.out.println("All film " + moviesLibrary.toString());
	}

	public void addMovie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie name: ");
		String nameMovie = sc.next().toUpperCase();

		System.out.println("Enter the movie duration:");
		System.out.println("hour: ");
		int durationMovieHour = sc.nextInt();
		System.out.println("minute:");
		int durationMovieMin = sc.nextInt();

		Time timeDuratinMovie = new Time(durationMovieHour, durationMovieMin);
		Movie movie = new Movie(nameMovie, timeDuratinMovie);

		moviesLibrary.add(movie);
		System.out.println(movie.toString() + " add to library");
	}

	public void removeMovie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie name: ");
		String nameMovie = sc.next().toUpperCase();

		Iterator<Movie> iterator = moviesLibrary.iterator();
		while (iterator.hasNext()) {
			Movie next = iterator.next();
			if (next.getTitle().equalsIgnoreCase(nameMovie)) {
				iterator.remove();
				System.out.println(nameMovie.toString() + " remove from library");
			} else {
				System.out.println(nameMovie + " not found!");
			}
		}
	}

	public void addSeance() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter day of seance: ");
		String day1 = sc.next().toUpperCase();

		for (Days days : day) {
			if (days.name().equalsIgnoreCase(day1)) {

				System.out.println("Enter movie name: ");
				String nameMovie = sc.next().toUpperCase();

				System.out.println("Enter when the movie starts:");
				System.out.println("hour");
				int startMovieHour = sc.nextInt();
				System.out.println("minute");
				int startMovieMin = sc.nextInt();

				System.out.println("Enter the movie duration:");
				System.out.println("hour: ");
				int durationMovieHour = sc.nextInt();
				System.out.println("minute:");
				int durationMovieMin = sc.nextInt();

				Time timeDuratinMovie = new Time(durationMovieHour, durationMovieMin);
				Time timeStartMovie = new Time(startMovieHour, startMovieMin);
				Movie movie = new Movie(nameMovie, timeDuratinMovie);
				Seance seance1 = new Seance(movie, timeStartMovie);

				if (timeStartMovie.getHour() <= open.getHour() || timeStartMovie.getHour() > close.getHour()) {
					System.out.println("In this time " + getClose() + " to " + getOpen() + " cinema is close!");
				} else {
					seances.add(seance1);

					Schedule sch = new Schedule(seances);

					schedules.put(days, sch);
					System.out.println(sch.toString() + " add to seanse");
				}
			}
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public void removeSeance() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter day of seance: ");
		String day1 = sc.next().toUpperCase();
		
		for (Days days : day) {
			if (days.name().equalsIgnoreCase(day1)) {
				
				System.out.println("Enter movie name: ");
				String nameMovie = sc.next().toUpperCase();
				System.out.println("Enter when the movie starts:");
				System.out.println("hour");
				int startMovieHour = sc.nextInt();
				System.out.println("minute");
				int startMovieMin = sc.nextInt();

				System.out.println("Enter the movie duration:");
				System.out.println("hour: ");
				int durationMovieHour = sc.nextInt();
				System.out.println("minute:");
				int durationMovieMin = sc.nextInt();

				Time timeDuratinMovie = new Time(durationMovieHour, durationMovieMin);
				Time timeStartMovie = new Time(startMovieHour, startMovieMin);
				Movie movie = new Movie(nameMovie, timeDuratinMovie);
				Seance seance1 = new Seance(movie, timeStartMovie);

				Set<Seance> seances2 = new TreeSet<>();
				seances2.add(seance1);

				Iterator<Seance> iterator = seances.iterator();

				while (iterator.hasNext()) {
					Seance seance = (Seance) iterator.next();
					if (seance.getMovie().getTitle().equalsIgnoreCase(nameMovie)) {
						if (schedules.containsValue(seances2)) {
							schedules.remove(days, seances2);
						}
						iterator.remove();
						System.out.println("Seance " + seance1.toString() + " remove from seance");
						
					} else {
						System.out.println("Seance " + seance1.toString() + " not found!");
					}
				}
			}
		}
	}
}
