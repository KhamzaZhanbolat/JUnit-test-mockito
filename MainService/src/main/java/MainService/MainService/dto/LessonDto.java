package MainService.MainService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonDto {

    private Long id;
    private String name;
    private String description;
    private String content;
    private int sequenceOrder;
    private int chapterId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
