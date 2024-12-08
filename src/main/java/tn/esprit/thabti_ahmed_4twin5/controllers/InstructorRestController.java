package tn.esprit.thabti_ahmed_4twin5.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.thabti_ahmed_4twin5.entities.Instructor;
import tn.esprit.thabti_ahmed_4twin5.Services.InstructorServiceImpl;

import java.util.List;

@RestController
@Tag(name = "Gestion Instructor")
@RequiredArgsConstructor
@RequestMapping("/instructor")
public class InstructorRestController {

    private final InstructorServiceImpl instructorService;

    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }

    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.updateInstructor(instructor);
    }

    @GetMapping("/get/{numInstructor}")
    public Instructor getInstructor(@PathVariable Long numInstructor) {
        return instructorService.retrieveInstructor(numInstructor);
    }

    @GetMapping("/all")
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @DeleteMapping("/delete/{numInstructor}")
    public void deleteInstructor(@PathVariable Long numInstructor) {
        instructorService.removeInstructor(numInstructor);
    }
    @PostMapping("/addAndAssignToCourses")
    public Instructor addInstructorAndAssignToCourses(@RequestBody Instructor instructor) {
        return instructorService.addInstructorAndAssignToCourses(instructor);
    }
    @PostMapping("/addInstructorToCourses/{numCourse}")
    public Instructor addInstructorToCourses(@RequestBody Instructor instructor, @PathVariable List<Long> numCourse) {
        return instructorService.addInstructorToCourse(instructor, numCourse);
    }

}
