package com.jwebmp.plugins.themes.mintontheme.leftsidebar.sidebar;

import com.google.common.base.Strings;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.ListItem;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.interfaces.IIcon;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class SideBarIconListItem extends ListItem<SideBarIconListItem>
{
    private final Link<?> link = new Link<>("#");
    private final Span<?, ?, ?> textSpan = new Span<>();

    public SideBarIconListItem()
    {
        this(null,null, null);
    }

    public SideBarIconListItem(String text, IIcon<?,?> icon, Event<?, ?> goToEvent)
    {
        super(null);
        link.add(icon);

        if (!Strings.isNullOrEmpty(text))
        {
            textSpan.setText(text);
            link.add(textSpan);
        }
        if (goToEvent != null)
        {
            link.addEvent(goToEvent);
        }
        add(link);
    }

    public SideBarIconListItem setDisabled(boolean disabled)
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
