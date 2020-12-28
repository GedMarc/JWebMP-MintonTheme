package com.jwebmp.plugins.themes.mintontheme.options;

public enum DataLayoutMode
{
	two_column,
	horizontal,
	detached;
	
	@Override
	public String toString()
	{
		return super.toString()
		            .replace('_', '-');
	}
}
