import java.util.Random;

public class Philosopher extends Thread {
  private Fork left;
  private Fork right;
  private Random random;

  public Philosopher(Fork left, Fork right) {
    this.left = left;
    this.right = right;
    random = new Random();
  }

  public void run() {
    try {
      while (true) {
        think();
        left.pickUp();
        right.pickUp();
        eat();
        right.putDown();
        left.putDown();
      }
    } catch (InterruptedException e) {
      System.out.println("Philosopher Interrupted");
    }
  }

  private void think() throws InterruptedException {
    System.out.println(this + " is thinking");
    Thread.sleep(random.nextInt(100));
  }

  private void eat() throws InterruptedException {
    System.out.println(this + " is eating");
    Thread.sleep(random.nextInt(100));
  }

  public String toString() {
    return "Philosopher " + getName();
  }
}