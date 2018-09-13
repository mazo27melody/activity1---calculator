package com.fimc.activity1.recource;

import javax.ws.rs.Path;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultResource {
	private String action;
	private double result;

}

