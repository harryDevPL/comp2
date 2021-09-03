package pl.wojcik.geolocation.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.wojcik.geolocation.exception.ApiRequestException;
import pl.wojcik.geolocation.exception.ExceptionConstants;
import pl.wojcik.geolocation.model.GeoLocation;
import pl.wojcik.geolocation.model.GeoLocationRequest;
import pl.wojcik.geolocation.model.dto.GeoLocationDTO;
import pl.wojcik.geolocation.model.mapper.GeoLocationMapper;
import pl.wojcik.geolocation.repository.GeoLocationRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeoLocationService {

    private final Logger logger = LogManager.getLogger(GeoLocationService.class);
    private final GeoLocationRepository repository;

    public ResponseEntity<List<GeoLocationDTO>> getAllLocations() {
        logger.info("Finding all locations: -> repo layer");
        List<GeoLocationDTO> geoLocationDTOList = repository.findAll()
                .stream()
                .map(GeoLocationMapper::entityToDTO)
                .collect(Collectors.toList());

        if (geoLocationDTOList.isEmpty()) {
            logger.warn("Geo locationDTO list is empty.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        logger.info("Sending all locations: <- repo layer");
        return new ResponseEntity<>(geoLocationDTOList, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<GeoLocationDTO> saveToDatabase(GeoLocationRequest request) {
        if (validateGeoLocation(request)) {
            logger.info("Saving locations to DB: -> repo layer");
            GeoLocation geoLocation = GeoLocationMapper.requestToEntity(request);
            GeoLocation location = repository.save(geoLocation);
            GeoLocationDTO geoLocationDTO = GeoLocationMapper.entityToDTO(location);
            logger.info("Sending locationsDTO from DB: <- repo layer");
            return new ResponseEntity<>(geoLocationDTO, HttpStatus.CREATED);
        } else {
            throw new ApiRequestException(ExceptionConstants.BAD_REQUEST_WRONG_FORMAT);
        }
    }

    public ResponseEntity<List<GeoLocationDTO>> getLocationsInRange(String latitude, String longitude, String range) {
        // should be logic to get all locations which are in range from PathVariable
        // it can be done in many ways: get All location and then filtered, create SQL to filter locations from DB or
        // specification filtering
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.CREATED);
    }

    private boolean validateGeoLocation(GeoLocationRequest geoLocation) {
        return geoLocation.getDeviceId() != null && !geoLocation.getDeviceId().isBlank();
    }
}
