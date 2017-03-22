package student.grades.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String examType;
	@OneToMany
	private List<Subject> subjects;

	protected Exam() {
	}

	public Exam(String examType, List<Subject> subjects) {
		this.examType = examType;
		this.subjects = subjects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public List<Subject> getSubjectId() {
		return subjects;
	}

	public void setSubjectId(List<Subject> subjects) {
		this.subjects = subjects;
	}
}
