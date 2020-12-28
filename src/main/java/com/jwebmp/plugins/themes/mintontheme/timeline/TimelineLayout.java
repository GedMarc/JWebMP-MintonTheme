package com.jwebmp.plugins.themes.mintontheme.timeline;

import com.jwebmp.core.base.html.DivSimple;

import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.Col_12;

public class TimelineLayout extends DivSimple<TimelineLayout>
{
	public TimelineLayout(boolean leftToRight)
	{
		addClass(Col_12);
		addClass("timeline");
		if (leftToRight)
		{
			addAttribute("dir", "ltr");
		}
		else
		{
			addAttribute("dir", "rtl");
		}
	}
	
	public TimelineLayout addHeader(TimelineHeader item)
	{
		add(item);
		return this;
	}
	
	public TimelineLayout addItem(TimelineItem item)
	{
		add(item);
		return this;
	}
}
