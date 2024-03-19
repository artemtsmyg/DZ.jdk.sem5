/**
 * Класс представляющий вилку
 */
public class Fork {
    
    private int id;
    private boolean isBusy;

    /**
     * Конструктор класса Fork
     * @param id уникальный идентификатор вилки 
     */
    
    public Fork(int id) {
        this.id = id;
        this.isBusy = false;
    }

    /**
     * Метод для взятия вилки философом
     * @param philosopherId идентификатор философа
     * @return true, если вилка свободна и ее удалось взять, иначе false 
     */
    
    public synchronized boolean pickUp(int philosopherId) {
        if (!isBusy) {
            isBusy = true;
            System.out.println(" --Философ " + philosopherId + " взял вилки " + id);
            return true;
        }
        return false;
    }

    /**
     * Метод для отложения вилки философом
     * @param philosopherId идентификатор философа 
     */
    
    public synchronized void putDown(int philosopherId) {
        isBusy = false;
        System.out.println(" --Философ " + philosopherId + " отложил вилки " + id);
    }
}