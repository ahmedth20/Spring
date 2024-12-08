package tn.esprit.thabti_ahmed_4twin5.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.thabti_ahmed_4twin5.Repositories.ICourseRepository;
import tn.esprit.thabti_ahmed_4twin5.entities.Course;
import tn.esprit.thabti_ahmed_4twin5.entities.Instructor;
import tn.esprit.thabti_ahmed_4twin5.Repositories.IInstructorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class InstructorServiceImpl implements IInstructorService {

    private final IInstructorRepository instructorRepository;
    private final ICourseRepository courseRepository;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void removeInstructor(Long numInstructor) {
        instructorRepository.deleteById(numInstructor);
    }

    @Override
    public Instructor retrieveInstructor(Long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public Instructor addInstructorAndAssignToCourses(Instructor instructor) {
        Set<Course> courseSet = new HashSet<>();
        if(instructor.getCourses().isEmpty()){
            return instructorRepository.save(instructor);
        }
        for(Course c : instructor.getCourses()){
            Course course = courseRepository.findById(c.getNumCourse()).orElse(null);
            courseSet.add(course);
        }
        instructor.setCourses(courseSet);
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor addInstructorToCourse(Instructor instructor, List<Long> numCourse) {

        List<Course> courses = (List<Course>) courseRepository.findAllById(numCourse);
        instructor.setCourses(new HashSet<>());

        for (Course course : courses) {
            if (course != null) {
                instructor.getCourses().add(course);
            }
        }


        return instructorRepository.save(instructor);
    }
}
