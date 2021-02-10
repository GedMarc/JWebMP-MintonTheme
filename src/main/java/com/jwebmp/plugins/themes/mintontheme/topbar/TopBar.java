package com.jwebmp.plugins.themes.mintontheme.topbar;

import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.html.attributes.LinkAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.children.ListChildren;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.themes.mintontheme.appsearch.AppSearchBSDropDown;
import com.jwebmp.plugins.themes.mintontheme.appsearch.AppSearchForm;
import com.jwebmp.plugins.themes.mintontheme.partials.LogoBox;
import com.jwebmp.plugins.themes.mintontheme.topbar.dropbox.DropBoxes;
import com.jwebmp.plugins.themes.mintontheme.topbar.megamenu.MegaMenu;
import com.jwebmp.plugins.themes.mintontheme.topbar.notifications.NotificationsDropDown;
import com.jwebmp.plugins.themes.mintontheme.topbar.profile.ProfileDropdown;
import com.jwebmp.plugins.bootstrap4.options.BSClearFix;
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.Dropdown;
import static com.jwebmp.plugins.bootstrap4.navs.BSNavsOptions.Nav_Link;
import static com.jwebmp.plugins.bootstrap4.options.BSContainerOptions.Container_Fluid;
import static com.jwebmp.plugins.bootstrap4.options.BSDefaultOptions.Float_Right;
import static com.jwebmp.plugins.bootstrap4.options.BSDefaultOptions.List_Unstyled;
import static com.jwebmp.plugins.bootstrap4.options.BSDisplayOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginBottom_0;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.Margin_0;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Effect;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Light;

@Accessors(chain = true)
@Getter
@Setter
public class TopBar
		extends DivSimple<TopBar>
{
	private final DivSimple<?> container = new DivSimple<>().addClass(Container_Fluid);
	private final List<ListChildren, ?, ?, ?> topbarRightSideLeftMostList = new List<>();
	private final List topbarLeftMostList = new List<>();
	
	private LogoBox logoBox;
	
	private AppSearchForm searchForm;
	private AppSearchBSDropDown searchFormSmallDropDown;
	
	private TopBarFullScreenButton fullScreenButton = new TopBarFullScreenButton(FontAwesomeIcons.expand_arrows_alt, FontAwesomeIcons.compress_alt);
	private DropBoxes dropBoxes;
	private NotificationsDropDown notificationsDropDown;
	private ProfileDropdown profileDropdown;
	private TopBarSettingsTrigger settingsTrigger;
	
	public TopBar()
	{
		addClass("navbar-custom");
		
		this.topbarRightSideLeftMostList.addClass(List_Unstyled);
		this.topbarRightSideLeftMostList.addClass(Float_Right);
		this.topbarRightSideLeftMostList.addClass(MarginBottom_0);
		this.topbarRightSideLeftMostList.addClass("topnav-menu");
		
		this.topbarLeftMostList.addClass(List_Unstyled)
		                       .addClass("topnav-menu")
		                       .addClass("topnav-menu-left")
		                       .addClass(Margin_0);
	}
	
	public TopBar addMenuButton(IIcon<?, ?> icon)
	{
		ListItem<?> listItem = new ListItem<>();
		Button<GlobalChildren, ?, ?, ?, ?> button = new Button<>().addClass("button-menu-mobile")
		                                                          .addClass(Waves_Effect.toString())
		                                                          .addClass(Waves_Light.toString());
		button.add(icon);
		listItem.add(button);
		this.topbarLeftMostList.add(listItem);
		
		ListItem<?> mobileListItem = new ListItem<>();
		Link<?> link = new Link<>();
		link.addClass("navbar-toggle");
		link.addClass(Nav_Link);
		link.addAttribute(LinkAttributes.Data_Toggle.toString(), "collapse");
		link.addAttribute(LinkAttributes.Data_Target.toString(), "#topnav-menu-content");
		
		DivSimple<?> lines = new DivSimple<>().addClass("lines");
		lines.add(new Span<>());
		lines.add(new Span<>());
		lines.add(new Span<>());
		lines.add(new Span<>());
		
		link.add(lines);
		mobileListItem.add(link);
		this.topbarLeftMostList.add(mobileListItem);
		
		return this;
	}
	
	public TopBar addNewDropDown(DefaultMenuDropDown dropDown)
	{
		this.topbarLeftMostList.add(new ListItem<>().add(dropDown));
		return this;
	}
	
	public TopBar addMegaMenu(MegaMenu dropDown)
	{
		this.topbarLeftMostList.add(dropDown.addClass("dropdown-mega")
		                                    .addClass(None)
		                                    .addClass(Xl_Block));
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			if (this.searchForm != null)
			{
				this.topbarRightSideLeftMostList.add(new ListItem<>().addClass(None)
				                                                     .addClass(Lg_Block)
				                                                     .add(this.searchForm)
				                                    );
			}
			if (this.searchFormSmallDropDown != null)
			{
				this.topbarRightSideLeftMostList.add(new ListItem<>().addClass(Inline_Block)
				                                                     .addClass(Lg_None)
				                                                     .add(this.searchFormSmallDropDown)
				                                    );
			}

			if (this.fullScreenButton != null)
			{
				this.topbarRightSideLeftMostList.add(new ListItem<>().addClass(Dropdown)
				                                                     .addClass(None)
				                                                     .addClass(Lg_Inline_Block)
				                                                     .addClass(Inline_Block)
				                                                     .addClass(Lg_None)
				                                                     .add(this.fullScreenButton)
				                                    );
			}
			if (this.dropBoxes != null)
			{
				this.topbarRightSideLeftMostList.add(new ListItem<>().addClass(Dropdown)
				                                                     .addClass(None)
				                                                     .addClass(Lg_Inline_Block)
				                                                     .addClass("topbar-dropdown")
				                                                     .add(this.dropBoxes)
				                                    );
			}
			
			if (this.notificationsDropDown != null)
			{
				this.topbarRightSideLeftMostList.add(new ListItem<>().addClass(Dropdown)
				                                                     .addClass(None)
				                                                     .addClass(Lg_Inline_Block)
				                                                     .addClass("topbar-dropdown")
				                                                     .add(this.notificationsDropDown)
				                                    );
			}
			
			if (this.profileDropdown != null)
			{
				this.topbarRightSideLeftMostList.add(new ListItem<>().addClass(Dropdown)
				                                                     .addClass("notification-list")
				                                                     .addClass("topbar-dropdown")
				                                                     .add(this.profileDropdown)
				                                    );
			}
			
			if (this.settingsTrigger != null)
			{
				this.topbarRightSideLeftMostList.add(new ListItem<>().addClass(Dropdown)
				                                                     .addClass("notification-list")
				                                                     .add(this.settingsTrigger)
				                                    );
			}
			
			
			this.container.add(this.topbarRightSideLeftMostList);
			if (logoBox != null)
			{
				this.container.add(logoBox);
			}
			this.container.add(this.topbarLeftMostList);
			
			add(this.container);
			
			add(BSClearFix.getInstance());
		}
		super.init();
	}
}
