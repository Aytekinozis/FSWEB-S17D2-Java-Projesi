package com.workintech.s17d2.rest;

import com.workintech.s17d2.model.Developer;
import com.workintech.s17d2.tax.DeveloperTax;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    private Map<Integer,Developer> developers;

    private DeveloperTax developerTax;

    @Autowired
    public void DeveloperController(DeveloperTax developerTax){
        this.developerTax = developerTax;
    }

    @PostConstruct
    public void construct(){
        developers = new HashMap<>();
        System.out.println("construct init");
    }
    @GetMapping
    public List<Developer> getAll(){
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Developer getDeveloper(@PathVariable Integer id){
        return developers.get(id);
    }
    @PostMapping
    public Developer addDev(@RequestBody Developer developer){

        developers.put(developer.getId(),developer);
        return developers.get(developer.getId());
    }
    @PutMapping("/{id}")
    public Developer updateDev(@PathVariable Integer id, @RequestBody Developer developer) {
        developers.put(id, developer);
        return developers.get(id);
    }
    @DeleteMapping("/{id}")
    public Developer deleteDev(@PathVariable Integer id) {
        return developers.remove(id);
    }
}
