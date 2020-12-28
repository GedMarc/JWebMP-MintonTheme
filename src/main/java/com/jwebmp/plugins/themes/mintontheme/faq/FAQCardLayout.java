package com.jwebmp.plugins.themes.mintontheme.faq;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.html.attributes.GlobalAttributes;
import com.jwebmp.core.base.html.attributes.LinkAttributes;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.cards.BSCard;
import com.jwebmp.plugins.bootstrap4.cards.parts.BSCardBody;
import com.jwebmp.plugins.bootstrap4.listgroup.tabs.BSTabContainer;
import com.jwebmp.plugins.bootstrap4.navs.BSNavTabs;
import com.jwebmp.plugins.bootstrap4.navs.parts.BSNavLinkItem;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.Col_12;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.None;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.Sm_Inline_Block;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginRight_1;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginTop_4;

@Accessors(chain = true)
@Getter
@Setter
public class FAQCardLayout extends DivSimple<FAQCardLayout>
{
	private final DivSimple<?> fullWidthCol = new DivSimple<>().addClass(Col_12);
	private final BSCard<?> card;
	private final BSCardBody<?> cardBody;
	private final BSNavTabs<?> navTabs;
	
	public FAQCardLayout()
	{
		addClass(MarginTop_4);
		addClass(Col_12);
		
		card = new BSCard<>();
		cardBody = card.addCardBody();
		
		navTabs = new BSNavTabs<>();
		this.navTabs.removeClass("nav-tabs");
		navTabs.addClass("nav-pills");
		navTabs.addClass("navtab-bg");
		
		this.fullWidthCol.add(this.card);
		add(this.fullWidthCol);
	}
	
	public FAQCardLayout addSection(IIcon<?, ?> icon, String title, Component div, boolean active)
	{
		BSNavLinkItem<?> sectionTitleLink = new BSNavLinkItem<>();
		sectionTitleLink.addAttribute(LinkAttributes.Data_Toggle, "tab");
		sectionTitleLink.addAttribute(GlobalAttributes.Aria_Expanded, "false");
		sectionTitleLink.addClass("nav-link");
		sectionTitleLink.addClass("px-3");
		sectionTitleLink.addClass("py-2");
		if (active)
		{
			sectionTitleLink.addClass("active");
		}
		if (icon != null)
		{
			Span iconSpan = new Span<>().addClass(MarginRight_1);
			iconSpan.add(icon);
			sectionTitleLink.add(iconSpan);
		}
		if (title != null)
		{
			Span titleSpan = new Span<>(title).addClass(None)
			                                  .addClass(Sm_Inline_Block);
			sectionTitleLink.add(titleSpan);
			
		}
		BSTabContainer<?> tabContainer = this.navTabs.addTab(sectionTitleLink, div, active);
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			this.cardBody.add(this.navTabs);
		}
		super.init();
	}
}
