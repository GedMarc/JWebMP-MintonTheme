package com.jwebmp.plugins.themes.mintontheme.topbar.dropbox;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.dropdown.BSDropDown;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.core.base.html.attributes.GlobalAttributes.Aria_Expanded;
import static com.jwebmp.core.base.html.attributes.GlobalAttributes.Aria_HasPopup;
import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.*;
import static com.jwebmp.plugins.bootstrap4.navs.BSNavsOptions.Nav_Link;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.Lg_Inline_Block;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.None;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.Padding_0;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Effect;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Light;

@Accessors(chain = true)
@Getter
@Setter
public class DropBoxes extends BSDropDown<DropBoxes>
{
	private final BSDropDownMenu<?> menu;
	private final Link<?> link;
	private final DropBoxContainer dropBoxContainer = new DropBoxContainer();
	
	public DropBoxes(IIcon<?, ?> icon)
	{
		addClass(None);
		addClass(Lg_Inline_Block);
		addClass("topbar-dropdown");
		
		this.link = addDropDownLink();
		this.link.setDirectToAddress("#");
		this.link.addClass(Nav_Link);
		this.link.addClass(Nav_Link);
		this.link.addClass(Dropdown_Toggle);
		this.link.addClass(Arrow_None);
		this.link.addClass(Waves_Effect.toString());
		this.link.addClass(Waves_Light.toString());
		
		this.link.addAttribute(Aria_HasPopup, "false");
		this.link.addAttribute(Aria_Expanded, "false");
		
		this.link.add(icon);
		icon.asHierarchyBase()
		    .addClass("noti-icon");
		
		this.menu = addDropDownMenu();
		this.menu.addClass(Dropdown_Lg);
		this.menu.addClass(Dropdown_Menu_Right);
		this.menu.addClass(Padding_0);
		
		this.menu.add(this.dropBoxContainer);
	}
}
