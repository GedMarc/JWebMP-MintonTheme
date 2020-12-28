package com.jwebmp.plugins.themes.mintontheme.tasks;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.plugins.bootstrap4.options.BSBackgroundOptions;
import com.jwebmp.plugins.bootstrap4.progressbar.BSProgressBar;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.options.BSDefaultOptions.Float_Right;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.Block;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginBottom_0;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginTop_2;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.Padding_2;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Muted;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Reset;

@Accessors(chain = true)
@Getter
@Setter
public class TaskSummaryItem extends Link<TaskSummaryItem>
{
	private String title;
	private BSBackgroundOptions coloursOption;
	
	private Integer value;
	
	public TaskSummaryItem(String title, BSBackgroundOptions coloursOption, Integer value)
	{
		super("javascript: void(0);");
		this.title = title;
		this.coloursOption = coloursOption;
		this.value = value;
		addClass(Text_Reset);
		addClass("item-hovered");
		addClass(Block);
		addClass(Padding_2);
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			Paragraph<?> p = new Paragraph<>().addClass(Text_Muted)
			                                  .addClass(MarginBottom_0)
			                                  .setText(this.title);
			Span<?, ?, ?> valSpan = new Span<>(this.value + "%").addClass(Float_Right);
			p.add(valSpan);
			p.setRenderTextBeforeChildren(true);
			
			add(p);
			
			BSProgressBar<?> progressBar = new BSProgressBar<>().addClass(MarginTop_2)
			                                                    .addStyle("height", "4px");
			progressBar.getProgressBar()
			           .setMin(0d)
			           .setMax(100d)
			           .setValue(this.value)
			           .addClass(this.coloursOption);
			
			add(progressBar);
		}
		super.init();
	}
}
