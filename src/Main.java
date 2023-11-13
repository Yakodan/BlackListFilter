import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> comments = new ArrayList<>();
        comments.add("Hi!");
        comments.add("BanWord");
        comments.add("Terraria");
        comments.add("I LOVE JAVA! AAAAAA");
        comments.add("Mamma mia");

        Set<String> blackList = new HashSet<>(Arrays.asList("Ban","Terra"));

        Filter filter = new Filter();
        filter.filterComments(comments,blackList);

        System.out.println(comments);

    }
}