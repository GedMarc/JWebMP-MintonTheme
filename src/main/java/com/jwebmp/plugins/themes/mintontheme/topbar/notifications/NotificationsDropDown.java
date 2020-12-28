package com.jwebmp.plugins.themes.mintontheme.topbar.notifications;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.badge.BSBadge;
import com.jwebmp.plugins.bootstrap4.dropdown.BSDropDown;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.Dropdown_Lg;
import static com.jwebmp.plugins.bootstrap4.dropdown.options.BSDropDownOptions.Dropdown_Menu_Right;
import static com.jwebmp.plugins.bootstrap4.navs.BSNavsOptions.Nav_Link;
import static com.jwebmp.plugins.bootstrap4.options.BSBorderOptions.Rounded_Circle;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Effect;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Light;

@Accessors(chain = true)
@Getter
@Setter
public class NotificationsDropDown extends BSDropDown<NotificationsDropDown>
{
	private final Link<?> link;
	private final BSDropDownMenu<?> menu;
	private final NotificationsHeader header;
	
	private final DivSimple<?> content = new DivSimple<>();
	private IIcon<?, ?> icon;
	private BSBadge<?> badge;
	
	private List<NotificationFooter> footers = new ArrayList<>();
	
	
	public NotificationsDropDown(String header)
	{
		setTag("li");
		addClass("notification-list");
		addClass("topbar-dropdown");
		
		this.link = addDropDownLink();
		this.link.addClass(Nav_Link);
		this.link.addClass(Waves_Effect.toString());
		this.link.addClass(Waves_Light.toString());
		
		this.menu = addDropDownMenu();
		this.menu.addClass(Dropdown_Menu_Right);
		this.menu.addClass(Dropdown_Lg);
		
		this.header = new NotificationsHeader(header);
		
		this.content.addClass("noti-scroll");
		this.content.addAttribute("data-simplebar", "");
	}
	
	public NotificationsDropDown(String header, IIcon<?, ?> icon, BSBadge<?> badge)
	{
		this(header);
		this.icon = icon;
		this.badge = badge;
	}
	
	public NotificationsDropDown addNotification(NotificationItem notificationItem)
	{
		this.content.add(notificationItem);
		return this;
	}
	
	public NotificationsDropDown addFooter(NotificationFooter footer)
	{
		this.footers.add(footer);
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			if (this.icon != null)
			{
				this.icon.asHierarchyBase()
				         .addClass("noti-icon");
				this.link.add(this.icon);
			}
			if (this.badge != null)
			{
				this.badge.addClass(Rounded_Circle);
				this.badge.addClass("noti-icon-badge");
				this.link.add(this.badge);
			}
			if (this.header != null)
			{
				getMenu().add(0, this.header);
			}
			getMenu().add(this.content);
			for (NotificationFooter footer : this.footers)
			{
				getMenu().add(footer);
			}
		}
		super.init();
	}
}
