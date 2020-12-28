package com.jwebmp.plugins.themes.mintontheme.tasks;

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
public class RightSideTaskWindow extends DivSimple<RightSideTaskWindow>
{
	private final List<TasksSummary> taskSummaries = new ArrayList<>();
	
	public RightSideTaskWindow()
	{
		addClass("tab-pane");
		setID("tasks-tab");
		addAttribute(Role.toString(), "tabpanel");
	}
	
	public RightSideTaskWindow addTaskGroup(TasksSummary summary)
	{
		this.taskSummaries.add(summary);
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			for (TasksSummary taskSummary : this.taskSummaries)
			{
				taskSummary.init();
				embed(taskSummary);
			}
		}
		super.init();
	}
}
