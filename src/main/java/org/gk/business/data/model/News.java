package org.gk.business.data.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor()
public class News {
    @EqualsAndHashCode.Include
    @NonNull
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String message;
    @NonNull
    private Date time;
    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;
}
