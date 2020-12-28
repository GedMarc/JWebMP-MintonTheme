package com.jwebmp.plugins.themes.mintontheme.topbar;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.interfaces.IIcon;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.navs.BSNavsOptions.Nav_Link;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Effect;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Light;


@Accessors(chain = true)
@Getter
@Setter
public class TopBarSettingsTrigger extends Link<TopBarSettingsTrigger>
{
	public TopBarSettingsTrigger(IIcon<?, ?> icon)
	{
		super("javascript:void(0);");
		addClass(Nav_Link);
		addClass("right-bar-toggle");
		addClass(Waves_Effect.toString());
		addClass(Waves_Light.toString());
		icon.asHierarchyBase()
		    .addClass("noti-icon");
		add(icon);
	}
}
