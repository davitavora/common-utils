package com.github.davitavorah.model;

import io.vavr.control.Option;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Min;

@Setter
@Getter
@NoArgsConstructor
public class SearchParams {

    private String order;

    private String filter;

    @Min(value = 1, message = "O valor mínimo para o tamanho da página é {value}.")
    private Integer size = 5;

    @Min(value = 0, message = "O valor mínimo de página é {value}.")
    private Integer page = 0;

    public String getFilter() {
        return Option.of(filter).map((i) -> "%" + i + "%").getOrElse("%%");
    }

    public Pageable getPageable() {
        var page = getPage();
        var size = getSize();
        var sort = getOrder().startsWith("-") ?
                Sort.by(getOrder().substring(1)).descending() : Sort.by(getOrder()).ascending();

        return PageRequest.of(page, size, sort);
    }

}
