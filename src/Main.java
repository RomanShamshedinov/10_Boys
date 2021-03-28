import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    @SuppressWarnings("checkstyle:SimplifyBooleanReturn")
    public static void main(final String[] args) {
        final ArrayList<Boy> boys = new ArrayList<>() {
            {
                add(new Boy("Николай", 68));
                add(new Boy("Пётр", 53));
                add(new Boy("Василий", 25));
                add(new Boy("Михаил", 19));
                add(new Boy("Алексей", 6));
                add(new Boy("Николай", 86));
                add(new Boy("Пётр", 35));
                add(new Boy("Михаил", 111));
                add(new Boy("Алексей", 22));
                add(new Boy("Михаил", 1));
                add(new Boy("Яков", 30));
            }
        };
//        Собрать имена совершеннолетних;
//        Убрать дубли, отсортировать по алфавиту и оставить четверых;
//        Собрать получившиеся имена в мапу, где где ключ - имя мальчика, значение - количество его тёзок в списке;
//        Вывести результат в консоль; {Василий=0, Алексей=1, Михаил=2, Николай=1}

        //Список нужных имен
        List<String> sortArray = boys.stream()
                .filter(a -> a.getAge() >= 18)
                .map(a -> a.getName())
                .distinct()
                .sorted()
                .limit(4)
                .collect(Collectors.toList());

        //Список количества тезок для списка sortArray
        List<Integer> dublicate = boys.stream()
                .filter(p -> {
                    List<String> sortArray1 = boys.stream()
                            .filter(a -> a.getAge() >= 18)
                            .map(a -> a.getName())
                            .distinct()
                            .sorted()
                            .limit(4)
                            .collect(Collectors.toList());
                    return (sortArray1.contains(p.getName()));
                })
                .distinct()
                .map(p -> p.getCount(p.getName(), boys))
                .collect(Collectors.toList());

        //Объединение двух списков в Map
        Map<Object, Object> result =
                IntStream.range(0, sortArray.size())
                        .boxed()
                        .collect(Collectors.toMap(i -> sortArray.get(i), i -> dublicate.get(i)));
        System.out.println(result);
    }

}
