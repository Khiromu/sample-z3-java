import com.microsoft.z3.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //System.load("C:\\Users\\lofu_\\OneDrive\\z3\\build\\libz3.dll");

        //application example of z3
        //reference https://qiita.com/quentin-maisonneuve/items/4f32cf52293dc44ffc3d

        Context context = new Context(new HashMap<>());
        BoolExpr a = context.mkBoolConst("a");
        BoolExpr b = context.mkBoolConst("b");
        BoolExpr c = context.mkBoolConst("c");

        BoolExpr formula = context.mkAnd(context.mkOr(a, b), c); // (a || b) && c


        Solver solver = context.mkSolver();
        solver.add(formula);

        if(solver.check() == Status.SATISFIABLE) {
            Model model = solver.getModel();
            Expr resultVa = model.eval(a, false);
            Expr resultVb = model.eval(b, false);
            Expr resultVc = model.eval(c, false);

            System.out.println(resultVa);   // Result is true
            System.out.println(resultVb);   // Result is false
            System.out.println(resultVc);   // Result is true

        }

    }
}
