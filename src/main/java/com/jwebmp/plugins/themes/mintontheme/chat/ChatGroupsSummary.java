package com.jwebmp.plugins.themes.mintontheme.chat;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H6;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.interfaces.IIcon;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.plugins.bootstrap4.options.BSDefaultOptions.Float_Right;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginTop_2;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.Padding_2;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Uppercase;

@Accessors(chain = true)
@Getter
@Setter
public class ChatGroupsSummary extends DivSimple<ChatGroupsSummary>
{
	private final List<ChatGroupSummaryItem> items = new ArrayList<>();
	private final DivSimple<?> paddingDiv = new DivSimple<>().addClass(Padding_2);
	private H6<?> header;
	private IIcon<?, ?> headerIcon;
	
	public ChatGroupsSummary(String header)
	{
		this.header = new H6<>(header);
		this.header.addClass("font-weight-medium");
		this.header.addClass("px-3");
		this.header.addClass(MarginTop_2);
		this.header.addClass(Text_Uppercase);
	}
	
	public ChatGroupsSummary addItem(ChatGroupSummaryItem item)
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
			for (ChatGroupSummaryItem item : this.items)
			{
				this.paddingDiv.add(item);
			}
			this.header.init();
			this.paddingDiv.init();
			
			if (this.headerIcon != null)
			{
				Link<?> link = new Link<>("javascript: void(0);")
						.addClass("font-10");
				link.add(this.headerIcon);
				this.headerIcon.asHierarchyBase()
				               .addClass(Float_Right);
				this.header.add(link);
			}
		}
		super.init();
	}
}
