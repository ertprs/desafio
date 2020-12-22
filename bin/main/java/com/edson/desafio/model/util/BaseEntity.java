package com.edson.desafio.model.util;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 7322714083484721792L;

	public abstract Integer getId();

	public abstract void setId(Integer id);

}
