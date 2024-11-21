package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        SLList<Integer> main = new SLList<Integer>();
        AList<Integer> listSize = new AList<Integer>();
        AList<Double> totalTime = new AList<Double>();
        AList<Integer> operations = new AList<Integer>();
        Stopwatch sw = new Stopwatch();
        for(int i=1;i<=8;i++) {
            int size=(int) (100*Math.pow(2,i));
            listSize.addLast(size);
            for(int j=0;j<size;j++) {
                main.addLast(1);
            }

            main.getLast();
            totalTime.addLast(sw.elapsedTime());

        }
        for(int i=1;i<=8;i++) {
            int operation=(int) (100 *Math.pow(2,i));
            operations.addLast(operation);
        }
        printTimingTable(listSize,totalTime,operations);
    }
    }


