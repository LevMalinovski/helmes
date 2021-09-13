package com.helmes.helmes.dto;

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
public class ApplicationDto implements DtoWithId {

    @NotNull
    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    @AssertTrue
    private Boolean terms;

    @NotEmpty
    private List<CategoryDto> categories;
}
