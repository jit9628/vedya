package com.ecommarce.api.entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Component
@ToString
public class EmailDetails {
	    private String recipient;
	    private String msgBody;
	    private String subject;
	    private String attachment;
}
