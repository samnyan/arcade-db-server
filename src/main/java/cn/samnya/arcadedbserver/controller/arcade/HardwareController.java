package cn.samnya.arcadedbserver.controller.arcade;

import cn.samnya.arcadedbserver.model.arcade.Hardware;
import cn.samnya.arcadedbserver.service.arcade.HardwareService;
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
@RequestMapping("/hardware")
public class HardwareController {

    @Autowired
    HardwareService hardwareService;

    @GetMapping("browser")
    public String index(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        Pageable pageRequest = PageRequest.of(page - 1, 10, Sort.by("id").descending());
        Page<Hardware> hardwarePage = hardwareService.findAll(pageRequest);
        model.addAttribute("page", hardwarePage);
        model.addAttribute("hardwareList", hardwarePage.getContent());
        return "hardware/browser";
    }

    @GetMapping("new")
    public String create(Model model) {
        Hardware hardware = new Hardware();
        model.addAttribute("hardware", hardware);
        return "hardware/new";
    }

    @PostMapping("new")
    public String create(@Valid @ModelAttribute Hardware hardware, BindingResult result) {
        if (result.hasErrors()) return "hardware/new";
        long id = hardwareService.save(hardware);
        return "redirect:/hardware/"+id;
    }

    @GetMapping("{id}")
    public String findById(@PathVariable Long id, Model model) {
        Optional<Hardware> hardware = hardwareService.findOne(id);
        model.addAttribute("hardware", hardware.orElseThrow());

        return "hardware/show";
    }
}
