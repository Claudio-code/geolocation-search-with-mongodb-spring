package com.search.geolocationsearchwithmongodbspring.factory;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
public class PageableFactory implements FactoryInterface<Pageable> {
    private Integer page;
    private Integer size;
    
    @Override
    public Pageable make() {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }

        return PageRequest.of(page, size);
    }    
}
