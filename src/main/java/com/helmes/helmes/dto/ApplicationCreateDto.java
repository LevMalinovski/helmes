package com.helmes.helmes.dto;

import com.helmes.helmes.validation.ApplicationCategoryConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationCreateDto implements Dto {
    @NotEmpty
    private String name;

    @NotNull
    @AssertTrue
    private Boolean terms;

    @NotEmpty
    @ApplicationCategoryConstraint
    private List<Long> categories;
}
