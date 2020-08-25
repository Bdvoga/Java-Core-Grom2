package lesson5;

import java.util.Arrays;

public class Withdraw {

    public static void main(String[] args) {
        String[] clients = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina"};
        int[] balances = {100, 500, 8432, 99, 12000, -54};

        System.out.println(withdraw(clients, balances, "Ann", 500));

    }

    public static int withdraw(String[] clients, int[] balances, String client, int money) {
        //1. Найти клиента
        //2. Вычислить новое значение баланса
        //3. Вернуть остаток на счете или -1

        //1.
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client) { //нашли клиента
                break;
            }
            clientIndex++;
        }

        //2.
        if (balances[clientIndex] < money) {
            return -1;
        } else {
            balances[clientIndex] -= money;
            return balances[clientIndex];
        }

    }
}