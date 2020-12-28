package com.jwebmp.plugins.themes.mintontheme.leftsidebar.sidebar;

import com.jwebmp.core.base.html.List;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.children.ListChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class SidebarNavSecondLevel
		extends List<ListChildren, NoAttributes, GlobalEvents, SidebarNavSecondLevel>
{
	public SidebarNavSecondLevel()
	{
		super(false);
		addClass("nav-second-level");
	}
}
