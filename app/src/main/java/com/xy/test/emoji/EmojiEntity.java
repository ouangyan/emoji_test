package com.xy.test.emoji;

/**
 * Created by john on 2019/9/4.
 */

public class EmojiEntity {
    public String name=null;
    public int unicode=0;
    public EmojiEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnicode() {
        return String.valueOf(Character.toChars(unicode));
    }

    public void setUnicode(int unicode) {
        this.unicode = unicode;
    }

    @Override
    public String toString() {
        return "EmojiEntity{" +
                "name='" + name + '\'' +
                ", unicode=" + unicode +
                '}';
    }
}
