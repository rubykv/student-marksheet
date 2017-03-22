package student.grades.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String subjectId;
	private Double marks;

	protected Subject() {
	}

	public Subject(String subjectId, Double marks) {
		this.subjectId = subjectId;
		this.marks = marks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public Double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}

}
