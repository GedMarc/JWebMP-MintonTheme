package com.jwebmp.plugins.themes.mintontheme.partials;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Image;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.Span;

import static com.jwebmp.core.base.html.attributes.ImageAttributes.Height;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Center;

public class LogoBox extends DivSimple<LogoBox>
{
	public LogoBox()
	{
		addClass("logo-box");
	}
	
	public LogoBox addLogo(String imgSmall, String imgLarge, String imgSmallDark, String imgLargeDark)
	{
		Link<?> linkLight = new Link<>("#");
		linkLight.addClass("logo")
		         .addClass("logo-light")
		         .addClass(Text_Center);
		
		Link<?> linkDark = new Link<>("#");
		linkDark.addClass("logo")
		        .addClass("logo-dark")
		        .addClass(Text_Center);
		
		Span logoSmall = new Span<>();
		logoSmall.addClass("logo-sm");
		Span logoLarge = new Span<>();
		logoLarge.addClass("logo-lg");
		
		Span logoSmallDark = new Span<>();
		logoSmallDark.addClass("logo-sm");
		Span logoLargeDark = new Span<>();
		logoLargeDark.addClass("logo-lg");
		
		linkLight.add(logoSmall);
		linkLight.add(logoLarge);
		
		linkDark.add(logoSmallDark);
		linkDark.add(logoLargeDark);
		
		Image<?> imageSmallDark = new Image<>(imgSmallDark);
		Image<?> imageLargeDark = new Image<>(imgLargeDark);
		Image<?> imageSmall = new Image<>(imgSmall);
		Image<?> imageLarge = new Image<>(imgLarge);
		
		imageSmall.addAttribute(Height, "24");
		imageSmallDark.addAttribute(Height, "24");
		
		imageLarge.addAttribute(Height, "70");
		imageLargeDark.addAttribute(Height, "70");
		
		logoSmall.add(imageSmall);
		logoLarge.add(imageLarge);
		
		logoSmallDark.add(imageSmallDark);
		logoLargeDark.add(imageLargeDark);
		
		add(linkDark);
		add(linkLight);
		
		return this;
	}
}
