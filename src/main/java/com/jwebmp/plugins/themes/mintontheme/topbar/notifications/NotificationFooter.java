package com.jwebmp.plugins.themes.mintontheme.topbar.notifications;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.interfaces.IIcon;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.Dropdown_Item;
import static com.jwebmp.plugins.bootstrap4.options.BSColoursOptions.Text_Primary;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Center;

@Accessors(chain = true)
@Getter
@Setter
public class NotificationFooter extends Link<NotificationFooter>
{
	
	public NotificationFooter(IIcon<?, ?> icon, String label)
	{
		setText(label);
		
		setRenderTextBeforeChildren(true);
		addClass(Dropdown_Item);
		addClass(Text_Center);
		addClass(Text_Primary);
		addClass("notify-item");
		addClass("notify-all");
		addStyle("cursor", "pointer");
		
		add(icon);
	}
}
