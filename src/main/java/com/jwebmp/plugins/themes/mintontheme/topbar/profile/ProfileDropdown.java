package com.jwebmp.plugins.themes.mintontheme.topbar.profile;

import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.badge.BSBadge;
import com.jwebmp.plugins.bootstrap4.dropdown.BSDropDown;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.Dropdown_Menu_Right;
import static com.jwebmp.plugins.bootstrap4.navs.BSNavsOptions.Nav_Link;
import static com.jwebmp.plugins.bootstrap4.options.BSBorderOptions.Rounded_Circle;
import static com.jwebmp.plugins.bootstrap4.options.BSDefaultOptions.Text_Overflow;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.*;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Effect;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Light;


@Accessors(chain = true)
@Getter
@Setter
public class ProfileDropdown extends BSDropDown<ProfileDropdown>
{
	private final Link<?> buttonLink;
	private final BSDropDownMenu<?> menu;
	
	private final Span<IComponentHierarchyBase, ?, ?> textSpan = new Span<>();
	
	private IComponentHierarchyBase<?, ?> icon;
	private String title;
	private IComponentHierarchyBase<?, ?> chevronIcon;
	
	ProfileDropdown()
	{
		setTag("li");
		addClass("notification-list");
		addClass("topbar-dropdown");
		
		this.buttonLink = addDropDownLink();
		this.buttonLink.addClass(Nav_Link);
		this.buttonLink.addClass("nav-user");
		this.buttonLink.addClass(MarginRight_0);
		this.buttonLink.addClass(Waves_Effect.toString());
		this.buttonLink.addClass(Waves_Light.toString());
		
		this.textSpan.setRenderTextBeforeChildren(true);
		
		this.menu = addDropDownMenu();
		this.menu.addClass(Dropdown_Menu_Right);
		this.menu.addClass("profile-dropdown");
	}
	
	public ProfileDropdown(IIcon<?, ?> iconImage, String title)
	{
		this();
		this.icon = (IComponentHierarchyBase<?, ?>) iconImage;
		this.title = title;
	}
	
	public ProfileDropdown(Image<?> iconImage, String title)
	{
		this();
		this.icon = iconImage;
		this.title = title;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			if (this.icon != null)
			{
				this.icon.addClass(Rounded_Circle);
				this.buttonLink.add(this.icon);
			}
			this.buttonLink.add(this.textSpan);
			if (this.chevronIcon != null)
			{
				this.textSpan.add(this.chevronIcon);
			}
		}
		super.init();
	}
	
	@Override
	public void preConfigure()
	{
		if (!isInitialized())
		{
			this.textSpan.addClass("pro-user-name");
			this.textSpan.addClass(MarginLeft_1);
			this.textSpan.setText(this.title);
		}
		super.preConfigure();
	}
	
	public ProfileDropdown addItem(IIcon<?, ?> icon, String text)
	{
		return addItem(icon, text, null);
	}
	
	public ProfileDropdown addItem(IIcon<?, ?> icon, String text, BSBadge<?> badge)
	{
		Link<?> link = new Link<>("javascript:void(0);");
		link.addClass("dropdown-item");
		link.addClass("notify-item");
		if (icon != null)
		{
			link.add(icon);
		}
		if (text != null)
		{
			Span<IComponentHierarchyBase, ?, ?> textSpan = new Span<>(text);
			link.add(textSpan);
			if (badge != null)
			{
				textSpan.setRenderTextBeforeChildren(true);
				textSpan.add(badge);
			}
		}
		this.menu.add(link);
		return this;
	}
	
	public ProfileDropdown addHeaderItem(String text)
	{
		DivSimple<?> header = new DivSimple<>();
		header.addClass("dropdown-header");
		header.addClass("noti-title");
		
		H6<?> headerText = new H6<>(text);
		headerText.addClass(Text_Overflow);
		headerText.addClass(Margin_0);
		
		header.add(headerText);
		
		this.menu.add(header);
		return this;
	}
	
	public ProfileDropdown addDivider()
	{
		this.menu.addDivider();
		return this;
	}
}
