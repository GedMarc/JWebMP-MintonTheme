package com.jwebmp.plugins.themes.mintontheme.appsearch;

import com.jwebmp.core.base.html.H5;
import com.jwebmp.core.base.html.Span;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.options.BSColoursOptions.Text_Danger;

@Accessors(chain = true)
@Getter
@Setter
public class AppSearchResultsHeader extends H5<AppSearchResultsHeader>
{
	private int results = 0;
	
	public AppSearchResultsHeader()
	{
	}
	
	public AppSearchResultsHeader(String text)
	{
		super(text);
	}
	
	@Override
	protected StringBuilder renderBeforeChildren()
	{
		return new StringBuilder("Found ");
	}
	
	@Override
	protected @NotNull StringBuilder renderChildren()
	{
		return new StringBuilder(new Span<>(Integer.toString(results)).addClass(Text_Danger)
		                                                              .toString(0));
	}
	
	@Override
	protected StringBuilder renderAfterChildren()
	{
		return new StringBuilder(" results");
	}
}
