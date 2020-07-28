package cn.samnya.arcadedbserver.service.arcade;

import cn.samnya.arcadedbserver.dao.GameRepository;
import cn.samnya.arcadedbserver.dao.SeriesRepository;
import cn.samnya.arcadedbserver.model.arcade.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    SeriesRepository seriesRepository;

    public Page<Game> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    public long save(Game game) {
        gameRepository.save(game);
        return game.getId();
    }

    public Optional<Game> findOne(Long id) {
        return gameRepository.findById(id);
    }

    public void linkSeries(long game_id, long series_id) {
        gameRepository.findById(game_id).ifPresent(game -> {
            seriesRepository.findById(series_id).ifPresent(series -> {
                game.setSeries(series);
                gameRepository.save(game);
            });
        });
    }
}
