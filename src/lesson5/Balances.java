package lesson5;

import java.util.Arrays;

public class Balances {
    public static void main(String[] args) {
        String[] clients = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina"};
        int[] balances = {100, 500, 8432, 99, 12000, -54};

        System.out.println(Arrays.toString(findClientsByBalance(clients, balances, 500)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(clients, balances)));

        System.out.println(depositMoney(clients, balances, "Ann", 1000));
        System.out.println(Arrays.toString(balances));

    }

    //1. Найти клиентов с балансом >= n
    static String[] findClientsByBalance(String[] clients, int[] balances, int n) {
        int count = 0;
        for (int balance : balances) {
            if (balance >= n)
                count++;
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance >= n) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }

        return results;
    }

    //2. Найти клиентов с отрицательным балансом
    static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {
        int count = 0;
        for (int balance : balances) {
            if (balance < 0)
                count++;
        }

        //2.
        String[] results = new String[count];

        //3.
        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance < 0) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }

        return results;
    }

    //3.
    static int depositMoney(String[] clients, int[] balances, String client, int money) {
        //1. Найти клиента в базе (в массивах)
        //2. Считаем сумму пополнения с учетом комиссии
        //3. Обновляем баланс (пополняем)

        int clientIndex = 0; //индекс клиента, счет которого будем пополнять
        for (String cl : clients) {
            if (cl == client) {
                break;
            }
            clientIndex++;
        }

        return balances[clientIndex] += money;
    }

}