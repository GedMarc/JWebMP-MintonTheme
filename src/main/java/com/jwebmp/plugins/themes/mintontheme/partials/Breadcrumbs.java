package com.jwebmp.plugins.themes.mintontheme.partials;

import com.jwebmp.core.base.html.List;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.children.ListChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;

import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.Margin_0;

public class Breadcrumbs extends List<ListChildren, NoAttributes, GlobalEvents, Breadcrumbs>
{
	public Breadcrumbs()
	{
		super(true);
		addClass("breadcrumb");
		addClass(Margin_0);
	}
	
	public Breadcrumbs addCrumb(BreadcrumbItem item)
	{
		add(item);
		return this;
	}
}
