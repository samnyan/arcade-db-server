package cn.samnya.arcadedbserver.controller.arcade;

import cn.samnya.arcadedbserver.model.arcade.Game;
import cn.samnya.arcadedbserver.service.arcade.GameService;
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
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("browser")
    public String browser(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        Pageable pageRequest = PageRequest.of(page - 1, 10, Sort.by("id").descending());
        Page<Game> gamePage = gameService.findAll(pageRequest);
        model.addAttribute("page", gamePage);
        model.addAttribute("gameList", gamePage.getContent());
        return "game/browser";
    }

    @GetMapping("new")
    public String create(Model model) {
        Game game = new Game();
        model.addAttribute("game", game);
        return "game/new";
    }

    @PostMapping("new")
    public String create(@Valid @ModelAttribute Game game, BindingResult result) {
        if (result.hasErrors()) return "game/new";
        long id = gameService.save(game);
        return "redirect:/game/"+id;
    }

    @GetMapping("{id}")
    public String detail(@PathVariable Long id, Model model){
        Optional<Game> game = gameService.findOne(id);
        model.addAttribute("game", game.orElseThrow());

        return "game/show";
    }

    @GetMapping("{id}/link")
    public String linkPage(@PathVariable Long id, Model model){
        Optional<Game> game = gameService.findOne(id);
        model.addAttribute("game", game.orElseThrow());

        return "game/link";
    }

    @PostMapping("{id}/link")
    public String createLink(@PathVariable long id, @RequestParam long series_id) {
        gameService.linkSeries(id,series_id);
        return "redirect:/game/"+id;
    }
}
