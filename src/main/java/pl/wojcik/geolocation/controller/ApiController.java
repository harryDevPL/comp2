package pl.wojcik.geolocation.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wojcik.geolocation.model.GeoLocationRequest;
import pl.wojcik.geolocation.model.dto.GeoLocationDTO;
import pl.wojcik.geolocation.service.GeoLocationService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class ApiController {

    private final Logger logger = LoggerFactory.getLogger(ApiController.class);
    private final GeoLocationService service;

    @GetMapping("/locations")
    public ResponseEntity<List<GeoLocationDTO>> getAllGeoLocations() {
        logger.info("Get all locations: -> service layer");
        return service.getAllLocations();
    }

    @GetMapping("/location/{latitude}/{longitude}/{range}")
    public ResponseEntity<List<GeoLocationDTO>> getLocationsInRange(@PathVariable String latitude, @PathVariable String longitude, @PathVariable String range) {
        return service.getLocationsInRange(latitude, longitude, range);
    }

    @PostMapping("/location/create")
    public ResponseEntity<GeoLocationDTO> createGeoLocation(@RequestBody GeoLocationRequest request) {
        logger.info("Create geo location: -> service layer");
        return service.saveToDatabase(request);
    }
}
