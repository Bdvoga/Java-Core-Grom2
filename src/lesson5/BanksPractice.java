package lesson5;

import java.util.Arrays;

public class BanksPractice {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina"};
        int[] balances = {100, 500, 8432, 99, 12000, -54};

        System.out.println(Arrays.toString(findClientsByBalance(names, balances, -100)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));
        depositMoney(names, balances, "Ann", 1000);
        System.out.println(Arrays.toString(balances));

    }

    // Найти клиентов с балансом > n
    // Сигнатура метода (описание)
    static String[] findClientsByBalance(String[] clients, int[] balances, int n) {
        //String[] results = new String[clients.length]; 1-й способ
        //создать массив длиной = кол-ву клиентов и в него заносить
        //результат, потом отфильтровать пустые значения - плохой

        //2-й:
        //1. находим кол-во результатов
        //2. создаем массив с длиной = кол-ву результатов
        //3. записываем в него результаты

        //1.
        int count = 0;
        for (int balance : balances) {
            if (balance >= n)
                count++;
        }

        //2.
        String[] results = new String[count];

        //3.
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

    //3.2. Найти клиентов с отрицательным балансом
    static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {
        //String[] results = new String[clients.length]; 1-й способ

        //1. находим кол-во результатов
        //2. создаем массив с длиной = кол-ву результатов
        //3. записываем в него результаты

        //1.
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
    static void depositMoney(String[] clients, int[] balances, String client, int money) {
        //1. Найти клиента в базе (в массивах)
        //2. Считаем сумму пополнения с учетом комиссии
        //3. Обновляем баланс (пополняем)

        //1. Выносим блок поиска клиента в базе в отдельный метод
//        int clientIndex = 0;
//        for (String cl : clients) {
//            if (cl == client) { //нашли клиента
//                break;
//            }
//            clientIndex++;
//        }
        //1. После вынесения в отд метод:
        //int clientIndex = findClientIndexByName(clients, client);

        //2. Выносим блок расчета суммы в отдельный метод
        //int moneyToDeposit = money <= 100 ? (int) (money - money * 0.02) : (int) (money - money * 0.01);
        //(int) - округляем до целого (для учебного примера)
        //int moneyToDeposit = calculateDepositAmountAfterCommission(money);

        //Переменные, вычисляемые в блоке 1 и 2, как самостоятельные не нужны. Можно сразу записать
        //результат в блок 3.

        //3.
        //balances[clientIndex] += moneyToDeposit;
        balances[findClientIndexByName(clients, client)] += calculateDepositAmountAfterCommission(money);
    }

    //Вынесем в отдельный метод блок поиска клиента для использования в др местах кода
    static int findClientIndexByName(String[] clients, String client) {
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client) { //нашли клиента
                break;
            }
            clientIndex++;
        }
        return clientIndex;
    }

    //Выносим в отдельный метод блок расчета суммы пополнения
    static int calculateDepositAmountAfterCommission(int money) {
        return money <= 100 ? (int) (money - money * 0.02) : (int) (money - money * 0.01);
    }
}
