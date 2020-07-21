package com.github.davitavorah.common.util;

import com.github.davitavorah.model.SearchParams;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static java.lang.String.format;

public class ControllerUtils {

    public static <T, E extends SearchParams> ResponseEntity<List<T>> buildPaginatedResponse(Page<T> page, E  parameters) {
        var content = page.getContent();
        var length = content.size();
        var total = page.getTotalElements();
        var offset = parameters.getPage() * parameters.getSize();
        var contentRange = content.isEmpty() ? "0-0/0" : format("%d-%d/%d", offset, length, total);
        return ResponseEntity.status(HttpStatus.OK).header("Content-Range", contentRange).body(content);
    }

}
