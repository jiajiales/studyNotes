package com.hik.bean;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUId = 1L;

	private String id;
	private String name;
}