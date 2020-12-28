package com.jwebmp.plugins.themes.mintontheme.faq;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H4;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.bootstrap4.containers.BSRow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.MarginBottom_4;

public class FAQCardItemLayout extends DivSimple<FAQCardItemLayout>
{
	private int columns = 2;
	private List<DivSimple<?>> sections = new ArrayList<>();
	
	public FAQCardItemLayout()
	{
		addClass("tab-pane");
		addClass("fade");
	}
	
	public FAQCardItemLayout addItem(String iconChar, String heading, String answer)
	{
		DivSimple<?> div = new DivSimple<>();
		
		DivSimple<?> qDiv = new DivSimple<>(iconChar).addClass("faq-question-q-box");
		H4<?> qesDiv = new H4<>(heading).addClass("faq-question")
		                                .addAttribute("data-wow-delay", ".1s");
		Paragraph<?> aDiv = new Paragraph<>(answer).addClass("faq-answer")
		                                           .addClass(MarginBottom_4);
		
		div.add(qDiv);
		div.add(qesDiv);
		div.add(aDiv);
		
		sections.add(div);
		
		return this;
	}
	
	public FAQCardItemLayout addItem(String iconChar, String heading, IComponentHierarchyBase<?, ?> content)
	{
		DivSimple<?> div = new DivSimple<>();
		
		DivSimple<?> qDiv = new DivSimple<>(iconChar).addClass("faq-question-q-box");
		H4<?> qesDiv = new H4<>(heading).addClass("faq-question")
		                                .addAttribute("data-wow-delay", ".1s");
		content.addClass("faq-answer");
		content.addClass(MarginBottom_4);
		
		div.add(qDiv);
		div.add(qesDiv);
		div.add(content);
		
		sections.add(div);
		
		return this;
	}
	
	@Override
	public void init()
	{
		if (!isInitialized())
		{
			List<DivSimple<?>> sectionsWritable = new CopyOnWriteArrayList<>(sections);
			int rows = sectionsWritable.size() / columns;
			int itemsPerColumn = sectionsWritable.size() / rows;
			for (int i = 0; i < rows; i++)
			{
				BSRow<?> r = new BSRow<>();
				for (int j = 0; j < itemsPerColumn; j++)
				{
					DivSimple<?> c = new DivSimple<>();
					if (columns <= 1)
					{
						c.addClass(Col_Lg_12);
					}
					else if (columns == 2)
					{
						c.addClass(Col_Lg_6);
					}
					else if (columns == 3)
					{
						c.addClass(Col_Lg_4);
					}
					else if (columns == 4)
					{
						c.addClass(Col_Lg_3);
					}
					DivSimple<?> divSimple = sectionsWritable.get(0);
					DivSimple<?> pg = new DivSimple<>().addClass("p-lg-2");
					pg.add(divSimple);
					c.add(pg);
					sectionsWritable.remove(0);
					r.add(c);
				}
				add(r);
			}
		}
	}
}

