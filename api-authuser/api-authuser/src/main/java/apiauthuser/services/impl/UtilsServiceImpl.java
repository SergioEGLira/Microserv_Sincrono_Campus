package apiauthuser.services.impl;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiauthuser.services.UtilsService;

@Service
public class UtilsServiceImpl implements UtilsService {
	
	String REQUEST_URI = "http://localhost:8082";
    
    public String createUrl(UUID userId, Pageable pageable) {
        return REQUEST_URI + "/courses/getAllCoursesPageable?userId=" + userId + "&page=" + pageable.getPageNumber() + "&size="
                + pageable.getPageSize() + "&sort=" + pageable.getSort().toString().replaceAll(": ", ",");
    }
}
