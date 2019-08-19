package cn.edu.nju.gzq.apirec;

import com.github.gumtreediff.tree.ITree;
import com.github.gumtreediff.client.Run;
import com.github.gumtreediff.gen.Generators;
import com.github.gumtreediff.matchers.Matcher;
import com.github.gumtreediff.matchers.Matchers;
import com.github.gumtreediff.actions.model.Action;
import com.github.gumtreediff.actions.ActionGenerator;

import java.util.List;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Run.initGenerators();
        String file1 = "res/Main1.java";
        String file2 = "res/Main2.java";
        ITree src = Generators.getInstance().getTree(file1).getRoot();
        ITree dst = Generators.getInstance().getTree(file2).getRoot();
        Matcher m = Matchers.getInstance().getMatcher(src, dst);
        m.match();
        ActionGenerator g = new ActionGenerator(src, dst, m.getMappings());
        g.generate();
        List<Action> actions = g.getActions();

        for (Action action : actions) {
            System.out.println(action.toString());
        }

    }
}
