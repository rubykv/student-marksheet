package student.grades.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import student.grades.entity.Grades;

@RepositoryRestResource(collectionResourceRel = "gradesystem", path = "gradesystem")
public interface GradeRepository extends PagingAndSortingRepository<Grades, Long> {
	Grades findStudentNameByStudentId(Long studentId);
	Grades findScoreByStudentId(Long studentId);
}
