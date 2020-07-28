package cn.samnya.arcadedbserver.dao;

import cn.samnya.arcadedbserver.model.arcade.Game;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Repository
public interface GameRepository extends PagingAndSortingRepository<Game, Long> {
}
