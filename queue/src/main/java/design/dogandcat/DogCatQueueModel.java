package design.dogandcat;

import com.google.common.base.MoreObjects;

/**
 * 猫狗队列存储model
 *
 * @author weijianyu
 */
public class DogCatQueueModel {
    private Pet pet;
    private long count;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("pet", pet)
                .add("count", count)
                .toString();
    }
}
