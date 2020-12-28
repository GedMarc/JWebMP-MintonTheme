package com.jwebmp.plugins.themes.mintontheme.topbar.megamenu;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.containers.BSColumn;
import com.jwebmp.plugins.bootstrap4.containers.BSRow;
import com.jwebmp.plugins.bootstrap4.dropdown.BSDropDown;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.plugins.bootstrap4.navs.BSNavsOptions.Nav_Link;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Effect;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Light;

@Accessors(chain = true)
@Getter
@Setter
public class MegaMenu extends BSDropDown<MegaMenu>
{
	private final Link<?> link;
	private final BSDropDownMenu<?> menu;
	
	private final List<MegaMenuSection> sections = new ArrayList<>();
	
	private MegaMenuAdvert advert;
	
	public MegaMenu(String label, IIcon<?, ?> chevronImage)
	{
		setTag("li");
		this.link = addDropDownLink();
		this.link.addClass(Nav_Link);
		this.link.addClass("dropdown-toggle");
		this.link.addClass(Waves_Effect.toString());
		this.link.addClass(Waves_Light.toString());
		
		this.link.setRenderTextBeforeChildren(true);
		this.link.setText(label);
		this.link.add(chevronImage);
		
		this.menu = addDropDownMenu();
		this.menu.addClass("dropdown");
		this.menu.addClass("dropdown-megamenu");
	}
	
	public MegaMenu addSection(MegaMenuSection section)
	{
		this.sections.add(section);
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			BSRow<?> topRow = new BSRow<>();
			BSColumn<?> mainColumn = new BSColumn<>().addClass("col-sm-8");
			
			BSRow<?> contentRow = new BSRow<>();
			
			for (MegaMenuSection section : this.sections)
			{
				contentRow.add(section);
			}
			
			mainColumn.add(contentRow);
			topRow.add(mainColumn);
			this.menu.add(topRow);
			
			BSColumn<?> advertColumn = new BSColumn<>().addClass("col-sm-4");
			
			topRow.add(advertColumn);
			if (this.advert != null)
			{
				advertColumn.add(this.advert);
			}
		}
		super.init();
	}
}
