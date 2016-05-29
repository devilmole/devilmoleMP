package cn.com.devilmole.model.menu;

import java.util.List;

/**
 * Created by devilmole on 16/5/26.
 */

public class Menu {

    private String name;
    private String type;
    private String key;
    private String url;
    private List<Menu> sub_button;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Menu> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Menu> sub_button) {
        this.sub_button = sub_button;
    }
}
