package apicourse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicourse.repositories.CourseRepository;
import apicourse.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
    CourseRepository courseRepository;

}
