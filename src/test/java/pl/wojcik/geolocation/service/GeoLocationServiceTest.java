package pl.wojcik.geolocation.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.wojcik.geolocation.repository.GeoLocationRepository;

class GeoLocationServiceTest {

    @Autowired
    private GeoLocationRepository repository;

    @BeforeEach
    void clearRepo() {
        repository.deleteAll();
    }

    @AfterEach
    void clearRepoAfterTests() {
        repository.deleteAll();
    }

    @Test
    public void shouldGetAllLocationsWhenRepositoryIsNotEmpty() {
        // MOCK
        // more testing is in the 3rd project
    }

}