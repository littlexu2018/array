import com.imooc.array.MyArray;

public class Main {

    public static void main(String[] args) {
        MyArray<Integer> array =new MyArray<Integer>();
        for (int i=0;i<10;i++){
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1,100);

        array.addFrist(-1);
        System.out.println(array);
/*
        array.remove(0);
        System.out.println(array);*/
    }
}
