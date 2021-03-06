import java.util.List;

public class Tree {

    //Внимание! Для расчета результата мы учитываем только корректность решения (прохождение тест-кейсов). Оптимальность алгоритма и затраты памяти не учитываются.
    //
    //После долгих приключений Ведьмак заскочил в местную деревню, чтобы выполнить задания и заработать денег.
    //На вход поступает 2 массива: массив вероятностей успешного выполнения задания, и второй - с наградой. Все задания выполняются последовательно
    //После успешного похода, авторитет Ведьмака в городе повышается, и награда за следующие походы будет больше на 10 золотых, однако из-за усталости шансы на успешность будущих вылазок уменьшаются вдвое (усталость действует на всё последующее приключение)
    //Ведьмак также может и отказаться от задания, если считает его невыгодным, но вернуться к нему уже не сможет
    //Посчитайте максимально возможный ожидаемый заработок за всё путешествие (он считается путём умножения награды на шанс успеха каждого задания, за которое Ведьмак возьмётся)
    //Например, если вероятность успеха 50, а награда 100, то математически ожидаемый заработок будет - 50 золотых
    //
    // Ввод:
    //
    //chances – массив чисел - вероятностей успеха в процентах (integer[]), где chances[i]=0..100, i–номер похода
    //loot – массив чисел - потенциальной награды (integer[]), где i–номер похода
    // Вывод:
    //integer – максимально возможная добыча в среднем, результат округлите в меньшую сторону
    //
    //Example:
    //
    //getResult([10, 50, 20, 25, 25], [10, 50, 20, 50, 50]) ->36
    ///*
    //1 задание пропускается
    //2 выполняется (0.5 * 50 = 25) +10 дополнительных монет на следующие
    //3 пропускается
    //4 выполняется (0.125 * (50 + 10) = 7.5 + 25 = 32.5)
    //5 выполняется (0.0625 * (50 + 20) = 32.5 + 4.375 = 36.875)
    //*/
        /**
         * Implement method getResult
         */
        public static int getResult(List<Integer> chances, List<Integer> loot) {
            int n = chances.size();
            double[][] dp = new double[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 0.0;
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Double.MIN_VALUE;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n; j++) {
                    double award = 0.01 * chances.get(i) / Math.pow(2.0, j) *
                            (loot.get(i) + 10 * j);
                    if (j + 1 < dp[i + 1].length) {
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + award);
                    }
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                }
            }
            double res = Double.MIN_VALUE;
            for (int j = 0; j <= n; j++) {
                res = Math.max(res, dp[n][j]);
            }
            return (int)res;
        }
}
