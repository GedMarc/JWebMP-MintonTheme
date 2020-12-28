package com.jwebmp.plugins.themes.mintontheme.settings;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H6;
import com.jwebmp.core.base.html.Label;
import com.jwebmp.core.base.html.attributes.GlobalAttributes;
import com.jwebmp.core.base.html.inputs.InputRadioType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.forms.groups.enumerations.BSFormCustomControls.*;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.PaddingBottom_1;

@Accessors(chain = true)
@Getter
@Setter
public class SettingsItem extends DivSimple<SettingsItem>
{
	private final DivSimple<?> controlDiv;
	private final InputRadioType<?> radioInput;
	private final Label<?> controlLabel;
	private H6<?> sectionTitle = new H6<>();
	private String name;
	private String value;
	private boolean checked;
	
	public SettingsItem(String title, String name, String id, String controlLabel, String value)
	{
		super();
		if (title != null)
		{
			this.sectionTitle.setText(title);
			this.sectionTitle.addClass("font-weight-medium")
			                 .addClass("font-14")
			                 .addClass(MarginTop_1)
			                 .addClass(MarginBottom_2)
			                 .addClass(PaddingBottom_1)
			;
			add(this.sectionTitle);
		}
		this.name = name;
		this.value = value;
		this.controlDiv = new DivSimple<>()
				.addClass(Custom_Control)
				.addClass(Custom_Switch)
				.addClass(MarginBottom_1);
		
		this.radioInput = new InputRadioType<>().addClass(Custom_Control_Input);
		this.radioInput.setID(id);
		
		this.controlLabel = new Label<>(controlLabel).addClass(Custom_Control_Label);
		this.controlLabel.setForInputComponent(this.radioInput);
		
		this.controlDiv.add(this.radioInput);
		this.controlDiv.add(this.controlLabel);
		
		add(this.controlDiv);
	}
	
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			
			this.radioInput.addAttribute(GlobalAttributes.Name, this.name);
			this.radioInput.addAttribute(GlobalAttributes.Value, this.value);
			this.radioInput.setChecked(this.checked);
		}
		super.preConfigure();
	}
}
