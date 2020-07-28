package cn.samnya.arcadedbserver.service.arcade;

import cn.samnya.arcadedbserver.dao.CompanyRepository;
import cn.samnya.arcadedbserver.dao.GameRepository;
import cn.samnya.arcadedbserver.dao.SeriesRepository;
import cn.samnya.arcadedbserver.model.arcade.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    SeriesRepository seriesRepository;

    @Autowired
    GameRepository gameRepository;

    public Page<Company> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    public Optional<Company> findOne(Long id) {
        return companyRepository.findById(id);
    }

    public long save(Company company) {
        companyRepository.save(company);
        return company.getId();
    }

    public void linkSeries(long company_id, long series_id) {
        companyRepository.findById(company_id).ifPresent(company -> {
            seriesRepository.findById(series_id).ifPresent(series -> {
                company.getSeries().add(series);
                series.getCompanies().add(company);
                companyRepository.save(company);
            });
        });
    }

    public void linkGame(long company_id, long game_id) {
        companyRepository.findById(company_id).ifPresent(company -> {
            gameRepository.findById(game_id).ifPresent(game -> {
                company.getGames().add(game);
                game.getCompanies().add(company);
                companyRepository.save(company);
            });
        });
    }

    public void linkAll(long company_id) {
        companyRepository.findById(company_id).ifPresent(company -> {
            gameRepository.findAll().forEach(game -> {
                game.getCompanies().add(company);
                company.getGames().add(game);
            });
            seriesRepository.findAll().forEach(series -> {
                series.getCompanies().add(company);
                company.getSeries().add(series);
            });
            companyRepository.save(company);
        });
    }
}
