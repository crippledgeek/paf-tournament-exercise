package com.paf.exercise.entities;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Cacheable
@Table(name = "player")
public class Player extends AbstractPersistable<Long> {

    @Column(name = "name" , nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "player_tournaments", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "tournaments_id"))
    @Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "player_tournaments")
    private Set<Tournament> tournaments = new HashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ?
                                   ((HibernateProxy) o)
                                           .getHibernateLazyInitializer()
                                           .getPersistentClass() :
                                   o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ?
                                      ((HibernateProxy) this)
                                              .getHibernateLazyInitializer()
                                              .getPersistentClass() :
                                      this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Player player = (Player) o;
        return getId() != null && Objects.equals(getId(), player.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ?
               ((HibernateProxy) this)
                       .getHibernateLazyInitializer()
                       .getPersistentClass()
                       .hashCode() :
               getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + "id = " + getId() + ", " + "name = " + getName() + ")";
    }
}