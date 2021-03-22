package com.jwebmp.plugins.themes.mintontheme.ui;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.attributes.HeaderTypes;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.cards.BSCard;
import com.jwebmp.plugins.bootstrap4.cards.parts.BSCardBody;
import com.jwebmp.plugins.bootstrap4.cards.parts.BSCardHeader;
import com.jwebmp.plugins.bootstrap4.cards.parts.BSCardTitle;
import com.jwebmp.plugins.bootstrap4.collapse.BSCollapse;
import com.jwebmp.plugins.bootstrap4.options.BSBackgroundOptions;
import com.jwebmp.plugins.bootstrap4.options.BSColoursOptions;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static com.jwebmp.plugins.bootstrap4.options.BSMarginOptions.*;

@Getter
@Setter
@Accessors(chain = true)
public class Portlet extends BSCard<Portlet> {

    private final BSCardBody<?> content;
    private final BSCardHeader<?> cardHeader;
    private final BSCardBody<?> cardBody;
    private final BSCardTitle<?> cardTitle;
    private final List<Link<?>> widgets = new ArrayList<>();

    private final DivSimple<?> cardWidgets = new DivSimple<>();
    private BSBackgroundOptions backgroundColour;
    private BSColoursOptions foreColour;

    private boolean styleFullCard;

    public Portlet() {
        cardBody = addCardBody();
        getChildren().remove(cardBody);

        cardHeader = addCardHeader("");
        cardHeader.add(cardWidgets);

        cardWidgets.addClass("card-widgets");

        cardTitle = cardBody.addTitle(HeaderTypes.H5, "");
        cardBody.getChildren().remove(cardTitle);
        cardTitle.addClass(MarginBottom_0);

        cardBody.getChildren().remove(cardTitle);
        cardHeader.add(cardTitle);
        content = new BSCardBody<>().removeClass("card-body");

        getChildren().add(content);

        content.add(cardBody);

        this.backgroundColour = BSBackgroundOptions.Bg_Primary;
        this.foreColour = BSColoursOptions.Text_White;
    }

    public Portlet(String title, IIcon<?, ?> icon, BSBackgroundOptions backgroundColour, BSColoursOptions foreColour) {
        this();
        this.backgroundColour = backgroundColour;
        this.foreColour = foreColour;
        cardTitle.setText(title);
        if (icon != null) {
            cardTitle.add((IComponentHierarchyBase<?, ?>) icon);
            cardTitle.setRenderTextBeforeChildren(false);
            ((IComponentHierarchyBase<?, ?>) icon).addClass(MarginRight_2);
        }
    }

    public Link<?> addWidget(IIcon<?, ?> icon, Event<?, ?> onWidgetClick) {
        Link<?> link = new Link<>("javascript:;");
        link.add(icon);
        icon.getIconComponent().addClass(MarginRight_1);
        link.addEvent(onWidgetClick);
        widgets.add(link);
        return link;
    }

    public Link<?> addReloadWidget(IIcon<?, ?> icon, Event<?, ?> onReload) {
        Link<?> link = new Link<>("javascript:;");
        link.addAttribute("data-toggle", "reload");
        icon.getIconComponent().addClass(MarginRight_1);
        link.add(icon);
        link.addEvent(onReload);
        widgets.add(link);
        return link;
    }

    public Link<?> addCollapseWidget(IIcon<?, ?> icon, boolean hideOnStart, Event<?, ?> onCollapse) {
        Link<?> link = new Link<>("javascript:;");
        BSCollapse.link(link,content,hideOnStart);
        link.add(icon);
        icon.getIconComponent().addClass(MarginRight_1);
        link.addEvent(onCollapse);
        widgets.add(link);
        return link;
    }

    public Link<?> addCloseWidget(IIcon<?, ?> icon, boolean hideOnStart, Event<?, ?> onClose) {
        Link<?> link = new Link<>("javascript:;");
        link.addAttribute("data-toggle", "remove");
        icon.getIconComponent().addClass(MarginRight_1);
        link.add(icon);
        link.addEvent(onClose);
        widgets.add(link);
        return link;
    }

    @Override
    public void init() {
        if (!isInitialized()) {
            for (Link<?> widget : widgets) {
                cardWidgets.add(widget);
            }

            if (styleFullCard) {
                addClass(backgroundColour);
                addClass(foreColour);
            } else {
                cardHeader.addClass(backgroundColour);
                cardHeader.addClass(foreColour);

                cardTitle.addClass(foreColour);
            }
        }
        super.init();
    }
}
