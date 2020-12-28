package com.jwebmp.plugins.themes.mintontheme.implementations;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.services.IPageConfigurator;
import jakarta.validation.constraints.NotNull;

public class MintonPageConfigurator implements IPageConfigurator<MintonPageConfigurator>
{
	
	@Override
	public @NotNull Page<?> configure(Page<?> page)
	{
		configureDefaultReferences(page.getBody());
		return page;
	}
	
	private void configureDefaultReferences(Body<?, ?> body)
	{
		body.addCssReference(new CSSReference("AppCSS", 1.0, "css/app.min.css", 50)
				                     .setLinkId("app-default-stylesheet")
		);
		body.addCssReference(new CSSReference("BootstrapDarkCSS", 1.0, "css/bootstrap-dark.min.css", 51)
				                     .setLinkId("bs-dark-stylesheet")
				                     .addAttribute("disabled", "disabled")
		
		);
		body.addCssReference(new CSSReference("AppDarkCSS", 1.0, "css/app-dark.min.css", 52)
				                     .setLinkId("app-dark-stylesheet")
				                     .addAttribute("disabled", "disabled")
		);
		body.addCssReference(new CSSReference("IconsCSS", 1.0, "icons.min.css", 53));
		body.addJavaScriptReference(new JavascriptReference("AppJS", 1.0, "js/app.min.js", Integer.MAX_VALUE));
	}
	
	@Override
	public boolean enabled()
	{
		return true;
	}
}
