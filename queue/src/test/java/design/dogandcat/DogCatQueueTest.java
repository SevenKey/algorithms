package design.dogandcat;

import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * DogCatQueue Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 31, 2018</pre>
 */
public class DogCatQueueTest {

    private DogCatQueue dogCatQueue;

    private List<Pet> petList = Lists.newArrayList();

    @Before
    public void before() throws Exception {
        dogCatQueue = new DogCatQueue();

        petList.add(new Dog());
        petList.add(new Cat());
        petList.add(new Dog());
        petList.add(new Cat());
        petList.add(new Dog());
        petList.add(new Cat());
        petList.add(new Dog());
        petList.add(new Dog());
        petList.add(new Cat());
        petList.add(new Cat());
        petList.add(new Cat());
        petList.add(new Cat());
        petList.add(new Cat());
        petList.add(new Cat());
        petList.add(new Cat());
        petList.add(new Dog());
        petList.add(new Dog());
        petList.add(new Dog());
        petList.add(new Dog());

        for (Pet pet : petList) {
            dogCatQueue.add(pet);
        }
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(Pet pet)
     */
    @Test
    public void testAdd() throws Exception {
        Assert.assertEquals(dogCatQueue.size(), petList.size());
    }

    /**
     * Method: poll()
     */
    @Test
    public void testPoll() throws Exception {
        for (Pet pet : petList) {
            Assert.assertEquals(pet, dogCatQueue.poll());
        }
    }

    /**
     * Method: pollDog()
     */
    @Test
    public void testPollDog() throws Exception {
        while (dogCatQueue.isDogEmpty()) {
            Assert.assertEquals("dog", dogCatQueue.pollDog().getType());
        }
    }

    /**
     * Method: pollCat()
     */
    @Test
    public void testPollCat() throws Exception {
        while (dogCatQueue.isCatEmpty()) {
            Assert.assertEquals("dog", dogCatQueue.pollCat().getType());
        }
    }
} 
