package festivalEntranceApp.objectDefinitions;

import java.util.Random;

public enum TicketTypes {
    FULL_PASS, FULL_VIP_PASS, FREE_PASS, ONE_DAY_PASS, ONE_DAY_VIP_PASS;

    public static TicketTypes randomTicketType() {
        Random random = new Random();
        TicketTypes ticketType[] = values();
        return ticketType[random.nextInt(ticketType.length)];
    }
}


