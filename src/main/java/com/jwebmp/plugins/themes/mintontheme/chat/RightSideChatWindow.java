package com.jwebmp.plugins.themes.mintontheme.chat;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Italic;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.navs.BSNavsAttributes.Role;

@Accessors(chain = true)
@Getter
@Setter
public class RightSideChatWindow extends DivSimple<RightSideChatWindow>
{
	private ChatFormSearch chatForm = new ChatFormSearch(new Italic<>().addClass("mdi mdi-magnify"));
	private ChatGroupsSummary chatGroupsSummary;
	private ChatsSummary chatFavouritesSummary;
	private ChatsSummary chatsSummary;
	
	public RightSideChatWindow()
	{
		addClass("tab-pane");
		setID("chat-tab");
		addAttribute(Role.toString(), "tabpanel");
		
		add(this.chatForm);
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			if (this.chatGroupsSummary != null)
			{
				this.chatGroupsSummary.init();
				embed(this.chatGroupsSummary);
			}
			if (this.chatFavouritesSummary != null)
			{
				this.chatFavouritesSummary.init();
				embed(this.chatFavouritesSummary);
			}
			if (this.chatsSummary != null)
			{
				this.chatsSummary.init();
				embed(this.chatsSummary);
			}
		}
		super.init();
	}
}
