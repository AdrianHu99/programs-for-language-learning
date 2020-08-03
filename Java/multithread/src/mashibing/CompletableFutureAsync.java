package mashibing;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureAsync {

    private static Random rand = new Random();
    private static long time = System.currentTimeMillis();

    static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis()- time)/1000 + " seconds");

        return rand.nextInt();
    }

    static void accept() throws ExecutionException, InterruptedException {
        System.out.println("Starting thenAccept()");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<Void> f =  future.thenAccept(System.out::println);
        // thenAccept() returns CompletableFuture<Void>, that's why f.get() will be null
        System.out.println(f.get());
    }

    static void acceptBoth() throws ExecutionException, InterruptedException {
        System.out.println("Starting thenAcceptBoth()");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<Void> f =  future.thenAcceptBoth(CompletableFuture.completedFuture(10), (x, y) -> System.out.println(x * y));
        // thenAcceptBoth() returns CompletableFuture<Void>, that's why f.get() will be null
        System.out.println(f.get());
    }

    static void compose() throws ExecutionException, InterruptedException {
        System.out.println("Starting thenCompose()");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<String> f =  future.thenCompose( i -> {
            return CompletableFuture.supplyAsync(() -> {
                return (i * 10) + "";
            });
        });
        System.out.println(f.get()); //1000
    }

    static void combine() throws ExecutionException, InterruptedException {
        System.out.println("Starting thenCombine()");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Sleep for " + (i+1) + " time");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "abc";
        });
        CompletableFuture<String> f =  future.thenCombine(future2, (x,y) -> y + "-" + x);
        System.out.println(f.get()); //abc-100
    }

    static void applyToEither() throws ExecutionException, InterruptedException {
        System.out.println("Starting applyToEither()");
        Random rand = new Random();
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 200;
        });
        CompletableFuture<String> f =  future.applyToEither(future2,i -> i.toString());
        // Sometimes it's 100 sometimes it's 200
        System.out.println("From applyToEither the result is " + f.get());
    }

    static void anyOf() throws ExecutionException, InterruptedException {
        System.out.println("Starting anyOf()");
        Random rand = new Random();
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        /*CompletableFuture<Void> f =  CompletableFuture.allOf(future1,future2);
        // f.get() is null
        if (f.isDone()) {
            System.out.println("anyOf() get result: " + f.get());
        }*/
        // 100 or abc
        CompletableFuture<Object> f =  CompletableFuture.anyOf(future1,future2);
        System.out.println("anyOf() get result: " + f.get());
    }

    static void whenComplete() throws ExecutionException, InterruptedException {
        System.out.println("Starting whenComplete()");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFutureAsync::getMoreData);
        Future<Integer> f = future.whenComplete((value, error) -> {
            System.out.println("v is " + value);
            System.out.println("e is " + error);
        });
        System.out.println(f.get());
        //System.in.read();
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        anyOf();

        //applyToEither();

       /* accept();

        acceptBoth();

        compose();

        combine();

        whenComplete();*/


    }
}
