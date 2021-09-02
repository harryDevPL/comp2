package pl.wojcik.geolocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojcik.geolocation.model.GeoLocation;

@Repository
public interface GeoLocationRepository extends JpaRepository<GeoLocation, Long> {
}
