package numberCounts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Shevchik
 * Date: 03.01.14
 * Time: 17:59
 * To change this template use File | Settings | File Templates.
 */

public class NumberCount {
    private Long minNumber;
    private Long maxNumber;
    private static int count;
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Long> current = new ArrayList<Long>(10);



    public static void main(String[] args){
        long timerBegin = System.currentTimeMillis();
        NumberCount numberCount = new NumberCount();
        numberCount.setMinNumber();
        numberCount.setMaxNumber();
        //current.ensureCapacity(10);
        /*
        for (int i = 0; i < 10; i++){
            current.add(0L-i);
        }
        */

        if (numberCount.getMaxNumber() < numberCount.getMinNumber()){
            System.out.println("Enter correct numbers!");
            System.exit(0);
        }

        /*
        System.out.println("Numbers without digit duplicated: ");
        for (Long i = numberCount.getMinNumber(); i <= numberCount.getMaxNumber(); i++){
            parse(i);
            if (check()){
                count++;
                System.out.print(i + "  ");
            }
        }
        */

        System.out.println("Numbers without digit duplicated: ");
        parse(numberCount.getMinNumber());
        for (Long i = numberCount.getMinNumber(); i <= numberCount.getMaxNumber(); i++){
            if (check()){
                setCount(getCount() + 1);
                System.out.print(i + "  ");
            }


        }

        /*
        System.out.println("Numbers without digit duplicated: ");
        current = parse(numberCount.getMinNumber());
        for (Long i = numberCount.getMinNumber(); i <= numberCount.getMaxNumber(); i++){
            int k = 0;
            if (check(current)){
                count++;
                System.out.print(i + "  ");
            }
            if (current.getLast() < 10){
                Long cur = current.removeLast();
                current.addLast(cur+1);
            } else {
                k++;
                Long cur = current.get(current.size()-k);
                current.set(current.size()-k, cur+1);
                for (int j = current.size() - k + 1; j <= current.size(); j++){
                    current.set(j, 0L);
                }
            }
        }
        */
        long timerEnd = System.currentTimeMillis();
        long timerDelta = timerEnd - timerBegin;
        System.out.println();
        System.out.println("Total count: " + getCount());
        System.out.println("Total time: " + timerDelta);
    }

    public static void parse(Long number){
        //ArrayList<Long> list = new ArrayList<Long>();
        //int i = 0;
        while (number > 0) {
            current.add(number % 10);
            number = number / 10;
            //i++;
        }
        //return current;
    }

    public static boolean check(){
        Set<Long> set = new HashSet<Long>(current);
        if (set.size() < current.size()){
            return false;
        }
        return true;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        NumberCount.count = count;
    }

    public Long getMinNumber() {
        return minNumber;
    }

    public void setMinNumber() {
        System.out.print("Enter min: ");
        this.minNumber = scan.nextLong();
    }

    public Long getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber() {
        System.out.print("Enter max: ");
        this.maxNumber = scan.nextLong();
    }
}
