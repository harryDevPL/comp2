package pl.wojcik.geolocation.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class GeoLocationDTO {
    private Long dtoId;
    private String deviceId;
    private long latitude;
    private long longitude;
}
