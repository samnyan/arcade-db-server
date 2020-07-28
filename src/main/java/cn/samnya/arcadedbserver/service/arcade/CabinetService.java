package cn.samnya.arcadedbserver.service.arcade;

import cn.samnya.arcadedbserver.dao.CabinetRepository;
import cn.samnya.arcadedbserver.dao.GameRepository;
import cn.samnya.arcadedbserver.dao.HardwareRepository;
import cn.samnya.arcadedbserver.dao.LocationRepository;
import cn.samnya.arcadedbserver.model.arcade.Cabinet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Service
public class CabinetService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    HardwareRepository hardwareRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    CabinetRepository cabinetRepository;

    public Optional<Cabinet> findOne(Long id) {
        return cabinetRepository.findById(id);
    }

    public long save(Cabinet cabinet) {
        cabinetRepository.save(cabinet);
        return cabinet.getId();
    }
}
