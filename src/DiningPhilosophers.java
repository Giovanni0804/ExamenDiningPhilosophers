public class DiningPhilosophers {

  public static void main(String[] args) {
    int numOfPhilosophers = 5;
    Fork[] forks = new Fork[numOfPhilosophers];
    Philosopher[] philosophers = new Philosopher[numOfPhilosophers];

    for (int i = 0; i < numOfPhilosophers; i++) {
      forks[i] = new Fork();
    }

    for (int i = 0; i < numOfPhilosophers; i++) {
      Fork left = forks[i];
      Fork right = forks[(i + 1) % numOfPhilosophers];
      philosophers[i] = new Philosopher(left, right);
    }

    for (int i = 0; i < numOfPhilosophers; i++) {
      philosophers[i].start();
    }
  }
}