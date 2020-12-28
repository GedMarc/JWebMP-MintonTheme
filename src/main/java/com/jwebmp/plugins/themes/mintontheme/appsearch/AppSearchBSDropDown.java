package com.jwebmp.plugins.themes.mintontheme.appsearch;

import com.jwebmp.core.base.html.Form;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.inputs.InputSearchType;
import com.jwebmp.plugins.bootstrap4.dropdown.BSDropDown;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons;
import com.jwebmp.plugins.waveseffect.WavesEffects;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.core.base.html.attributes.GlobalAttributes.Aria_Expanded;
import static com.jwebmp.core.base.html.attributes.GlobalAttributes.Aria_HasPopup;
import static com.jwebmp.plugins.bootstrap4.buttons.BSButtonAttributes.Role;
import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.*;
import static com.jwebmp.plugins.bootstrap4.forms.groups.enumerations.BSFormGroupOptions.Form_Control;
import static com.jwebmp.plugins.bootstrap4.navs.BSNavsOptions.Nav_Link;
import static com.jwebmp.plugins.bootstrap4.options.BSSpacingOptions.Padding_0;
import static com.jwebmp.plugins.bootstrap4.options.BSSpacingOptions.Padding_3;

@Accessors(chain = true)
@Getter
@Setter
public class AppSearchBSDropDown extends BSDropDown<AppSearchBSDropDown>
{
	private final Form<?> searchForm = new Form<>();
	private final InputSearchType<?> searchInput = new InputSearchType<>();
	
	public AppSearchBSDropDown()
	{
		Link<?> link = asMe().addDropDownLink();
		link.addAttribute(Role.toString(), "button");
		link.addAttribute(Aria_HasPopup, "false");
		link.addAttribute(Aria_Expanded, "false");
		link.addClass(Nav_Link);
		link.addClass(Dropdown_Toggle);
		link.addClass(Arrow_None);
		link.addClass(WavesEffects.Waves_Effect.toString());
		link.addClass(WavesEffects.Waves_Light.toString());
		link.add(FontAwesome.icon(FontAwesomeIcons.search)
		                    .addClass("noti-icon"));
		
		BSDropDownMenu<?> bsDropDownMenu = asMe().addDropDownMenu();
		bsDropDownMenu.addClass(Dropdown_Lg);
		bsDropDownMenu.addClass(Dropdown_Menu_Right);
		bsDropDownMenu.addClass(Padding_0);
		
		this.searchForm.addClass(Padding_3);
		this.searchForm.add(this.searchInput);
		this.searchInput.addClass(Form_Control);
		
		bsDropDownMenu.add(this.searchForm);
	}
}
