package com.jwebmp.plugins.themes.mintontheme.leftsidebar;

import com.google.common.base.Strings;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.dropdown.BSDropDown;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownLink;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.Block;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.H5;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Reset;

@Accessors(chain = true)
@Getter
@Setter
public class UserOptionsMenu extends BSDropDown<UserOptionsMenu>
{
	private final Link<?> dropDownLink;
	private final BSDropDownMenu<?> dropDownMenu;
	private String fullNameBinding;
	
	public UserOptionsMenu()
	{
		dropDownLink = addDropDownLink()
				.addClass(Text_Reset)
				.addClass(H5)
				.addClass(MarginTop_2)
				.addClass(MarginBottom_1)
				.addClass(Block);
		dropDownMenu = addDropDownMenu();
	}
	
	public BSDropDownLink<?> addItem(String labelText)
	{
		return addItem(null, labelText, null);
	}
	
	public BSDropDownLink<?> addItem(IIcon<?, ?> icon, String labelText)
	{
		return addItem(icon, labelText, null);
	}
	
	public BSDropDownLink<?> addItem(IIcon<?, ?> icon, String labelText, Event<?, ?> event)
	{
		BSDropDownLink<?> bsDropDownLink = dropDownMenu.addItem();
		bsDropDownLink.setDirectToAddress("javascript:void(0);");
		bsDropDownLink.addClass("notify-item");
		
		bsDropDownLink.add(icon);
		icon.asHierarchyBase()
		    .addClass(MarginRight_1);
		bsDropDownLink.add(new Span<>(labelText));
		
		if (event != null)
		{
			bsDropDownLink.addEvent(event);
		}
		
		dropDownMenu.add(bsDropDownLink);
		return bsDropDownLink;
	}
	
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			if (Strings.isNullOrEmpty(dropDownLink.getText()))
			{
				dropDownLink.setText(!Strings.isNullOrEmpty(fullNameBinding) ? "{{" + fullNameBinding + "}}" : "Guest User");
			}
		}
		super.preConfigure();
	}
	
	@Override
	public BSDropDownMenu<?> addDropDownMenu()
	{
		return super.addDropDownMenu()
		            .addClass("user-pro-dropdown");
	}
}
