package cn.samnya.arcadedbserver.dao;

import cn.samnya.arcadedbserver.model.arcade.Series;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Repository
public interface SeriesRepository extends PagingAndSortingRepository<Series, Long> {

    List<Series> findByNameContaining(String name);

}
