package MainService.MainService.controllers;

import MainService.MainService.dto.LessonDto;
import MainService.MainService.service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/lesson")
@RequiredArgsConstructor
public class LessonApi {

    private final LessonService lessonService;

    @PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> getLessonById(@PathVariable Long id) {
        log.info("Get lesson: {}", id);
        return  ResponseEntity.ok(lessonService.getById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
    @GetMapping
    public List<LessonDto> getAllLessons() {
        log.info("Get all lessons");
        return lessonService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<LessonDto> createLesson(@RequestBody LessonDto lesson) {
        log.info("Create lesson: {}", lesson.getName());
        return  ResponseEntity.ok(lessonService.create(lesson));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<LessonDto> updateLesson(@PathVariable Long id, @RequestBody LessonDto lesson) {
        log.info("Update lesson: {}", lesson.getName());
        return  ResponseEntity.ok(lessonService.update(id, lesson));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLesson(@PathVariable Long id) {
        log.info("Delete lesson: {}", id);
        return ResponseEntity.ok(lessonService.delete(id));
    }
}
