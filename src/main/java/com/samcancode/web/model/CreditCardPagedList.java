package com.samcancode.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@SuppressWarnings("serial")
public class CreditCardPagedList extends PageImpl<CreditCardDto> {

    public CreditCardPagedList(List<CreditCardDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public CreditCardPagedList(List<CreditCardDto> content) {
        super(content);
    }
}