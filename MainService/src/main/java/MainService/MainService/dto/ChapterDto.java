package MainService.MainService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDto {

    private Long id;
    private String name;
    private String description;
    private int sequenceOrder;
    private Long courseId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
