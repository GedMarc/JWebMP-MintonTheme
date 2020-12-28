package com.jwebmp.plugins.themes.mintontheme.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

public class MintonModuleInclusions implements IGuiceScanModuleInclusions<MintonModuleInclusions>
{
	@Override
	public @NotNull Set<String> includeModules()
	{
		Set<String> set = new HashSet<>();
		set.add("com.jwebmp.plugins.themes.mintontheme");
		return set;
	}
}
