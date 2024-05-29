package com.paf.exercise.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;
import java.rmi.server.UID;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tournament")
public class Tournament extends AbstractPersistable<Long> {

    @ManyToMany(mappedBy = "tournaments", cascade = CascadeType.PERSIST)
    private Set<Player> players = new LinkedHashSet<>();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "reward_amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal rewardAmount;

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
        Tournament that = (Tournament) o;
        return getId() != null && Objects.equals(getId(), that.getId());
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
        return getClass().getSimpleName() + "(" + "id = " + getId() + ", " + "rewardAmount = " + getRewardAmount() + ", " + "name = " + getName() + ")";
    }
}