// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

// Всего возможных варианта расположения 8 ферзей на 64-х клеточной доске состовляет: 4 426 165 368 варианта, но вариантов
// которые подходят под условие всего 92. Индексные значения [0],[1] итд - это строки, значение после "=" - это столбец доски!
public class TaskFour {
        static int[] chessboard = {0,0,0,0,0,0,0,0};
        static int index = 0;
        static int version = 0;

        public static void main(String[] args){

            do {
                if (checking()){
                    if (index == 7) {
                        System.out.println(version++ + " [0]=" + chessboard[0] + " [1]=" + chessboard[1] + " [2]=" + chessboard[2] + " [3]=" + chessboard[3] + " [4]=" + chessboard[4] + " [5]=" + chessboard[5] + " [6]=" + chessboard[6] + " [7]=" + chessboard[7]);
                        chessboard[index]++;
                    }
                    else {
                        index++;
                    }
                }
                else {
                    chessboard[index]++;
                }
            } while (chessboard[0]<8);
        }

        static boolean checking() {
            int i;

            if (index == 0) {
                return true;
            }

            if (chessboard[index]>7){
                chessboard[index] = 0;
                index--;
                return false;
            }

            for (i=0;i<index;i++){
                if ((chessboard[index] == chessboard[i])|((Math.abs(chessboard[index] - chessboard[i])) == (index-i))){
                    return false;
                }
            }

            return true;
        }
    }

