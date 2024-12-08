package tn.esprit.thabti_ahmed_4twin5.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.thabti_ahmed_4twin5.entities.Course;
import tn.esprit.thabti_ahmed_4twin5.Services.CourseServiceImpl;

import java.util.List;

@RestController
@Tag(name = "Gestion Course")
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseRestController {

    private final CourseServiceImpl courseService;
    @Operation(description = "Ajout d'un nouveau Course")
    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }
    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }
    @GetMapping("/get/{numCourse}")
    public Course getCourse(@PathVariable Long numCourse) {
        return courseService.retrieveCourse(numCourse);
    }

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.retriveAll();
    }

    @DeleteMapping("/delete/{numCourse}")
    public void deleteCourse(@PathVariable Long numCourse) {
        courseService.removeCourse(numCourse);
    }
}
