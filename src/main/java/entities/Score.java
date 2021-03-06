package entities;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "value", nullable = false)
	private Double value;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_fk", nullable = false)
	private User user;

	public Score() {
	}

	public Score(Integer id, Double value, User user) {
		this.id = id;
		this.value = value;
		this.user = user;
	}

	public Score(Double value, User user) {
		this.value = value;
		this.user = user;
	}

	public Score(Double value) {
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}