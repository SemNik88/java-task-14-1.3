import org.example.AviaSouls;
import org.example.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    @Test
    public void searchMultipleTicketsFound() {
        // Создаем билеты
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 8000, 13, 14);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 8000, 15, 17);

        // Создаем экземпляр AviaSouls и добавляем билеты
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        // Вызываем метод поиска
        Ticket[] foundTickets = aviaSouls.search("Москва", "Санкт-Петербург");

        // Проверяем, что количество найденных билетов равно ожидаемому
        Assertions.assertEquals(2, foundTickets.length);
    }

    @Test
    public void searchSingleTicketFound() {
        // Создаем билет
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 8000, 13, 14);

        // Создаем экземпляр AviaSouls и добавляем билет
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);

        // Вызываем метод поиска
        Ticket[] foundTickets = aviaSouls.search("Москва", "Санкт-Петербург");

        // Проверяем, что количество найденных билетов равно ожидаемому (в данном случае 1)
        Assertions.assertEquals(1, foundTickets.length);
    }

    @Test
    public void searchNoTicketsFound() {
        // Создаем билеты
        Ticket ticket1 = new Ticket("Санкт-Петербург", "Кострома", 8000, 15, 17);
        Ticket ticket2 = new Ticket("Кострома", "Санкт-Петербург", 10000, 13, 15);

        // Создаем экземпляр AviaSouls и добавляем билеты
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        // Вызываем метод поиска
        Ticket[] foundTickets = aviaSouls.search("Москва", "Санкт-Петербург");

        // Проверяем, что количество найденных билетов равно ожидаемому (в данном случае 0)
        Assertions.assertEquals(0, foundTickets.length);
    }
}






