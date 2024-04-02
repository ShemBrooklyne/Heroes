package geek.wys.jstcrud.controller;

import geek.wys.jstcrud.models.Hero;
import geek.wys.jstcrud.service.HeroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shem.mwangi
 * @since 02/04/2024
 **/
@Slf4j
@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/all")
    public List<Hero> getAllHeroes() {
        return heroService.getAllHeroes();
    }

    @GetMapping("/filter/{id}")
    public Hero getHeroById(@PathVariable Long id) {
        return heroService.getHeroById(id);
    }

    @PostMapping("/create")
    public Hero createHero(@RequestBody Hero hero) {
        return heroService.createHero(hero);
    }

    @PutMapping("/update/{id}")
    public Hero updateHero(@PathVariable Long id, @RequestBody Hero hero) {
        return heroService.updateHero(id, hero);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHero(@PathVariable Long id) {
        heroService.deleteHero(id);
    }
}
