package design.dogandcat;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;

/**
 * dog cat pet 不变 实现一下功能
 * 判断队列中猫数量,狗数量
 * 实现
 * add
 * poll
 * pollDog
 * pollCat
 * isEmpty
 * isEmptyCat
 * isEmptyDog
 * 猫狗队列
 *
 * @author weijianyu
 */
public class DogCatQueue {

    private static final String CAT = "cat";
    private static final String DOG = "dog";

    private LinkedList<DogCatQueueModel> dogQueue;
    private LinkedList<DogCatQueueModel> catQueue;
    private long count;

    public DogCatQueue() {
        dogQueue = Lists.newLinkedList();
        catQueue = Lists.newLinkedList();
        count = 0;
    }

    public void add(Pet pet) {
        DogCatQueueModel dogCatQueueModel = new DogCatQueueModel();
        dogCatQueueModel.setPet(pet);

        if (StringUtils.equals(pet.getType(), DOG)) {
            dogCatQueueModel.setCount(count++);
            dogQueue.add(dogCatQueueModel);
        } else if (StringUtils.equals(pet.getType(), CAT)) {
            dogCatQueueModel.setCount(count++);
            catQueue.add(dogCatQueueModel);
        } else {
            throw new RuntimeException("pet type error!");
        }
    }

    public Pet poll() {
        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            throw new RuntimeException("dog and cat queue is empty!");
        } else if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
            if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
                return dogQueue.poll().getPet();
            } else {
                return catQueue.poll().getPet();
            }
        } else if (dogQueue.isEmpty()) {
            return catQueue.poll().getPet();
        } else {
            return dogQueue.poll().getPet();
        }
    }

    public Dog pollDog() {
        if (dogQueue.isEmpty()) {
            throw new RuntimeException("dog queue is empty!");
        }
        return (Dog) dogQueue.poll().getPet();
    }

    public Cat pollCat() {
        if (catQueue.isEmpty()) {
            throw new RuntimeException("cat queue is empty!");
        }
        return (Cat) catQueue.poll().getPet();
    }

    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }
}
