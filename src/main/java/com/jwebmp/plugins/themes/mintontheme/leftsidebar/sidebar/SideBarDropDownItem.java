package com.jwebmp.plugins.themes.mintontheme.leftsidebar.sidebar;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.ListItem;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.collapse.BSCollapse;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class SideBarDropDownItem extends ListItem<SideBarDropDownItem>
{
	private final Link<?> dropdownLink = new Link<>();
	
	private final DivSimple<?> dropdownContent = new DivSimple<>();
	private final SidebarNavSecondLevel dropdownLevel = new SidebarNavSecondLevel();
	private final IIcon<?, ?> icon;
	private final ComponentHierarchyBase<?, ?, ?, ?, ?> badge;
	private boolean hideOnStart = true;
	
	public SideBarDropDownItem()
	{
		this(null);
	}
	
	public SideBarDropDownItem(String text)
	{
		this(text, null, null);
	}
	
	public SideBarDropDownItem(String text, IIcon<?, ?> icon, ComponentHierarchyBase<?, ?, ?, ?, ?> badge)
	{
		super(text);
		this.icon = icon;
		this.badge = badge;
	}
	
	public SideBarDropDownItem addItem(String text, Event<?, ?> event)
	{
		if (event != null)
		{
			setID(event.getClassCanonicalName());
		}
		dropdownLevel.add(new SideBarListItem(text, event)
				                  .addStyle("cursor", "pointer"));
		return this;
	}
	
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			BSCollapse.link(dropdownLink, dropdownContent, hideOnStart);
			
			dropdownLink.add(icon);
			dropdownLink.add(badge);
			dropdownLink.add(new Span<>(getText()));
			setText((String) null);
			dropdownLink.addStyle("cursor", "pointer");
			
			dropdownContent.add(dropdownLevel);
			
			add(dropdownLink);
			add(dropdownContent);
		}
		super.preConfigure();
	}
}
