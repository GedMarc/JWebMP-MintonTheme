package com.jwebmp.plugins.themes.mintontheme.chat;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Form;
import com.jwebmp.core.base.html.inputs.InputSearchType;
import com.jwebmp.core.base.interfaces.IIcon;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.forms.groups.enumerations.BSFormGroupOptions.Form_Control;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.Padding_3;

@Accessors(chain = true)
@Getter
@Setter
public class ChatFormSearch extends Form<ChatFormSearch>
{
	private final DivSimple<?> positioner = new DivSimple<>().addClass("position-relative");
	
	private final InputSearchType<?> searchInput = new InputSearchType<>();
	
	public ChatFormSearch(IIcon<?, ?> searchIcon)
	{
		addClass("search-bar");
		addClass(Padding_3);
		
		this.searchInput.addClass(Form_Control);
		this.searchInput.setPlaceholder("Search...");
		
		add(this.positioner);
		
		this.positioner.add(this.searchInput);
		this.positioner.add(searchIcon);
		Component.class.cast(searchIcon)
		               .setTag("span");
	}
}
