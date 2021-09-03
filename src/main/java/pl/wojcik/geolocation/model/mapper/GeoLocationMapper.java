package pl.wojcik.geolocation.model.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.wojcik.geolocation.model.GeoLocation;
import pl.wojcik.geolocation.model.GeoLocationRequest;
import pl.wojcik.geolocation.model.dto.GeoLocationDTO;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GeoLocationMapper {

    public static GeoLocationDTO entityToDTO(GeoLocation geoLocation) {
        if (Objects.nonNull(geoLocation.getDeviceId())) {
            return GeoLocationDTO.builder()
                    .dtoId(geoLocation.getId())
                    .deviceId(geoLocation.getDeviceId())
                    .latitude(geoLocation.getLatitude())
                    .longitude(geoLocation.getLongitude())
                    .build();
        }
        return GeoLocationDTO.builder().build();
    }

    public static GeoLocation requestToEntity(GeoLocationRequest request) {
        if (Objects.nonNull(request.getDeviceId())) {
            return GeoLocation.builder()
                    .deviceId(request.getDeviceId())
                    .latitude(request.getLatitude())
                    .longitude(request.getLongitude())
                    .build();
        }
        return GeoLocation.builder().build();
    }
}
