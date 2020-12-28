package com.jwebmp.plugins.themes.mintontheme.timeline;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H2;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.plugins.bootstrap4.buttons.BSButtonOptions;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.buttons.BSButtonOptions.Btn;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.None;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginTop_0;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.Margin_0;

@Accessors(chain = true)
@Getter
@Setter
public class TimelineHeader extends DivSimple<TimelineHeader>
{
	private final DivSimple<?> timeShow = new DivSimple<>().addClass("time-show")
	                                                       .addClass(MarginTop_0);
	private String header;
	
	private BSButtonOptions buttonOptions;
	
	public TimelineHeader(String header)
	{
		this.header = header;
		setTag("article");
		addClass("timeline-item");
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			add(new H2<>().addClass(Margin_0)
			              .addClass(None));
			timeShow.add(new Link<>("#")
					             .addClass(Btn)
					             .addClass(buttonOptions)
					             .addClass("width-lg")
					             .setText(header));
			add(timeShow);
		}
		super.init();
	}
}
