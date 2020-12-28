package com.jwebmp.plugins.themes.mintontheme.topbar.dropbox;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Image;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.html.attributes.ImageAttributes;
import com.jwebmp.plugins.bootstrap4.containers.BSRow;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.Col;
import static com.jwebmp.plugins.bootstrap4.options.BSContainerOptions.No_Gutters;
import static com.jwebmp.plugins.bootstrap4.options.BSPaddingOptions.Padding_2;

public class DropBoxContainer extends DivSimple<DropBoxContainer>
{
	private final List<BSRow<?>> rows = new ArrayList<>();
	
	public DropBoxContainer()
	{
		addClass(Padding_2);
	}
	
	public DropBoxContainer addButton(String goToAddress, String imageSource, String label)
	{
		DivSimple<?> col = new DivSimple<>().addClass(Col);
		
		Link<?> link = new Link<>(goToAddress);
		link.setTargetFrameName("_blank");
		link.addClass("dropdown-icon-item");
		Image<?> image = new Image<>(imageSource);
		image.addAttribute(ImageAttributes.Alt, label);
		
		Span<?, ?, ?> span = new Span<>(label);
		
		link.add(image);
		link.add(span);
		
		col.add(link);
		
		if (this.rows.isEmpty() || this.rows.get(this.rows.size() - 1)
		                                    .getChildren()
		                                    .size() == 3)
		{
			newRow();
		}
		
		BSRow<?> lastRow = this.rows.get(this.rows.size() - 1);
		lastRow.add(col);
		
		return this;
	}
	
	private void newRow()
	{
		BSRow<?> row = new BSRow();
		row.addClass(No_Gutters);
		this.rows.add(row);
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			this.rows.forEach(this::add);
		}
		super.init();
	}
}
