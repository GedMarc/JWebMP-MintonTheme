package com.jwebmp.plugins.themes.mintontheme.partials;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.ListItem;

public class BreadcrumbItem extends ListItem<BreadcrumbItem>
{
	public BreadcrumbItem(String title)
	{
		this(title, false, null);
	}
	
	public BreadcrumbItem(String title, Event<?, ?> event)
	{
		this(title, false, event);
	}
	
	public BreadcrumbItem(String title, boolean active)
	{
		this(title, active, null);
	}
	
	public BreadcrumbItem(String title, boolean active, Event<?, ?> event)
	{
		addClass("breadcrumb-item");
		if (active)
		{
			addClass("active");
		}
		Link<?> link = new Link<>("javascript: void(0);");
		link.setText(title);
		add(link);
		
		if (event != null)
		{
			addEvent(event);
		}
	}
}
