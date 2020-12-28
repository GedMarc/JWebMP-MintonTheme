package com.jwebmp.plugins.themes.mintontheme.rightsidebar;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.themes.mintontheme.chat.RightSideChatWindow;
import com.jwebmp.plugins.themes.mintontheme.settings.RightSideSettingsWindow;
import com.jwebmp.plugins.themes.mintontheme.tasks.RightSideTaskWindow;
import com.jwebmp.plugins.bootstrap4.listgroup.tabs.BSTabContainer;
import com.jwebmp.plugins.bootstrap4.navs.BSNavTabs;
import com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions;
import com.jwebmp.plugins.materialicons.MDIIcon;
import com.jwebmp.plugins.materialicons.MDIIcons;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.navs.BSNavsOptions.Nav_Bordered;
import static com.jwebmp.plugins.bootstrap4.navs.BSNavsOptions.Nav_Justified;
import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.H_100;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.Block;
import static com.jwebmp.plugins.bootstrap4.options.BSSpacingOptions.Margin_Y_1;
import static com.jwebmp.plugins.bootstrap4.options.BSSpacingOptions.Padding_Y_2;

@Accessors(chain = true)
@Getter
@Setter
public class RightSideBar extends DivSimple<RightSideBar>
{
	private final BSNavTabs<?> sidebar = new BSNavTabs<>();
	private final DivSimple<?> overlay = new DivSimple<>();
	
	public RightSideBar()
	{
		
		addClass("right-bar");
		this.sidebar.addAttribute("data-simplebar", "");
		this.sidebar.addClass(H_100);
		this.overlay.addClass("rightbar-overlay");
		
		this.sidebar.getNavs()
		            .addClass(Nav_Bordered);
		this.sidebar.getNavs()
		            .addClass(Nav_Justified);
		
		this.sidebar.getTabContents()
		            .addClass(BSPaddingOptions.PaddingTop_0);
		add(this.sidebar);
		//add(this.overlay);
	}
	
	public BSTabContainer<?> addChatTab()
	{
		BSTabContainer<?> container = this.sidebar.addTab(new MDIIcon<>(MDIIcons.message_text_outline)
				                                                  .addClass(Block)
				                                                  .addClass(Margin_Y_1)
				                                                  .addClass("font-22"), new DivSimple<>(), true);
		container.getListItem()
		         .getLinkItem()
		         .addClass(Padding_Y_2);
		container.setTabPane(new RightSideChatWindow());
		return container;
	}
	
	public BSTabContainer<?> addTasksTab()
	{
		BSTabContainer<?> container = this.sidebar.addTab(new MDIIcon<>(MDIIcons.format_list_checks)
				                                                  .addClass(Block)
				                                                  .addClass(Margin_Y_1)
				                                                  .addClass("font-22"), new DivSimple<>());
		container.getListItem()
		         .getLinkItem()
		         .addClass(Padding_Y_2);
		container.setTabPane(new RightSideTaskWindow());
		return container;
	}
	
	public BSTabContainer<?> addSettingsTab()
	{
		BSTabContainer<?> container = this.sidebar.addTab(new MDIIcon<>(MDIIcons.settings)
				                                                  .addClass(Block)
				                                                  .addClass(Margin_Y_1)
				                                                  .addClass("font-22"), new DivSimple<>());
		
		container.getListItem()
		         .getLinkItem()
		         .addClass(Padding_Y_2);
		container.setTabPane(new RightSideSettingsWindow());
		return container;
	}
	
	
}
