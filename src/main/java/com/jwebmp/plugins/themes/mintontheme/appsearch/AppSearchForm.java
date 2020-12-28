package com.jwebmp.plugins.themes.mintontheme.appsearch;

import com.jwebmp.core.base.html.Form;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class AppSearchForm extends Form<AppSearchForm>
{
	private final AppSearchDropDown dropDown = new AppSearchDropDown();
	
	public AppSearchForm()
	{
		addClass("app-search");
		add(this.dropDown);
	}
}
