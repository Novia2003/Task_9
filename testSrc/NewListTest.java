import org.junit.Assert;
import org.junit.Test;
import ru.vsu.cs.novichikhin.CreatingNewList;
import ru.vsu.cs.util.ArrayUtils;

import java.util.List;

public class NewListTest {

    @Test
    public void createNewList1() {
        List<Integer> firstList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input01.txt", 0);
        List<Integer> secondList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input01.txt", 1);
        List<Integer> expectedList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestResult/output01.txt", 0);

        assert firstList != null && secondList != null;

        CreatingNewList newList = new CreatingNewList(firstList, secondList);
        Assert.assertEquals(expectedList, newList.createNewList());
    }

    @Test
    public void createNewList2() {
        List<Integer> firstList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input02.txt", 0);
        List<Integer> secondList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input02.txt", 1);
        List<Integer> expectedList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestResult/output02.txt", 0);

        assert firstList != null && secondList != null;

        CreatingNewList newList = new CreatingNewList(firstList, secondList);
        Assert.assertEquals(expectedList, newList.createNewList());
    }

    @Test
    public void createNewList3() {
        List<Integer> firstList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input03.txt", 0);
        List<Integer> secondList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input03.txt", 1);
        List<Integer> expectedList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestResult/output03.txt", 0);

        assert firstList != null && secondList != null;

        CreatingNewList newList = new CreatingNewList(firstList, secondList);
        Assert.assertEquals(expectedList, newList.createNewList());
    }

    @Test
    public void createNewList4() {
        List<Integer> firstList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input04.txt", 0);
        List<Integer> secondList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input04.txt", 1);
        List<Integer> expectedList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestResult/output04.txt", 0);

        assert firstList != null && secondList != null;

        CreatingNewList newList = new CreatingNewList(firstList, secondList);
        Assert.assertEquals(expectedList, newList.createNewList());
    }

    @Test
    public void createNewList5() {
        List<Integer> firstList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input05.txt", 0);
        List<Integer> secondList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input05.txt", 1);
        List<Integer> expectedList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestResult/output05.txt", 0);

        assert firstList != null && secondList != null;

        CreatingNewList newList = new CreatingNewList(firstList, secondList);
        Assert.assertEquals(expectedList, newList.createNewList());
    }

    @Test
    public void createNewList6() {
        List<Integer> firstList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input06.txt", 0);
        List<Integer> secondList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input06.txt", 1);
        List<Integer> expectedList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestResult/output06.txt", 0);

        assert firstList != null && secondList != null;

        CreatingNewList newList = new CreatingNewList(firstList, secondList);
        Assert.assertEquals(expectedList, newList.createNewList());
    }

    @Test
    public void createNewList7() {
        List<Integer> firstList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input07.txt", 0);
        List<Integer> secondList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input07.txt", 1);
        List<Integer> expectedList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestResult/output07.txt", 0);

        assert firstList != null && secondList != null;

        CreatingNewList newList = new CreatingNewList(firstList, secondList);
        Assert.assertEquals(expectedList, newList.createNewList());
    }

    @Test
    public void createNewList8() {
        List<Integer> firstList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input08.txt", 0);
        List<Integer> secondList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input08.txt", 1);
        List<Integer> expectedList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestResult/output08.txt", 0);

        assert firstList != null && secondList != null;

        CreatingNewList newList = new CreatingNewList(firstList, secondList);
        Assert.assertEquals(expectedList, newList.createNewList());
    }

    @Test
    public void createNewList9() {
        List<Integer> firstList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input09.txt", 0);
        List<Integer> secondList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input09.txt", 1);
        List<Integer> expectedList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestResult/output09.txt", 0);

        assert firstList != null && secondList != null;

        CreatingNewList newList = new CreatingNewList(firstList, secondList);
        Assert.assertEquals(expectedList, newList.createNewList());
    }

    @Test
    public void createNewList10
            () {
        List<Integer> firstList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input10.txt", 0);
        List<Integer> secondList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestCase/input10.txt", 1);
        List<Integer> expectedList = ArrayUtils.readListFromFile("testSrc/TestFiles/TestResult/output10.txt", 0);

        assert firstList != null && secondList != null;

        CreatingNewList newList = new CreatingNewList(firstList, secondList);
        Assert.assertEquals(expectedList, newList.createNewList());
    }
}