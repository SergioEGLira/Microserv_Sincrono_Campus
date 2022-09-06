package apicourse.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import apicourse.enums.CourseLevel;
import apicourse.enums.CourseStatus;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_COURSES")
public class CourseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID courseId;
	@Column(nullable = false, length = 150)
	private String name;
	@Column(nullable = false, length = 250)
	private String description;
	@Column
	private String imageUrl;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@Column(nullable = false)
	private LocalDateTime creationDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@Column(nullable = false)
	private LocalDateTime lastUpdateDate;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CourseStatus courseStatus;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CourseLevel courseLevel;
	@Column(nullable = false)
	private UUID userInstructor;

}
