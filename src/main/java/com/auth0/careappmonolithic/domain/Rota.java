package com.auth0.careappmonolithic.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Rota.
 */
@Entity
@Table(name = "rota")
public class Rota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "client", nullable = false)
    private String client;

    @NotNull
    @Column(name = "carer", nullable = false)
    private String carer;

    @NotNull
    @Column(name = "time", nullable = false)
    private Instant time;

    @NotNull
    @Column(name = "duration", nullable = false)
    private Duration duration;

    @OneToMany(mappedBy = "rota")
    @JsonIgnoreProperties(value = { "visit", "rota", "client" }, allowSetters = true)
    private Set<Carer> carers = new HashSet<>();

    @JsonIgnoreProperties(value = { "rota", "carer", "client" }, allowSetters = true)
    @OneToOne(mappedBy = "rota")
    private Visit visit;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Rota id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return this.client;
    }

    public Rota client(String client) {
        this.setClient(client);
        return this;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getCarer() {
        return this.carer;
    }

    public Rota carer(String carer) {
        this.setCarer(carer);
        return this;
    }

    public void setCarer(String carer) {
        this.carer = carer;
    }

    public Instant getTime() {
        return this.time;
    }

    public Rota time(Instant time) {
        this.setTime(time);
        return this;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public Duration getDuration() {
        return this.duration;
    }

    public Rota duration(Duration duration) {
        this.setDuration(duration);
        return this;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Set<Carer> getCarers() {
        return this.carers;
    }

    public void setCarers(Set<Carer> carers) {
        if (this.carers != null) {
            this.carers.forEach(i -> i.setRota(null));
        }
        if (carers != null) {
            carers.forEach(i -> i.setRota(this));
        }
        this.carers = carers;
    }

    public Rota carers(Set<Carer> carers) {
        this.setCarers(carers);
        return this;
    }

    public Rota addCarer(Carer carer) {
        this.carers.add(carer);
        carer.setRota(this);
        return this;
    }

    public Rota removeCarer(Carer carer) {
        this.carers.remove(carer);
        carer.setRota(null);
        return this;
    }

    public Visit getVisit() {
        return this.visit;
    }

    public void setVisit(Visit visit) {
        if (this.visit != null) {
            this.visit.setRota(null);
        }
        if (visit != null) {
            visit.setRota(this);
        }
        this.visit = visit;
    }

    public Rota visit(Visit visit) {
        this.setVisit(visit);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rota)) {
            return false;
        }
        return id != null && id.equals(((Rota) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Rota{" +
            "id=" + getId() +
            ", client='" + getClient() + "'" +
            ", carer='" + getCarer() + "'" +
            ", time='" + getTime() + "'" +
            ", duration='" + getDuration() + "'" +
            "}";
    }
}
