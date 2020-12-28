package com.jwebmp.plugins.themes.mintontheme.topbar.megamenu;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H3;
import com.jwebmp.core.base.html.H4;
import com.jwebmp.plugins.bootstrap4.buttons.BSButton;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.options.BSColoursOptions.Text_Dark;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginTop_3;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Center;

@Accessors(chain = true)
@Getter
@Setter
public class MegaMenuAdvert extends DivSimple<MegaMenuAdvert>
{
	public MegaMenuAdvert(String title, String subTitle, BSButton<?> linkButton)
	{
		addClass(Text_Center);
		addClass(MarginTop_3);
		
		H3<?> titleHeader = new H3<>(title).addClass(Text_Dark);
		H4<?> subtitleHeader = new H4<>(subTitle);
		
		if (linkButton != null)
		{
			linkButton.addClass(MarginTop_3);
		}
		
		add(titleHeader);
		add(subtitleHeader);
		add(linkButton);
	}
}
