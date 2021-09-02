package pl.wojcik.geolocation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GeoLocation {

    @Id
    private Long id;
    private String deviceId;
    private long latitude;
    private long longitude;
}
