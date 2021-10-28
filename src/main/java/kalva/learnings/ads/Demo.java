package kalva.learnings.ads;

import com.google.common.collect.ImmutableList;

import java.util.*;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("java");
        Optional<List<String>> opt = Optional.ofNullable(name);

//        List<String> s1 = opt.get();
//        s1.set(0, "golang");

        ImmutableList<String> immutableList = ImmutableList.copyOf(opt.get());
        System.out.println(opt.isPresent());
        opt.ifPresent(s1 -> s1.set(0, "golang"));
        System.out.println(opt.get());
//        Executors.newFixedThreadPool();
//        opt.orElseThrow(new RuntimeException(""));

        Optional<Object> empty = Optional.empty();
        System.out.println(empty.isPresent());

//        immutableList.add(1,"1");

        System.out.println("\n\n\n\n");
        System.out.println(mean1(Arrays.asList(1d, 2d, 3d, 4d, 5d)));
        System.out.println(mean(Arrays.asList(1d, 2d, 3d, 4d, 5d)));
        System.out.println(mean(Arrays.asList()));
        mean(Arrays.asList(1d, 2d, 3d, 4d, 5d)).map(aDouble -> {
            System.out.println(aDouble.doubleValue());
            return null;
        });
    }

    private static Optional<Double> mean(Collection<Double> numbers) {
        if (numbers.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(
                numbers.stream()
                        .mapToDouble(Double::doubleValue)
                        .sum() / numbers.size());
    }

    private static Double mean1(Collection<Double> numbers) {
        if (numbers.isEmpty()) {
            throw new ArithmeticException("mean of empty collection");
        }
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .sum() / numbers.size();
    }
}
