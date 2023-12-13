import org.example.AviaSouls;
import org.example.Ticket;
import org.example.TicketTimeComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    private AviaSouls aviaSouls;

    @Test
    public void searchTicketSortByTimeMoving() {

        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 12000, 13, 15);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Кострома", 8000, 15, 17);
        Ticket ticket3 = new Ticket("Кострома", "Санкт-Петербург", 10000, 13, 15);
        Ticket ticket4 = new Ticket("Москва", "Санкт-Петербург", 10000, 10, 11);
        Ticket ticket5 = new Ticket("Москва", "Санкт-Петербург", 10000, 10, 13);

        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);


        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};

        TicketTimeComparator comparator = new TicketTimeComparator();


        aviaSouls.searchAndSortBy("Москва", "Санкт-Петербург", comparator);

        Ticket[] expected = {ticket4, ticket1, ticket5};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Санкт-Петербург", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByPriceFirstMore() {

        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 10000, 13, 14);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Кострома", 8000, 15, 17);

        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);


        Ticket[] tickets = {ticket1, ticket2};

        Arrays.sort(tickets);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortByPriceFirstLess() {

        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 8000, 13, 14);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Кострома", 10000, 15, 17);

        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);


        Ticket[] tickets = {ticket1, ticket2};

        Arrays.sort(tickets);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortByPriceFirstEqual() {

        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 8000, 13, 14);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Кострома", 8000, 15, 17);

        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);


        Ticket[] tickets = {ticket1, ticket2};

        Arrays.sort(tickets);

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }
}





