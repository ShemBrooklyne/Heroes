package geek.wys.jstcrud.repository;

import geek.wys.jstcrud.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shem.mwangi
 * @since 02/04/2024
 **/
@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
}
