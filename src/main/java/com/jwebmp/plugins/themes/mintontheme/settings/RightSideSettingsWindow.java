package com.jwebmp.plugins.themes.mintontheme.settings;

import com.jwebmp.core.base.html.DivSimple;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.plugins.bootstrap4.navs.BSNavsAttributes.Role;

@Accessors(chain = true)
@Getter
@Setter
public class RightSideSettingsWindow extends DivSimple<RightSideSettingsWindow>
{
	private final List<SettingsSummary> settings = new ArrayList<>();
	
	public RightSideSettingsWindow()
	{
		addClass("tab-pane");
		setID("settings-tab");
		addAttribute(Role.toString(), "tabpanel");
	}
	
	public RightSideSettingsWindow addSettingsGroup(SettingsSummary summary)
	{
		this.settings.add(summary);
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			for (SettingsSummary taskSummary : this.settings)
			{
				taskSummary.init();
				embed(taskSummary);
			}
		}
		super.init();
	}
}
