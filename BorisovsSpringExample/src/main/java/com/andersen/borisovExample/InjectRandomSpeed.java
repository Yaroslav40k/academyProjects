package com.andersen.borisovExample;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface InjectRandomSpeed {
	int min();
	int max();

}
