package tn.esprit.thabti_ahmed_4twin5.Services;

import tn.esprit.thabti_ahmed_4twin5.entities.Instructor;
import java.util.List;

public interface IInstructorService {
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    void removeInstructor(Long numInstructor);
    Instructor retrieveInstructor(Long numInstructor);
    List<Instructor> getAllInstructors();
}
