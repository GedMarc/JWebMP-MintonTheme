package com.jwebmp.plugins.themes.mintontheme.leftsidebar;

import com.google.common.base.Strings;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Image;
import com.jwebmp.core.base.html.Paragraph;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;

import static com.jwebmp.plugins.bootstrap4.options.BSBorderOptions.Rounded_Circle;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Center;
import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.Text_Reset;

@Accessors(chain = true)
@Getter
@Setter
public class LeftMenuUserBox extends DivSimple<LeftMenuUserBox>
{
    private String profileImageSourceBinding;

    private String fullNameBinding;
    private String altBinding;

    private UserOptionsMenu userMenu;

    private String roleNameBinding;

    public LeftMenuUserBox()
    {
        addClass("user-box");
        addClass(Text_Center);
        userMenu = new UserOptionsMenu();
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            Image<?> image = new Image<>();
            image.bind(profileImageSourceBinding);

            image.addAttribute("alt", altBinding == null ? "user-img" : "{{" + altBinding + "}}");
            image.addClass(Rounded_Circle);
            image.addClass("avatar-md");

            if (!Strings.isNullOrEmpty(fullNameBinding))
            {
                image.addAttribute("title", "{{" + fullNameBinding + "}}");
            }
            else {
                image.addAttribute("title", "Guest User");
            }
            add(image);
            add(userMenu);

            if(!Strings.isNullOrEmpty(roleNameBinding))
            {
                Paragraph<?> p = new Paragraph<>("{{" + roleNameBinding + "}}").addClass(Text_Reset);
                add(p);
            }
            else
            {
                Paragraph<?> p = new Paragraph<>("Guest").addClass(Text_Reset);
                add(p);
            }
        }
        super.init();
    }
    
}
