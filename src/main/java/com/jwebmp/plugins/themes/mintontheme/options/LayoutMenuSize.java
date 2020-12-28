package com.jwebmp.plugins.themes.mintontheme.options;

public enum LayoutMenuSize
{
	$default,
	compressed,
	compact;
	
	@Override
	public String toString()
	{
		return super.toString()
		            .replaceAll("\\$", "");
	}
}
