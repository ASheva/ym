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
    private static ArrayList<Long> currentList = new ArrayList<Long>(10);
    private static Set<Long> currentSet = new HashSet<Long>();



    public static void main(String[] args){
        long timerBegin = System.currentTimeMillis();
        NumberCount numberCount = new NumberCount();
        numberCount.setMinNumber();
        numberCount.setMaxNumber();

        //dataInput error check
        if (numberCount.getMaxNumber() < numberCount.getMinNumber()){
            System.out.println("Enter correct numbers!");
            numberCount.setMinNumber();
            numberCount.setMaxNumber();
            System.out.println("Well done! :)");
        }

        System.out.println("Numbers without digit duplicated: ");
        for (Long i = numberCount.getMinNumber(); i <= numberCount.getMaxNumber(); i++) {
            parse(i);
            if (check()) {
                setCount(getCount() + 1);
                System.out.print(i + "  ");
            }
        }

        /*
        //try increment number by digit into arrayList
        System.out.println("Numbers without digit duplicated: ");
        currentList = parse(numberCount.getMinNumber());
        for (Long i = numberCount.getMinNumber(); i <= numberCount.getMaxNumber(); i++){
            int k = 0;
            if (check(currentList)){
                count++;
                System.out.print(i + "  ");
            }
            if (currentList.getLast() < 10){
                Long cur = currentList.removeLast();
                currentList.addLast(cur+1);
            } else {
                k++;
                Long cur = currentList.get(currentList.size()-k);
                currentList.currentSet(currentList.size()-k, cur+1);
                for (int j = currentList.size() - k + 1; j <= currentList.size(); j++){
                    currentList.currentSet(j, 0L);
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

    //parsing number into arrayList
    public static void parse(Long number){
        currentList.clear();
        while (number > 0) {
            currentList.add(number % 10);
            number = number / 10;
        }
    }

    //check current number by digit duplicates
    public static boolean check(){
        currentSet.clear();
        currentSet.addAll(currentList);
        if (currentSet.size() < currentList.size()){
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
