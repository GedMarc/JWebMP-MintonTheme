package com.jwebmp.plugins.themes.mintontheme;

import com.google.common.base.Strings;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.attributes.LinkAttributes;
import com.jwebmp.plugins.bootstrap4.containers.BSContainer;
import com.jwebmp.plugins.bootstrap4.containers.BSRow;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.Col_Md_6;
import static com.jwebmp.plugins.bootstrap4.options.BSContainerOptions.Container_Fluid;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.None;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.Sm_Block;

@Accessors(chain = true)
@Getter
@Setter
public class Footer extends DivSimple<Footer>
{
	private final BSContainer<?> container = new BSContainer<>(Container_Fluid);
	
	private final DivSimple<?> footerLinks = new DivSimple<>();
	private final List<Link<?>> links = new ArrayList<>();
	
	private String writeUpText;
	
	public Footer()
	{
		setTag("footer");
		addClass("footer");
		add(this.container);
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			BSRow<?> footerRow = new BSRow<>();
			DivSimple<?> writeUp = new DivSimple<>().addClass(Col_Md_6);
			writeUp.setText(this.writeUpText);
			footerRow.add(writeUp);
			
			DivSimple<?> footerLinksDiv = new DivSimple<>().addClass(Col_Md_6);
			DivSimple<?> footerLink = new DivSimple<>().addClass("text-md-right")
			                                           .addClass("footer-links")
			                                           .addClass(None)
			                                           .addClass(Sm_Block);
			
			for (Link<?> link : this.links)
			{
				footerLink.add(link);
			}
			footerLinksDiv.add(footerLink);
			footerRow.add(footerLinksDiv);
			
			this.container.add(footerRow);
		}
		super.init();
	}
	
	public Footer addLink(Link<?> link)
	{
		if (Strings.isNullOrEmpty(link.getAttribute(LinkAttributes.HRef)))
		{
			link.setDirectToAddress("javascript:void(0);");
		}
		this.links.add(link);
		return this;
	}
}
