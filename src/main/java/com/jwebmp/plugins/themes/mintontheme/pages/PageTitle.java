package com.jwebmp.plugins.themes.mintontheme.pages;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H4;
import com.jwebmp.plugins.themes.mintontheme.partials.Breadcrumbs;
import com.jwebmp.plugins.bootstrap4.containers.BSRow;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.Col_12;

@Accessors(chain = true)
@Getter
@Setter
public class PageTitle extends BSRow<PageTitle>
{
	private final DivSimple<?> fullRowColumn = new DivSimple<>().addClass(Col_12);
	private final DivSimple<?> pageTitleBox = new DivSimple<>().addClass("page-title-box");
	private final H4<?> pageTitle = new H4<>().addClass("page-title");
	
	private final DivSimple<?> pageTitleRight = new DivSimple<>().addClass("page-title-right");
	
	private Breadcrumbs breadcrumbs;
	
	public PageTitle(String title, Breadcrumbs breadcrumbs)
	{
		//Make this section replaceable by ID only
		setID("titlebox");
		this.breadcrumbs = breadcrumbs;
		
		this.pageTitle.setText(title);
		this.pageTitleBox.add(this.pageTitle);
		
		this.pageTitleRight.add(this.breadcrumbs);
		this.pageTitleBox.add(this.pageTitleRight);
		
		this.fullRowColumn.add(this.pageTitleBox);
		
		add(this.fullRowColumn);
	}
}
