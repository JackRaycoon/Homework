package patterns;

import patterns.strategy.StrategyDemo;
import patterns.chainofresponsibility.ChainDemo;
import patterns.builder.BuilderDemo;
import patterns.proxy.ProxyDemo;
import patterns.decorator.DecoratorDemo;
import patterns.adapter.AdapterDemo;

public class PatternsDemo {
    public static void main(String[] args) {
        System.out.println("Демонстрация паттернов:\n");

        System.out.println("1. Strategy");
        StrategyDemo.main(args);

        System.out.println("\n2. Chain of Responsibility");
        ChainDemo.main(args);

        System.out.println("\n3. Builder");
        BuilderDemo.main(args);

        System.out.println("\n4. Proxy");
        ProxyDemo.main(args);

        System.out.println("\n5. Decorator");
        DecoratorDemo.main(args);

        System.out.println("\n6. Adapter");

        AdapterDemo.main(args);

        System.out.println("\nДемонстрация завершена.");
    }
}