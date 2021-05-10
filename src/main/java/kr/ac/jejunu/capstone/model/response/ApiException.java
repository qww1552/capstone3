package kr.ac.jejunu.capstone.model.response;

import lombok.*;
import java.time.ZonedDateTime;


@RequiredArgsConstructor
@Builder
@Getter
public class ApiException {
    private final Integer status;
    private final String message;
    private final ZonedDateTime timestamp;
}
