package com.jwebmp.plugins.themes.mintontheme.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class LayoutOptions extends JavaScriptPart<LayoutOptions>
{
	private LayoutMode mode;
	private LayoutWidths width;
	private LayoutMenuPosition menuPosition;
	private LayoutSidebarOptions sidebar;
	@JsonProperty("topbar")
	private LayoutTopbarOptions topBar;
	private Boolean showRightSidebarOnPageLoad;
}
