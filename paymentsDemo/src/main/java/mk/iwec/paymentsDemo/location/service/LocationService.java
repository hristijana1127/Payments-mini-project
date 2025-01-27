package mk.iwec.paymentsDemo.location.service;

import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.infrastructure.service.impl.GenericServiceImpl;
import mk.iwec.paymentsDemo.location.dto.LocationDTO;
import mk.iwec.paymentsDemo.location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocationService extends GenericServiceImpl<LocationDTO, Location, UUID> {
    public LocationService(JpaRepository<Location, UUID> repository, GeneralMapper<LocationDTO, Location> mapper) {
        super(repository, mapper);
    }
}
