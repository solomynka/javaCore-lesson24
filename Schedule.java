package lesson24;

import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

	Set<Seance> seances = new TreeSet<>();
	
	String seanceName;
	

	public Schedule(Set<Seance> seances) {
		super();
		this.seances = seances;
	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	public String getSeanceName() {
		return seanceName;
	}

	public void setSeanceName(String seanceName) {
		this.seanceName = seanceName;
	}

	public void addSeance() {
		

	}
	public void removeSeance() {
		
		
		seances.forEach(System.out::println);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie name: ");
		String nameMovie = sc.next().toUpperCase();
		
		Iterator<Seance> iterator = seances.iterator();
		
		while(iterator.hasNext()) {
			Seance next = iterator.next();
			if(next.getMovie().getTitle().equals(nameMovie)) {
				iterator.remove();
				System.out.println("Seance " + nameMovie.toString() + " remove");
			}else {
				System.out.println("Seance " + nameMovie +" not found");
			}
		}	
	}

	@Override
	public int hashCode() {
		return Objects.hash(seances);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return Objects.equals(seances, other.seances);
	}

	@Override
	public String toString() {
		return "Seances= " + seances ;
	}

	
	
	
}
