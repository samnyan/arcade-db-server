package cn.samnya.arcadedbserver.service.arcade;

import cn.samnya.arcadedbserver.dao.HardwareRepository;
import cn.samnya.arcadedbserver.model.arcade.Hardware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Service
public class HardwareService {

    @Autowired
    HardwareRepository hardwareRepository;

    public Page<Hardware> findAll(Pageable pageable) {
        return hardwareRepository.findAll(pageable);
    }

    public long save(Hardware hardware) {
        hardwareRepository.save(hardware);
        return hardware.getId();
    }

    public Optional<Hardware> findOne(Long id) {
        return hardwareRepository.findById(id);
    }
}
