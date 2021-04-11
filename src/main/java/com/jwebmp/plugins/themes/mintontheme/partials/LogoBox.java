package com.jwebmp.plugins.themes.mintontheme.partials;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Image;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.Span;

import static com.jwebmp.core.base.html.attributes.ImageAttributes.Height;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Center;

public class LogoBox extends DivSimple<LogoBox>
{
	
	private Image<?> imageSmallDark;
	private Image<?> imageLargeDark;
	private Image<?> imageSmall;
	private Image<?> imageLarge;
	
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
		
		imageSmallDark = new Image<>(imgSmallDark);
		imageLargeDark = new Image<>(imgLargeDark);
		imageSmall = new Image<>(imgSmall);
		imageLarge = new Image<>(imgLarge);
		
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
	
	public Image<?> getImageSmallDark()
	{
		return imageSmallDark;
	}
	
	public LogoBox setImageSmallDark(Image<?> imageSmallDark)
	{
		this.imageSmallDark = imageSmallDark;
		return this;
	}
	
	public Image<?> getImageLargeDark()
	{
		return imageLargeDark;
	}
	
	public LogoBox setImageLargeDark(Image<?> imageLargeDark)
	{
		this.imageLargeDark = imageLargeDark;
		return this;
	}
	
	public Image<?> getImageSmall()
	{
		return imageSmall;
	}
	
	public LogoBox setImageSmall(Image<?> imageSmall)
	{
		this.imageSmall = imageSmall;
		return this;
	}
	
	public Image<?> getImageLarge()
	{
		return imageLarge;
	}
	
	public LogoBox setImageLarge(Image<?> imageLarge)
	{
		this.imageLarge = imageLarge;
		return this;
	}
}
