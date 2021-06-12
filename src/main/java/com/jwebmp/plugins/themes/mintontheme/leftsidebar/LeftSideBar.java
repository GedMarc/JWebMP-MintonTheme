package com.jwebmp.plugins.themes.mintontheme.leftsidebar;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.themes.mintontheme.partials.LogoBox;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.H_100;

@Accessors(chain = true)
@Getter
@Setter
public class LeftSideBar extends DivSimple<LeftSideBar> {
    private DivSimple<?> content = new DivSimple<>();
    private LeftMenuUserBox userBox;
    private LeftSideBarMenu sideBarMenu;
    private LogoBox logoBox;
    private String roleNameBinding;

    public LeftSideBar() {
        addClass("left-side-menu");
        this.content.addClass(H_100);
      //  this.content.addClass("menuitem-active");
        this.content.addAttribute("data-simplebar", "");
    }

    @Override
    public void init() {
        if (!isInitialized()) {
            if (userBox != null)
                this.content.add(this.userBox);
            
            if(sideBarMenu != null)
            {
                this.content.add(this.sideBarMenu);
            }

            this.content.add(new DivSimple<>().addClass("clearfix"));

            if (logoBox != null)
                add(this.logoBox);
            add(this.content);
        }
        super.init();
    }
}
