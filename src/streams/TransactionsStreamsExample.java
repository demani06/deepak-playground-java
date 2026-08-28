package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class TransactionsStreamsExample {

    public record Transaction(String transactionId, String accountId, double amount, long timestamp, String category) {}
    record AccountStats(String accountId, long count, double totalAmount) {}
    static void main() {
        List<Transaction> transactionList = getSampleTransactionsData();

        //get total transaction amount per category.
        System.out.println("getTotalAmountByCategory = " + getTotalAmountByCategory(transactionList));

        System.out.println("getHighestValueTransaction = " + getHighestValueTransaction(transactionList));

        System.out.println("getTopTransactionByCategory = " + getTopTransactionByCategory(transactionList));

        System.out.println("getTop3AccountsByTxCount = " + getTop3AccountsByTxCount(transactionList));

    }



    public static List<String> getTop3AccountsByTxCount(List<Transaction> transactions) {
        Map<String, AccountStats> statsMap = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::accountId,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> new AccountStats(
                                        list.getFirst().accountId(),
                                        list.size(),
                                        list.stream().mapToDouble(Transaction::amount).sum()
                                )
                        )
                ));

        // Step 2: Sort using a composite comparator and select top 3
        return statsMap.values().stream()
                .sorted(
                        Comparator.comparingLong(AccountStats::count).reversed()
                                .thenComparingDouble(AccountStats::totalAmount).reversed()
                )
                .limit(3)
                .map(AccountStats::accountId)
                .toList();



    }


    public static Map<String, Transaction> getTopTransactionByCategory(List<Transaction> transactions) {
       return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::category, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Transaction::amount)), Optional::get)));
    }


    static Map<String, Double> getTotalAmountByCategory(List<Transaction> transactions){
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::accountId, Collectors.summingDouble(Transaction::amount)));
    }

    static Optional<Transaction> getHighestValueTransaction(List<Transaction> transactions) {
        // Fill in your solution here using Stream.max() and Comparator
        return transactions.stream()
                .max(Comparator.comparingDouble(Transaction::amount).thenComparingLong(Transaction::timestamp));
    }










    private static List<Transaction>  getSampleTransactionsData() {
       return List.of(
                new Transaction("123", "222", 444, 1787916331L, "Books" ),
                new Transaction("222", "222", 100, 1787911301L, "Books" ),
                new Transaction("334", "222", 100, 1782911301L, "Food" ),
                new Transaction("456", "200", 50, 1782911301L, "Food" ),
                new Transaction("456", "200", 30, 1783911301L, "Entertainment" ),
                new Transaction("456", "100", 30, 1783911301L, "Sports" ),
                new Transaction("456", "100", 550, 1785911305L, "Sports" ),
                new Transaction("446", "222", 550, 1785911302L, "Home Decors" )
        );
    }



}
