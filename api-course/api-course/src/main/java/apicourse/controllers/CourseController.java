package apicourse.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apicourse.models.CourseModel;
import apicourse.services.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
    CourseService courseService;
	
	@DeleteMapping("/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable(value="courseId") UUID courseId){
        Optional<CourseModel> courseModelOptional = courseService.findById(courseId);
        if(!courseModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não existe.");
        }
        courseService.delete(courseModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deletamos o curso com sucesso!");
    }

}
