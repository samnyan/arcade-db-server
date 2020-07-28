package cn.samnya.arcadedbserver.service.arcade;

import cn.samnya.arcadedbserver.dao.LocationRepository;
import cn.samnya.arcadedbserver.model.arcade.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public Page<Location> findAll(Pageable pageable) {
        return locationRepository.findAll(pageable);
    }

    public long save(Location location) {
        locationRepository.save(location);
        return location.getId();
    }

    public Optional<Location> findOne(Long id) {
        return locationRepository.findById(id);
    }

}
