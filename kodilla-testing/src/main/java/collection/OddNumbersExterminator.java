package collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

       for(Integer random : numbers) {
           if(random % 2 == 0) {
               result.add(random);
           }
       }
       return result;
    }
}
