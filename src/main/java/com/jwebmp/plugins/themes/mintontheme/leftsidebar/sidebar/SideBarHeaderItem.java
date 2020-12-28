package com.jwebmp.plugins.themes.mintontheme.leftsidebar.sidebar;

import com.jwebmp.core.base.html.ListItem;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Getter
@Setter
public class SideBarHeaderItem extends ListItem<SideBarHeaderItem>
{

    public SideBarHeaderItem()
    {
        this(null);
    }

    public SideBarHeaderItem(String text)
    {
        super(text);
        addClass("menu-title");
    }

}
