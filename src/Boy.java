import java.util.List;
import java.util.Objects;

public class Boy {
    private String name;
    private int age;

    Boy(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    public final int getCount(final String names, final List<Boy> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (names.equals(list.get(i).getName())) {
                count++;
            }
        }
        return --count;
    }

    @Override
    public final String toString() {
        return name + "-" + age;
    }

    @Override
    public final boolean equals(final Object anObject) {
        try {
            return this.name.equals(((Boy) anObject).name);
        } catch (NullPointerException e) {
            return Objects.equals(this.name, ((Boy) anObject).name);
        }
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name);
    }
}
