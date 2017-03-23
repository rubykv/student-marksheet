package student.grades.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import student.grades.entity.Grades;
import student.grades.entity.Mark;

public interface StudentMarksRepository extends PagingAndSortingRepository<Mark,Long>{
	Mark findByStudentId(Grades studentId);
}
