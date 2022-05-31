package lesson24;

import java.util.Objects;

public class Time {

	private int min;
	private int hour;
	
	
	public Time(int hour, int min) {
		super();
		try {
			if(min>=0 & min<=60) {
				this.min = min;
			}
			if(hour>=0 & hour<=24) {
				this.hour = hour;
			}
		}catch (Exception e){
			System.out.println("Wrong input time ");
		}
	}
	

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public static Time sumTime(Time time1, Time time2) throws IllegalArgumentException {
		int hour = time1.getHour() + time2.getHour();
		int min = time1.getMin() + time2.getMin();

		if (min >= 60) {
			hour = hour + 1;
			min = min - 60;
		} else if (hour >= 24) {
			hour = hour - 24;
		}

		return new Time(hour, min);
	}

	@Override
	public String toString() {
		return " " + hour +" : "+  min + " ";

	}
	
	@Override
	public int hashCode() {
		return Objects.hash(hour, min);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hour == other.hour && min == other.min;
	}


	

	
}
