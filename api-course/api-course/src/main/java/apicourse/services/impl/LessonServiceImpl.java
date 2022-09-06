package apicourse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicourse.repositories.LessonRepository;
import apicourse.services.LessonService;

@Service
public class LessonServiceImpl implements LessonService {
	
	@Autowired
    LessonRepository lessonRepository;

}
