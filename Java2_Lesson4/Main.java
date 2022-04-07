package ru.geekbrains.com;
//Домашнее задание к уроку Java2_Lesson4
////Сделать добавление и удаление из односвязного списка по индексу
//Ученик Николай Горобий

public class Main {
    
    
        public static void main(String[] args) {
            OwnLinkedList<Integer> integLL = new OwnLinkedList<>();

            integLL.addNodeIndx(1111, 0);
            integLL.addNodeIndx(2222, 1);
            integLL.addNodeIndx(3333, 2);
            integLL.addNodeIndx(4444, 3);
            integLL.addNodeIndx(5555, 4);
            integLL.addNodeIndx(6666, 5);
            integLL.addNodeIndx(7777, 6);
            integLL.display();
            System.out.println();
            integLL.addNodeIndx(8888, 4);
            integLL.addNodeIndx(9999, 0);

            integLL.display();
            System.out.println();


            integLL.deleteNodeIndx(9);
            integLL.deleteNodeIndx(4);
            integLL.deleteNodeIndx(1);

            integLL.display();
            System.out.println();
        }
    }
