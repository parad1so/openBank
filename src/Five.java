import java.util.List;

public class Five {
    //Внимание! Для расчета результата мы учитываем только корректность решения (прохождение тест-кейсов). Оптимальность алгоритма и затраты памяти не учитываются.
    //
    //Андрею очень везёт с акциями на бирже. Он всегда выходит в максимальный плюс, который возможен на отрезке времени. Напишите программу, которая бы выводила его прибыль. Количество покупок и продаж не ограничено. Однако покупать акции можно только на начальные деньги, то есть деньги, вырученные с продаж, использовать не получится. Купить и продать можно только целое число акций.
    //
    // Ввод:
    //
    //money - количество денег у Андрея (integer)
    //stock - массив курса акции (integer[]), где stock[i] - цена за одну акцию
    // Вывод:
    //integer – количество денег, полученных по итогу торгов акций
    //
    //Example:
    //
    //money=7
    //stock=[2, 6, 5, 3, 1, 2, 1]
    //getResult(money, stock) =20
    ///*Андрей в первый день купил 3 акции по 2 рубля и продал их на следующий день за 6 рублей. Потом он на оставшиеся деньги купил акцию за 1 рубль и продал её в два раз дороже не следующий день. (3*6) + (1*2) = 20*/
    /**
     * Implement method getResult
     */
    public static int getResult(int money, List<Integer> stock) {
        int[][][] dp = new int[stock.size() + 1][money + 1][money + 1];
        for (int day = 0; day <= stock.size(); day++) {
            for (int mon = 0; mon <= money; mon++) {
                for (int st = 0; st <= money; st++) {
                    dp[day][mon][st] = Integer.MIN_VALUE;
                }
            }
        }
        dp[0][money][0] = 0;
        for (int day = 0; day < stock.size(); day++) {
            for (int mon = 0; mon <= money; mon++) {
                for (int st = 0; st <= money; st++) {
                    // buy
                    for (int num = 0; num * stock.get(day) <= mon; num++) {
                        int spend = num * stock.get(day);
                        if (st + num <= money) {
                            dp[day + 1][mon - spend][st + num] =
                                    Math.max(
                                            dp[day + 1][mon - spend][st + num],
                                            dp[day][mon][st]);
                        }
                    }
                    // sell
                    for (int num = 0; num <= st; num++) {
                        int spend = num * stock.get(day);
                        dp[day + 1][mon][st - num] =
                                Math.max(dp[day + 1][mon][st - num],
                                        dp[day][mon][st] + spend);
                    }
                    // do nothing
                    dp[day + 1][mon][st] = Math.max(
                            dp[day + 1][mon][st], dp[day][mon][st]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int mon = 0; mon <= money; mon++) {
            for (int st = 0; st <= money; st++) {
                res = Math.max(res, dp[stock.size()][mon][st] + mon);
            }
        }
        return res;
    }
}
