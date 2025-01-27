package mk.iwec.paymentsDemo.location.mapper;


import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.location.dto.LocationDTO;
import mk.iwec.paymentsDemo.location.model.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper extends GeneralMapper<LocationDTO, Location> {
}
