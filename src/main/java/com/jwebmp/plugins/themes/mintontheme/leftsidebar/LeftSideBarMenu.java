package com.jwebmp.plugins.themes.mintontheme.leftsidebar;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.List;
import com.jwebmp.core.base.html.interfaces.children.ListChildren;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class LeftSideBarMenu extends DivSimple<LeftSideBarMenu>
{
    private final List<ListChildren,?,?,?> menuList = new List<>();

    public LeftSideBarMenu()
    {
        setID("sidebar-menu");

        menuList.setID("side-menu");
        add(menuList);
    }
}
