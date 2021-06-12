package com.jwebmp.plugins.themes.mintontheme.implementations;

import com.jwebmp.core.Page;
import com.jwebmp.core.SessionHelper;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.base.angular.modules.AngularMessagesModule;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;
import com.jwebmp.core.generics.WebReference;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.bootstrap4.BootstrapReferencePool;
import jakarta.validation.constraints.NotNull;

public class MintonPageConfigurator implements IPageConfigurator<MintonPageConfigurator>
{
	public MintonPageConfigurator()
	{
		BootstrapReferencePool.Bootstrap4CoreReference.getCssReference()
		                                              .setLeft("css/bootstrap-minton.min.css")
		                                              .setLinkId("bs-default-stylesheet");
		AngularPageConfigurator.setEnabled(true);
		AngularPageConfigurator.setRequired(true);
		SessionHelper.setCacheAddress(false);
		WebReference.setUseVersionIdentifier(true);
		AngularMessagesModule.setMesssgesModuleEnabled(true);
		
	}
	
	@Override
	public @NotNull Page<?> configure(Page<?> page)
	{
		configureDefaultReferences(page.getBody());
		return page;
	}
	
	private void configureDefaultReferences(Body<?, ?> body)
	{
		body.addCssReference(new CSSReference("IconsCSS", 1.0, "css/icons.min.css", -10));
		
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
		
		//body.addJavaScriptReference(new JavascriptReference("Vendor", 1.0, "js/vendor.min.js", Integer.MIN_VALUE));
		body.addJavaScriptReference(new JavascriptReference("AppJS", 1.0, "js/app.minton.min.js", Integer.MAX_VALUE - 1)
		.setPriority(RequirementsPriority.StoneLast));
		
	}
	
	@Override
	public boolean enabled()
	{
		return true;
	}
}
