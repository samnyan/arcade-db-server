package cn.samnya.arcadedbserver.service.arcade;

import cn.samnya.arcadedbserver.dao.SeriesRepository;
import cn.samnya.arcadedbserver.model.arcade.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    public Page<Series> findAll(Pageable pageable) {
        return seriesRepository.findAll(pageable);
    }

    public Optional<Series> findOne(Long id) {
        return seriesRepository.findById(id);
    }

    public long save(Series series) {
        seriesRepository.save(series);
        return series.getId();
    }

    public void delete(Long id) {
        seriesRepository.deleteById(id);
    }
}
