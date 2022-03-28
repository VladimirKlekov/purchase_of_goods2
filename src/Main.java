import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int productNumber = 0;
        int productCount = 0;
        int sumProducts = 0;

        Scanner scanner = new Scanner(System.in);

        String[] products = {
                "Хлеб",
                "Яблоки",
                "Молоко"};
        // массив с ценами
        int[] prices = {
                100,
                200,
                300};
        int[] count = new int[products.length];
        int[] sum = new int[products.length];
        System.out.println("_____________________________________________________________________");
        System.out.println("Здравствуйте, в нашем магазине вы можете приобрести: ");
        // отображаю товар и его стоимость
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " = " + prices[i] + " рублей за штуку");
        }

        // делаю цикл
        while (true) {
            System.out.println("_____________________________________________________________________");
            System.out.println("Введите через пробел номер и количество товара или end для завершения");
            String input = scanner.nextLine();
            System.out.println("_____________________________________________________________________");
            if (input.equals("end")) {
                break;
            }
            String parts[] = input.split(" ");
            productNumber = Integer.parseInt(parts[0]) - 1;//-1 для записи в 0
            productCount = Integer.parseInt(parts[1]);

            //передадим введенны данные от пользователя в массив
            sum[productNumber] += prices[productNumber] * productCount; //= это присвоит, += сложит и присвоит
            count[productNumber] += productCount;

            System.out.println("Ваш заказ:");
            System.out.printf("%s %9s %6s %s\n", "Наименование товара | ", "Количество | ", "Рубл/за.шт | ", "Стоимость");

            // выведи табоицу с выбор пользователя
            for (int i = 0; i < sum.length; i++) {
                if (count[i] != 0) {
                    System.out.printf("%s %20s %15s %16s\n", products[i], count[i], prices[i],
                            sum[i]);
                }
            }

        }
        // посчитай сумму в массиве
        for (int s : sum) {
            sumProducts += s;
        }

        System.out.println("Сумма покумки составит: " + sumProducts + "рублей");
        System.out.println("Программа завершена");
    }
}
