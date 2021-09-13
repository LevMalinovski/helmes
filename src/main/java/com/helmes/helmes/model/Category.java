package com.helmes.helmes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CATEGORY")
public class Category extends BaseModel {
    @NotEmpty
    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "parent_id")
    private Category parent;

    @BatchSize(size = 100)
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH},
            mappedBy = "parent")
    private List<Category> children;
}
