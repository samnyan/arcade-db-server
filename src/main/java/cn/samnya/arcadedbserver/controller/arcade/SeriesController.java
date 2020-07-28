package cn.samnya.arcadedbserver.controller.arcade;

import cn.samnya.arcadedbserver.model.arcade.Series;
import cn.samnya.arcadedbserver.service.arcade.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Controller
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @GetMapping("browser")
    public String browser(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        Pageable pageRequest = PageRequest.of(page - 1, 10, Sort.by("id").descending());
        Page<Series> seriesPage = seriesService.findAll(pageRequest);
        model.addAttribute("page", seriesPage);
        model.addAttribute("seriesList", seriesPage.getContent());
        return "series/browser";
    }

    @GetMapping("new")
    public String create(Model model) {
        Series series = new Series();
        model.addAttribute("series", series);
        return "series/new";
    }

    @PostMapping("new")
    public String create(@Valid @ModelAttribute Series series, BindingResult result) {
        if (result.hasErrors()) return "series/new";
        long id = seriesService.save(series);
        return "redirect:/series/" + id;
    }

    @PostMapping("search")
    public String search(){
        return "series/browser";
    }

    @GetMapping("{id}")
    public String findById(@PathVariable Long id, Model model){
        Optional<Series> series = seriesService.findOne(id);
        model.addAttribute("series", series.orElseThrow());
        return "series/show";


    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Series series){
        series.setId(id);
        seriesService.save(series);
        return "redirect:/series";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id){
        seriesService.delete(id);
        return "redirect:/series";
    }

    @GetMapping("{id}/link")
    public String linkPage(@PathVariable Long id, Model model){
        Optional<Series> series = seriesService.findOne(id);
        model.addAttribute("series", series.orElseThrow());

        return "series/link";
    }

}
