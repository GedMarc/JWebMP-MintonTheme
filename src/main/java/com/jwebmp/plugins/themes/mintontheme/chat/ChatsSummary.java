package com.jwebmp.plugins.themes.mintontheme.chat;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H6;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.interfaces.IIcon;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.plugins.bootstrap4.buttons.BSButtonOptions.Btn_White;
import static com.jwebmp.plugins.bootstrap4.buttons.BSButtonSizeOptions.Btn;
import static com.jwebmp.plugins.bootstrap4.buttons.BSButtonSizeOptions.Btn_Sm;
import static com.jwebmp.plugins.bootstrap4.options.BSDefaultOptions.Float_Right;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.Padding_2;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Center;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Uppercase;

@Accessors(chain = true)
@Getter
@Setter
public class ChatsSummary extends DivSimple<ChatsSummary>
{
	private final List<ChatSummaryItem> items = new ArrayList<>();
	private final DivSimple<?> paddingDiv = new DivSimple<>().addClass(Padding_2);
	private H6<?> header;
	private IIcon<?, ?> headerIcon;
	
	private Event<?, ?> loadMoreEvent;
	private IIcon<?, ?> loadMoreIcon;
	private String loadMoreButtonText;
	
	public ChatsSummary(String header)
	{
		this.header = new H6<>(header);
		this.header.addClass("font-weight-medium");
		this.header.addClass("px-3");
		this.header.addClass(MarginTop_2);
		this.header.addClass(Text_Uppercase);
	}
	
	public ChatsSummary addItem(ChatSummaryItem item)
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
			for (ChatSummaryItem item : this.items)
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
			
			if (this.loadMoreButtonText != null)
			{
				DivSimple<?> moreDiv = new DivSimple<>().addClass(Text_Center)
				                                        .addClass(MarginTop_3);
				Link<?> link = new Link<>("javascript:void(0);");
				link.addClass(Btn);
				link.addClass(Btn_Sm);
				link.addClass(Btn_White);
				if (this.loadMoreIcon != null)
				{
					this.loadMoreIcon.asHierarchyBase()
					                 .addClass(MarginRight_2);
					link.add(this.loadMoreIcon);
				}
				link.setText(this.loadMoreButtonText);
				link.setRenderTextBeforeChildren(false);
				if (this.loadMoreEvent != null)
				{
					link.addEvent(this.loadMoreEvent);
				}
				moreDiv.add(link);
				add(moreDiv);
			}
		}
		super.init();
	}
}
