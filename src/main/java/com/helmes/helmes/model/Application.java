package com.helmes.helmes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "APPLICATION")
public class Application extends BaseModel {

    @NotEmpty
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "TOKEN", nullable = false)
    private String token;

    @NotNull
    @AssertTrue
    @Column(name = "TERMS", nullable = false)
    private Boolean terms;

    @ManyToMany
    @JoinTable(
            name = "APPLICATION_CATEGORIES",
            joinColumns = @JoinColumn(name = "APPLICATION_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORIES_ID", referencedColumnName = "ID")
    )
    private List<Category> categories;
}
