package leon.com.fyx.entity;

/**
 * <p>类名：leon.com.fyx.entity<p>
 * <p>文件描述：<p>
 * <p>作者：h.yw<p>
 * <p>创建时间：2018/3/29 16:53<p>
 * <p>更改时间：2018/3/29 16:53<p>
 * <p>版本号：1<p>
 */

public class DateBaseEntity {

    String date;
    String hint;
    boolean optional = true;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }
}
