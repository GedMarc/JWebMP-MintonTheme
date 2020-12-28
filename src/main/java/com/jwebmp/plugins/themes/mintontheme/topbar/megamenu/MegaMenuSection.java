package com.jwebmp.plugins.themes.mintontheme.topbar.megamenu;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.H5;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.List;
import com.jwebmp.core.base.html.ListItem;
import com.jwebmp.plugins.bootstrap4.containers.BSColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.options.BSColoursOptions.Text_Dark;
import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.Col;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginTop_0;

@Accessors(chain = true)
@Getter
@Setter
public class MegaMenuSection extends BSColumn<MegaMenuSection>
{
	private H5<?> header;
	private List itemList = new List<>();
	
	public MegaMenuSection(String headerText)
	{
		super(Col);
		this.header = new H5<>(headerText);
		this.header.addClass(Text_Dark);
		this.header.addClass(MarginTop_0);
		this.itemList.addClass("list-unstyled");
		this.itemList.addClass("megamenu-list");
		
		add(this.header);
		add(this.itemList);
	}
	
	public MegaMenuSection addItem(String text, Event<?, ?> event)
	{
		ListItem<?> li = new ListItem<>();
		Link<?> link = new Link<>("javascript:void(0);");
		link.setText(text);
		li.add(link);
		if (event != null)
		{
			li.addEvent(event);
		}
		this.itemList.add(li);
		return this;
	}
}
