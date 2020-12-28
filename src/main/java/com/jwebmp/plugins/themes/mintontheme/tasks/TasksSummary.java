package com.jwebmp.plugins.themes.mintontheme.tasks;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H6;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.options.BSBackgroundOptions;
import com.jwebmp.plugins.bootstrap4.options.BSColoursOptions;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.plugins.bootstrap4.options.BSDefaultOptions.Float_Right;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.Block;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.Margin_0;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.Padding_2;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.Padding_3;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Reset;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Uppercase;

@Accessors(chain = true)
@Getter
@Setter
public class TasksSummary extends DivSimple<TasksSummary>
{
	private final List<TaskSummaryItem> items = new ArrayList<>();
	private final DivSimple<?> paddingDiv = new DivSimple<>().addClass("px-2");
	
	private H6<?> header;
	private IIcon<?, ?> headerIcon;
	
	private BSBackgroundOptions backgroundOptions;
	private BSColoursOptions coloursOptions;
	
	private Link<?> link = new Link<>("javascript: void(0);")
			.addClass(Text_Reset)
			.addClass("item-hovered")
			.addClass(Block)
			.addClass(Padding_2);
	
	
	public TasksSummary(String header)
	{
		this.header = new H6<>(header);
		this.header.addClass("font-weight-medium");
		this.header.addClass(Padding_3);
		this.header.addClass(Margin_0);
		this.header.addClass(Text_Uppercase);
	}
	
	public TasksSummary addItem(TaskSummaryItem item)
	{
		this.items.add(item);
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			for (TaskSummaryItem item : this.items)
			{
				this.paddingDiv.add(item);
			}
			if (this.headerIcon != null)
			{
				Link<?> link = new Link<>("javascript: void(0);")
						.addClass("font-10");
				link.add(this.headerIcon);
				this.headerIcon.asHierarchyBase()
				               .addClass(Float_Right);
				this.header.add(link);
			}
			add(this.header);
			add(this.paddingDiv);
			this.header.init();
			this.paddingDiv.init();
		}
		super.init();
	}
}
