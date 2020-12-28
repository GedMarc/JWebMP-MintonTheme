package com.jwebmp.plugins.themes.mintontheme;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.themes.mintontheme.topbar.TopBar;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class ContentPage extends DivSimple<ContentPage>
{
	private final DivSimple<?> contentDiv = new DivSimple<>();
	//private SwapContainer contentContainer;
	private Footer footer = new Footer();
	private TopBar topBar = new TopBar();
	
	public ContentPage()
	{
		addClass("content-page");
		this.contentDiv.addClass("content");
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			this.contentDiv.add(this.topBar);
	//		this.contentDiv.add(this.contentContainer);
			
			add(this.contentDiv);
			add(this.footer);
		}
		super.init();
	}
}
