package com.jwebmp.plugins.themes.mintontheme.faq;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H3;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.buttons.BSButton;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.Col_12;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.*;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Effect;
import static com.jwebmp.plugins.waveseffect.WavesEffects.Waves_Light;

@Accessors(chain = true)
@Getter
@Setter
public class FAQPageLayout extends DivSimple<FAQPageLayout>
{
	private DivSimple<?> centerLayout = new DivSimple<>().addClass(Text_Center);
	
	public FAQPageLayout()
	{
		addClass(Col_12);
	}
	
	public FAQPageLayout addHeaderIcon(IIcon<?, ?> icon)
	{
		icon.asHierarchyBase()
		    .addClass(H1);
		icon.asHierarchyBase()
		    .addClass(Text_Muted);
		this.centerLayout.add(icon);
		return this;
	}
	
	public FAQPageLayout addHeading(String heading)
	{
		H3<?> h3 = new H3<>(heading).addClass(MarginBottom_3);
		this.centerLayout.add(h3);
		return this;
	}
	
	public FAQPageLayout addHeadingWriteUp(String heading)
	{
		Paragraph<?> p = new Paragraph<>(heading).addClass(Text_Muted);
		this.centerLayout.add(p);
		return this;
	}
	
	public FAQPageLayout addDirectionButton(IIcon<?, ?> icon, BSButton<?> button, Event<?, ?> event)
	{
		icon.asHierarchyBase()
		    .addClass(MarginRight_1);
		button.add(icon);
		
		button.addClass(Waves_Effect.toString());
		button.addClass(Waves_Light.toString());
		button.addClass(MarginTop_2);
		button.addClass(MarginRight_1);
		
		if (event != null)
		{
			button.addEvent(event);
		}
		
		button.setRenderTextBeforeChildren(false);
		
		this.centerLayout.add(button);
		
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			add(this.centerLayout);
		}
		super.init();
	}
}
