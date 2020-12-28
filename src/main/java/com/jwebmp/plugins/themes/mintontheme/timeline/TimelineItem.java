package com.jwebmp.plugins.themes.mintontheme.timeline;

import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IIcon;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.Col_12;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginBottom_0;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginTop_0;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Muted;

@Accessors(chain = true)
@Getter
@Setter
public class TimelineItem extends DivSimple<TimelineItem>
{
	private final DivSimple<?> timelineDiv = new DivSimple<>().addClass("timeline-desk")
	                                                          .addClass(Col_12);
	private final DivSimple<?> timelineBox = new DivSimple<>().addClass("timeline-box");
	private IIcon<?, ?> timelineIcon;
	
	public TimelineItem(boolean right)
	{
		setTag("article");
		addClass("timeline-item");
		addClass("row");
		if (!right)
		{
			addClass("timeline-item-left");
		}
	}
	
	public TimelineItem addArrow(boolean right)
	{
		Span<?, ?, ?> arrow = new Span<>();
		if (right)
		{
			arrow.addClass("arrow");
		}
		else
		{
			addClass("timeline-item-left");
			arrow.addClass("arrow-alt");
		}
		timelineBox.add(0, arrow);
		return this;
	}
	
	public TimelineItem addHeading(String heading)
	{
		timelineBox.add(new H4<>(heading).addClass(MarginTop_0)
		                                 .addClass("font-16"));
		return this;
	}
	
	public TimelineItem addSubHeading(String subHeading)
	{
		timelineBox.add(new Paragraph<>().addClass(Text_Muted)
		                                 .add(new SmallText<>(subHeading)));
		return this;
	}
	
	public TimelineItem addDetails(String subHeading)
	{
		timelineBox.add(new Paragraph<>(subHeading).addClass(MarginBottom_0));
		return this;
	}
	
	public TimelineItem addContent(IComponentHierarchyBase<?, ?> subHeading)
	{
		timelineBox.add(subHeading);
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			if (timelineIcon != null)
			{
				if (timelineBox.getChildren()
				               .isEmpty())
				{
					timelineBox.add(timelineIcon);
				}
				else
				{
					timelineBox.add(1, timelineIcon);
				}
			}
			
			timelineDiv.add(timelineBox);
			add(timelineDiv);
		}
		super.init();
	}
}
