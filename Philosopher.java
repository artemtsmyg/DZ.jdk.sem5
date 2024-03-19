/**
 * Класс представляющий философа
 */
public class Philosopher extends Thread {
    
    private int id; // идентификатор философа
    private Fork leftFork; // левая вилка
    private Fork rightFork; // правая вилка
    private int eatCount; // количество раз, которые философ поел
/**
 * Конструктор класса Philosopher
 * @param id идентификатор философа
 * @param leftFork левая вилка
 * @param rightFork правая вилка 
 */ 
    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.eatCount = 0;
    }

    /**
     * Метод запуска потока философа 
     */ 
    
    @Override
    public void run() {
        while (eatCount < 3) {
            try {
                think();
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод, представляющий размышления философа
     * @throws InterruptedException 
     */
    
    private void think() throws InterruptedException {
        System.out.println(" --Философ " + id + " размышляет ");
        Thread.sleep((long) (Math.random() * 20000));
    }

    /**
     * Метод, представляющий процесс приема пищи философом
     * @throws InterruptedException 
     */ 
    
    private void eat() throws InterruptedException {
        if (leftFork.pickUp(id) && rightFork.pickUp(id)) {
            System.out.println(" --Философ " + id + " ест ");
            Thread.sleep(500);
            leftFork.putDown(id);
            rightFork.putDown(id);
            eatCount++;
        } else {
            System.out.println(" --Философ " + id + " ждет вилки ");
        }
    }
}