package student.grades.application;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import student.grades.entity.Exam;
import student.grades.entity.Grades;
import student.grades.entity.Student;
import student.grades.entity.Subject;
import student.grades.repository.GradeRepository;
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
	public CommandLineRunner demo(final GradeRepository repository, final StudentRepository stdRepository){
		return (args) -> {

			log.info("Saving data into repository");
			Grades grade = new Grades();
			grade.setStudentId(1L);
			repository.save(grade);
			
			log.info("Fetching all data"+repository.findStudentNameByStudentId(1L));
			Student student = new Student();
			student.setStudentName("Whatever");
			student.setStudentId(grade);
			stdRepository.save(student);
			log.info("Fetching student data"+stdRepository.findByStudentId(grade));
			if(stdRepository.findByStudentId(grade) != null){
				log.info("Student name is : "+stdRepository.findByStudentId(grade).getStudentName());
			}

		};
	}

}
