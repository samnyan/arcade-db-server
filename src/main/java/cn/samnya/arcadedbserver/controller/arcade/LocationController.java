package cn.samnya.arcadedbserver.controller.arcade;

import cn.samnya.arcadedbserver.model.arcade.Cabinet;
import cn.samnya.arcadedbserver.model.arcade.Location;
import cn.samnya.arcadedbserver.service.arcade.CabinetService;
import cn.samnya.arcadedbserver.service.arcade.LocationService;
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
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    CabinetService cabinetService;

    @GetMapping("browser")
    public String browser(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        Pageable pageRequest = PageRequest.of(page - 1, 10, Sort.by("id").descending());
        Page<Location> locationPage = locationService.findAll(pageRequest);
        model.addAttribute("page", locationPage);
        model.addAttribute("locationList", locationPage.getContent());
        return "location/browser";
    }

    @GetMapping("new")
    public String create(Model model) {
        Location location = new Location();
        model.addAttribute("location", location);
        return "location/new";
    }

    @PostMapping("new")
    public String create(@Valid @ModelAttribute Location location, BindingResult result) {
        if (result.hasErrors()) return "location/new";
        long id = locationService.save(location);
        return "redirect:/location/"+id;
    }

    @GetMapping("{id}")
    public String findById(@PathVariable Long id, Model model) {
        Optional<Location> location = locationService.findOne(id);
        model.addAttribute("location", location.orElseThrow());

        return "location/show";
    }

    /**
     * Cabinet
     */


    @GetMapping("{id}/cabinet")
    public String showCabinetList(@PathVariable Long id, Model model) {
        Optional<Location> location = locationService.findOne(id);
        model.addAttribute("location", location.orElseThrow());
        return "location/cabinet/list";
    }

    @GetMapping("{locationId}/cabinet/{cabinetId}")
    public String showCabinet(@PathVariable Long locationId, @PathVariable Long cabinetId, Model model) {
        Optional<Cabinet> cabinet = cabinetService.findOne(cabinetId);
        model.addAttribute("cabinet", cabinet.orElseThrow());
        return "location/cabinet/show";
    }

    @GetMapping("{locationId}/cabinet/add")
    public String addCabinet(@PathVariable Long locationId, Model model) {
        Optional<Location> location = locationService.findOne(locationId);
        model.addAttribute("location", location.orElseThrow());
        Cabinet cabinet = new Cabinet();
        cabinet.setLocation(location.orElseThrow());
        model.addAttribute("cabinet",cabinet);
        return "location/cabinet/add";
    }

    @PostMapping("{locationId}/cabinet/add")
    public String addCabinet(@PathVariable Long locationId, Model model, @ModelAttribute Cabinet cabinet, BindingResult result) {
        if (result.hasErrors()) return "location/cabinet/add";
        long cabinetId = cabinetService.save(cabinet);
        return "redirect:/location/"+locationId+"/cabinet/"+cabinetId;
    }

}
