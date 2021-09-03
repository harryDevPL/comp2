package pl.wojcik.geolocation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoLocationRequest {
    private String deviceId;
    private long latitude;
    private long longitude;
}
