import java.util.Arrays;
import java.util.List;

public class Four {

    //Внимание! Для расчета результата мы учитываем только корректность решения (прохождение тест-кейсов). Оптимальность алгоритма и затраты памяти не учитываются.
    //
    //Дочь программиста Ивана хочет поиграть в классики во дворе. Но она не знает правил, поэтому она придумала их сама.  Из каждой позиции она может перемещаться влево и вправо на определенное разрешенное количество шагов. И необходимо дойти до цели, совершая минимальное количество прыжков.
    //На вход подаётся массив данных steps – длина прыжка из каждой позиции. Девочка начинает с 0 позиции и может перемещается влево или вправо на steps[i] шагов. Найдите кратчайший путь девочки до позиции goal.
    //
    // Ввод:
    //
    //steps - массив чисел (integer[]) - длина прыжка для каждой клетки, steps[i] > 0
    //goal - число (integer) – позиция в массиве, до которой нужно добраться
    // Вывод:
    //integer - минимальное количество шагов. Или 0, если дойти невозможно
    //
    //Example:
    //
    //steps=[2, 3, 1, 4, 5]
    //goal=4
    //getResult(steps, goal)= 3
    ///*
    //**2,** 3, 1, 4, 5
    //2, 3, **1**, 4, 5
    //2, **3**, 1, 4, 5
    //2, 3, 1, 4, **5**
    //Итого – 3 шага
    //*/
        /**
         * Implement method getResult
         */

        public static int getResult(List<Integer> steps, int goal) {
            int[] dst = new int[steps.size()];
            Arrays.fill(dst, -1);
            dst[0] = 0;
            int[] q = new int[steps.size()];
            int num = 0;
            q[num++] = 0;
            int pos = 0;
            while (pos < num) {
                int cur = q[pos++];
                if (cur == goal) {
                    return dst[cur];
                }
                int lf = cur - steps.get(cur);
                if (0 <= lf && lf < steps.size() && dst[lf] == -1) {
                    dst[lf] = dst[cur] + 1;
                    q[num++] = lf;
                }
                int rg = cur + steps.get(cur);
                if (0 <= rg && rg < steps.size() && dst[rg] == -1) {
                    dst[rg] = dst[cur] + 1;
                    q[num++] = rg;
                }
            }
            if (dst[goal] == -1) return 0;
            return dst[goal];
        }
}
