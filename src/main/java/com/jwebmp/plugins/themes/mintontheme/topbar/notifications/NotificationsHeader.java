package com.jwebmp.plugins.themes.mintontheme.topbar.notifications;

import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.Dropdown_Item;
import static com.jwebmp.plugins.bootstrap4.options.BSColoursOptions.Text_Dark;
import static com.jwebmp.plugins.bootstrap4.options.BSDefaultOptions.Float_Right;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.Margin_0;

@Accessors(chain = true)
@Getter
@Setter
public class NotificationsHeader extends DivSimple<NotificationsHeader>
{
	private final SmallText<?> clearAllText = new SmallText<>("Clear All");
	private final H5<?> header;
	
	public NotificationsHeader(String header)
	{
		addClass(Dropdown_Item);
		addClass("noti-title");
		
		this.header = new H5<>(header).addClass(Margin_0)
		                              .setRenderTextBeforeChildren(false);
		Span<GlobalChildren, ?, ?> span = new Span<>().addClass(Float_Right);
		Link<?> link = new Link<>("#");
		link.addClass(Text_Dark);
		
		link.add(this.clearAllText);
		span.add(link);
		
		this.header.add(span);
		
		add(this.header);
	}
}
