public class kadai9 {
    public static void main(String[] args) {
        Dog pochi = new Dog();
        pochi.print();

        pochi.roudou();
        pochi.print();

        pochi.roudou();
        pochi.print();

        pochi.shokuji();
        pochi.print();

        pochi.shokuji();
        pochi.print();

        pochi.roudou();
        pochi.print();

        pochi.suiminn();
        pochi.print();

        pochi.roudou();
        pochi.print();

        pochi.suiminn();
        pochi.print();

    }
}

class Dog {
    private DogState myState;

    public Dog() {
        myState = TanoshiiState.getInstance();
    }

    public void roudou() {
        myState.tukareta(this);
    }

    public void shokuji() {
        myState.tabeta(this);
    }

    public void suiminn() {
        myState.neteru(this);
    }

    public void changeState(DogState d) {
        myState = d;
    }

    public void print() {
        System.out.print("現在、わたしは「");
        System.out.print(myState.toString());
        System.out.println("」です。");
    }
}

abstract class DogState {
    public abstract void tukareta(Dog yobidashimoto);

    public abstract void tabeta(Dog yobidashimoto);

    public abstract void neteru(Dog yobidashimoto);
}

class TanoshiiState extends DogState {
    private static TanoshiiState s = new TanoshiiState();

    private TanoshiiState() {
    }

    public static DogState getInstance() {
        return s;
    }

    public void tukareta(Dog moto) {
        moto.changeState(FutsuuState.getInstance());
    }

    public void neteru(Dog moto) {
        moto.changeState(SuiminnState.getInstance());
    }

    public void tabeta(Dog moto) { // なにもしない
    }

    public String toString() {
        return "楽しい状態";
    }
}

class FutsuuState extends DogState {
    private static FutsuuState s = new FutsuuState();

    private FutsuuState() {
    }

    public static DogState getInstance() {
        return s;
    }

    public void tukareta(Dog moto) {
        moto.changeState(IrairaState.getInstance());
    }

    public void neteru(Dog moto) {
        moto.changeState(SuiminnState.getInstance());
    }

    public void tabeta(Dog moto) {
        moto.changeState(TanoshiiState.getInstance());
    }

    public String toString() {
        return "普通状態";
    }
}

class IrairaState extends DogState {
    private static IrairaState s = new IrairaState();

    private IrairaState() {
    }

    public static DogState getInstance() {
        return s;
    }

    public void tukareta(Dog moto) {
        // なにもしない
    }

    public void tabeta(Dog moto) {
        moto.changeState(TanoshiiState.getInstance());
    }

    public void neteru(Dog moto) {
        moto.changeState(SuiminnState.getInstance());
    }

    public String toString() {
        return "いらいら状態";
    }
}

class SuiminnState extends DogState {
    private static SuiminnState s = new SuiminnState();

    private SuiminnState() {
    }

    public static DogState getInstance() {
        return s;
    }

    public void tukareta(Dog moto) {
        moto.changeState(IrairaState.getInstance());
    }

    public void tabeta(Dog moto) {
        moto.changeState(TanoshiiState.getInstance());
    }

    public void neteru(Dog moto) {
        // なにもしない
    }

    public String toString() {
        return "寝てる状態";
    }
}