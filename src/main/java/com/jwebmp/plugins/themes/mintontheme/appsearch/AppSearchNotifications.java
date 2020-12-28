package com.jwebmp.plugins.themes.mintontheme.appsearch;

import com.jwebmp.core.base.html.DivSimple;

public class AppSearchNotifications extends DivSimple<AppSearchNotifications>
{
	public AppSearchNotifications()
	{
		addClass("notification-list");
	}
	
	public AppSearchNotifications addNotification(String imageSource, String title, String subTitle)
	{
		AppSearchNotification notification = new AppSearchNotification();
		notification.getSearchImage()
		            .addAttribute("src", imageSource);
		notification.getSearchResultHeading()
		            .setText(title);
		notification.getSearchResultSubHeading()
		            .setText(subTitle);
		add(notification);
		return this;
	}
}
