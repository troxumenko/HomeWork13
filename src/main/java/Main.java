import entities.Account;
import entities.Client;
import entities.Status;
import services.AccountService;
import services.ClientService;
import services.StatusService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        AccountService accountService = new AccountService();
        StatusService statusService = new StatusService();

//        List<Client> all = clientService.getClients();
//        List<Account> all = accountService.getAccounts();
//        List<Status> all = statusService.getStatuses();

//        List<Client> all = clientService.getClientsByPhone(380958089090L);
//        List<String> all = accountService.getAccountsNumberByValue(1000.0);
//        List<Client> all = clientService.getClientsByEqualId();
//        List<String> all = clientService.getValuesFromClientsAndAccounts();

//        for (int i = 0; i < all.size(); i++) {
//            System.out.println(all.get(i));
//        }


//        Client client = new Client("example", "example@gmail.com", 380997776699L, "My name is example", 36);
//        Account account = new Account(36, "123456789", 150000.15);
//        Status status = new Status("EXAMPLE", "TEXT FOR EXAMPLE");

//        clientService.save(customer);
//        accountService.save(account);
//        statusService.save(status);


//        Client client = new Client(13, "example1", "example1@gmail.com", 380997776691L, "My name is example1", 31);
//        Account account = new Account(12, 31, "123456781", 150001.15);
//        Status status = new Status(4, "EXAMPLE1", "TEXT FOR EXAMPLE1");

//        clientService.update(client);
//        accountService.update(account);
//        statusService.update(status);


//        clientService.delete(13);
//        accountService.delete(12);
//        statusService.delete(4);

    }
}
