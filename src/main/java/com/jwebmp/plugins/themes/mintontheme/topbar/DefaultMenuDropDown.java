package com.jwebmp.plugins.themes.mintontheme.topbar;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.dropdown.BSDropDown;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.navs.BSNavsOptions.Nav_Link;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginLeft_2;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginRight_1;
import static com.jwebmp.plugins.fontawesome5.FontAwesome.icon;
import static com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles.Light;
import static com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles.Solid;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Effect;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Light;

@Accessors(chain = true)
@Getter
@Setter
public class DefaultMenuDropDown extends BSDropDown<DefaultMenuDropDown>
{
	private final Link<?> link;
	private final BSDropDownMenu<?> menu;
	
	public DefaultMenuDropDown(String label)
	{
		setTag("li");
	//	addClass(None);
		addClass(Block);
		
		this.link = addDropDownLink();
		this.link.addClass(Nav_Link);
		this.link.addClass("dropdown-toggle");
		this.link.addClass(Waves_Effect.toString());
		this.link.addClass(Waves_Light.toString());
		
		this.link.setText(label);
		this.link.setRenderTextBeforeChildren(true);
		this.link.add(icon(FontAwesomeIcons.chevron_down, Solid).addClass(MarginLeft_2));
		
		this.menu = addDropDownMenu();
	}
	
	public DefaultMenuDropDown addItem(IIcon<?, ?> icon, String label, Event<?, ?> event)
	{
		Link<?> link = new Link<>("javascript:void(0);").addClass("dropdown-item");
		icon.asHierarchyBase()
		    .addClass(MarginRight_1);
		link.add(icon);
		link.add(new Span<>(label));
		
		if (event != null)
		{
			link.addEvent(event);
		}
		this.menu.add(link);
		return this;
	}
	
	public DefaultMenuDropDown addDivider()
	{
		this.menu.addDivider();
		return this;
	}
	
}
