package com.jwebmp.plugins.themes.mintontheme.settings;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H6;
import com.jwebmp.core.base.html.Span;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.plugins.bootstrap4.options.BSBackgroundOptions.Bg_Light;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.Block;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.Margin_0;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.Padding_3;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Uppercase;

@Accessors(chain = true)
@Getter
@Setter
public class SettingsSummary extends DivSimple<SettingsSummary>
{
	private final List<SettingsItem> items = new ArrayList<>();
	private final DivSimple<?> paddingDiv = new DivSimple<>().addClass(Padding_3);
	
	private H6<?> header;
	
	public SettingsSummary(String header)
	{
		this.header = new H6<>();
		this.header.addClass("font-weight-medium");
		this.header.addClass("px-3");
		this.header.addClass(Margin_0);
		this.header.addClass("py-2");
		this.header.addClass("font-13");
		this.header.addClass(Text_Uppercase);
		this.header.addClass(Bg_Light);
		
		Span<?, ?, ?> headerTextSpan = new Span<>(header).addClass(Block)
		                                                 .addClass("py-1");
		
		this.header.add(headerTextSpan);
	}
	
	public SettingsSummary addItem(SettingsItem item)
	{
		this.items.add(item);
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			add(this.header);
			add(this.paddingDiv);
			this.header.init();
			this.paddingDiv.init();
			for (SettingsItem item : this.items)
			{
				item.init();
				this.paddingDiv.add(item);
			}
		}
		super.init();
	}
}
