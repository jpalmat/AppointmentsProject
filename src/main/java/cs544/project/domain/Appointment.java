package cs544.project.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm:ss")
	private Date time;
	
	private String location;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "appointment_id")
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	public Appointment() {}
			
	public Appointment(Date date, Date time, String location) {
		this.date = date;
		this.time = time;
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void setReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}
}
