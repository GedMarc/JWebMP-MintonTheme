package com.jwebmp.plugins.themes.mintontheme.appsearch;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.inputs.InputSearchType;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.buttons.BSButton;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;
import com.jwebmp.plugins.bootstrap4.forms.groups.sets.BSFormInputGroup;
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.*;
import static com.jwebmp.plugins.bootstrap4.forms.groups.enumerations.BSFormGroupOptions.Form_Control;
import static com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles.Duotone;


@Accessors(chain = true)
@Getter
@Setter
public class AppSearchDropDown extends DivSimple<AppSearchDropDown>
{
	private final BSFormInputGroup<?, InputSearchType<?>> appSearchGroup = new BSFormInputGroup<>();
	private final BSDropDownMenu<?> menu = new BSDropDownMenu<>();
	
	private final AppSearchNotifications notifications = new AppSearchNotifications();
	
	public AppSearchDropDown()
	{
		addClass(Dropdown);
		addClass("app-search-box");
		
		this.appSearchGroup.setInput(new InputSearchType<>().setID("top-search")
		                                                    .setPlaceholder("Search...")
		                                                    .addClass(Form_Control)
		);
		
		this.appSearchGroup.append(new BSButton<>().addAttribute("type", "submit")
		                                           .add(FontAwesome.icon(FontAwesomeIcons.search_plus, Duotone))
		);
		appSearchGroup.setEnableMessages(false);
		add(this.appSearchGroup);
		
		this.menu.addClass(Dropdown_Lg)
		         .setID("search-dropdown");
		
		add(this.menu);
		
	}
	
	public AppSearchDropDown clearMenu()
	{
		this.menu.getChildren()
		         .clear();
		return this;
	}
	
	public AppSearchDropDown addHeading(IComponentHierarchyBase<?, ?> headerItem)
	{
		DivSimple<?> heading = new DivSimple<>();
		heading.addClass(Dropdown_Header);
		heading.addClass("noti-title");
		
		heading.add(headerItem);
		
		this.menu.add(heading);
		return this;
	}
	
	public AppSearchDropDown addStaticItem(IIcon<?, ?> icon, String text)
	{
		AppSearchDropDownItem item = new AppSearchDropDownItem();
		item.setIcon(icon);
		item.getTextSpan()
		    .setText(text);
		this.menu.add(item);
		
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			this.menu.add(this.notifications);
		}
		super.init();
	}
	
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
		
		}
		super.preConfigure();
	}
}
