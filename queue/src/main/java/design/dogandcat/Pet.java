package design.dogandcat;

import com.google.common.base.MoreObjects;

/**
 * 宠物类
 *
 * @author weijianyu
 */
public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", type)
                .toString();
    }
}
