package tn.esprit.thabti_ahmed_4twin5.Services;

import tn.esprit.thabti_ahmed_4twin5.entities.Course;

import java.util.List;

public interface ICourseService {
    Course addCourse(Course course);
    Course updateCourse(Course course);
    void removeCourse(Long numCourse);
    Course retrieveCourse(Long numCourse);
    List<Course> retriveAll();
}
