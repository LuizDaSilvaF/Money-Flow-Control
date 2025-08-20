package luizdasilva.moneyflowcontrol.dto.user;

import java.time.Instant;
import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email,
        Instant createdAt,
        Instant updatedAt
) {
}
