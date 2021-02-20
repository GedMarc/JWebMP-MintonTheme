package com.jwebmp.plugins.themes.mintontheme.topbar;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.attributes.LinkAttributes;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.fontawesome5.FontAwesomeSwapOnClick;
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons;

import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.Arrow_None;
import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.Dropdown_Toggle;
import static com.jwebmp.plugins.bootstrap4.navs.BSNavsOptions.Nav_Link;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Effect;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Light;

public class TopBarFullScreenButton extends Link<TopBarFullScreenButton>
{
	TopBarFullScreenButton()
	{
		setID("topBarFullScreen");
		setDirectToAddress("#");
		addClass(Nav_Link);
		addClass(Dropdown_Toggle);
		addClass(Arrow_None);
		addClass(Waves_Effect.toString());
		addClass(Waves_Light.toString());
		
		addAttribute(LinkAttributes.Data_Toggle, "fullscreen");
	}
	
	public TopBarFullScreenButton(IIcon<?, ?> icon)
	{
		this();
		add(icon);
		icon.asHierarchyBase()
		    .addClass("noti-icon");
	}
	
	public TopBarFullScreenButton(FontAwesomeIcons maximizeIcon, FontAwesomeIcons minimizeIcon)
	{
		this();
		FontAwesome<?> icon = FontAwesome.icon(maximizeIcon);
		add(icon);
		icon.addClass("noti-icon");
		icon.addFeature(new FontAwesomeSwapOnClick(icon, maximizeIcon, minimizeIcon));
	}
	
}
