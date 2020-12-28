package com.jwebmp.plugins.themes.mintontheme.appsearch;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.interfaces.IIcon;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.Dropdown_Item;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginRight_1;

@Accessors(chain = true)
@Getter
@Setter
public class AppSearchDropDownItem extends Link<AppSearchDropDownItem>
{
	private final Span<?, ?, ?> textSpan = new Span<>();
	private IIcon<?, ?> icon;
	
	public AppSearchDropDownItem()
	{
		super("#");
		addClass(Dropdown_Item);
		addClass("notify-item");
	}
	
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			if (this.icon != null)
			{
				this.icon.asHierarchyBase()
				         .addClass(MarginRight_1);
				add(this.icon);
			}
			add(this.textSpan);
		}
		super.preConfigure();
	}
}
