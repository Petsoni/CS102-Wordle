package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "surname", nullable = false, length = 40)
	private String surname;

	@Column(name = "username", nullable = false, length = 50)
	private String username;

	@Column(name = "password", nullable = false, length = 50)
	private String password;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "score_id", nullable = false)
	private List<Score> scores;

	public User() {
	}

	public User(Integer id, String name, String surname, String username, String password) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String name, String surname, String username, String password) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}