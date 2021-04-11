package com.jwebmp.plugins.themes.mintontheme.chat;

import com.jwebmp.core.base.html.*;
import com.jwebmp.plugins.bootstrap4.options.BSColoursOptions;

import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.*;

public class ChatGroupSummaryItem extends Link<ChatGroupSummaryItem>
{
	public ChatGroupSummaryItem(String text)
	{
		this(text, new Italic<>().addClass("mdi mdi-checkbox-blank-circle-outline"), null);
	}
	
	public ChatGroupSummaryItem(String text, BSColoursOptions coloursOption)
	{
		this(text, new Italic<>().addClass("mdi mdi-checkbox-blank-circle-outline"), coloursOption);
	}
	
	public ChatGroupSummaryItem(String text, Italic<?> icon, BSColoursOptions coloursOption)
	{
		super("javascript: void(0);");
		addClass(Text_Reset);
		addClass("notification-item");
		addClass(PaddingLeft_3);
		addClass(MarginBottom_2);
		addClass(Block);
		
		Span<?, ?, ?> textSpan = new Span<>();
		textSpan.addClass(MarginBottom_0);
		textSpan.addClass(MarginTop_1);
		textSpan.setText(text);
		
		icon.asHierarchyBase()
		    .addClass(MarginRight_1);
		if (coloursOption != null)
		{
			icon.asHierarchyBase()
			    .addClass(coloursOption);
		}
		
		add(icon);
		add(textSpan);
	}
}
