package com.samcancode.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@SuppressWarnings("serial")
public class BeerOrderPagedList extends PageImpl<BeerOrderDto> {
	
	//the following definition is for Jackson to map the BeerOrderPagedList object into Json
	@JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
	public BeerOrderPagedList( @JsonProperty("content") List<BeerOrderDto> content,
						  @JsonProperty("number") int number,
						  @JsonProperty("size") int size,
						  @JsonProperty("totalElements") Long totalElements,
						  @JsonProperty("pageable") JsonNode pageable,
						  @JsonProperty("last") boolean last,
						  @JsonProperty("totalPages") int totalPages,
						  @JsonProperty("sort") JsonNode sort,
						  @JsonProperty("first") boolean first,
						  @JsonProperty("numberOfElements") int numberOfElements
						) {
		super( content, PageRequest.of(number, size), totalElements );
	}
	
    public BeerOrderPagedList(List<BeerOrderDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerOrderPagedList(List<BeerOrderDto> content) {
        super(content);
    }
}