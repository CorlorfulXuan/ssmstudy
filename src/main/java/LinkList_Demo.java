import java.util.*;

public class LinkList_Demo {
    public static void main(String[] args) {
        //构建一个空链表
        List<String> a = new LinkedList<>();
        //添加一个元素
        a.add("Berry");
        a.add("Marry");
        a.add("Siri");
        //在指定位置添加一个元素
        a.add(0,"Baidu");

        List<String> b = new LinkedList<>();
        b.add("China");
        b.add("Korea");
        b.add("German");
        b.add("England");
        b.add("China");

        //返回一个用于访问集合中每个元素的迭代器
        Iterator<String> bIter = b.iterator();
        //返回将要存在的下一个对象。如果到达集合尾部，将抛出一个NoSuchElementException
        System.out.println(bIter.next());
        //如果存在可访问的元素，则返回true
        System.out.println(bIter.hasNext());

        a.addAll(0, b);
        //删除给定位置的元素并返回这个元素
        System.out.println(a.remove(0));
        //获取给定位置的元素
        System.out.println(a.get(0));
        //用新元素取代给定元素的位置，并返回原来哪个元素
        System.out.println(a.set(0, "China"));
        //返回与指定元素相等的元素在列表中第一次出现的位置，如果没有这样的元素将返回-1
        System.out.println(a.indexOf("China"));
        //返回与指定元素相等的元素在列表中最后一次出现的位置，如果没有这样的元素将返回-1
        System.out.println(a.lastIndexOf("China"));

        System.out.println(a);

        //返回一个列表迭代器，以便用来访问列表中的元素，listIterator才有add方法
        ListIterator<String> aIter = a.listIterator();
        System.out.println(aIter.next());
        //返回前一个对象。如果到达头部，抛出NoSuchElementException异常
        aIter.previous();
        //在迭代器当前位置前添加一个元素
        aIter.add("First");
        System.out.println(a);
        //用新元素取代next或previous上次访问的元素。如果在next或previous上次访问后列表结构被修改了，将抛出一个IllegalStateException异常
        aIter.next();
        aIter.set("Second");
        System.out.println(a);
        //还有可供访问的元素，返回true
        System.out.println(aIter.hasPrevious());
        //返回下一次调用next方法时将返回的元素索引
        System.out.println(aIter.nextIndex());
        //返回下一次调用previous方法时将返回的元素索引
        System.out.println(aIter.previousIndex());
        //返回一个列表迭代器，以便用来访问列表中的元素，这个元素第一次调用next返回的给定索引的元素。
        ListIterator<String> aIter1 = a.listIterator(2);
        System.out.println(aIter1.next());

        //构造一个空链表，将集合中所有元素添加到这链表中
        LinkedList<String> clone_a = new LinkedList<>(a);
        System.out.println(clone_a);
        //将元素添加到列表的头部或尾部
        clone_a.addFirst("start");
        clone_a.addLast("end");
        System.out.println(clone_a);
        //删除并返回列表头部或尾部的元素
        System.out.println(clone_a.removeFirst());
        System.out.println(clone_a.removeLast());
        System.out.println(clone_a);

        Collection<String> demo = new LinkedList<>(a);
        //返回当前存储在集合中的元素个数
        System.out.println(demo.size());
        //如果集合中没有元素，返回true
        System.out.println(demo.isEmpty());
        //如果集合包含一个与obj相等的对象，返回true
        System.out.println(demo.contains("China"));
        //如果集合包含other集合中的所有元素，返回true
        System.out.println(demo.containsAll(b));
        //将一个元素添加到集合中，如果这个调用改变了集合，返回true
        System.out.println(demo.add("end"));
        //将一个集合中的所有元素添加到这个集合，如果这个调用改变了集合，返回true
        System.out.println(demo.addAll(b));
        //从这个集合中删除等于obj的元素，如果这个调用改变了集合，返回true
        System.out.println(demo.remove("end"));
        //从这个集合中删除other集合中存在的所有元素，如果这个调用改变了集合，返回true
        System.out.println(demo.removeAll(b));
        //从这个集合中删除所有与other集合中不同的元素，如果这个调用改变了集合，返回true
        System.out.println(demo.retainAll(a));
        //返回这个集合的对象数组
        System.out.println(Arrays.toString(demo.toArray()));
        //返回这个集合的对象数组。如果arrayToFill足够大，剩余的用null填充；否则，分配一个新数组。
        String[] demo_a = new String[15];
        demo.toArray(demo_a);
        System.out.println(Arrays.toString(demo_a));
        //删除所有元素
        demo.clear();
        System.out.println(demo);

    }
}
