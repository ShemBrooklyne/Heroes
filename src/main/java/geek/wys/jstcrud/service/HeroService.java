package geek.wys.jstcrud.service;

import geek.wys.jstcrud.models.Hero;
import geek.wys.jstcrud.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    public Hero getHeroById(Long id) {
        return heroRepository.findById(id).orElse(null);
    }

    public Hero createHero(Hero hero) {
        return heroRepository.save(hero);
    }

    public Hero updateHero(Long id, Hero hero) {
        Hero existingHero = heroRepository.findById(id).orElse(null);
        if (existingHero != null) {
            existingHero.setName(hero.getName());
            existingHero.setAlias(hero.getAlias());
            existingHero.setSuperPower(hero.getSuperPower());
            return heroRepository.save(existingHero);
        } else {
            return null;
        }
    }

    public void deleteHero(Long id) {
        heroRepository.deleteById(id);
    }
}
