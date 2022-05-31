package lesson24;

import java.util.Objects;

public class Movie implements Comparable<Movie>{

	private String title;
	private Time duration;
	
	public Movie(String title, Time duration) {
		super();
		this.title = title;
		this.duration = duration;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(duration, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(duration, other.duration) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Movie title=" + title + ", movie duration = " + duration;
	}
	@Override
	public int compareTo(Movie o) {
		return this.title.compareToIgnoreCase(o.getTitle());
	}
	
	
}
