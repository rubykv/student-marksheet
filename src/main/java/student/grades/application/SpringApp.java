package student.grades.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import student.grades.entity.Grades;
import student.grades.entity.Mark;
import student.grades.entity.Student;
import student.grades.repository.GradeRepository;
import student.grades.repository.StudentMarksRepository;
import student.grades.repository.StudentRepository;

@SpringBootApplication
@EnableJpaRepositories("student.grades.repository")
@EntityScan("student.grades.entity")
public class SpringApp {
	private static final Logger log = LoggerFactory.getLogger(SpringApp.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringApp.class);
	}

	@Bean
	public CommandLineRunner demo(final GradeRepository repository, final StudentRepository stdRepository, final StudentMarksRepository markRepo) {
		return (args) -> {

			log.info("Saving Grades data into repository");
			Grades grade = new Grades();
			grade.setStudentId(1L);
			repository.save(grade);

			log.info("Saving student data" + repository.findStudentNameByStudentId(1L));
			Student student = new Student();
			student.setStudentName("Whatever");
			student.setStudentId(grade);
			stdRepository.save(student);
			
			log.info("Saving mark data" + repository.findStudentNameByStudentId(1L));
			Mark mark = new Mark();
			mark.setStudentId(grade);
			mark.setScore(240L);
			markRepo.save(mark);
			
			log.info("Fetching student data based on student Id from Grades");
			if (null != stdRepository.findByStudentId(grade)  && null!= markRepo.findByStudentId(grade)) {
				log.info("Student - " + stdRepository.findByStudentId(grade).getStudentName()+" scored a total of "+  markRepo.findByStudentId(grade).getScore()+" out of 250");
			}
		};
	}
}
