package com.abhi.example.validator;

public @interface CustomValidator {
 
	Class <? extends BaseValidator> [] value();
}
