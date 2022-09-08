package apicourse.services;

import java.util.Optional;
import java.util.UUID;

import apicourse.models.ModuleModel;

public interface ModuleService {

	ModuleModel save(ModuleModel moduleModel);
	
	Optional<ModuleModel> findModuleIntoCourse(UUID courseId, UUID moduleId);

	void delete(ModuleModel moduleModel);

}
