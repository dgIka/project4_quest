package models.scenes;

import models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewScene extends AbstractScene {

    private String id = "Interview";

    private Map<Integer, Dialog> dialogs;

    public InterviewScene(Player player) {
        this.currentDialogId = player.getCurrentDialogId();
        player.setCurrentSceneId(this.id);

        this.dialogs = new HashMap<>();

        this.dialogs.put(1, new Dialog("Вы видите перед собой молодую девушку в очках. " +
                "Она пристально смотрит на вас. Ну? "
                , List.of(new Option(1, "Что \"ну\"?", 2)
                , new Option(2, "Что происходит, где я?", 2)
                , new Option(3, "Простите, не могли бы вы повторить вопрос?",3))));

        this.dialogs.put(2, new Dialog("С вами все в порядке? Вы на собеседовании на позицию JAVA-разработчика."
                , List.of(new Option(1, "Да чтото голова закружилась, не повторите вопрос?", 3))));

        this.dialogs.put(3, new Dialog("Я спросила для чего используется ключевое слово transient в Java?"
                , List.of(new Option(1, "Оно указывает, что переменная не " +
                "должна сериализоваться при записи объекта в ObjectOutputStream", 5)
                , new Option(2, "Оно помечает переменную как временную, " +
                        "позволяя немедленно ее собрать сборщиком мусора.",4)
                , new Option(3, "Оно гарантирует, что переменная " +
                        "будет инициализирована нулевым значением.",4))));

        this.dialogs.put(4, new Dialog("Не верно", List.of(new Option(1, "Дальше",6))));
        this.dialogs.put(5, new Dialog("Верно", List.of(new Option(1, "Дальше",6))));

        this.dialogs.put(6, new Dialog("Что произойдет, если метод equals() не переопределен в классе" +
                ", но используется для сравнения объектов?"
                , List.of(new Option(1, "Компилятор выдаст ошибку, так как " +
                        "метод equals() обязателен для переопределения.",7)
                , new Option(2, "Сравнение будет выполнено по ссылкам на объекты (как ==)",8)
                , new Option(3, "Будет автоматически сравниваться содержимое всех полей объекта.",7))));

        this.dialogs.put(7, new Dialog("Не верно", List.of(new Option(1, "Дальше",9))));
        this.dialogs.put(8, new Dialog("Верно", List.of(new Option(1, "Дальше",9))));

        this.dialogs.put(9, new Dialog("Какой модификатор доступа позволяет методу " +
                "быть доступным только внутри пакета, если не указан другой модификатор?"
                , List.of(new Option(1, "protected.",10)
                , new Option(2, "default",11)
                , new Option(3, "private.",10))));

        this.dialogs.put(10, new Dialog("Не верно", List.of(new Option(1, "Дальше",12))));
        this.dialogs.put(11, new Dialog("Верно", List.of(new Option(1, "Дальше",12))));

        this.dialogs.put(12, new Dialog("Что возвращает метод hashCode() в " +
                "классе Object, если он не переопределен?"
                , List.of(new Option(1, "Хэш-код, основанный на содержимом всех полей объекта.", 13)
                , new Option(2, "Случайное число, генерируемое при создании объекта.", 13)
                , new Option(3, "Уникальный идентификатор объекта, основанный на его адресе в памяти", 14))));


        this.dialogs.put(13, new Dialog("Не верно", List.of(new Option(1, "Дальше",15))));
        this.dialogs.put(14, new Dialog("Верно", List.of(new Option(1, "Дальше",15))));


        this.dialogs.put(15, new Dialog("Какой интерфейс в Java используется для создания " +
                "потокобезопасной коллекции, если нужно синхронизировать доступ?"
                , List.of(new Option(1, "Concurrent.", 16)
                , new Option(2, "Collections.synchronizedCollection()",17)
                , new Option(3, "SynchronizedCollection.",16))));

        this.dialogs.put(16, new Dialog("Не верно", List.of(new Option(1, "Дальше",18))));
        this.dialogs.put(17, new Dialog("Верно", List.of(new Option(1, "Дальше",18))));

        this.dialogs.put(18, new Dialog("В Spring, как аннотация @Autowired решает проблему " +
                "неоднозначности, если в контексте несколько бинов одного типа?"
                , List.of(new Option(1, "Она автоматически выбирает бин с самым коротким именем.", 23)
                , new Option(2, "Нужно использовать @Qualifier для указания конкретного имени бина", 19)
                , new Option(3, "Spring выберет бин, созданный последним в контексте.", 23))));

        this.dialogs.put(19, new Dialog("Верно", List.of(new Option(1, "Дальше",20))));

        this.dialogs.put(20, new Dialog("В Java Stream API, как обрабатывается исключение " +
                "в map операции, если оно выбрасывается в лямбда-выражении?"
                , List.of(new Option(1, "Исключение автоматически оборачивается " +
                        "в RuntimeException и передается дальше.", 23)
                , new Option(2, "Stream автоматически прерывает " +
                        "выполнение и возвращает пустой результат.", 23)
                , new Option(3, "Stream API требует явной обработки " +
                        "исключений с помощью try-catch внутри лямбда-выражения", 21))));

        this.dialogs.put(21, new Dialog("Верно", List.of(new Option(1, "Дальше",22))));

        this.dialogs.put(22, new Dialog("В Spring Framework, если вы используете @Transactional " +
                "с Propagation.NESTED в сочетании с JPA, работающим на пуле соединений HikariCP" +
                ", и возникает OptimisticLockException в дочерней транзакции из-за " +
                "конфликта версий сущности, как можно настроить retry-механизм с учетом " +
                "ограничений пула и без нарушения целостности транзакции?"
                , List.of(new Option(1, "Что? Что это за вопрос? Кто вообще знает на него ответ???", 23)
                , new Option(2, "Использовать @Retryable с maxAttempts=3 на методе " +
                        "и настроить HikariCP на увеличение maxPoolSize.", 23)
                , new Option(3, "Реализовать кастомный TransactionInterceptor, перехватывающий " +
                        "OptimisticLockException, и вручную управлять retry с помощью TransactionTemplate", 24)
                , new Option(4, "Установить hibernate.connection.autocommit=true " +
                        "и игнорировать исключение, полагаясь на HikariCP.", 23))));

        this.dialogs.put(23, new Dialog("Верноневерно", List.of(new Option(1, "Эээээ... что?",25))));
        this.dialogs.put(24, new Dialog("Верно", List.of(new Option(1, "Дальше",28))));

        this.dialogs.put(25, new Dialog("След%%%и% %о%%%с"
                , List.of(new Option(1, "Что происходит?", 26))));

        this.dialogs.put(26, new Dialog("// ERROR: NullPointerException at com.mind" +
                ".interview.JavaCore#run(): ВЫЗОВ МЕТОДА [STACK TRACE CORRUPTED]" +
                ". Что произойдет, если instanceofвозвращаетtrueдляObject::method_refв " +
                "контекстеConcurrentHashMap::computeIfAbsentсlambda#ERROR_0xFF? " +
                "[DATA CORRUPTION]: _state == volatile && synchronized (this) { /* FRAGMENT LOST */ }"
                , List.of(new Option(
                        1, "lambda#0xFF computeIfAbsent -> NullRef *sync_block* volatile TRUE", 27)
                , new Option(2, "::method_ref synchronized { CORRUPTED STACK } -> 0xFF lambda", 27)
                , new Option(3, "Object#ERROR volatile { computeIfAbsent } -> NULL TRACE", 27))));

        this.dialogs.put(27, new Dialog("Опять знакомое чувство, к которому прибавилась легкая головная боль. " +
                "И вот ты снова стоишь в пещере перед сундуком. " +
                "Открытым, пустым, без следов магии. Что это вообще было?"
                , List.of(new Option(1, "Отправиться к выходу из пещеры", 1, "Forest"))));


        this.dialogs.put(28, new Dialog("Угадал ты или действительно знал, " +
                "но ты прошел тест и открыл секретную концовку." +
                " Поздравляю, с такими знаниями нужно ли тебе вообще тратить время на такую ерунду" +
                ", как этот квест? Но, в любом случае, ты можешь начать заново " +
                "и попробовать пройти игру другим способом (если конечно ты уже этого не делал). Удачи!"
                , List.of(new Option(1, "Дальше", 1, "Win"))));









//      this.dialogs.put(, new Dialog("", List.of(new Option(, "",))));
//      , new Option(, "",)
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Integer, Dialog> getDialogs() {
        return dialogs;
    }

    public void setDialogs(Map<Integer, Dialog> dialogs) {
        this.dialogs = dialogs;
    }
}
