package com.jwebmp.plugins.themes.mintontheme.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
		getterVisibility = JsonAutoDetect.Visibility.NONE,
		setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@Accessors(chain = true)
public class LayoutTopbarOptions extends JavaScriptPart<LayoutTopbarOptions>
{
	private LayoutMode color;
}
