package Seminar_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

public class Sample03 {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
     *
     * 5,6,7,8 - необязательные, опциональные задания.
     *
     * 1.  Предусловия.
     * 2.  Постусловия.
     * 3.  Инвариант.
     * 4.  Определить абстрактные и конкретные классы.
     * 5.  Определить интерфейсы.
     * 6.  Реализовать наследование.
     * 7.  Выявить компоненты.
     * 8.  Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без деталей.
     */
    public static void main(String[] args) {

        Core core = new Core();

        MobileApp mobileApp = new MobileApp(core.getCustomerProvider(), core.getTicketProvider());

        mobileApp.searchTicket(new Date());
        mobileApp.buyTicket("1000000000000044");

        BusStation busStation = new BusStation(core.getTicketProvider());

    }

}

class Customer{

    private static int counter;
    private final int id;
    private Collection<Ticket> tickets;

    {
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }
}
class Ticket {
    private int id;
    private int customerId;
    private Date date;
    private String qrcode;
    private boolean enable = true;

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}

class Database{


    private static int count;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    /**
     * Получить актуальную стоимость билета
     * @return
     */
    public double getTicketAmount(){
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * @return
     */
    public int createTicketOrder(int clientId){
        return  ++count;
    }


    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }
}


class TicketProvider{
    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider){
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    public Collection<Ticket> searchTicket(int clientId, Date date){

        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }
        return tickets;

    }

    public boolean buyTicket(int clientId, String cardNo){

        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();

        return paymentProvider.buy(orderId, cardNo, amount);
    }

    public boolean checkTicket(String qrcode){
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)){
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }

}

class CustomerProvider{
    private final Database database;

    public CustomerProvider(Database database){
        this.database = database;
    }

    public Customer getCustomer(String login, String password){

        return database.getCustomers().stream().findFirst().get();

    }

}

class Core{

    private final CustomerProvider customerProvider;
    private final TicketProvider ticketProvider;
    private final PaymentProvider paymentProvider;
    private final Database database;

    public Core(){
        database = new Database();
        customerProvider = new CustomerProvider(database);
        paymentProvider = new PaymentProvider();
        ticketProvider = new TicketProvider(database, paymentProvider);
    }

    public CustomerProvider getCustomerProvider() {
        return customerProvider;
    }

    public TicketProvider getTicketProvider() {
        return ticketProvider;
    }
}


/**
 * Мобильное приложение
 */
class MobileApp{

    private final TicketProvider ticketProvider;
    private final Customer customer;

    public MobileApp(CustomerProvider customerProvider, TicketProvider ticketProvider){
        this.ticketProvider = ticketProvider;
        customer = customerProvider.getCustomer("login", "password");
    }

    public void searchTicket(Date date){
        customer.setTickets(ticketProvider.searchTicket(customer.getId(), new Date()));
    }


    public boolean buyTicket(String cardNo){
        return ticketProvider.buyTicket(customer.getId(), cardNo);
    }


}

/**
 * Автобусная станция
 */
class BusStation{

    private TicketProvider ticketProvider;

    public BusStation(TicketProvider ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    public TicketProvider getTicketProvider() {
        return ticketProvider;
    }

    public void setTicketProvider(TicketProvider ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    /***
     * Метод приветствующий клиента, либо, изгоняющий самозванца.
     * @param qrCode QR-код билета
     */
    public void boardingPassenger(String qrCode){
        if (ticketProvider.checkTicket(qrCode)){
            System.out.println("Welcome!");
        }else {
            System.out.println("Don't waste my time! Get out!");
        }
    }
}

interface PaymentMaster{
    public boolean contractOrientedBuy(int orderId, String cardNo, double amount);

}
class PaymentProvider implements PaymentMaster{

    public boolean buy(int orderId, String cardNo, double amount) {
       return true;
    }

    /***
     *
     * @param orderId id заказа //TODO реализовать сущность "Заказ"
     * @param cardNo номер банковской карты клиента
     * @param amount стоимость билета
     * @return true в случае успешной транзакции
     */
    @Override
    public boolean contractOrientedBuy(int orderId, String cardNo, double amount) {
        ProcessingCompany pc = new ProcessingCompany();

        if (orderId <= 0) {
            throw new RuntimeException("Невалидный id заказа!");
        }if (!checkCardNumber(cardNo)){
            throw  new RuntimeException("Несуществующий номер карты!");
        }

        try {
            pc.sendPayment();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        pc.disconnect();
        return false;
    }
    private boolean checkCardNumber(String cardNumber){
        Random random = new Random();
        return random.nextBoolean();
    }
}


class ProcessingCompany {

    private Collection<Bank> banks = new ArrayList<>();
    public void sendPayment(){}
    public void disconnect(){}

}



class Bank {


}
