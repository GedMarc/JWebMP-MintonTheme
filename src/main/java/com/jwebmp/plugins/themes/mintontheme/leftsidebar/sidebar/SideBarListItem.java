package com.jwebmp.plugins.themes.mintontheme.leftsidebar.sidebar;

import com.google.common.base.Strings;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.ListItem;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class SideBarListItem extends ListItem<SideBarListItem>
{
    private final Link<?> link = new Link<>("#");

    public SideBarListItem()
    {
        this(null, null);
    }

    public SideBarListItem(String text, Event<?, ?> goToEvent)
    {
        super(null);
        if (!Strings.isNullOrEmpty(text))
        {
            link.setText(text);
        }
        if (goToEvent != null)
        {
            link.addEvent(goToEvent);
        }
        add(link);
    }

    public SideBarListItem setDisabled(boolean disabled)
    {
        if (disabled)
        {
            addAttribute("disabled", "");
        } else
        {
            removeAttribute("disabled");
        }
        return this;
    }

}
