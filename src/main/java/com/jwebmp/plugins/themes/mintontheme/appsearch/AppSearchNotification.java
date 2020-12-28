package com.jwebmp.plugins.themes.mintontheme.appsearch;

import com.jwebmp.core.base.html.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.Dropdown_Item;
import static com.jwebmp.plugins.bootstrap4.media.BSComponentMediaOptions.Media;
import static com.jwebmp.plugins.bootstrap4.media.BSComponentMediaOptions.Media_Body;
import static com.jwebmp.plugins.bootstrap4.options.BSBorderOptions.Rounded_Circle;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.Flex;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginBottom_0;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginRight_2;
import static com.jwebmp.plugins.bootstrap4.options.BSSpacingOptions.Margin_0;


@Accessors(chain = true)
@Getter
@Setter
public class AppSearchNotification extends Link<AppSearchNotification>
{
	private final DivSimple<?> mediaContainer = new DivSimple<>();
	private final DivSimple<?> mediaBody = new DivSimple<>();
	private final Image<?> searchImage = new Image<>();
	
	private final H5<?> searchResultHeading = new H5<>();
	private final Span<?, ?, ?> searchResultSubHeading = new Span<>();
	
	public AppSearchNotification()
	{
		super("#");
		addClass(Dropdown_Item);
		addClass("notify-item");
		
		this.mediaContainer.addClass(Media);
		add(this.mediaContainer);
		
		this.searchImage.addClass(Flex);
		this.searchImage.addClass(MarginRight_2);
		this.searchImage.addClass(Rounded_Circle);
		this.searchImage.addAttribute("height", "32");
		this.mediaContainer.add(this.searchImage);
		
		this.mediaBody.addClass(Media_Body);
		this.mediaContainer.add(this.mediaBody);
		
		this.searchResultHeading.addClass(Margin_0);
		this.searchResultHeading.addClass("font-14");
		
		this.searchResultSubHeading.addClass(MarginBottom_0);
		this.searchResultSubHeading.addClass("font-12");
		
		this.mediaBody.add(this.searchResultHeading);
		this.mediaBody.add(this.searchResultSubHeading);
	}
}
