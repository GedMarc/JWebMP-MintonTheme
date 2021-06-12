package com.jwebmp.plugins.themes.mintontheme;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.themes.mintontheme.leftsidebar.LeftSideBar;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class ContentView extends DivSimple<ContentView>
{
	private LeftSideBar leftSideBar = new LeftSideBar();
	private ContentPage contentPage = new ContentPage();
	
	public ContentView()
	{
		setID("wrapper");
	}
	
	@Override
	public void init()
	{
		add(leftSideBar);
		add(contentPage);
		super.init();
	}
}
