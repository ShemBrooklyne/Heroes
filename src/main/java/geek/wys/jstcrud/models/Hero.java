package geek.wys.jstcrud.models;

import jakarta.persistence.*;

/**
 * @author shem.mwangi
 * @since 02/04/2024
 **/
@Entity
@Table(name = "heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String alias;

    @Column(name = "super_power")
    private String superPower;

    public Hero() {
    }

    public Hero(Long id, String name, String alias, String superPower) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.superPower = superPower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }
}
