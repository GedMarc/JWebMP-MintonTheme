package com.jwebmp.plugins.themes.mintontheme.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class MintonUserDetails
{
	private String fullName;
	private String roleName;
	private String userImageURL;
	
}
