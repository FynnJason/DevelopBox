package app.fynnjason.com.developbox.main;

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 * function：主界面数据Model
 */

public class MainModel {
    private String name;
    private String description;

    public MainModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
