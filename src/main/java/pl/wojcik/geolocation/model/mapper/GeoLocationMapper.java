package pl.wojcik.geolocation.model.mapper;

import pl.wojcik.geolocation.model.GeoLocation;
import pl.wojcik.geolocation.model.dto.GeoLocationDTO;

public class GeoLocationMapper {

    public static GeoLocationDTO entityToDTO(GeoLocation geoLocation) {
        return GeoLocationDTO.builder()
                .dtoId(geoLocation.getId())
                .deviceId(geoLocation.getDeviceId())
                .latitude(geoLocation.getLatitude())
                .longitude(geoLocation.getLongitude())
                .build();
    }
}
