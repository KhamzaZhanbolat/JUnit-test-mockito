package MainService.MainService.controllers;

import MainService.MainService.dto.CourseDto;
import MainService.MainService.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseApi {

    private final CourseService courseService;

    @PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        log.info("CourseDto for id {}", id);
        CourseDto courseDto = courseService.getById(id);
        return courseDto;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
    @GetMapping
    public List<CourseDto> getAllCourses() {
        log.info("Courses list");
        return courseService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseDto) {
        log.info("Create course {}", courseDto.getName());
        boolean status = courseService.create(courseDto);
        if (status) {
            log.debug("Course created {}", courseDto.getName());
            return courseDto;
        }else {
            log.error("Course creation failed");
            return null;
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        log.info("Update course {}", courseDto.getName());
        return ResponseEntity.ok(courseService.update(id, courseDto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        log.info("Delete course {}", id);
        return ResponseEntity.ok(courseService.delete(id));
    }
}
