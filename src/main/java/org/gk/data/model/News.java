package org.gk.data.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class News {
    @EqualsAndHashCode.Include
    private Long id;
    private String message;
    private Date time;
}
