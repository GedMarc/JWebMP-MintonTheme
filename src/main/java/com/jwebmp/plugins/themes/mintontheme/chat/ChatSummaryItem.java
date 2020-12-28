package com.jwebmp.plugins.themes.mintontheme.chat;

import com.jwebmp.core.base.html.H6;
import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.options.BSBackgroundOptions;

import static com.jwebmp.plugins.bootstrap4.media.BSComponentMediaOptions.Media_Body;
import static com.jwebmp.plugins.bootstrap4.options.BSBorderOptions.Rounded_Circle;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.*;

public class ChatSummaryItem extends Link<ChatSummaryItem>
{
	private DivSimple<?> media;
	private DivSimple<?> positionalDiv;
	private IComponentHierarchyBase<?, ?> iconImage;
	
	private String title;
	private String text;
	private BSBackgroundOptions coloursOption;
	
	ChatSummaryItem()
	{
		super("javascript: void(0);");
		addClass(Text_Reset);
		addClass("notification-item");
		
		this.media = new DivSimple<>().addClass("media");
		this.positionalDiv = new DivSimple<>().addClass("position-relative")
		                                      .addClass(MarginRight_2);
	}
	
	public ChatSummaryItem(String title, String text, Image<?> icon, BSBackgroundOptions onlineStatusColour)
	{
		this();
		this.title = title;
		this.text = text;
		this.coloursOption = onlineStatusColour;
		this.iconImage = icon;
	}
	
	public ChatSummaryItem(String title, String text)
	{
		this(title, text, (IIcon<?, ?>) null, null);
	}
	
	public ChatSummaryItem(String title, String text, BSBackgroundOptions coloursOption)
	{
		this(title, text, (IIcon<?, ?>) null, coloursOption);
	}
	
	public ChatSummaryItem(String title, String text, IIcon<?, ?> icon, BSBackgroundOptions onlineStatusColour)
	{
		this();
		this.title = title;
		this.text = text;
		this.coloursOption = onlineStatusColour;
		this.iconImage = (IComponentHierarchyBase<?, ?>) icon;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			Span<?, ?, ?> userStatusSpan = new Span<>().addClass("user-status");
			
			this.positionalDiv.add(userStatusSpan);
			
			if (this.iconImage != null)
			{
				this.iconImage.addClass(Rounded_Circle);
				this.iconImage.addClass("avatar-sm");
				this.positionalDiv.add(this.iconImage);
			}
			
			this.media.add(this.positionalDiv);
			
			DivSimple<?> bodyNotification = new DivSimple<>().addClass(Media_Body)
			                                                 .addClass("overflow-hidden");
			
			H6<?> h6 = new H6<>(this.title).addClass(MarginTop_0)
			                               .addClass(MarginBottom_1)
			                               .addClass("font-14");
			
			bodyNotification.add(h6);
			
			DivSimple<?> textDiv = new DivSimple<>().addClass("font-13")
			                                        .addClass(Text_Muted);
			textDiv.add(new Paragraph<>(this.text).addClass(MarginBottom_0, Text_Truncate));
			userStatusSpan.addClass(this.coloursOption);
			
			bodyNotification.add(textDiv);
			this.media.add(bodyNotification);
			
			add(this.media);
		}
		super.init();
	}
}
