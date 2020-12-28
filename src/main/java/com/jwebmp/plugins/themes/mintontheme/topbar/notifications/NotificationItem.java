package com.jwebmp.plugins.themes.mintontheme.topbar.notifications;

import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.options.BSBackgroundOptions;
import com.jwebmp.plugins.bootstrap4.options.BSColoursOptions;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.Dropdown_Item;
import static com.jwebmp.plugins.bootstrap4.options.BSBorderOptions.Rounded_Circle;
import static com.jwebmp.plugins.bootstrap4.options.BSDefaultOptions.Float_Right;
import static com.jwebmp.plugins.bootstrap4.options.BSImageOptions.Img_Fluid;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginBottom_0;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Muted;

@Accessors(chain = true)
@Getter
@Setter
public class NotificationItem extends Link<NotificationItem>
{
	private IComponentHierarchyBase<?, ?> icon;
	private BSBackgroundOptions backgroundOption;
	private BSColoursOptions coloursOptions;
	private String details;
	private String smallText;
	
	private boolean shaded;
	private boolean rightAlignSmallText;
	private boolean rightAlignDetail;
	private boolean asUserMessage;
	
	public NotificationItem()
	{
		addClass(Dropdown_Item);
		addClass("notify-item");
	}
	
	public NotificationItem(IIcon<?, ?> icon, BSBackgroundOptions iconBackgroundOption, BSColoursOptions iconColoursOption,
	                        String details, String smallText)
	{
		this();
		setDirectToAddress("javascript:void(0);");
		this.icon = (IComponentHierarchyBase<?, ?>) icon;
		this.backgroundOption = iconBackgroundOption;
		this.coloursOptions = iconColoursOption;
		this.details = details;
		this.smallText = smallText;
	}
	
	public NotificationItem(Image<?> image, String details, String smallText)
	{
		this();
		setDirectToAddress("javascript:void(0);");
		this.icon = image;
		this.details = details;
		this.smallText = smallText;
		
		image.addClass(Img_Fluid);
		image.addClass(Rounded_Circle);
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			if (this.shaded)
			{
				addClass("active");
			}
			
			DivSimple<?> iconDiv = new DivSimple<>().addClass("notify-icon");
			if (this.backgroundOption != null)
			{
				iconDiv.addClass(this.backgroundOption);
			}
			
			if (this.coloursOptions != null)
			{
				iconDiv.addClass(this.coloursOptions);
			}
			
			iconDiv.add(this.icon);
			add(iconDiv);
			
			Paragraph<?> paragraph = new Paragraph<>(this.details).addClass("notify-details");
			if (this.rightAlignDetail)
			{
				paragraph.addClass(Float_Right);
			}
			add(paragraph);
			SmallText<?> smallText = new SmallText<>(getSmallText());
			
			if (this.asUserMessage)
			{
				if (this.rightAlignSmallText)
				{
					smallText.addClass(Float_Right);
				}
				Paragraph<?> pSmallText = new Paragraph<>().addClass(Text_Muted)
				                                           .addClass(MarginBottom_0)
				                                           .addClass("user-msg");
				pSmallText.add(smallText);
				add(pSmallText);
			}
			else
			{
				if (this.rightAlignSmallText)
				{
					smallText.addClass(Float_Right);
				}
				smallText.addClass(Text_Muted);
				add(smallText);
			}
		}
		super.init();
	}
}
