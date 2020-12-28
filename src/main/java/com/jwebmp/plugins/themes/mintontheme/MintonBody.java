package com.jwebmp.plugins.themes.mintontheme;

import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.html.interfaces.children.BodyFeatures;
import com.jwebmp.plugins.themes.mintontheme.options.DataLayoutMode;
import com.jwebmp.plugins.themes.mintontheme.options.LayoutOptions;
import com.jwebmp.plugins.themes.mintontheme.rightsidebar.RightSideBar;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class MintonBody<J extends MintonBody<J>> extends Body<BodyFeatures, J>
{
	private ContentView contentView = new ContentView();
	private RightSideBar rightSideBar = new RightSideBar();
	
	private LayoutOptions dataLayout;
	private DataLayoutMode dataLayoutMode;
	
	public MintonBody()
	{
		addClass("loading");
		setInvertColonRender(true);
	}
	
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			if (dataLayout != null)
			{
				
				addAttribute("data-layout", dataLayout.toString(true));
			}
			if (dataLayoutMode != null)
			{
				addAttribute("data-layout-mode", dataLayoutMode.toString());
			}
		}
		super.preConfigure();
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			add(this.contentView);
			add(this.rightSideBar);
			add(this.rightSideBar.getOverlay());
		}
		super.init();
	}
}
