package apicourse.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicourse.models.LessonModel;
import apicourse.repositories.LessonRepository;
import apicourse.services.LessonService;

@Service
public class LessonServiceImpl implements LessonService {
	
	@Autowired
    LessonRepository lessonRepository;

	@Override
    public LessonModel save(LessonModel lessonModel) {
        return lessonRepository.save(lessonModel);
    }

	@Override
    public Optional<LessonModel> findLessonIntoModule(UUID moduleId, UUID lessonId) {
        return lessonRepository.findLessonIntoModule(moduleId, lessonId);
    }

	@Override
    public void delete(LessonModel lessonModel) {
        lessonRepository.delete(lessonModel);
    }

	@Override
    public List<LessonModel> findAllByModule(UUID moduleId) {
        return lessonRepository.findAllLessonsIntoModule(moduleId);
    }

}
