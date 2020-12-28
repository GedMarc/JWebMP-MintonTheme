package com.jwebmp.plugins.themes.mintontheme.chat;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.options.BSColoursOptions;
import com.jwebmp.plugins.materialicons.MDIIcon;
import com.jwebmp.plugins.materialicons.MDIIcons;

import static com.jwebmp.plugins.bootstrap4.options.BSColoursOptions.Text_Success;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.Block;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.PaddingLeft_3;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Reset;

public class ChatGroupSummaryItem extends Link<ChatGroupSummaryItem>
{
	public ChatGroupSummaryItem(String text)
	{
		this(text, new MDIIcon<>(MDIIcons.checkbox_blank_circle_outline), Text_Success);
	}
	
	public ChatGroupSummaryItem(String text, BSColoursOptions coloursOption)
	{
		this(text, new MDIIcon<>(MDIIcons.checkbox_blank_circle_outline), coloursOption);
	}
	
	public ChatGroupSummaryItem(String text, IIcon<?, ?> icon, BSColoursOptions coloursOption)
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
		icon.asHierarchyBase()
		    .addClass(coloursOption);
		
		add(icon);
		add(textSpan);
	}
}
