package student.grades.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long score;
	private String subjectId;

	protected Mark() {

	}

	public Mark(Long score, String subjectId) {
		this.score = score;
		this.subjectId = subjectId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
}
