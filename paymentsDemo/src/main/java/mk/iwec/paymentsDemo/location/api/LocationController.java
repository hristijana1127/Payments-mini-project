package mk.iwec.paymentsDemo.location.api;

import mk.iwec.paymentsDemo.infrastructure.Endpoints;
import mk.iwec.paymentsDemo.location.dto.LocationDTO;
import mk.iwec.paymentsDemo.location.model.Location;
import mk.iwec.paymentsDemo.location.service.LocationService;
import mk.iwec.paymentsDemo.payment.dto.PaymentDTO;
import mk.iwec.paymentsDemo.payment.service.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Endpoints.LOCATION)
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable UUID uuid){
        return ResponseEntity.ok(locationService.findById(uuid));
    }

    @GetMapping
    public ResponseEntity<Page<LocationDTO>> getAllLocations(Pageable pageable){
        Page<LocationDTO> locations = locationService.findAll(pageable);
        return ResponseEntity.ok(locations);
    }
    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO){
        return new ResponseEntity<>(locationService.save(locationDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable UUID uuid, @RequestBody LocationDTO locationDTO){
        return ResponseEntity.ok(locationService.update(uuid,locationDTO));
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteLocation(@PathVariable UUID uuid){
        locationService.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}
