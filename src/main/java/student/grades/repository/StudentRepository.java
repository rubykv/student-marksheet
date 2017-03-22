package student.grades.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import student.grades.entity.Grades;
import student.grades.entity.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student,Long>{
	Student findByStudentId(Grades studentId);
}
