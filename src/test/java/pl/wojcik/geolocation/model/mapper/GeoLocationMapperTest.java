package pl.wojcik.geolocation.model.mapper;

import org.junit.jupiter.api.Test;
import pl.wojcik.geolocation.model.GeoLocation;
import pl.wojcik.geolocation.model.GeoLocationRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class GeoLocationMapperTest {

    @Test
    public void shouldMapGeoLocationRequestToEntity() {
        // GIVEN
        GeoLocationRequest request = GeoLocationRequest.builder()
                .deviceId("device_id_1")
                .latitude(10203040)
                .longitude(20304050)
                .build();
        // WHEN
        GeoLocation geoLocation = GeoLocationMapper.requestToEntity(request);
        // THEN
        assertEquals(geoLocation.getDeviceId(), request.getDeviceId());
        assertEquals(geoLocation.getLongitude(), request.getLongitude());
        assertEquals(geoLocation.getLatitude(), request.getLatitude());
    }

    @Test
    public void shouldNotMapGeoLocationRequestToEntityWhenLocationIsWrongFormat() {
        // GIVEN
        GeoLocationRequest request = GeoLocationRequest.builder()
                .deviceId(null)
                .build();
        // WHEN
        GeoLocation geoLocation = GeoLocationMapper.requestToEntity(request);
        // THEN
        assertNull(geoLocation.getDeviceId());
        assertEquals(geoLocation.getLongitude(), 0);
        assertEquals(geoLocation.getLatitude(), 0);
    }
}