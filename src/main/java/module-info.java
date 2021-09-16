import com.jwebmp.plugins.themes.mintontheme.implementations.MintonModuleInclusions;
import com.jwebmp.plugins.themes.mintontheme.implementations.MintonPageConfigurator;

module com.jwebmp.plugins.themes.mintontheme {
	
	exports com.jwebmp.plugins.themes.mintontheme;
	exports com.jwebmp.plugins.themes.mintontheme.ui;
	exports com.jwebmp.plugins.themes.mintontheme.appsearch;
	exports com.jwebmp.plugins.themes.mintontheme.faq;
	exports com.jwebmp.plugins.themes.mintontheme.chat;
	exports com.jwebmp.plugins.themes.mintontheme.topbar;
	exports com.jwebmp.plugins.themes.mintontheme.topbar.dropbox;
	exports com.jwebmp.plugins.themes.mintontheme.topbar.megamenu;
	exports com.jwebmp.plugins.themes.mintontheme.topbar.notifications;
	exports com.jwebmp.plugins.themes.mintontheme.topbar.profile;
	exports com.jwebmp.plugins.themes.mintontheme.dto;
	exports com.jwebmp.plugins.themes.mintontheme.leftsidebar;
	exports com.jwebmp.plugins.themes.mintontheme.leftsidebar.sidebar;
	exports com.jwebmp.plugins.themes.mintontheme.options;
	exports com.jwebmp.plugins.themes.mintontheme.pages;
	exports com.jwebmp.plugins.themes.mintontheme.partials;
	exports com.jwebmp.plugins.themes.mintontheme.rightsidebar;
	exports com.jwebmp.plugins.themes.mintontheme.settings;
	exports com.jwebmp.plugins.themes.mintontheme.tasks;
	exports com.jwebmp.plugins.themes.mintontheme.timeline;
	
	requires com.jwebmp.plugins.bootstrap4;
	requires com.jwebmp.plugins.waveseffect;

	requires com.jwebmp.plugins.fontawesome5;
	
	requires com.jwebmp.core.angularjs;

	requires com.guicedee.guicedservlets.undertow;


	requires static lombok;
	requires org.apache.commons.lang3;
	requires org.apache.commons.io;
	 

	provides com.jwebmp.core.services.IPageConfigurator with MintonPageConfigurator;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with MintonModuleInclusions;
	
	exports com.jwebmp.plugins.themes.mintontheme.implementations;
	
	opens com.jwebmp.plugins.themes.mintontheme.implementations to com.google.guice;
	
	opens com.jwebmp.plugins.themes.mintontheme.dto to com.fasterxml.jackson.databind;
	opens com.jwebmp.plugins.themes.mintontheme to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.ui to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.options to com.jwebmp.core, com.fasterxml.jackson.databind;
	opens com.jwebmp.plugins.themes.mintontheme.leftsidebar to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.leftsidebar.sidebar to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.chat to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.appsearch to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.pages to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.faq to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.tasks to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.timeline to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.topbar to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.topbar.dropbox to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.topbar.notifications to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.topbar.megamenu to com.jwebmp.core;
	opens com.jwebmp.plugins.themes.mintontheme.topbar.profile to com.jwebmp.core;
	
}