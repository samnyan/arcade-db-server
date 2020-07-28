package cn.samnya.arcadedbserver.controller.arcade;

import cn.samnya.arcadedbserver.model.arcade.Company;
import cn.samnya.arcadedbserver.service.arcade.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("browser")
    public String index(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        Pageable pageRequest = PageRequest.of(page - 1, 10, Sort.by("id").descending());
        Page<Company> companyPage = companyService.findAll(pageRequest);
        model.addAttribute("page", companyPage);
        model.addAttribute("companyList", companyPage.getContent());
        return "company/browser";
    }

    @GetMapping("new")
    public String create(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "company/new";
    }

    @PostMapping("new")
    public String create(@Valid @ModelAttribute Company company, BindingResult result) {
        if (result.hasErrors()) return "company/new";
        long id = companyService.save(company);
        return "redirect:/company/"+id;
    }

    @GetMapping("{id}")
    public String findById(@PathVariable Long id, Model model){
        Optional<Company> company = companyService.findOne(id);
        model.addAttribute("company", company.orElseThrow());

        return "company/show";
    }

    /**
     * Linking
     */

    @GetMapping("{id}/link")
    public String linkPage(@PathVariable Long id, Model model){
        Optional<Company> company = companyService.findOne(id);
        model.addAttribute("company", company.orElseThrow());

        return "company/link";
    }

    @PostMapping("{id}/link")
    public String createLink(@PathVariable long id, @RequestParam String type, @RequestParam long target_id) {
        switch(type) {
            case "series": companyService.linkSeries(id,target_id); break;
            case "game": companyService.linkGame(id,target_id); break;
        }

        return "redirect:/company/"+id;
    }

//    @GetMapping("{id}/linkall")
//    public String linkall(@PathVariable long id) {
//            companyService.linkAll(id);
//        return "redirect:/company/"+id;
//    }
}
