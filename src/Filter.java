import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Класс, реализующий интерфейс {@link BlackListFilter}
 */
public class Filter implements BlackListFilter{

    /**
     * Метод, удаляющий строки из листа комментариев, если они содержат хотя бы одну подстроку из набора чёрного списка<br>
     * Если в метод передаётся список комментариев фиксированной длины, он информирует об этом и не выполняет фильтрацию
     * @param comments list of comments; every comment
     *                 is a sequence of words, separated
     *                 by spaces, punctuation or line breaks
     * @param blackList set of words that should not
     *                  be present in a comment
     */
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {

        // Проверяем фиксированность длины списка комментариев
        try{
            comments.add("");
        } catch (UnsupportedOperationException e){
            System.out.println("Comments List is fixed-size list! Please make it not fixed-size list!");
        }

        // Если всё в порядке, убираем проверочный элемент ""
        comments.remove(comments.size()-1);

        Iterator<String> iterator = comments.iterator();

        // Убираем все строки, попавшие под цензуру, при помощи итератора, чтобы не нарушать перебор списка
        while(iterator.hasNext()){
            String comment = iterator.next();
            for(String banWord : blackList){
                if(comment.contains(banWord)){
                    iterator.remove();
                }
            }
        }
    }
}
