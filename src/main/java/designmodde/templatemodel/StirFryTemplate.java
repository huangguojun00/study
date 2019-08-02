package designmodde.templatemodel;

/**
 * @Author Huang Guojun
 * @Date 2019/8/2
 * @Discription
 */
public abstract class StirFryTemplate  {
    // 模板方法，用来控制炒菜流程， 声明为final不希望子类复用
    final void cookProcess(){
          this.pourOil();
          this.heatOil();
          this.pourVagetable();
          this.pourSauce();
          this.fry();
    }

    // 所有的都是一样的  复用
    void pourOil(){
        System.out.println("倒油");
    }

    // 热油是一样的   复用
    void heatOil(){
        System.out.println("热油");
    }

    // 倒蔬菜不一样
    abstract void pourVagetable();

    abstract void pourSauce();

    void fry(){
        System.out.println("do");
    }

}
