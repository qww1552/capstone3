package kr.ac.jejunu.capstone.exception;

import lombok.*;
import java.time.ZonedDateTime;


@RequiredArgsConstructor
@Builder
@Getter
public class ApiException {
    private final Integer statusCode;

    private final String message;
    private final ZonedDateTime data;
}
